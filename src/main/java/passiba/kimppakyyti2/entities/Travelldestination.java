/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passiba.kimppakyyti2.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pauline
 */
@Entity
@Table(name = "travelldestination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Travelldestination.findAll", query = "SELECT t FROM Travelldestination t"),
    @NamedQuery(name = "Travelldestination.findByTraveldestinationId", query = "SELECT t FROM Travelldestination t WHERE t.traveldestinationId = :traveldestinationId"),
    @NamedQuery(name = "Travelldestination.findByTravellingFrom", query = "SELECT t FROM Travelldestination t WHERE t.travellingFrom = :travellingFrom"),
    @NamedQuery(name = "Travelldestination.findByTravellingTo", query = "SELECT t FROM Travelldestination t WHERE t.travellingTo = :travellingTo"),
    @NamedQuery(name = "Travelldestination.findByTraveltime", query = "SELECT t FROM Travelldestination t WHERE t.traveltime = :traveltime")})
public class Travelldestination implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "traveldestination_id")
    private Long traveldestinationId;
    @Size(max = 60)
    @Column(name = "travelling_from",insertable = true,updatable = true)
    private String travellingFrom;
    @Size(max = 60)
    @Column(name = "travelling_to",insertable = true,updatable = true)
    private String travellingTo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "traveltime",insertable = true,updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date traveltime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "traveldestinationId", fetch = FetchType.LAZY,orphanRemoval = true)
    private Collection<DriversDestination> driversDestinationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "traveldestinationId", fetch = FetchType.LAZY,orphanRemoval = true)
    private Collection<TravellerDestination> travellerDestinationCollection;

    public Travelldestination() {
    }

    public Travelldestination(Long traveldestinationId) {
        this.traveldestinationId = traveldestinationId;
    }

    public Travelldestination(Long traveldestinationId, Date traveltime) {
        this.traveldestinationId = traveldestinationId;
        this.traveltime = traveltime;
    }

    public Long getTraveldestinationId() {
        return traveldestinationId;
    }

    public void setTraveldestinationId(Long traveldestinationId) {
        this.traveldestinationId = traveldestinationId;
    }

    public String getTravellingFrom() {
        return travellingFrom;
    }

    public void setTravellingFrom(String travellingFrom) {
        this.travellingFrom = travellingFrom;
    }

    public String getTravellingTo() {
        return travellingTo;
    }

    public void setTravellingTo(String travellingTo) {
        this.travellingTo = travellingTo;
    }

    public Date getTraveltime() {
        return traveltime;
    }

    public void setTraveltime(Date traveltime) {
        this.traveltime = traveltime;
    }

    @XmlTransient
    public Collection<DriversDestination> getDriversDestinationCollection() {
        return driversDestinationCollection;
    }

    public void setDriversDestinationCollection(Collection<DriversDestination> driversDestinationCollection) {
        this.driversDestinationCollection = driversDestinationCollection;
    }

    @XmlTransient
    public Collection<TravellerDestination> getTravellerDestinationCollection() {
        return travellerDestinationCollection;
    }

    public void setTravellerDestinationCollection(Collection<TravellerDestination> travellerDestinationCollection) {
        this.travellerDestinationCollection = travellerDestinationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traveldestinationId != null ? traveldestinationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Travelldestination)) {
            return false;
        }
        Travelldestination other = (Travelldestination) object;
        if ((this.traveldestinationId == null && other.traveldestinationId != null) || (this.traveldestinationId != null && !this.traveldestinationId.equals(other.traveldestinationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "passiba.kimppakyyti2.entities.Travelldestination[ traveldestinationId=" + traveldestinationId + " ]";
    }
    
}
