/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passiba.kimppakyyti2.setup;

import javax.ejb.EJB;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;


/**
 *
 * @author pauline
 */
@Alternative
public class DevelopmentStartup extends ProductionStartUp{
    
    
     @EJB
    private passiba.kimppakyyti2.users.beans.UsersFacade ejbFacade;
 //   @Inject
  //  private TravellerSessionBeanLocal travelleruserservice;
    
  //  @Inject
    //private org.passiba.autoruletti.drivers.beans.DriversFacade ejbFacadedrivers;
    @Override
    public void init() {

     /*   Users user= new Users(); 
        user.setPassword("lonelyplanet");
        user.setPhonenumber("050056787778");
        travelleruserservice.createUser(user);
        user=travelleruserservice.getUser(user.getPhonenumber());
        Drivers driver1= new Drivers();
        driver1.setUserId(user);
        driver1.setFirstName("pauline");
        driver1.setLastName("Globetotter");
        
        //ejbFacadedrivers.create(driver1);
        
        Users user2= new Users(); 
        user2.setPassword("lonelyplanet");
        user2.setPhonenumber("050056787778");
        travelleruserservice.createUser(user2);
        user2=travelleruserservice.getUser(user2.getPhonenumber());
        Drivers driver2= new Drivers();
        driver2.setUserId(user2);
        driver2.setFirstName("paul");
        driver2.setLastName("Wolwerine");
        
        //ejbFacadedrivers.create(driver2);*/
        
        
    
    }
    
    
    
}
