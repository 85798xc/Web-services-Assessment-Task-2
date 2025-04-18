package com.example.webservicesassessmenttask2.service.soap;

import com.example.webservicesassessmenttask2.entity.Student;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.springframework.stereotype.Service;


@WebService
@Service
public interface StudentSoapService {
    @WebMethod
    Student getStudentById(Long id);
}