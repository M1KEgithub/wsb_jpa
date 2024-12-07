package com.jpacourse.persistence.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	// Relacja dwustronna (Visit jest dzieckiem, Patient jest rodzicem)
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	private PatientEntity patient;

	// Relacja dwustronna (Visit jest dzieckiem, Doctor jest rodzicem)
	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	private DoctorEntity doctor;

	// Relacja jednostronna od strony rodzica (Visit jest właścicielem relacji)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "visit_id", nullable = false)
	private List<MedicalTreatmentEntity> treatments = new ArrayList<>();



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

}
