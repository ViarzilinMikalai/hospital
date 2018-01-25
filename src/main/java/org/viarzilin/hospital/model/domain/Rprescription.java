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

  @Column(name = "ISCANCELL")
  private boolean isCancell;

  @Temporal(TemporalType.DATE)
  @Column(name = "PRESCRIPTION_DATE")
  private Date rprescriptionDate;

  @Column(name = "TEST")
  private String test;


  /**
   * Many-to-one relationship Reception to Rprescription
   */
  /**
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "ID_RECEPTION")
  private Reception receptions;
*/

  /**
   * Many-to-one relationship Rprescription to Prescription
   */
  /**
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "ID_PRESCRIPTION")
  private Prescription prescriptions;
*/

  /**
   * Many-to-many relationship Rprescription to User
   */
  /**
  @ManyToMany
  @JoinTable(name = "PRESC_EXECUTOR",
          joinColumns = @JoinColumn(name = "IDPATIENT_PRESCRIPTION", referencedColumnName = "ID_RES_PRESC"),
          inverseJoinColumns = @JoinColumn(name = "ID_STAFF", referencedColumnName = "ID_STAFF"))
  private List<User> userList;
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

  public boolean isCancell() {
    return isCancell;
  }

  public void setCancell(boolean cancell) {
    isCancell = cancell;
  }

  public Date getRprescriptionDate() {
    return rprescriptionDate;
  }

  public void setRprescriptionDate(Date rprescriptionDate) {
    this.rprescriptionDate = rprescriptionDate;
  }

  public String getTest() {
    return test;
  }

  public void setTest(String test) {
    this.test = test;
  }

  /**
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
*/
  @Override
  public String toString() {
    return "Rprescription{" +
        "id=" + id +
        ", isCancell=" + isCancell +
        ", rprescriptionDate=" + rprescriptionDate +
        ", test='" + test + '\'' +
        '}';
  }
}
