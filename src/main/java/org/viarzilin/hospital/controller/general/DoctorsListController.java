package org.viarzilin.hospital.controller.general;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.viarzilin.hospital.model.domain.User;
import org.viarzilin.hospital.model.service.UserService;

@Controller
public class DoctorsListController {

  @Autowired(required = true)
  private UserService userService;

  @RequestMapping(value = "general/doctorslist", method = RequestMethod.GET)
  public String listUsersByRoleDoctor(Model model){
    model.addAttribute("user", new User());
    model.addAttribute("listUsersByRoleDoctor", userService.listUsersByRoleDoctor());
    return "general/doctorslist";
  }
}
