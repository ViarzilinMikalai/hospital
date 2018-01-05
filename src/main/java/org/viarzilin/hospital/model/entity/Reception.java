package org.viarzilin.hospital.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Table(name = "reception")
@Entity
public class Reception {


  @Id
  @Column(name = "ID-RESEPTION")
  @GeneratedValue(GenerationType.IDENTITY)
  private int idReception;

  @Temporal(TemporalType.DATE)
  @Column(name = "RECEPTION_DATE", nullable = false)
  private Date receptionDate;

  @Column(name = "PRELIMINARY_DIAGNOSIS", nullable = false, length = 60)
  private String preliminaryDiagnosis;

  //private int idStaff;

  @Temporal(TemporalType.DATE)
  @Column(name = "DISCHARGE_DATE")
  private Date dischargeDate;

  @Column(name = "FINAL_DIAGNOSIS", nullable = true, length = 60)
  private String finalDiagnosis;

  @Column(name = "IS_DISCHARGE")
  private boolean isDischrge;


  /**
   * Many-to-one relationship Patient to Reception
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "PATIENT_ID")
  private Patient patient;


  /**
   * Many-to-one relationship Staff to Reception
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "ID_STAFF")
  private Staff staff;


  /**
   * One_to_many relationship Reception to ReceptionPrescription
   */
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "receptions", orphanRemoval = true)
  private Set<ReceptionPrescription> receptionPrescriptions;


  /**
   * Getters and Setters
   */
  public int getIdReception() {
    return idReception;
  }

  public void setIdReception(int idReception) {
    this.idReception = idReception;
  }

  public java.util.Date getReceptionDate() {
    return receptionDate;
  }

  public void setReceptionDate(Date receptionDate) {
    this.receptionDate = receptionDate;
  }

  public String getPreliminaryDiagnosis() {
    return preliminaryDiagnosis;
  }

  public void setPreliminaryDiagnosis(String preliminaryDiagnosis) {
    this.preliminaryDiagnosis = preliminaryDiagnosis;
  }

  public Date getDischargeDate() {
    return dischargeDate;
  }

  public void setDischargeDate(Date dischargeDate) {
    this.dischargeDate = dischargeDate;
  }

  public String getFinalDiagnosis() {
    return finalDiagnosis;
  }

  public void setFinalDiagnosis(String finalDiagnosis) {
    this.finalDiagnosis = finalDiagnosis;
  }

  public boolean isDischrge() {
    return isDischrge;
  }

  public void setDischrge(boolean dischrge) {
    isDischrge = dischrge;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public Staff getStaff() {
    return staff;
  }

  public void setStaff(Staff staff) {
    this.staff = staff;
  }

  public Set<ReceptionPrescription> getReceptionPrescriptions() {
    return receptionPrescriptions;
  }

  public void setReceptionPrescriptions(Set<ReceptionPrescription> receptionPrescriptions) {
    this.receptionPrescriptions = receptionPrescriptions;
  }


  @Override
  public String toString() {
    return "Reception{" +
            "idReception=" + idReception +
            ", receptionDate=" + receptionDate +
            ", preliminaryDiagnosis='" + preliminaryDiagnosis + '\'' +
            ", dischargeDate=" + dischargeDate +
            ", finalDiagnosis='" + finalDiagnosis + '\'' +
            ", isDischrge=" + isDischrge +
            '}';
  }
}
