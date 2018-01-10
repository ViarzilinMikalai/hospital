package org.viarzilin.hospital.controller;

import org.viarzilin.hospital.model.service.PrescriptionsService;

public class PrescriptionsController {

  private PrescriptionsService prescriptionService;

  public void setPrescriptionService(
      PrescriptionsService prescriptionService) {
    this.prescriptionService = prescriptionService;
  }
}
