package org.viarzilin.hospital.controller.doctor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.viarzilin.hospital.model.domain.Reception;
import org.viarzilin.hospital.model.service.PatientService;
import org.viarzilin.hospital.model.service.ReceptionService;
import org.viarzilin.hospital.model.service.RprescriptionService;
import org.viarzilin.hospital.model.service.UserService;


@Controller
public class AllReceptionsController {

    @Autowired(required = true)
    private ReceptionService receptionService;

    @Autowired
    private UserService userService;

//    @Autowired
//    private RprescriptionService rprescriptionService;

    @Autowired
    private PatientService patientService;


    @RequestMapping(value = "doctor/all-patient-receptions", method = RequestMethod.GET)
    public String listReceptions(Model model){
        model.addAttribute("reception", new Reception());
        model.addAttribute("listReceptions", this.receptionService.listReceptions());
        model.addAttribute("listUsersByRoleDoctor", userService.listUsersByRoleDoctor());
        model.addAttribute("listPatients", patientService.listPatients());

        return "doctor/all-patient-receptions";
    }


    @RequestMapping(value = "/doctor/all-patient-receptions/add", method = RequestMethod.POST)
    public String addReception(@ModelAttribute("reception") Reception reception){

        if(reception.getId() == 0){
            receptionService.addReception(reception);
        }else {
            receptionService.updateReception(reception);
        }

        return "redirect:/doctor/all-patient-receptions";
    }


    @RequestMapping("/doctor/all-patient-receptions/remove/{id}")
    public String removeReception(@PathVariable("id") int id){
        receptionService.removeReception(id);

        return "redirect:/doctor/all-patient-receptions";
    }


    @RequestMapping("/doctor/all-patient-receptions/edit/{id}")
    public String editReception(@PathVariable("id") int id, Model model){
        model.addAttribute("reception", receptionService.getReceptionById(id));
        model.addAttribute("listReceptions", receptionService.listReceptions());
        model.addAttribute("listPatients", patientService.listPatients());
        model.addAttribute("listUsersByRoleDoctor", userService.listUsersByRoleDoctor());

        return "doctor/all-patient-receptions";
    }

}
