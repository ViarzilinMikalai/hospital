package org.viarzilin.hospital.model.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "reception_prescription")
@Entity
public class Rprescription {

  @Id
  @Column(name = "ID_REC_PRESC")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Temporal(TemporalType.DATE)
  @Column(name = "PRESCRIPTION_DATE")
  private Date rprescriptionDate;

  @Column(name = "IS_EXECUTED")
  private boolean isExecuted;

  @Temporal(TemporalType.DATE)
  @Column(name = "EXECUTION_DATE")
  private Date executionDate;


  /**
   * Many-to-one relationship Reception to Rprescription
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "ID_RECEPTION", nullable = false, updatable = false)
  private Reception receptions;

  /**
   * Many-to-one relationship User to Rprescription
   */
//  @ManyToOne(fetch = FetchType.EAGER)
//  @JoinColumn(name = "ID_USER", nullable = false, updatable = false)
//  private User user;
//
//  public User getUser() {
//    return user;
//  }
//
//  public void setUser(User user) {
//    this.user = user;
//  }


  /**
   * Many-to-one relationship Rprescription to Prescription
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "ID_PRESCRIPTION", nullable = false, updatable = false)
  private Prescription prescription;


  /**
   * Getters and Setters
   */
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getRprescriptionDate() {
    return rprescriptionDate;
  }

  public void setRprescriptionDate(Date rprescriptionDate) {
    this.rprescriptionDate = rprescriptionDate;
  }

  public Prescription getPrescription() {
    return prescription;
  }

  public void setPrescription(Prescription prescription) {
    this.prescription = prescription;
  }

  public Reception getReceptions() {
    return receptions;
  }

  public void setReceptions(Reception receptions) {
    this.receptions = receptions;
  }

  public boolean isExecuted() {
    return isExecuted;
  }

  public void setExecuted(boolean executed) {
    isExecuted = executed;
  }

  public Date getExecutionDate() {
    return executionDate;
  }

  public void setExecutionDate(Date executionDate) {
    this.executionDate = executionDate;
  }


  @Override
  public String toString() {
    return "Rprescription{" +
        "id=" + id +
        ", rprescriptionDate=" + rprescriptionDate +
        ", isExecuted=" + isExecuted +
        ", executionDate=" + executionDate +
        ", receptions=" + receptions +
//        ", user=" + user +
        ", prescription=" + prescription +
        '}';
  }
}
