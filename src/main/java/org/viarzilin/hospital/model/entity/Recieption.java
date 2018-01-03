package org.viarzilin.hospital.model.entity;

import java.util.Date;

public class Recieption {

  private int idRecieption;
  private int patientId;
  private Date recieptionDate;
  private String preliminaryDiagnosis;
  private int idStaff;
  private Date dischargeDate;
  private String finalDiagnosis;
  private boolean isDischrge;
}
