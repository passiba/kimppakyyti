/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package passiba.kimppakyyti2.driver.service;

import java.util.List;
import javax.ejb.Local;
import passiba.kimppakyyti2.entities.Travelldestination;

/**
 *
 * @author pauline
 */
@Local
public interface TravelldestinationFacadeLocal {

    void create(Travelldestination travelldestination);

    void edit(Travelldestination travelldestination);

    void remove(Travelldestination travelldestination);

    Travelldestination find(Object id);

    List<Travelldestination> findAll();

    List<Travelldestination> findRange(int[] range);

    int count();
    
}
