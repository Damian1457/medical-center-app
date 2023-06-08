package pl.wasik.damian.spring.app.medicalcenter.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DOCTORS")
public class DoctorEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SPECIALIZATION")
    private String specialization;

    @Column(name = "YEARS_OF_EXPERIENCE")
    private int yearsOfExperience;

    @OneToOne
    private PatientEntity patientEntity;

    public DoctorEntity() {
    }

    public DoctorEntity(String name, String specialization, int yearsOfExperience) {
        this.name = name;
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
    }

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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
