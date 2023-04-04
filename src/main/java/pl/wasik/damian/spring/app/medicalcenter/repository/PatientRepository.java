package pl.wasik.damian.spring.app.medicalcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wasik.damian.spring.app.medicalcenter.repository.entity.PatientEntity;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

//    private static final Logger LOGGER = Logger.getLogger(PatientRepository.class.getName());
//
//    public void patient() {
//        LOGGER.info("patient()");
//    }
}
