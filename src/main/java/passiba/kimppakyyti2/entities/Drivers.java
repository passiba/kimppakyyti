/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passiba.kimppakyyti2.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pauline
 */
@Entity
@Table(name = "drivers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drivers.findAll", query = "SELECT d FROM Drivers d"),
    @NamedQuery(name = "Drivers.findByDriverId", query = "SELECT d FROM Drivers d WHERE d.driverId = :driverId"),
    @NamedQuery(name = "Drivers.findByFirstName", query = "SELECT d FROM Drivers d WHERE d.firstName = :firstName"),
    @NamedQuery(name = "Drivers.findByLastName", query = "SELECT d FROM Drivers d WHERE d.lastName = :lastName")})
public class Drivers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "driver_id")
    private Long driverId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "lastName")
    private String lastName;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Users userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driverId", fetch = FetchType.LAZY)
    private Collection<DriversDestination> driversDestinationCollection;

    public Drivers() {
    }

    public Drivers(Long driverId) {
        this.driverId = driverId;
    }

    public Drivers(Long driverId, String firstName, String lastName) {
        this.driverId = driverId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<DriversDestination> getDriversDestinationCollection() {
        return driversDestinationCollection;
    }

    public void setDriversDestinationCollection(Collection<DriversDestination> driversDestinationCollection) {
        this.driversDestinationCollection = driversDestinationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (driverId != null ? driverId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drivers)) {
            return false;
        }
        Drivers other = (Drivers) object;
        if ((this.driverId == null && other.driverId != null) || (this.driverId != null && !this.driverId.equals(other.driverId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "passiba.kimppakyyti2.entities.Drivers[ driverId=" + driverId + " ]";
    }
    
}
