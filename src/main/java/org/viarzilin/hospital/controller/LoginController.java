package org.viarzilin.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.viarzilin.hospital.model.service.UserService;

@Controller
public class LoginController {

  @Autowired
  UserDetailsService userDetailsService;

  public LoginController() {
  }

  @RequestMapping(value = "/login")
  public String loginPage() {
    return "login";
  }

  @RequestMapping("/welcome")
  public String welcomePage(ModelMap model) {
    UserDetails user = getPrincipal();

    String page = "access_denied";

    if (user != null) {
      model.addAttribute("user", user.getUsername());

      switch (user.getAuthorities().toArray()[0].toString()) {
        case "ROLE_ADMIN":
          page = "admin/**";
          break;
        case "ROLE_CUSTOMER":
          page = "customer/customer";
          break;

        case "ROLE_MASTER":
          page = "master/master";
          break;

        default:
          break;
      }

    }

    return page;
  }

  @RequestMapping(value="/logout")
  public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null){
      new SecurityContextLogoutHandler().logout(request, response, authentication);
    }
    return "logout";
  }

  @RequestMapping(value = "/access_denied")
  public String accessDeniedPage(ModelMap model) {
    return "access_denied";
  }

  private UserDetails getPrincipal(){
    return SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails ? (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal() : null;
  }
}



