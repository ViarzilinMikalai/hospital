package org.viarzilin.hospital.controller.nurse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.viarzilin.hospital.model.domain.Reception;
import org.viarzilin.hospital.model.service.ReceptionService;

@Controller
public class HospitalizedPatientsController {

  @Autowired(required = true)
  private ReceptionService receptionService;

  @RequestMapping(value = "nurse/hospitalized-receptions", method = RequestMethod.GET)
  public String listReceptions(Model model){
    model.addAttribute("reception", new Reception());
    model.addAttribute("listHospitalizedReceptions", this.receptionService.listHospitalizedReceptions());
    return "nurse/hospitalized-receptions";
  }

}
