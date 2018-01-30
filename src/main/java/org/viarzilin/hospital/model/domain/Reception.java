package org.viarzilin.hospital.model.domain;

import javax.persistence.*;
import java.util.Date;

@Table(name = "reception")
@Entity
public class Reception {

  @Id
  @Column(name = "ID_RESEPTION")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Temporal(TemporalType.DATE)
  @Column(name = "RECEPTION_DATE", nullable = false)
  private Date receptionDate;

  @Column(name = "PRELIMINARY_DIAGNOSIS", nullable = false, length = 60)
  private String preliminaryDiagnosis;

  @Temporal(TemporalType.DATE)
  @Column(name = "DISCHARGE_DATE")
  private Date dischargeDate;

  @Column(name = "FINAL_DIAGNOSIS", nullable = true, length = 60)
  private String finalDiagnosis;

  @Column(name = "IS_DISCHARGE")
  private boolean isDischarge;


  /**
   * Many-to-one relationship Patient to Reception
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "PATIENT_ID", nullable = false, updatable = false)
  private Patient patient;

  /**
   * Many-to-one relationship User to Reception
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "ID_USER", nullable = false, updatable = false)
  private User user;


  /**
   * One_to_many relationship Reception to Rprescription
   */
  /**
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "receptions", orphanRemoval = true)
  private List<Rprescription> rprescriptions;
*/

  /**
   * Getters and Setters
   */
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public boolean isDischarge() {
    return isDischarge;
  }

  public void setDischarge(boolean discharge) {
    isDischarge = discharge;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
  /**
  public List<Rprescription> getReceptionPrescriptions() {
    return receptionPrescriptions;
  }

  public void setReceptionPrescriptions(List<Rprescription> receptionPrescriptions) {
    this.receptionPrescriptions = receptionPrescriptions;
  }
 */
  @Override
  public String toString() {
    return "Reception{" +
            "idReception=" + id +
            ", receptionDate=" + receptionDate +
            ", preliminaryDiagnosis='" + preliminaryDiagnosis + '\'' +
            ", dischargeDate=" + dischargeDate +
            ", finalDiagnosis='" + finalDiagnosis + '\'' +
            ", isDischrge=" + isDischarge +
            '}';
  }
}
