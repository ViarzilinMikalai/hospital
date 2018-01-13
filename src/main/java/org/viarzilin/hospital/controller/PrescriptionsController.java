package org.viarzilin.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.viarzilin.hospital.model.entity.Prescription;
import org.viarzilin.hospital.model.service.PrescriptionsService;

@Controller
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
    model.addAttribute("getAllPresc", this.prescriptionsService.getAllPresc());

    return "prescriptions";
  }

  @RequestMapping(value = "/prescriptions/add", method = RequestMethod.POST)
  public String addPrescription(@ModelAttribute("prescription") Prescription prescription){
    if (prescription.getId() == 0){
      this.prescriptionsService.addPrescription(prescription);
    } else {
      this.prescriptionsService.updatePrescription(prescription);
    }

    return "redirect:/prescriptions";
  }

  @RequestMapping("/remove/{id}")
  public String removePrescription(@PathVariable("id") int id){
    this.prescriptionsService.removePrescription(id);

    return "redirect:/prescriptions";
  }

  @RequestMapping("edit/{id}")
  public String editPrescription(@PathVariable("id") int id, Model model){
    model.addAttribute("prescription", this.prescriptionsService.getPrescById(id));
    model.addAttribute("getAllPresc", this.prescriptionsService.getAllPresc());

    return "redirect:/prescriptions";
  }

  @RequestMapping("prescriptiondata/{id}")
  public String prescriptionData(@PathVariable("id") int id, Model model){
    model.addAttribute("prescription", this.prescriptionsService.getPrescById(id));

    return "prescriptiondata";
  }
}
