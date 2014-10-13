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
import javax.persistence.ManyToOne;
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
@Table(name = "traveller_destination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TravellerDestination.findAll", query = "SELECT t FROM TravellerDestination t"),
    @NamedQuery(name = "TravellerDestination.findByTravellerDestinationId", query = "SELECT t FROM TravellerDestination t WHERE t.travellerDestinationId = :travellerDestinationId")})
public class TravellerDestination implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "traveller_destination_id")
    private Long travellerDestinationId;
    @OneToOne(mappedBy = "travellerDestinationId", fetch = FetchType.LAZY)
    private Travellagreement travellagreement;
    @JoinColumn(name = "traveller_id", referencedColumnName = "traveller_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Travellers travellerId;
    @JoinColumn(name = "traveldestination_id", referencedColumnName = "traveldestination_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Travelldestination traveldestinationId;

    public TravellerDestination() {
    }

    public TravellerDestination(Long travellerDestinationId) {
        this.travellerDestinationId = travellerDestinationId;
    }

    public Long getTravellerDestinationId() {
        return travellerDestinationId;
    }

    public void setTravellerDestinationId(Long travellerDestinationId) {
        this.travellerDestinationId = travellerDestinationId;
    }

    public Travellagreement getTravellagreement() {
        return travellagreement;
    }

    public void setTravellagreement(Travellagreement travellagreement) {
        this.travellagreement = travellagreement;
    }

    public Travellers getTravellerId() {
        return travellerId;
    }

    public void setTravellerId(Travellers travellerId) {
        this.travellerId = travellerId;
    }

    public Travelldestination getTraveldestinationId() {
        return traveldestinationId;
    }

    public void setTraveldestinationId(Travelldestination traveldestinationId) {
        this.traveldestinationId = traveldestinationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (travellerDestinationId != null ? travellerDestinationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TravellerDestination)) {
            return false;
        }
        TravellerDestination other = (TravellerDestination) object;
        if ((this.travellerDestinationId == null && other.travellerDestinationId != null) || (this.travellerDestinationId != null && !this.travellerDestinationId.equals(other.travellerDestinationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "passiba.kimppakyyti2.entities.TravellerDestination[ travellerDestinationId=" + travellerDestinationId + " ]";
    }
    
}
