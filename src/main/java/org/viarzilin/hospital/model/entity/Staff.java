package org.viarzilin.hospital.model.entity;

import java.util.Date;
import java.util.Set;
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

    @Column(name = "CREATE_DATE", nullable = false, updatable = false)
    private Date createDate;

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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patient", orphanRemoval = true)
    private Set<Reception> receptions;


    /**
    * Many-to-many relationship ReceptionPrescription to Staff
    */
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "staffList")
    private Set<ReceptionPrescription> receptionPrescriptionSet;

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

    public Auth getAuthes() {
        return authes;
    }

    public void setAuthes(Auth authes) {
        this.authes = authes;
    }

    public Set<Reception> getReceptions() {
        return receptions;
    }

    public void setReceptions(Set<Reception> receptions) {
        this.receptions = receptions;
    }

    public Set<ReceptionPrescription> getReceptionPrescriptionSet() {
        return receptionPrescriptionSet;
    }

    public void setReceptionPrescriptionSet(Set<ReceptionPrescription> receptionPrescriptionSet) {
        this.receptionPrescriptionSet = receptionPrescriptionSet;
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
