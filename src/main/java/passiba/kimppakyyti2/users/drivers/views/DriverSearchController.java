/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passiba.kimppakyyti2.users.drivers.views;


import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;
import passiba.kimppakyyti2.login.service.TravellerSessionBeanLocal;
import passiba.kimppakyyti2.users.views.PageNavigationEnum;
/**
 *
 * @author pauline
 */
@Named("driverSearchController")
@RequestScoped
public class DriverSearchController {
    
    
    @Size(min = 2, max = 50)
    private String travellingFrom,travellingTo;

    public String getTravellingFrom() {
        return travellingFrom;
    }

    public void setTravellingFrom(String travellingFrom) {
        this.travellingFrom = travellingFrom;
    }

    public String getTravellingTo() {
        return travellingTo;
    }

    public void setTravellingTo(String travellingTo) {
        this.travellingTo = travellingTo;
    }
    public String processSerach()
    {
        return PageNavigationEnum.HOME.toString();
    }
    
}
