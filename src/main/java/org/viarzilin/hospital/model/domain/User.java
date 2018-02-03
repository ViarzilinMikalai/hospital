package org.viarzilin.hospital.model.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Table(name = "user")
@Entity
public class User {


    @Id
    @Column(name = "ID_USER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "LASTNAME", nullable = false, length = 20)
    private String lastName;

    @Column(name = "FIRSTNAME", nullable = false, length = 20)
    private String firstName;

    @Column(name = "SURNAME", nullable = false, length = 20)
    private String surName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDATE", nullable = false, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATEDATE")
    private Date updateDate;


    /**
    * Authentication of this user
    */
    @OneToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="ID_AUTH", unique = true, nullable = false, updatable = false)
    private Auth auth;


    /**
    * One_to_many relationship User to Reception
    */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true)
    private List<Reception> receptions;


  /**
   * One_to_many relationship User to Rprescription
   */
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user", orphanRemoval = true)
//    private List<Rprescription> rprescription;
//
//  public List<Rprescription> getRprescription() {
//    return rprescription;
//  }
//
//  public void setRprescription(
//      List<Rprescription> rprescription) {
//    this.rprescription = rprescription;
//  }

/**
    * Many-to-many relationship Rprescription to User
    */
    /**
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "staffList")
    private List<Rprescription> receptionPrescriptionList;
*/
    public User() {

    }

/**
     * Getters and Setters
     */
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public Auth getAuth() {
    return auth;
  }

  public void setAuth(Auth auth) {
    this.auth = auth;
  }

  public List<Reception> getReceptions() {
    return receptions;
  }

  public void setReceptions(List<Reception> receptions) {
    this.receptions = receptions;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", lastName='" + lastName + '\'' +
        ", firstName='" + firstName + '\'' +
        ", surName='" + surName + '\'' +
        ", createDate=" + createDate +
        ", updateDate=" + updateDate +
        '}';
  }


}
