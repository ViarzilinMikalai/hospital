package org.viarzilin.hospital.model.entity;

import com.sun.javafx.beans.IDProperty;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

public class Patient {
  @Id
  @Column(name = "ID_PATIENT")
  @GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
  private int idPatient;

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
  @Column(name = "CREATE_DATE")
  private Date createDate;

  @Temporal(TemporalType.DATE)
  @Column(name = "UPDATE_DATE")
  private Date updateDate;

  /**
   * One-to-many relationship Patient to Recieption
   */
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patient", orphanRemoval = true)
  private Set<Recieption> recieptions;


  public Patient(){

  }

  /**
   * Getters and Setters
   */
  public int getIdPatient() {
    return idPatient;
  }

  public void setIdPatient(int idPatient) {
    this.idPatient = idPatient;
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

  public java.util.Date getBerthDate() {
    return birthDate;
  }

  public void setBerthDate(Date berthDate) {
    this.birthDate = berthDate;
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

  public Set<Recieption> getRecieptions() {
    return recieptions;
  }

  public void setRecieptions(Set<Recieption> recieptions) {
    this.recieptions = recieptions;
  }

  @Override
  public String toString() {
    return "Patient{" +
            "idPatient=" + idPatient +
            ", lastName='" + lastName + '\'' +
            ", firstName='" + firstName + '\'' +
            ", surName='" + surName + '\'' +
            ", birthDate=" + birthDate +
            ", adress='" + adress + '\'' +
            ", createDate=" + createDate +
            ", updateDate=" + updateDate +
            ", recieptions=" + recieptions +
            '}';
  }
}
