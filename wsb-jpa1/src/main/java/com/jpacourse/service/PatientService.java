package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    // Metoda pobierająca pacjenta po ID
    public PatientTO getPatientById(Long id) {
        Optional<PatientEntity> patientEntity = patientRepository.findById(id);
        return patientEntity.map(patientMapper::toTO).orElse(null);
    }

    // Metoda usuwająca pacjenta oraz powiązane wizyty (kaskadowo)
    @Transactional
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
