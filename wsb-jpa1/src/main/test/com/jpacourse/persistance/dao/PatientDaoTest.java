package com.jpacourse.persistance.dao;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Test
    void testAddVisitToPatient() {
        // Given
        Long patientId = 1L; // Pacjent z istniejącej bazy
        Long doctorId = 1L;  // Lekarz z istniejącej bazy
        Date visitDate = new Date(); // Użycie aktualnej daty jako daty wizyty

        // When
        patientDao.addVisit(patientId, doctorId, visitDate);

        // Then
        PatientEntity patient = patientDao.findById(patientId);
        assertNotNull(patient, "Patient should not be null after adding a visit.");
        assertFalse(patient.getVisits().isEmpty(), "Patient should have at least one visit.");

        VisitEntity visit = patient.getVisits().iterator().next();
        assertNotNull(visit, "Visit should not be null.");
        assertEquals(doctorId, visit.getDoctor().getId(), "Doctor ID should match.");
        assertEquals(patientId, visit.getPatient().getId(), "Patient ID should match.");
        assertNotNull(visit.getVisitDate(), "Visit date should not be null.");
    }
}