/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package passiba.kimppakyyti2.driver.service;

import java.util.List;
import javax.ejb.Local;
import passiba.kimppakyyti2.entities.TravellerDestination;

/**
 *
 * @author pauline
 */
@Local
public interface TravellerDestinationFacadeLocal {

    void create(TravellerDestination travellerDestination);

    void edit(TravellerDestination travellerDestination);

    void remove(TravellerDestination travellerDestination);

    TravellerDestination find(Object id);

    List<TravellerDestination> findAll();

    List<TravellerDestination> findRange(int[] range);

    int count();
    
}
