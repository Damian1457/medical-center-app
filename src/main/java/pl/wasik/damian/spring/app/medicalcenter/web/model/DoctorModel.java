package pl.wasik.damian.spring.app.medicalcenter.web.model;

public class DoctorModel {
    private String name;
    private String specialization;
    private int yearsOfExperience;

    public DoctorModel(String name, String specialization, int yearsOfExperience) {
        this.name = name;
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
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
