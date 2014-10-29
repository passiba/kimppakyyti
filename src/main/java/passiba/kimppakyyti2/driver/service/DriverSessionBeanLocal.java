/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package passiba.kimppakyyti2.driver.service;

import java.util.List;
import javax.ejb.Local;
import passiba.kimppakyyti2.entities.Drivers;
import passiba.kimppakyyti2.entities.DriversDestination;
import passiba.kimppakyyti2.entities.Users;
import passiba.kimppakyyti2.users.views.User;

/**
 *
 * @author pauline
 */
@Local
public interface DriverSessionBeanLocal {
    
    public Drivers getDriver(long driverid);
    
    public void createDriver(Drivers driver);
    
    public void createDriver(User user,Users currentUser);
    
    public void updateDriver(Drivers driver);
    
    public void deleteDriver(long driverid);
    
    public void createDriverDestination(User user,Users currentUser);
    
    public void updateDriversDestination(Drivers driver,DriversDestination destination);
    
    public void deleteDestination(Drivers driver,DriversDestination destination);
    
    public List<DriversDestination>findDriverDestinations(Drivers driver);
    
}
