package org.viarzilin.hospital.model.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "Patient")
@Entity
public class Patient {


  @Id
  @Column(name = "ID_PATIENT")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "LASTNAME", nullable = false, length = 20)
  private String lastName;

  @Column(name = "FIRSTNAME", nullable = false, length = 20)
  private String firstName;

  @Column(name = "SURNAME", length = 20)
  private String surName;

  @Temporal(TemporalType.DATE)
  @Column(name = "BIRTH_DATE")
  private Date birthDate;

  @Column(name = "ADRESS", nullable = false, length = 45)
  private String adress;

  @Temporal(TemporalType.DATE)
  @Column(name = "CREATE_DATE", nullable = false, updatable = false)
  private Date createDate;

  @Temporal(TemporalType.DATE)
  @Column(name = "UPDATE_DATE")
  private Date updateDate;

  /**
   * One-to-many relationship Patient to Reception
   */
  /**
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "patient", orphanRemoval = true)
  private List<Reception> receptions;
*/

  public Patient(){

  }

  /**
   * Getters and Setters
   */
  public int getIdPatient() {
    return id;
  }

  public void setIdPatient(int idPatient) {
    this.id = idPatient;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSurName() {
    return surName;
  }

  public void setSurName(String surName) {
    this.surName = surName;
  }

  public java.util.Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public java.util.Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public java.util.Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }
/**
  public List<Reception> getReceptions() {
    return receptions;
  }

  public void setReceptions(List<Reception> receptions) {
    this.receptions = receptions;
  }
*/
  @Override
  public String toString() {
    return "Patient{" +
            "idPatient=" + id +
            ", lastName='" + lastName + '\'' +
            ", firstName='" + firstName + '\'' +
            ", surName='" + surName + '\'' +
            ", birthDate=" + birthDate +
            ", adress='" + adress + '\'' +
            ", createDate=" + createDate +
            ", updateDate=" + updateDate +
            '}';
  }
}
