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
@Table(name = "drivers_destination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DriversDestination.findAll", query = "SELECT d FROM DriversDestination d"),
    @NamedQuery(name = "DriversDestination.findByDriversDestinationId", query = "SELECT d FROM DriversDestination d WHERE d.driversDestinationId = :driversDestinationId")})
public class DriversDestination implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "drivers_destination_id")
    private Long driversDestinationId;
    @OneToOne(mappedBy = "driversDestinationId", fetch = FetchType.LAZY)
    private Travellagreement travellagreement;
    @JoinColumn(name = "driver_id", referencedColumnName = "driver_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Drivers driverId;
    @JoinColumn(name = "traveldestination_id", referencedColumnName = "traveldestination_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Travelldestination traveldestinationId;

    public DriversDestination() {
    }

    public DriversDestination(Long driversDestinationId) {
        this.driversDestinationId = driversDestinationId;
    }

    public Long getDriversDestinationId() {
        return driversDestinationId;
    }

    public void setDriversDestinationId(Long driversDestinationId) {
        this.driversDestinationId = driversDestinationId;
    }

    public Travellagreement getTravellagreement() {
        return travellagreement;
    }

    public void setTravellagreement(Travellagreement travellagreement) {
        this.travellagreement = travellagreement;
    }

    public Drivers getDriverId() {
        return driverId;
    }

    public void setDriverId(Drivers driverId) {
        this.driverId = driverId;
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
        hash += (driversDestinationId != null ? driversDestinationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DriversDestination)) {
            return false;
        }
        DriversDestination other = (DriversDestination) object;
        if ((this.driversDestinationId == null && other.driversDestinationId != null) || (this.driversDestinationId != null && !this.driversDestinationId.equals(other.driversDestinationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "passiba.kimppakyyti2.entities.DriversDestination[ driversDestinationId=" + driversDestinationId + " ]";
    }
    
}
