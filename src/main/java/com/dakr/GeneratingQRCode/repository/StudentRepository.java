package com.dakr.GeneratingQRCode.repository;

import com.dakr.GeneratingQRCode.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student ,Long> {
}
