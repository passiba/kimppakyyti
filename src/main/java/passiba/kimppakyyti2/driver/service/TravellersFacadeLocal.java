/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package passiba.kimppakyyti2.driver.service;

import java.util.List;
import javax.ejb.Local;
import passiba.kimppakyyti2.entities.Travellers;

/**
 *
 * @author pauline
 */
@Local
public interface TravellersFacadeLocal {

    void create(Travellers travellers);

    void edit(Travellers travellers);

    void remove(Travellers travellers);

    Travellers find(Object id);

    List<Travellers> findAll();

    List<Travellers> findRange(int[] range);

    int count();
    
}
