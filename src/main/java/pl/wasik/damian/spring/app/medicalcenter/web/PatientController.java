package pl.wasik.damian.spring.app.medicalcenter.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wasik.damian.spring.app.medicalcenter.service.PatientService;
import pl.wasik.damian.spring.app.medicalcenter.web.model.PatientModel;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/patients") // http://localhost:8080/patients
public class PatientController {

    private static final Logger LOGGER = Logger.getLogger(PatientController.class.getName());
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients/{id}")
    public PatientModel getPatient(@PathVariable Long id, PatientModel patientModel) {
        LOGGER.info("getPatient(" + id + ")");
        return patientService.getPatient(id, patientModel);
    }
}
// TODO: 04.04.2023 Dla modeli patient i doctor stworzyć:
// modele i encje 1:1 na chwilę obecną
// controller, service i repository
// testy jednostkowe do repository
// stworzyć widoki html: lista modeli, dodawanie nowego modelu - lista pacjentów i lekarzy i dodawanie nowych pacjentów i lekarzy
