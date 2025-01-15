package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    void testDeletePatientCascade() {
        // Given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName("John");
        patientEntity.setLastName("Doe");
        patientEntity.setAge(30);
        PatientEntity savedPatient = patientRepository.save(patientEntity);

        Long patientId = savedPatient.getId();

        // When
        patientService.deletePatient(patientId);

        // Then
        Optional<PatientEntity> deletedPatient = patientRepository.findById(patientId);
        assertTrue(deletedPatient.isEmpty(), "Patient should be deleted from the repository");
    }

    @Test
    void testGetPatientById() {
        // Given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName("John");
        patientEntity.setLastName("Doe");
        patientEntity.setAge(30);
        PatientEntity savedPatient = patientRepository.save(patientEntity);

        Long patientId = savedPatient.getId();

        // When
        PatientTO patientTO = patientService.getPatientById(patientId);

        // Then
        assertEquals("John", patientTO.getFirstName());
        assertEquals("Doe", patientTO.getLastName());
        assertEquals(30, patientTO.getAge());
    }
}
