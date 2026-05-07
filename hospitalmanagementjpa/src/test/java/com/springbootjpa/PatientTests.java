package com.springbootjpa;

import com.springbootjpa.entity.Patient;
import com.springbootjpa.entity.type.BloodGroupType;
import com.springbootjpa.repository.PatientRepository;
import com.springbootjpa.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
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

    @Test
    public void testPatientTransactions(){
        Patient p1 = patientRepository.findByName("Reyansh");

        List<Patient> patients = patientRepository.findByBirthDateOrEmail
                (LocalDate.parse("2020-04-17"),"reyansh@gmail.com");
        List<Patient> patientBetweenDates = patientRepository.findByBirthDateBetween
                (LocalDate.parse("2020-04-17"), LocalDate.parse("2020-04-17"));

        List<Patient> patientsContains = patientRepository.findByNameContainingOrderByIdDesc
                ("ansh");
        for(Patient p: patientsContains){
            System.out.println(p);
        }

        List<Patient> patientBloodGroup = patientRepository.
                findByBloodGroup(BloodGroupType.A_POSITIVE);
        for(Patient p: patientBloodGroup){
            System.out.println(p);
        }

        List<Patient> patientsDate = patientRepository.
                findByBornAfterDate(LocalDate.of(1993,3,14));
        for(Patient p: patientsDate){
            System.out.println(p);
        }

        List<Object[]> patientsBloodGroupCount = patientRepository.countBloodGroupPatient();
        for(Object[] obj: patientsBloodGroupCount){
            System.out.println(obj[0]+ ":" +obj[1]);
        }

        List<Patient> allPatients = patientRepository.findAllPatients();
        for(Patient p: allPatients){
            System.out.println(p);
        }
    }
}
