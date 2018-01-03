package org.viarzilin.hospital.model.entity;

import javax.persistence.*;


@Entity
public class Auth {

  @Id
  @Column(name = "ID_AUTH")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idAuth;



  @Column(name = "LOGIN", nullable = false, length = 16)
  private String login;

  @Column(name = "PASSWORD", nullable = false, length = 16)
  private String password;

  @Column(name = "EMAIL", nullable = false, length = 20)
  private String email;

  @Column(name="ISACTIVE")
  private boolean isActive;


  /**
   * Authentication of this staff
   */
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="STAFF_ID", unique = true, nullable = false, updatable = false)
  private Staff staff;


  public Auth(String login, String password, String email, boolean isActive, Staff staff) {
    this.login = login;
    this.password = password;
    this.email = email;
    this.isActive = isActive;
    this.staff = staff;
  }

  public Auth(){

  }
  /**
   * Getters and Setters
   */
  public int getIdAuth() {
    return idAuth;
  }

  public void setIdAuth(int idAuth) {
    this.idAuth = idAuth;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  public Staff getStaff() {
    return staff;
  }

  public void setStaff(Staff staff) {
    this.staff = staff;
  }

  @Override
  public String toString() {
    return "Auth{" +
            "idAuth=" + idAuth +
            ", login='" + login + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", isActive=" + isActive +
            ", staff=" + staff +
            '}';
  }


}
