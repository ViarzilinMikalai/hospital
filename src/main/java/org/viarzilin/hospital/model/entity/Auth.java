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



  public Auth(){

  }


}
