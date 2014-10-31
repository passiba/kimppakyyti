/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package passiba.kimppakyyti2.driver.service;

import java.util.List;
import javax.ejb.Local;
import passiba.kimppakyyti2.entities.Drivers;
import passiba.kimppakyyti2.entities.Users;
import passiba.kimppakyyti2.users.views.User;

/**
 *
 * @author pauline
 */
@Local
public interface DriversFacadeLocal {

    
    
     /**
     * Creates the Driver
     *
     * @param  Drivers- driver
     * 
     */
    
    void create(Drivers driver);
    
    
    /**
     * Creates the Driver
     *
     * @param  User- user
     * 
     * @param Users - currentUser
     * 
     */
    
    void createDriver(User user,Users currentUser);
    
    /**
     * Edit the Driver
     *
     * @param  Drivers- driver
     * 
     * 
     * 
     */
    void edit(Drivers drivers);
    
    
      /**
     * Remove the driver
     * @param  Drivers- driver
     * 
     * 
     * 
     */

    void remove(Drivers drivers);
    
    
    /**
     * Returns the Driver
     *
     * @param driverid - long driverid
     * @return Drivers
     */

    Drivers find(Object id);
    
    
     /**
     * Returns all Drivers
     *
     * 
     * @return List Drivers
     */

    
    List<Drivers> findAll();
    /**
     * Returns all Drivers
     *  @param  int range
     * 
     * @return List Drivers
     */
    List<Drivers> findRange(int[] range);
    
    
    /**
     * Count the number of Drivers
     * 
     * @return int
     */
    int count();
    
}
