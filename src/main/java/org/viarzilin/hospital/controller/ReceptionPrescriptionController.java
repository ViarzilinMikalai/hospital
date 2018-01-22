package org.viarzilin.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.viarzilin.hospital.model.entity.ReceptionPrescription;
import org.viarzilin.hospital.model.service.ReceptionPrescriptionService;

@Controller
public class ReceptionPrescriptionController {

    private ReceptionPrescriptionService receptionPrescriptionService;

    @Autowired(required = true)
    @Qualifier(value = "receptionPrescriptionService")
    public void setReceptionPrescriptionService(ReceptionPrescriptionService receptionPrescriptionService) {
        this.receptionPrescriptionService = receptionPrescriptionService;
    }

    @RequestMapping(value = "recprescr", method = RequestMethod.GET)
    public String listReceptionPrescriptions(Model model){
        model.addAttribute("receptionPrescription", new ReceptionPrescription());
        model.addAttribute("listReceptionPrescriptions", this.receptionPrescriptionService.listReceptionPrescriptions());

        return "recprescr";
    }

    @RequestMapping(value = "/recprescr/add", method = RequestMethod.POST)
    public String addReceptionPrescription(@ModelAttribute("receptionPrescription") ReceptionPrescription receptionPrescription){
        if(receptionPrescription.getId() == 0){
            this.receptionPrescriptionService.addReceptionPrescription(receptionPrescription);
        }else {
            this.receptionPrescriptionService.updateReceptionPrescription(receptionPrescription);
        }

        return "redirect:/recprescr";
    }

    @RequestMapping("/recprescr/remove/{id}")
    public String removeReceptionPrescription(@PathVariable("id") int id){
        this.receptionPrescriptionService.removeReceptionPrescription(id);

        return "redirect:/recprescr";
    }

    @RequestMapping("/recprescr/edit/{id}")
    public String editReceptionPrescription(@PathVariable("id") int id, Model model){
        model.addAttribute("receptionPrescription", this.receptionPrescriptionService.getReceptionPrescriptionById(id));
        model.addAttribute("listReceptionPrescriptions", this.receptionPrescriptionService.listReceptionPrescriptions());

        return "recprescr";
    }

    @RequestMapping("recprescrdata/{id}")
    public String receptionPrescriptionData(@PathVariable("id") int id, Model model){
        model.addAttribute("receptionPrescription", this.receptionPrescriptionService.getReceptionPrescriptionById(id));

        return "recprescrdata";
    }

}

