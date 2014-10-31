/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package passiba.kimppakyyti2.driver.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
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
public class DriversFacade extends AbstractFacade<Drivers> implements DriversFacadeLocal {
    @PersistenceContext(unitName = "passiba_kimppakyyti2_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    @Inject
    private DriversDestinationFacade driverDestinationFacade;
   
    @Inject  
    private TravelldestinationFacade travellDestinationFacade;
     
    @Inject
    private UserFacade userejbFacade;
  

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DriversFacade() {
        super(Drivers.class);
    }
    public DriversDestinationFacade getDriverDestinationFacade() {
        return driverDestinationFacade;
    }

    public TravelldestinationFacade getTravellDestinationFacade() {
        return travellDestinationFacade;
    }

    public UserFacade getUserejbFacade() {
        return userejbFacade;
    }
    
    private void createDriverDestinations(User user,Drivers driver)
    {
        
         if (user.getTravellingFrom() != null && user.getTravellingTo() != null
                    && user.getTravelltime() != null) {
                DriversDestination driverDestination = new DriversDestination();
                driverDestination.setDriverId(driver);
                
                Travelldestination travelDestination = new Travelldestination();
                travelDestination.setTravellingFrom(user.getTravellingFrom());
                travelDestination.setTravellingTo(user.getTravellingTo());
                travelDestination.setTraveltime(user.getTravelltime());
                
                getTravellDestinationFacade().create(travelDestination);
                 
                 
                 driverDestination.setTraveldestinationId(travelDestination);
              
                /* List< Travelldestination> travels=new ArrayList<Travelldestination>();
                 travels.add(travelDestination);*/
                
               getDriverDestinationFacade().create(driverDestination);
                
            }
        
           
        
    }
    /*
    * Creates the driver 
     -@param User user
      @praam Users currentUser
    */
    @Override
    public void createDriver(User user,Users currentUser) {
        
        if (user != null && user.getFirstName() != null
                && user.getLastName() != null) {
            
            
            //create user
            
            getUserejbFacade().create(currentUser);
            
            Drivers newdriver = new Drivers();
            newdriver.setFirstName(user.getFirstName());
            newdriver.setLastName(user.getLastName());
            newdriver.setUserId(currentUser);
            getEntityManager().persist(newdriver);
            //create drivers destinations
            createDriverDestinations(user, newdriver);
           

        
        }
        
    }
    
}
