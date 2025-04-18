package com.example.webservicesassessmenttask2.service.soap;

import com.example.webservicesassessmenttask2.entity.Student;
import com.example.webservicesassessmenttask2.repository.StudentRepository;
import jakarta.jws.WebService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@WebService(endpointInterface = "com.example.webservicesassessmenttask2.service.soap.StudentSoapService")
@RequiredArgsConstructor
@Service
public class StudentSoapServiceImpl implements StudentSoapService {

    private final StudentRepository studentRepository;

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findByIdWithSubjects(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
