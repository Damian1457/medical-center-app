package pl.wasik.damian.spring.app.medicalcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wasik.damian.spring.app.medicalcenter.repository.entity.DoctorEntity;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
}
