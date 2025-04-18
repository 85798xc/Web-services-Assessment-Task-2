package com.example.webservicesassessmenttask2.config;

import com.example.webservicesassessmenttask2.service.soap.StudentSoapServiceImpl;
import jakarta.xml.ws.Endpoint;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SoapWebServiceConfig {

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint(Bus bus, StudentSoapServiceImpl studentSoapService) {
        EndpointImpl endpoint = new EndpointImpl(bus, studentSoapService);
        endpoint.publish("/student-service");
        return endpoint;
    }
}