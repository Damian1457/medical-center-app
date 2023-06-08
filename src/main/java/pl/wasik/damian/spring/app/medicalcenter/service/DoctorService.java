package pl.wasik.damian.spring.app.medicalcenter.service;

import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.medicalcenter.repository.DoctorRepository;
import pl.wasik.damian.spring.app.medicalcenter.repository.entity.DoctorEntity;
import pl.wasik.damian.spring.app.medicalcenter.web.model.DoctorModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class DoctorService {

    private static final Logger LOGGER = Logger.getLogger(DoctorService.class.getName());
    private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public DoctorModel getDoctor(Long id) {
        LOGGER.info("getDoctor(" + id + ")");
        Optional<DoctorEntity> optionalDoctorEntity = doctorRepository.findById(id);
        DoctorEntity doctorEntity = optionalDoctorEntity.orElseThrow();

        return new DoctorModel(
                doctorEntity.getName(),
                doctorEntity.getSpecialization(),
                doctorEntity.getYearsOfExperience()
        );
    }

    public DoctorModel createDoctor(DoctorModel doctorModel) {
        LOGGER.info("createDoctor(" + doctorModel + ")");

        DoctorEntity doctorEntity = new DoctorEntity(
                doctorModel.getName(),
                doctorModel.getSpecialization(),
                doctorModel.getYearsOfExperience()
        );
        DoctorEntity savedDoctorEntity = doctorRepository.save(doctorEntity);

        return new DoctorModel(
                savedDoctorEntity.getName(),
                savedDoctorEntity.getSpecialization(),
                savedDoctorEntity.getYearsOfExperience()
        );
    }

    public DoctorModel updateDoctor(Long id, DoctorModel doctorModel) {
        LOGGER.info("updateDoctor(" + id + ", " + doctorModel + ")");

        Optional<DoctorEntity> optionalDoctorEntity = doctorRepository.findById(id);
        DoctorEntity doctorEntity = optionalDoctorEntity.orElseThrow();
        doctorEntity.setName(doctorModel.getName());
        doctorEntity.setSpecialization(doctorModel.getSpecialization());
        doctorEntity.setYearsOfExperience(doctorModel.getYearsOfExperience());

        DoctorEntity updateDoctorEntity = doctorRepository.save(doctorEntity);

        return new DoctorModel(
                updateDoctorEntity.getName(),
                updateDoctorEntity.getSpecialization(),
                updateDoctorEntity.getYearsOfExperience()
        );
    }

    public void deleteDoctor(Long id) {
        LOGGER.info("deleteDoctor(" + id + ")");

        Optional<DoctorEntity> optionalDoctorEntity = doctorRepository.findById(id);
        DoctorEntity doctorEntity = optionalDoctorEntity.orElseThrow();
        doctorRepository.delete(doctorEntity);
    }

    public List<DoctorModel> getAllDoctors() {
        LOGGER.info("getAllDoctors()");

        List<DoctorEntity> doctorEntities = doctorRepository.findAll();
        List<DoctorModel> doctorModels = new ArrayList<>();

        for (DoctorEntity doctorEntity : doctorEntities) {
            doctorModels.add(new DoctorModel(
                    doctorEntity.getName(),
                    doctorEntity.getSpecialization(),
                    doctorEntity.getYearsOfExperience()
            ));
        }
        return doctorModels;
    }
}
