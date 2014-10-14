/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passiba.kimppakyyti2.users.views;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import passiba.kimppakyyti2.entities.Users;
import passiba.kimppakyyti2.login.bean.AuthenticatedUser;
import passiba.kimppakyyti2.login.service.TravellerSessionBeanLocal;
import passiba.kimppakyyti2.login.service.UserSessionBean;
import passiba.kimppakyyti2.users.beans.UsersFacade;

/**
 *
 * @author pauline
 */
@Named("loginController")
@SessionScoped
public class LoginController implements Serializable {

    @Inject
    private UserSessionBean userloginService;
    
    private String password;
    private String number;
    
    /**
     * Current user
    */
    @Inject @AuthenticatedUser
    private Users user; 
  
    private UserSessionBean getLoginFacade() {
        return userloginService;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public void authenticate() {

        if (this.number != null) {
            this.user = userloginService.getUser(number);
            if (this.user != null) {
                 FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Welcome user" + user.getPhonenumber() + " " + user.getPassword()));

            }else
            {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Welcome " + getNumber() + " " + getPassword()));
            }
        }
    }
     

}
