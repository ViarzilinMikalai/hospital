package org.viarzilin.hospital.model.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import org.viarzilin.hospital.model.entity.enumerated.TypeStaff;


@Table(name = "staff")
@Entity
public class Staff {


    @Id
    @Column(name = "ID_STAFF")
    @GeneratedValue(GenerationType.IDENTITY)
    private int idStaff;

    @Column(name = "LASTNAME", nullable = false, length = 20)
    private String lastName;

    @Column(name = "FIRSTNAME", nullable = false, length = 20)
    private String firstName;

    @Column(name = "SURNAME", nullable = false, length = 20)
    private String surName;

    @Column(name = "TYPE_STAFF", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeStaff typeStaff;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_DATE", nullable = false, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "UPDATE_DATE")
    private Date updateDate;


    /**
    * Authentication of this staff
    */
    @OneToOne(mappedBy = "staff")
    private Auth authes;


    /**
    * One_to_many relationship Staff to Reception
    */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "patient", orphanRemoval = true)
    private List<Reception> receptions;


    /**
    * Many-to-many relationship ReceptionPrescription to Staff
    */
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "staffList")
    private List<ReceptionPrescription> receptionPrescriptionList;

    public Staff() {

    }

/**
     * Getters and Setters
     */
    public int getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
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

    public TypeStaff getTypeStaff() {
        return typeStaff;
    }

    public void setTypeStaff(TypeStaff typeStaff) {
        this.typeStaff = typeStaff;
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

    public Auth getAuthes() {
        return authes;
    }

    public void setAuthes(Auth authes) {
        this.authes = authes;
    }

    public List<Reception> getReceptions() {
        return receptions;
    }

    public void setReceptions(List<Reception> receptions) {
        this.receptions = receptions;
    }

    public List<ReceptionPrescription> getReceptionPrescriptionList() {
        return receptionPrescriptionList;
    }

    public void setReceptionPrescriptionList(List<ReceptionPrescription> receptionPrescriptionList) {
        this.receptionPrescriptionList = receptionPrescriptionList;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "idStaff=" + idStaff +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", typeStaff=" + typeStaff +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }


}
