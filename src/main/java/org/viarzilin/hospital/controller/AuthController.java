package org.viarzilin.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.viarzilin.hospital.model.domain.Auth;
import org.viarzilin.hospital.model.service.AuthService;

@Controller
public class AuthController {

    @Autowired(required = true)
    private AuthService authService;

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping(value = "authes", method = RequestMethod.GET)
    public String listAuthes(Model model){
        model.addAttribute("auth", new Auth());
        model.addAttribute("listAuthes", this.authService.listAuthes());

        return "authes";
    }

    @RequestMapping(value = "/authes/add", method = RequestMethod.POST)
    public String addAuth(@ModelAttribute("auth") Auth auth){
        if(auth.getId() == 0){
            this.authService.addAuth(auth);
        }else {
            this.authService.updateAuth(auth);
        }

        return "redirect:/authes";
    }

    @RequestMapping("/authes/remove/{id}")
    public String removeAuth(@PathVariable("id") int id){
        this.authService.removeAuth(id);

        return "redirect:/authes";
    }

    @RequestMapping("/authes/edit/{id}")
    public String editAuth(@PathVariable("id") int id, Model model){
        model.addAttribute("auth", this.authService.getAuthById(id));
        model.addAttribute("listAuthes", this.authService.listAuthes());

        return "authes";
    }

    @RequestMapping("authdata/{id}")
    public String authData(@PathVariable("id") int id, Model model){
        model.addAttribute("auth", this.authService.getAuthById(id));

        return "authdata";
    }

}
