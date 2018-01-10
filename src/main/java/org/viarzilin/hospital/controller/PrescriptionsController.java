package org.viarzilin.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.viarzilin.hospital.model.entity.Prescription;
import org.viarzilin.hospital.model.service.PrescriptionsService;

public class PrescriptionsController {

  private PrescriptionsService prescriptionsService;

  @Autowired(required = true)
  @Qualifier(value = "prescriptionsService")
  public void setPrescriptionsService(
      PrescriptionsService prescriptionsService) {
    this.prescriptionsService = prescriptionsService;
  }

  @RequestMapping(value = "prescriptions", method = RequestMethod.GET)
  public String getAllPresc(Model model){
    model.addAttribute("prescription", new Prescription());
    model.addAttribute("getAllPresc()", this.prescriptionsService.getAllPresc());

    return "prescriptions";
  }

  @RequestMapping(value = "prescriptions/add", method = RequestMethod.POST)
  public String addPrescription(@ModelAttribute("prescription") Prescription prescription){
    if (prescription.getIdPrescription() == 0){
      this.prescriptionsService.addPrescription(prescription);
    } else {
      this.prescriptionsService.updatePrescription(prescription);
    }

    return "redirect:/prescriptions";
  }

  @RequestMapping("/remove/{idPrescription}")
  public String removePrescription(@PathVariable("idPrescription") int idPrescription){
    this.prescriptionsService.removePrescription(idPrescription);

    return "redirect:/prescriptions";
  }

  @RequestMapping("edit/{idPrescription}")
  public String editPrescription(@PathVariable("idPrescription") int idPrescription, Model model){
    model.addAttribute("prescription", this.prescriptionsService.getPrescById(idPrescription));
    model.addAttribute("getAllPresc()", this.prescriptionsService.getAllPresc());

    return "redirect:/prescriptions";
  }

  @RequestMapping("prescriptiondata/{idPrescription}")
  public String prescriptionData(@PathVariable("idPrescription") int idPrescription, Model model){
    model.addAttribute("prescription", this.prescriptionsService.getPrescById(idPrescription));

    return "prescriptiondata";
  }
}
