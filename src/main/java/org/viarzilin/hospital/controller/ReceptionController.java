package org.viarzilin.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.viarzilin.hospital.model.domain.Patient;
import org.viarzilin.hospital.model.domain.Reception;
import org.viarzilin.hospital.model.domain.Rprescription;
import org.viarzilin.hospital.model.domain.User;
import org.viarzilin.hospital.model.service.PatientService;
import org.viarzilin.hospital.model.service.ReceptionService;
import org.viarzilin.hospital.model.service.RprescriptionService;
import org.viarzilin.hospital.model.service.UserService;

@Controller
public class ReceptionController {

    @Autowired(required = true)
    private ReceptionService receptionService;

    @Autowired
    private UserService userService;

    @Autowired
    private RprescriptionService rprescriptionService;

    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "receptions", method = RequestMethod.GET)
    public String listReceptions(Model model){
        model.addAttribute("reception", new Reception());
        model.addAttribute("listReceptions", this.receptionService.listReceptions());
        model.addAttribute("user", new User());
        model.addAttribute("listUsersByRoleDoctor", userService.listUsersByRoleDoctor());
        model.addAttribute("patient", new Patient());
        model.addAttribute("listPatients", patientService.listPatients());

//
//        model.addAttribute("rprescription", new Rprescription());
//        model.addAttribute("listRprescriptions", rprescriptionService.listRprescriptions());
//

        return "receptions";
    }

    @RequestMapping(value = "/receptions/add", method = RequestMethod.POST)
    public String addReception(@ModelAttribute("reception") Reception reception){

        if(reception.getId() == 0){
            receptionService.addReception(reception);
        }else {
            receptionService.updateReception(reception);
        }

        return "redirect:/receptions";
    }

    @RequestMapping("/receptions/remove/{id}")
    public String removeReception(@PathVariable("id") int id){
        receptionService.removeReception(id);

        return "redirect:/receptions";
    }

    @RequestMapping("/receptions/edit/{id}")
    public String editReception(@PathVariable("id") int id, Model model){
        model.addAttribute("reception", receptionService.getReceptionById(id));
        model.addAttribute("listReceptions", receptionService.listReceptions());

        return "receptions";
    }

    @RequestMapping("receptiondata/{id}")
    public String receptionData(@PathVariable("id") int id, Model model){
        model.addAttribute("reception", receptionService.getReceptionById(id));
        model.addAttribute("prescriptionsByReceptionId",
            rprescriptionService.listPrescriptionsByReceptionId(id));


        return "receptiondata";
    }

    @RequestMapping(value = "/receptions/discharge", method = RequestMethod.POST)
    public String dischargeReception(@ModelAttribute("reception") Reception reception){

            receptionService.dischargePatient(reception);

        return "redirect:/receptions";
    }
}
