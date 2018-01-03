package org.viarzilin.hospital.model.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

public class Patient {
  private int idPatient;
  private String lastName;
  private String firstName;
  private String surName;
  private Date berthDate;
  private String adress;
  private Date createDate;
  private Date updateDate;

  /**
   * One-to-many relationship Patient to Recieption
   */
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patient", orphanRemoval = true)
  private Set<Recieption> recieptions;

  public Patient(int idPatient, String lastName, String firstName,
                 String surName, Date berthDate, String adress, Date createDate, Date updateDate, Set<Recieption> recieptions) {
    this.idPatient = idPatient;
    this.lastName = lastName;
    this.firstName = firstName;
    this.surName = surName;
    this.berthDate = berthDate;
    this.adress = adress;
    this.createDate = createDate;
    this.updateDate = updateDate;
    this.recieptions = recieptions;
  }

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

  public Date getBerthDate() {
    return berthDate;
  }

  public void setBerthDate(Date berthDate) {
    this.berthDate = berthDate;
  }

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getUpdateDate() {
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
}
