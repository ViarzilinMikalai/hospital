package org.viarzilin.hospital.model.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "reception_pescription")
@Entity
public class ReceptionPrescription {

  @Id
  @Column(name = "ID_RES_PRESC")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idRecPrescr;


  //private int idPrescription;
  //private int idReception;

  @Column(name = "ISCANCELL")
  private boolean isCancell;

  @Temporal(TemporalType.DATE)
  @Column(name = "PRESCRIPTION_DATE")
  private Date prescriptionDate;


  /**
   * Many-to-one relationship Reception to ReceptionPrescription
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "ID_RECEPTION")
  private Reception receptions;


  /**
   * Many-to-one relationship ReceptionPrescription to Prescription
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "ID_PRESCRIPTION")
  private Prescription prescriptions;


  /**
   * Many-to-many relationship ReceptionPrescription to User
   */
  @ManyToMany
  @JoinTable(name = "PRESC_EXECUTOR",
          joinColumns = @JoinColumn(name = "IDPATIENT_PRESCRIPTION", referencedColumnName = "ID_RES_PRESC"),
          inverseJoinColumns = @JoinColumn(name = "ID_STAFF", referencedColumnName = "ID_STAFF"))
  private List<User> userList;


  /**
   * Getters and Setters
   */
  public int getIdRecPrescr() {
    return idRecPrescr;
  }

  public void setIdRecPrescr(int idRecPrescr) {
    this.idRecPrescr = idRecPrescr;
  }

  public boolean isCancell() {
    return isCancell;
  }

  public void setCancell(boolean cancell) {
    isCancell = cancell;
  }

  public java.util.Date getPrescriptionDate() {
    return prescriptionDate;
  }

  public void setPrescriptionDate(Date prescriptionDate) {
    this.prescriptionDate = prescriptionDate;
  }

  public Reception getReceptions() {
    return receptions;
  }

  public void setReceptions(Reception receptions) {
    this.receptions = receptions;
  }

  public Prescription getPrescriptions() {
    return prescriptions;
  }

  public void setPrescriptions(Prescription prescriptions) {
    this.prescriptions = prescriptions;
  }

  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }


  @Override
  public String toString() {
    return "ReceptionPrescription{" +
            "idRecPrescr=" + idRecPrescr +
            ", isCancell=" + isCancell +
            ", prescriptionDate=" + prescriptionDate +
            '}';
  }
}
