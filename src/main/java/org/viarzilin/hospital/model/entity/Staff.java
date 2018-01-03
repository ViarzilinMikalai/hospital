package org.viarzilin.hospital.model.entity;

import java.util.Date;
import javax.persistence.*;

import org.viarzilin.hospital.model.entity.enumerated.TypeStaff;

@Entity
public class Staff {
  private int idStaff;
  private String lastName;
  private String firstName;
  private String surName;
  private TypeStaff tupeStaff;
  private Date createDate;
  private Date updateDate;

  @OneToOne(mappedBy = "staff")
  private Auth auth;

}
