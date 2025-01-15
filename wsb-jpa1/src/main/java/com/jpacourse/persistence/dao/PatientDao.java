package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;

@Repository
public class PatientDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addVisit(Long patientId, Long doctorId, Date visitDate) {
        PatientEntity patient = entityManager.find(PatientEntity.class, patientId);
        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);

        if (patient != null && doctor != null) {
            VisitEntity visit = new VisitEntity();
            visit.setVisitDate(visitDate); // Ustawienie daty wizyty
            visit.setDoctor(doctor); // Powiązanie wizyty z lekarzem
            visit.setPatient(patient); // Powiązanie wizyty z pacjentem

            patient.getVisits().add(visit);
            entityManager.merge(patient);
        }
    }

    @Transactional
    public PatientEntity findById(Long patientId) {
        return entityManager.find(PatientEntity.class, patientId);
    }
}
