package org.viarzilin.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.viarzilin.hospital.model.domain.User;
import org.viarzilin.hospital.model.service.UserService;

@Controller
public class UserController {

  @Autowired(required = true)
  private UserService userService;

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "admin/users", method = RequestMethod.GET)
  public String listUsers(Model model){
    model.addAttribute("user", new User());
    model.addAttribute("listUsers", this.userService.listUsers());

    return "admin/users";
  }

  @RequestMapping(value = "/admin/users/add", method = RequestMethod.POST)
  public String addUser(@ModelAttribute("user") User user){
    if(user.getId() == 0){
      this.userService.addUser(user);
    }else {
      this.userService.updateUser(user);
    }

    return "redirect:/admin/users";
  }

  @RequestMapping("/admin/users/remove/{id}")
  public String removeUser(@PathVariable("id") int id){
    this.userService.removeUser(id);

    return "redirect:/admin/users";
  }

  @RequestMapping("/admin/users/edit/{id}")
  public String editUser(@PathVariable("id") int id, Model model){
    model.addAttribute("user", this.userService.getUserById(id));
    model.addAttribute("listUsers", this.userService.listUsers());

    return "admin/users";
  }

  @RequestMapping("admin/userdata/{id}")
  public String userData(@PathVariable("id") int id, Model model){
    model.addAttribute("user", this.userService.getUserById(id));

    return "admin/userdata";
  }

}
