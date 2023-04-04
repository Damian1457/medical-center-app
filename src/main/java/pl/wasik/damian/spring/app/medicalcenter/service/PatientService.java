package pl.wasik.damian.spring.app.medicalcenter.service;

import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.medicalcenter.repository.PatientRepository;
import pl.wasik.damian.spring.app.medicalcenter.repository.entity.PatientEntity;
import pl.wasik.damian.spring.app.medicalcenter.web.model.PatientModel;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PatientService {

    private static final Logger LOGGER = Logger.getLogger(PatientService.class.getName());
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientModel getPatient(Long id, PatientModel patientModel) {
        LOGGER.info("getPatient(" + id + ")");
        Optional<PatientEntity> optionalPatientEntity = patientRepository.findById(id);
        PatientEntity patientEntity = optionalPatientEntity.orElseThrow();
//        patientModel = new PatientModel(patientModel.getName(), patientModel.getAge(), patientModel.getGender(), patientModel.getAddress(), patientModel.getPhoneNumber(), patientModel.getMedicalHistory());
        return patientModel;
    }
}
