package org.viarzilin.hospital.model.entity;

import org.viarzilin.hospital.model.entity.enumerated.TypePrescription;
import javax.persistence.*;
import java.util.List;


@Table(name = "prescription")
@Entity
public class Prescription {

    @Id
    @Column(name = "ID_PRESCRIPTION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrescription;

    @Column(name = "NAME_PRESCRIPTION", nullable = false, length = 20)
    private String namePrescription;

    @Column(name = "TYPE_PRESCRIPTION", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private TypePrescription typePrescription;

    @Column(name = "DESCRIPTION", length = 100)
    private String description;


    /**
    * One_to_many relationship Prescription to ReceptionPrescription
    */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "prescriptions", orphanRemoval = true)
     private List<ReceptionPrescription> receptionPrescriptions;

    /**
     * Getters and Setters
     */

    public int getIdPrescription() {
        return idPrescription;
    }

    public void setIdPrescription(int idPrescription) {
        this.idPrescription = idPrescription;
    }

    public String getNamePrescription() {
        return namePrescription;
    }

    public void setNamePrescription(String namePrescription) {
        this.namePrescription = namePrescription;
    }

    public TypePrescription getTypePrescription() {
        return typePrescription;
    }

    public void setTypePrescription(TypePrescription typePrescription) {
        this.typePrescription = typePrescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ReceptionPrescription> getReceptionPrescriptions() {
        return receptionPrescriptions;
    }

    public void setReceptionPrescriptions(List<ReceptionPrescription> receptionPrescriptions) {
        this.receptionPrescriptions = receptionPrescriptions;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "idPrescription=" + idPrescription +
                ", namePrescription='" + namePrescription + '\'' +
                ", typePrescription=" + typePrescription +
                ", description='" + description + '\'' +
                '}';
    }
}
