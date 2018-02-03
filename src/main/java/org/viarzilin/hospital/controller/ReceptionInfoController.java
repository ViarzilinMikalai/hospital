package org.viarzilin.hospital.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.viarzilin.hospital.model.domain.Reception;
import org.viarzilin.hospital.model.domain.Rprescription;
import org.viarzilin.hospital.model.service.PatientService;
import org.viarzilin.hospital.model.service.PrescriptionService;
import org.viarzilin.hospital.model.service.ReceptionService;
import org.viarzilin.hospital.model.service.RprescriptionService;
import org.viarzilin.hospital.model.service.UserService;


@Controller
public class ReceptionInfoController {

  @Autowired(required = true)
  private ReceptionService receptionService;

  @Autowired
  private UserService userService;

  @Autowired
  private RprescriptionService rprescriptionService;

  @Autowired
  private PatientService patientService;

  @Autowired
  private PrescriptionService prescriptionService;


  @RequestMapping(value = "receptiondata/{id}", method = RequestMethod.GET)
  public String listReceptions(@PathVariable("id") int id, Model model){

    model.addAttribute("reception", receptionService.getReceptionById(id));
    model.addAttribute("prescriptionsByReceptionId",
        rprescriptionService.listPrescriptionsByReceptionId(id));
    model.addAttribute("rprescription", new Rprescription());
    model.addAttribute("listRprescriptions", rprescriptionService.listRprescriptions());
    model.addAttribute("listPrescriptions", prescriptionService.listPrescriptions());
    model.addAttribute("listHospitalizedReceptions", receptionService.listHospitalizedReceptions());

    return "receptiondata";
  }


  @RequestMapping(value = "/receptiondata/{id}/addprescription", method = RequestMethod.POST)
  public String addRprescription(@ModelAttribute("rprescription") Rprescription rprescription){
    if(rprescription.getId() == 0){
      rprescriptionService.addRprescription(rprescription);
    }else {
      rprescriptionService.updateRprescription(rprescription);
    }

    return "redirect:/receptiondata/{id}/";
  }


  @RequestMapping(value = "/receptions/discharge", method = RequestMethod.POST)
  public String dischargeReception(@ModelAttribute("reception") Reception reception){

    receptionService.dischargePatient(reception);

    return "redirect:/receptions";
  }


}
