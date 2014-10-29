/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package passiba.kimppakyyti2.driver.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import passiba.kimppakyyti2.entities.Drivers;
import passiba.kimppakyyti2.entities.DriversDestination;
import passiba.kimppakyyti2.entities.Travelldestination;
import passiba.kimppakyyti2.entities.Users;
import passiba.kimppakyyti2.users.views.User;


/**
 *
 * @author pauline
 */
@Stateless
public class DriverSessionBean implements DriverSessionBeanLocal {
    
    
     /**
     * Persistence Context
     */
    @PersistenceContext(unitName="passiba_kimppakyyti2_war_1.0-SNAPSHOTPU")
    private EntityManager entityManager;
    

    @Override
    public Drivers getDriver(long driverid) {
         return entityManager.find(Drivers.class,driverid);
    }

    @Override
    public void createDriver(Drivers driver) {
        entityManager.persist(driver);
    }

    @Override
    public void updateDriver(Drivers driver) {
        entityManager.merge(driver);
    }

    @Override
    public void deleteDriver(long driverid) {
       entityManager.remove(driverid);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void createDriver(User user,Users currentUser) {
        
        if (user != null && user.getFirstName() != null
                && user.getLastName() != null) {
            Drivers newdriver = new Drivers();
            newdriver.setFirstName(user.getFirstName());
            newdriver.setLastName(user.getLastName());
            newdriver.setUserId(currentUser);
            
            //create drivers destinations
            //this.createDriverDestination(user, currentUser);
            
            if(user.getTravellingFrom()!=null && user.getTravellingTo() !=null
                    && user.getTravelltime() != null)
            {
                DriversDestination driverDestination=new DriversDestination();
                driverDestination.setDriverId(newdriver);
            
                Travelldestination travelDestination=new Travelldestination();
                travelDestination.setTravellingFrom(user.getTravellingFrom());
                travelDestination.setTravellingTo(user.getTravellingTo());
                travelDestination.setTraveltime(user.getTravelltime());
               /* List< Travelldestination> travels=new ArrayList<Travelldestination>();
                travels.add(travelDestination);*/
            
                driverDestination.setTraveldestinationId(travelDestination);
            }
            entityManager.persist(currentUser);
        }
        
    }

    @Override
    public void createDriverDestination(User user, Users currentUser) {
        
    }

    @Override
    public void updateDriversDestination(Drivers driver, DriversDestination destination) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDestination(Drivers driver, DriversDestination destination) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DriversDestination> findDriverDestinations(Drivers driver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
