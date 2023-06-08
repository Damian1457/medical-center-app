package pl.wasik.damian.spring.app.medicalcenter.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.wasik.damian.spring.app.medicalcenter.service.DoctorService;
import pl.wasik.damian.spring.app.medicalcenter.web.model.DoctorModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/doctors") //http://localhost:8080/doctors
public class DoctorController {

    private static final Logger LOGGER = Logger.getLogger(DoctorController.class.getName());
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    //Wyjaśnić Jackowi co działbym osiągnąć gdybym dodał jako atrybut DoctorModel doctorModel;
    @GetMapping("/{id}")
    public DoctorModel read(@PathVariable Long id) {
        LOGGER.info("getDoctor(" + id + ")");
        return doctorService.getDoctor(id);
    }

    @PostMapping()
    public DoctorModel create(@RequestBody DoctorModel doctorModel) {
        LOGGER.info("updateDoctor(" + doctorModel + ")");
        return doctorService.createDoctor(doctorModel);
    }

    @PutMapping("/{id}")
    public DoctorModel update(@PathVariable Long id, @RequestBody DoctorModel doctorModel) {
        LOGGER.info("updateDoctor(" + id + ", " + doctorModel + ")");
        return doctorService.updateDoctor(id, doctorModel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        LOGGER.info("deleteDoctor(" + id + ")");
        doctorService.deleteDoctor(id);
    }

    @GetMapping()
    public List<DoctorModel> getAllDoctors() {
        LOGGER.info("getAllDoctors()");
        return doctorService.getAllDoctors();
    }
}
