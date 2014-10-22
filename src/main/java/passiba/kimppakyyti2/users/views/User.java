/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passiba.kimppakyyti2.users.views;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.Size;
import org.primefaces.event.SelectEvent;
import passiba.kimppakyyti2.entities.Users;

/**
 *
 * @author pauline
 */
@Named
public  class User implements Serializable {
   
    /**
     * User name for the user
     */
    @Size(min = 5, max = 30, message = "{step1_usernameSize}")
    protected String username;
    @Size(min = 2, max = 50)
    protected String travellingFrom;
    @Size(min = 2, max = 50)
    protected String travellingTo;
    protected Date travelltime;
    protected boolean isDriver;
    /**
     * Password
     */
     @Size(min = 8, max = 30, message = "Password Minimum size 8,Max size 30")
    private String password;
    /**
     * First name
     */
    @Size(min = 2, max = 30, message = "First name min size 2 and max size 30")
    private String firstName;
    /**
     * Last name
     */
    @Size(min = 2, max = 30, message = "Last name min size 2 and max size 30")
    private String lastName;
    /**
     * Password confirmation
     */
        @Size(min = 8, max = 30, message = "Password min size is 8 and max size is 30")
    private String passwordConfirm;
    /**
     * Phone number
     */
    private String phoneNumber;

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    /*
    fired upon Calendar date selection in order to change date
     */
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    public Date getTravelltime() {
        return travelltime;
    }

    public void setTravelltime(Date travelltime) {
        this.travelltime = travelltime;
    }

    public boolean isIsDriver() {
        return isDriver;
    }

    public void setIsDriver(boolean isDriver) {
        this.isDriver = isDriver;
    }
    
}
