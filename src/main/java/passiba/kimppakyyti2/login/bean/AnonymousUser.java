/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passiba.kimppakyyti2.login.bean;

import passiba.kimppakyyti2.entities.Users;

/**
 *
 * @author pauline
 */
public class AnonymousUser extends Users
{
     /* Default constructor
     */
    public AnonymousUser() {
        //setUsername("Anonymous");
    }
    
    /**
     * Return true - we are anyonmous
     * @return true
     */
    @Override
    public boolean isAnonymous() {
        return true;
    }

    
}
