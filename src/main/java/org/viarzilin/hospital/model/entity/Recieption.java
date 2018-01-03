package org.viarzilin.hospital.model.entity;

import javax.persistence.*;
import java.util.Date;

public class Recieption {

  private int idRecieption;
  private Date recieptionDate;
  private String preliminaryDiagnosis;
  private int idStaff;
  private Date dischargeDate;
  private String finalDiagnosis;
  private boolean isDischrge;


  /**
   * Many-to-one relationship Patient to Recieption
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "PATIENT_ID")
  private Patient patient;

}
