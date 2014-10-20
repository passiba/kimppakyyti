/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passiba.kimppakyyti2.users.views;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;
import passiba.kimppakyyti2.entities.Drivers;
import passiba.kimppakyyti2.entities.Travelldestination;
import passiba.kimppakyyti2.entities.Travellers;
import passiba.kimppakyyti2.entities.Users;

/**
 *
 * @author pauline
 */
@ManagedBean
@ViewScoped
public class UserWizard implements java.io.Serializable {

    private Users user = new Users();
    private Travellers traveller = new Travellers();
    private Drivers driver= new Drivers();
    private String firstname,lastname;
    private boolean skip,isDriver;
    
    private Travelldestination destination;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Travellers getTraveller() {
        return traveller;
    }

    public void setTraveller(Travellers traveller) {
        this.traveller = traveller;
    }
    
    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public Drivers getDriver() {
        return driver;
    }

    public void setDriver(Drivers driver) {
        this.driver = driver;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isIsDriver() {
        return isDriver;
    }

    public void setIsDriver(boolean isDriver) {
        this.isDriver = isDriver;
    }

    public Travelldestination getDestination() {
        return destination;
    }

    public void setDestination(Travelldestination destination) {
        this.destination = destination;
    }
    
    public void save() {
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getPhonenumber());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

}
