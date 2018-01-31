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


  /**
   * Many-to-one relationship Reception to Rprescription
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "ID_RECEPTION", nullable = false, updatable = false)
  private Reception receptions;

  /**
   * Many-to-one relationship User to Rprescription
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "ID_USER", nullable = false, updatable = false)
  private User user;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }


  /**
   * Many-to-one relationship Rprescription to Prescription
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "ID_PRESCRIPTION", nullable = false, updatable = false)
  private Prescription prescription;


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
    /**
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
        '}';
  }
}
