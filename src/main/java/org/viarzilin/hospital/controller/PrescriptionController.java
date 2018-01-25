package org.viarzilin.hospital.controller;

import org.viarzilin.hospital.model.entity.Prescription;
import org.viarzilin.hospital.model.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PrescriptionController {
  @Autowired(required = true)
  private PrescriptionService prescriptionService;

  public void setPrescriptionService(PrescriptionService prescriptionService) {
    this.prescriptionService = prescriptionService;
  }

  @RequestMapping(value = "prescriptions", method = RequestMethod.GET)
  public String listPrescriptions(Model model){
    model.addAttribute("prescription", new Prescription());
    model.addAttribute("listPrescriptions", this.prescriptionService.listPrescriptions());

    return "prescriptions";
  }

  @RequestMapping(value = "/prescriptions/add", method = RequestMethod.POST)
  public String addPrescription(@ModelAttribute("prescription") Prescription prescription){
    if(prescription.getId() == 0){
      this.prescriptionService.addPrescription(prescription);
    }else {
      this.prescriptionService.updatePrescription(prescription);
    }

    return "redirect:/prescriptions";
  }

  @RequestMapping("/prescriptions/remove/{id}")
  public String removePrescription(@PathVariable("id") int id){
    this.prescriptionService.removePrescription(id);

    return "redirect:/prescriptions";
  }

  @RequestMapping("/prescriptions/edit/{id}")
  public String editPrescription(@PathVariable("id") int id, Model model){
    model.addAttribute("prescription", this.prescriptionService.getPrescriptionById(id));
    model.addAttribute("listPrescriptions", this.prescriptionService.listPrescriptions());

    return "prescriptions";
  }

  @RequestMapping("prescriptiondata/{id}")
  public String prescriptionData(@PathVariable("id") int id, Model model){
    model.addAttribute("prescription", this.prescriptionService.getPrescriptionById(id));

    return "prescriptiondata";
  }
}
