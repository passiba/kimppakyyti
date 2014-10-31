/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package passiba.kimppakyyti2.driver.service;

import java.util.List;
import javax.ejb.Local;
import passiba.kimppakyyti2.entities.DriversDestination;

/**
 *
 * @author pauline
 */
@Local
public interface DriversDestinationFacadeLocal {

    void create(DriversDestination driversDestination);

    void edit(DriversDestination driversDestination);

    void remove(DriversDestination driversDestination);

    DriversDestination find(Object id);

    List<DriversDestination> findAll();

    List<DriversDestination> findRange(int[] range);

    int count();
    
}
