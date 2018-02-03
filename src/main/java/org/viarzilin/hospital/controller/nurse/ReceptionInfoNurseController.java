package org.viarzilin.hospital.controller.nurse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.viarzilin.hospital.model.domain.Reception;
import org.viarzilin.hospital.model.domain.Rprescription;
import org.viarzilin.hospital.model.service.PrescriptionService;
import org.viarzilin.hospital.model.service.ReceptionService;
import org.viarzilin.hospital.model.service.RprescriptionService;


@Controller
public class ReceptionInfoNurseController {

  @Autowired(required = true)
  private ReceptionService receptionService;


  @Autowired
  private RprescriptionService rprescriptionService;


  @RequestMapping(value = "/nurse/receptiondata-for-nurse/{id}", method = RequestMethod.GET)
  public String listReceptions(@PathVariable("id") int id, Model model){

    model.addAttribute("reception", receptionService.getReceptionById(id));
    model.addAttribute("prescriptionsByReceptionId",
        rprescriptionService.listPrescriptionsByReceptionId(id));
    model.addAttribute("rprescription", new Rprescription());
    model.addAttribute("listRprescriptions", rprescriptionService.listRprescriptions());


    return "nurse/receptiondata-for-nurse";
  }


}
