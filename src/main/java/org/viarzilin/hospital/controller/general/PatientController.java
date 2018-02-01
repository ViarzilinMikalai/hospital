package org.viarzilin.hospital.controller.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.viarzilin.hospital.model.domain.Patient;
import org.viarzilin.hospital.model.service.PatientService;

@Controller
public class PatientController {

  @Autowired(required = true)
  private PatientService patientService;


  @RequestMapping(value = "general/patients", method = RequestMethod.GET)
  public String listPatients(Model model){
    model.addAttribute("patient", new Patient());
    model.addAttribute("listPatients", this.patientService.listPatients());

    return "general/patients";
  }

  @RequestMapping(value = "/general/patients/add", method = RequestMethod.POST)
  public String addPatient(@ModelAttribute("patient") Patient patient){
    if(patient.getId() == 0){
      this.patientService.addPatient(patient);
    }else {
      this.patientService.updatePatient(patient);
    }

    return "redirect:/general/patients";
  }

  @RequestMapping("/general/patients/remove/{id}")
  public String removePatient(@PathVariable("id") int id){
    this.patientService.removePatient(id);

    return "redirect:/general/patients";
  }

  @RequestMapping("/general/patients/edit/{id}")
  public String editPatient(@PathVariable("id") int id, Model model){
    model.addAttribute("patient", this.patientService.getPatientById(id));
    model.addAttribute("listPatients", this.patientService.listPatients());

    return "general/patients";
  }

//  @RequestMapping("patientdata/{id}")
//  public String patientData(@PathVariable("id") int id, Model model){
//    model.addAttribute("patient", this.patientService.getPatientById(id));
//
//    return "patientdata";
//  }
}
