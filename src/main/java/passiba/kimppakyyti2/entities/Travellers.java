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
@Table(name = "travellers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Travellers.findAll", query = "SELECT t FROM Travellers t"),
    @NamedQuery(name = "Travellers.findByTravellerId", query = "SELECT t FROM Travellers t WHERE t.travellerId = :travellerId"),
    @NamedQuery(name = "Travellers.findByFirstName", query = "SELECT t FROM Travellers t WHERE t.firstName = :firstName"),
    @NamedQuery(name = "Travellers.findByLastName", query = "SELECT t FROM Travellers t WHERE t.lastName = :lastName")})
public class Travellers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "traveller_id")
    private Long travellerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "LastName")
    private String lastName;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Users userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "travellerId", fetch = FetchType.LAZY)
    private Collection<TravellerDestination> travellerDestinationCollection;

    public Travellers() {
    }

    public Travellers(Long travellerId) {
        this.travellerId = travellerId;
    }

    public Travellers(Long travellerId, String firstName, String lastName) {
        this.travellerId = travellerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getTravellerId() {
        return travellerId;
    }

    public void setTravellerId(Long travellerId) {
        this.travellerId = travellerId;
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
    public Collection<TravellerDestination> getTravellerDestinationCollection() {
        return travellerDestinationCollection;
    }

    public void setTravellerDestinationCollection(Collection<TravellerDestination> travellerDestinationCollection) {
        this.travellerDestinationCollection = travellerDestinationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (travellerId != null ? travellerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Travellers)) {
            return false;
        }
        Travellers other = (Travellers) object;
        if ((this.travellerId == null && other.travellerId != null) || (this.travellerId != null && !this.travellerId.equals(other.travellerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "passiba.kimppakyyti2.entities.Travellers[ travellerId=" + travellerId + " ]";
    }
    
}
