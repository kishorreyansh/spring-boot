package com.springbootjpa;

import com.springbootjpa.entity.Patient;
import com.springbootjpa.repository.PatientRepository;
import com.springbootjpa.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patientLists = patientRepository.findAll();
        System.out.println("Patient List: "+patientLists);
    }

    @Test
    public void testPatientById(){
        Patient p1 = patientService.getPatientById(1L);
        System.out.println("Patient details: "+p1);
    }
}
