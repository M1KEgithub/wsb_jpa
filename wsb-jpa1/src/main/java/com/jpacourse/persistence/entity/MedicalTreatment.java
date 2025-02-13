package com.jpacourse.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name="medical_treatment")
public class MedicalTreatment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	// Gettery i settery
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
