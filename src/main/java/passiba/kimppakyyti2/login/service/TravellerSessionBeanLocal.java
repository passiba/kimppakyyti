/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passiba.kimppakyyti2.login.service;

import javax.ejb.Local;
import passiba.kimppakyyti2.entities.Users;
import passiba.kimppakyyti2.users.views.User;

/**
 *
 * @author pauline
 */
@Local
public interface TravellerSessionBeanLocal {
    
     /**
     * Returns the user
     *
     * @param userId - user
     * @return Users
     */
    Users getUser(long userId);

    /**
     * Retrieves the user provided the phonenumber
     * @param String- phonumber
     * @return Users
     */
    Users getUser(String phonenumer);

    /**
     * Sets the user
     *
     * @param users - user
     */
    void createUser(Users user);
    
   
    /**
     * Returns the current user
     * @return users
     */
    Users getAuthenticatedUser();
    
    /**
     * Returns true if we have authenticated
     * @return true if authenticated
     */
    boolean isAuthenticated();
    
}
