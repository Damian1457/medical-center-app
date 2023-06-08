package pl.wasik.damian.spring.app.medicalcenter.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wasik.damian.spring.app.medicalcenter.service.PatientService;
import pl.wasik.damian.spring.app.medicalcenter.web.model.PatientModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/patients") // http://localhost:8080/patients
public class PatientController {
    private static final Logger LOGGER = Logger.getLogger(PatientController.class.getName());
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("createView()");
        return "medical/patient";
    }

    @PostMapping
    public String create(PatientModel patientModel) {
        LOGGER.info("createPatient(" + patientModel + ")");
        patientService.create(patientModel);
        return "redirect:/patients";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable Long id) {
        LOGGER.info("getPatient(" + id + ")");
        patientService.read(id);
        return "medical/patient";
    }

    @PutMapping("/{id}")
    public PatientModel update(@PathVariable Long id, @RequestBody PatientModel patientModel) {
        LOGGER.info("updatePatient(" + id + ", " + patientModel + ")");
        return patientService.update(id, patientModel);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        LOGGER.info("deletePatient(" + id + ")");
        patientService.delete(id);
    }

    @GetMapping
//    public List<PatientModel> getAllPatients() {
    public String getAllPatients(ModelMap modelMap) {
        LOGGER.info("getAllPatients()");
        List<PatientModel> patients = patientService.getAllPatients();
        modelMap.addAttribute("patients", patients);
        return "medical/patients";
    }
}

// TODO: 11.04.2023 Przećwiczyć Thymleafa

// TODO: 04.04.2023 Dla modeli patient i doctor stworzyć:
// modele i encje 1:1 na chwilę obecną
// controller, service i repository
// testy jednostkowe do repository
// stworzyć widoki html: lista modeli, dodawanie nowego modelu - lista pacjentów i lekarzy i dodawanie nowych pacjentów i lekarzy


// TODO: 19.05.2023 pozostałe metody zrobić.