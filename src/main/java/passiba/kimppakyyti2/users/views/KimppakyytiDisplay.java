/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passiba.kimppakyyti2.users.views;

import java.io.Serializable;
import java.util.logging.Level;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import passiba.kimppakyyti2.entities.Users;
import passiba.kimppakyyti2.login.bean.AnonymousUser;
import passiba.kimppakyyti2.login.bean.AuthenticatedUser;
import passiba.kimppakyyti2.login.service.UserSessionBean;

/**

 * @author pauline
 */
@Named("KimppakyytiDisplay")
@SessionScoped
public class KimppakyytiDisplay implements Serializable{
    
    
     @Inject
    private UserSessionBean userloginService;
    
    
    
    private UserSessionBean getLoginFacade() {
        return userloginService;
    }
    
    
    /**
     * User
     */
      @Inject @AuthenticatedUser
    private Users user;

    /**
     * Checks credentials - if we have logged in
     */
    private synchronized void checkCredentials() {
        if(user != null &&  user.getPhonenumber()!=null  && !user.isGuest()) {
            return;
        }
       /* ExternalContext remoteUser = FacesContext.getCurrentInstance().getExternalContext();
        if(remoteUser != null) {
                  user = userloginService.getUser(remoteUser);
            
        }*/ else {
            instantiateGuestInstance();
        }
    }

    /**
     * Instantiates a guest instance
     */
    private void instantiateGuestInstance() {
        user = new AnonymousUser();
        user.setGuest(true);
    }

    /**
     * Returns the current user
     * @return user
     */
    public Users getUser() {
        checkCredentials();
        return user;
    }

    /**
     * Returns true if we are a guest
     * @return true if guest
     */
    public boolean isGuest() {
        checkCredentials();
        return user == null || user.isGuest();
    }

    /**
     * Invalidates the session
     */
    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        instantiateGuestInstance();
    }
    
}
