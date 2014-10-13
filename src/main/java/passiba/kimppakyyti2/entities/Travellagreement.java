/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passiba.kimppakyyti2.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pauline
 */
@Entity
@Table(name = "travellagreement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Travellagreement.findAll", query = "SELECT t FROM Travellagreement t"),
    @NamedQuery(name = "Travellagreement.findByTravellagreementId", query = "SELECT t FROM Travellagreement t WHERE t.travellagreementId = :travellagreementId")})
public class Travellagreement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "travellagreement_id")
    private Long travellagreementId;
    @JoinColumn(name = "traveller_destination_id", referencedColumnName = "traveller_destination_id")
    @OneToOne(fetch = FetchType.LAZY)
    private TravellerDestination travellerDestinationId;
    @JoinColumn(name = "drivers_destination_id", referencedColumnName = "drivers_destination_id")
    @OneToOne(fetch = FetchType.LAZY)
    private DriversDestination driversDestinationId;

    public Travellagreement() {
    }

    public Travellagreement(Long travellagreementId) {
        this.travellagreementId = travellagreementId;
    }

    public Long getTravellagreementId() {
        return travellagreementId;
    }

    public void setTravellagreementId(Long travellagreementId) {
        this.travellagreementId = travellagreementId;
    }

    public TravellerDestination getTravellerDestinationId() {
        return travellerDestinationId;
    }

    public void setTravellerDestinationId(TravellerDestination travellerDestinationId) {
        this.travellerDestinationId = travellerDestinationId;
    }

    public DriversDestination getDriversDestinationId() {
        return driversDestinationId;
    }

    public void setDriversDestinationId(DriversDestination driversDestinationId) {
        this.driversDestinationId = driversDestinationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (travellagreementId != null ? travellagreementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Travellagreement)) {
            return false;
        }
        Travellagreement other = (Travellagreement) object;
        if ((this.travellagreementId == null && other.travellagreementId != null) || (this.travellagreementId != null && !this.travellagreementId.equals(other.travellagreementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "passiba.kimppakyyti2.entities.Travellagreement[ travellagreementId=" + travellagreementId + " ]";
    }
    
}
