package org.viarzilin.hospital.controller.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.viarzilin.hospital.model.domain.Patient;
import org.viarzilin.hospital.model.domain.Reception;
import org.viarzilin.hospital.model.service.PatientService;
import org.viarzilin.hospital.model.service.ReceptionService;

@Controller
public class PatientController {

  @Autowired(required = true)
  private PatientService patientService;

  @Autowired
  private ReceptionService receptionService;

  @RequestMapping(value = "general/patients", method = RequestMethod.GET)
  public String listPatients(Model model){
    model.addAttribute("patient", new Patient());
    model.addAttribute("listPatients", patientService.listPatients());

    return "general/patients";
  }

  @RequestMapping(value = "/general/patients/add", method = RequestMethod.POST)
  public String addPatient(@ModelAttribute("patient") Patient patient){
    if(patient.getId() == 0){
      patientService.addPatient(patient);
    }else {
      patientService.updatePatient(patient);
    }

    return "redirect:/general/patients";
  }

  @RequestMapping("/general/patients/remove/{id}")
  public String removePatient(@PathVariable("id") int id){
    patientService.removePatient(id);

    return "redirect:/general/patients";
  }

  @RequestMapping("/general/patients/edit/{id}")
  public String editPatient(@PathVariable("id") int id, Model model){
    model.addAttribute("patient", patientService.getPatientById(id));
    model.addAttribute("listPatients", patientService.listPatients());

    return "general/patients";
  }



}
