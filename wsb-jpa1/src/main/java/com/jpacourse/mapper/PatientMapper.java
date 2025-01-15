package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.entity.PatientEntity;
import org.springframework.stereotype.Component;

// Mapowanie encji PatientEntity na Transfer Object (TO)
@Component
public class PatientMapper {
    public PatientTO toTO(PatientEntity entity) {
        PatientTO to = new PatientTO();
        to.setId(entity.getId());
        to.setFirstName(entity.getFirstName());
        to.setLastName(entity.getLastName());
        to.setAge(entity.getAge());
        // Mapowanie innych pól jeśli wymagane
        return to;
    }
}
