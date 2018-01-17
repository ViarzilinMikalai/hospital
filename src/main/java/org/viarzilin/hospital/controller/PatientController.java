package org.viarzilin.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.viarzilin.hospital.model.service.PatientService;

@Controller
public class PatientController {
  private PatientService patientService;

  @Autowired(required = true)
  @Qualifier(value = "patientService")
  public void setPatientService(PatientService patientService) {
    this.patientService = patientService;
  }

  
}
