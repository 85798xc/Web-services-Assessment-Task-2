package com.example.webservicesassessmenttask2.repository;

import com.example.webservicesassessmenttask2.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findByStudentId(Long studentId);
}