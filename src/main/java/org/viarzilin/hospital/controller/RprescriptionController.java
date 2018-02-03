package org.viarzilin.hospital.controller;

import org.viarzilin.hospital.model.domain.Rprescription;
import org.viarzilin.hospital.model.service.PrescriptionService;
import org.viarzilin.hospital.model.service.ReceptionService;
import org.viarzilin.hospital.model.service.RprescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.viarzilin.hospital.model.service.UserService;


@Controller
public class RprescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired(required = true)
    private ReceptionService receptionService;

    @Autowired
    private UserService userService;

    @Autowired(required = true)
    private RprescriptionService rprescriptionService;

    @RequestMapping(value = "rprescriptions", method = RequestMethod.GET)
    public String listRprescriptions(Model model){
        model.addAttribute("rprescription", new Rprescription());
        model.addAttribute("listRprescriptions", rprescriptionService.listRprescriptions());
        model.addAttribute("listHospitalizedReceptions", receptionService.listHospitalizedReceptions());
        model.addAttribute("listUsersByRoleDoctor", userService.listUsersByRoleDoctor());
        model.addAttribute("listPrescriptions", prescriptionService.listPrescriptions());

        return "rprescriptions";
    }

//    @RequestMapping(value = "/rprescriptions/add", method = RequestMethod.POST)
//    public String addRprescription(@ModelAttribute("rprescription") Rprescription rprescription){
//        if(rprescription.getId() == 0){
//            rprescriptionService.addRprescription(rprescription);
//        }else {
//            rprescriptionService.updateRprescription(rprescription);
//        }
//
//        return "redirect:/rprescriptions";
//    }

    @RequestMapping("/rprescriptions/remove/{id}")
    public String removeRprescription(@PathVariable("id") int id){
        rprescriptionService.removeRprescription(id);

        return "redirect:/rprescriptions";
    }

    @RequestMapping("/rprescriptions/edit/{id}")
    public String editRprescription(@PathVariable("id") int id, Model model){
        model.addAttribute("rprescription", rprescriptionService.getRprescriptionById(id));
        model.addAttribute("listRprescriptions", rprescriptionService.listRprescriptions());

        return "rprescriptions";
    }
}
