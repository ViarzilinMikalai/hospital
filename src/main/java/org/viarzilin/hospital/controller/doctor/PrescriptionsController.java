package org.viarzilin.hospital.controller.doctor;

import org.viarzilin.hospital.model.domain.Prescription;
import org.viarzilin.hospital.model.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PrescriptionsController {

  @Autowired(required = true)
  private PrescriptionService prescriptionService;

  @RequestMapping(value = "doctor/prescriptions", method = RequestMethod.GET)
  public String listPrescriptions(Model model){
    model.addAttribute("prescription", new Prescription());
    model.addAttribute("listPrescriptions", prescriptionService.listPrescriptions());

    return "doctor/prescriptions";
  }


  @RequestMapping(value = "/doctor/prescriptions/add", method = RequestMethod.POST)
  public String addPrescription(@ModelAttribute("prescription") Prescription prescription){
    if(prescription.getId() == 0){
      prescriptionService.addPrescription(prescription);
    }else {
      prescriptionService.updatePrescription(prescription);
    }

    return "redirect:/doctor/prescriptions";
  }


  @RequestMapping("/doctor/prescriptions/remove/{id}")
  public String removePrescription(@PathVariable("id") int id){
    prescriptionService.removePrescription(id);

    return "redirect:/doctor/prescriptions";
  }


  @RequestMapping("/doctor/prescriptions/edit/{id}")
  public String editPrescription(@PathVariable("id") int id, Model model){
    model.addAttribute("prescription", prescriptionService.getPrescriptionById(id));
    model.addAttribute("listPrescriptions", prescriptionService.listPrescriptions());

    return "doctor/prescriptions";
  }
}
