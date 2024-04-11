package com.dakr.GeneratingQRCode.controller;

import com.dakr.GeneratingQRCode.QRCode.QRCodeGenerator;
import com.dakr.GeneratingQRCode.entity.Student;
import com.dakr.GeneratingQRCode.service.StudentService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudent() throws IOException, WriterException {
        List<Student> students= studentService.getStudent();
        if(students.size()!=0){
            for(Student student: students){
                QRCodeGenerator.generateQRCode(student);
            }
        }
        return ResponseEntity.ok(studentService.getStudent());
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") Long id){
        return studentService.findById(id);
    }
}
