package org.viarzilin.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.viarzilin.hospital.model.domain.Reception;
import org.viarzilin.hospital.model.service.ReceptionService;

@Controller
public class ReceptionController {

    @Autowired(required = true)
    private ReceptionService receptionService;

//    public void setReceptionService(ReceptionService receptionService) {
//        this.receptionService = receptionService;
//    }

    @RequestMapping(value = "receptions", method = RequestMethod.GET)
    public String listReceptions(Model model){
        model.addAttribute("reception", new Reception());
        model.addAttribute("listReceptions", this.receptionService.listReceptions());

        return "receptions";
    }

    @RequestMapping(value = "/receptions/add", method = RequestMethod.POST)
    public String addReception(@ModelAttribute("reception") Reception reception){
        if(reception.getId() == 0){
            this.receptionService.addReception(reception);
        }else {
            this.receptionService.updateReception(reception);
        }

        return "redirect:/receptions";
    }

    @RequestMapping("/receptions/remove/{id}")
    public String removeReception(@PathVariable("id") int id){
        this.receptionService.removeReception(id);

        return "redirect:/receptions";
    }

    @RequestMapping("/receptions/edit/{id}")
    public String editReception(@PathVariable("id") int id, Model model){
        model.addAttribute("reception", this.receptionService.getReceptionById(id));
        model.addAttribute("listReceptions", this.receptionService.listReceptions());

        return "receptions";
    }

    @RequestMapping("receptiondata/{id}")
    public String receptionData(@PathVariable("id") int id, Model model){
        model.addAttribute("reception", this.receptionService.getReceptionById(id));

        return "receptiondata";
    }

}
