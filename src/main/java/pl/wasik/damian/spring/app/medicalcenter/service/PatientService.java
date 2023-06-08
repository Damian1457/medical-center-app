package pl.wasik.damian.spring.app.medicalcenter.service;

import org.springframework.stereotype.Service;
import pl.wasik.damian.spring.app.medicalcenter.mapper.PatientMapper;
import pl.wasik.damian.spring.app.medicalcenter.repository.PatientRepository;
import pl.wasik.damian.spring.app.medicalcenter.repository.entity.PatientEntity;
import pl.wasik.damian.spring.app.medicalcenter.web.model.PatientModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PatientService {

    private static final Logger LOGGER = Logger.getLogger(PatientService.class.getName());
    private PatientRepository patientRepository;
    private PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientModel create(PatientModel patientModel) {
        LOGGER.info("createPatient(" + patientModel + ")");
        PatientEntity createPatient = patientMapper.mapToPatientEntity(patientModel);
        PatientEntity savedPatient = patientRepository.save(createPatient);
        return patientMapper.mapToPatientModel(savedPatient);
    }

    public PatientModel read(Long id) {
        LOGGER.info("getPatient(" + id + ")");
        Optional<PatientEntity> getPatient = patientRepository.findById(id);
        PatientEntity patientEntity = getPatient.orElseThrow();
        return patientMapper.mapToPatientModel(patientEntity);
    }

    public PatientModel update(Long id, PatientModel patientModel) {
        LOGGER.info("updatePatient(" + id + ", " + patientModel + ")");
        Optional<PatientEntity> optionalPatientEntity = patientRepository.findById(id);
        PatientEntity patientEntity = optionalPatientEntity.orElseThrow();
        PatientEntity updatedPatientEntity = patientMapper.mapToUpdatePatientEntity(patientEntity, patientModel);
        PatientEntity savedPatientEntity = patientRepository.save(updatedPatientEntity);
        return patientMapper.mapToPatientModel(savedPatientEntity);
    }

    public void delete(Long id) {
        LOGGER.info("deletePatient(" + id + ")");
        Optional<PatientEntity> optionalPatientEntity = patientRepository.findById(id);
        PatientEntity patientEntity = optionalPatientEntity.orElseThrow();
        patientRepository.delete(patientEntity);
    }

    public List<PatientModel> getAllPatients() {
        LOGGER.info("getAllPatients()");

        List<PatientEntity> patientEntities = patientRepository.findAll();
        List<PatientModel> patientModels = new ArrayList<>();

        for (PatientEntity patientEntity : patientEntities) {
            patientModels.add(new PatientModel(
                    patientEntity.getId(),
                    patientEntity.getName(),
                    patientEntity.getAge(),
                    patientEntity.getGender(),
                    patientEntity.getAddress(),
                    patientEntity.getPhoneNumber(),
                    patientEntity.getMedicalHistory()
            ));
        }
        return patientModels;
    }
}
