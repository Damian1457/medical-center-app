package pl.wasik.damian.spring.app.medicalcenter.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.wasik.damian.spring.app.medicalcenter.repository.entity.DoctorEntity;

import java.util.Optional;

@SpringBootTest
class DoctorRepositoryTest {

    public static final String NAME_JACEK = "Jacek";
    public static final int YEARS_OF_EXPERIENCE_10 = 10;
    public static final String SPECIALIZATION_DENTIST = "Dentist";

    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    void shouldSaveDoctorEntityToRepository() {
        //Given
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setName(NAME_JACEK);
        doctorEntity.setYearsOfExperience(YEARS_OF_EXPERIENCE_10);
        doctorEntity.setSpecialization(SPECIALIZATION_DENTIST);

        //When
        doctorRepository.save(doctorEntity);
        Optional<DoctorEntity> result = doctorRepository.findById(doctorEntity.getId());

        //Then
        Assertions.assertThat(result).isPresent();
        Assertions.assertThat(result.get().getName()).isEqualTo(NAME_JACEK);
        Assertions.assertThat(result.get().getYearsOfExperience()).isEqualTo(YEARS_OF_EXPERIENCE_10);
        Assertions.assertThat(result.get().getSpecialization()).isEqualTo(SPECIALIZATION_DENTIST);
    }
}