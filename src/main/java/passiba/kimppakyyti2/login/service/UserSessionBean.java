/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passiba.kimppakyyti2.login.service;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import passiba.kimppakyyti2.entities.Users;
import passiba.kimppakyyti2.login.bean.AuthenticatedUser;


/**
 *
 * @author pauline
 */
@Named
@SessionScoped
public class UserSessionBean implements Serializable{

    /**
     * traveller service
     */
    @EJB
    private TravellerSessionBeanLocal travellerService;
   
    /**
     * Reference to the users
     */
    private Users user;
    
    
    /**
     * Creates the current user
     * @return User
     */
    @Produces @SessionScoped @AuthenticatedUser @Named("currentUser")
    public Users getCurrentUser() {
        if(user == null || user.isAnonymous()) {
            user = travellerService.getAuthenticatedUser();
        }
        return user;
    }
    
    /**
     * Returns true if the user has authenticated
     * @return true if authenticated
     */
    public boolean isAuthenticated() {
       return travellerService.isAuthenticated();
    }
    
        /**
     * Logs out the user
     * @param users - user
     */
    public void logout(@Disposes @AuthenticatedUser Users user) {
        this.user = null;
    }
    
    /**
     * Get user using the phonenumber
     * @param -String phoenumber
     * @return Users found user
    *
    */
    public Users getUser(String phonenumer) {
        return travellerService.getUser(phonenumer);
    }
    
    
}
