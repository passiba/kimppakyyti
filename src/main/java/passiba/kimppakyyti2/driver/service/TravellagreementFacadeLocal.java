/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package passiba.kimppakyyti2.driver.service;

import java.util.List;
import javax.ejb.Local;
import passiba.kimppakyyti2.entities.Travellagreement;

/**
 *
 * @author pauline
 */
@Local
public interface TravellagreementFacadeLocal {

    void create(Travellagreement travellagreement);

    void edit(Travellagreement travellagreement);

    void remove(Travellagreement travellagreement);

    Travellagreement find(Object id);

    List<Travellagreement> findAll();

    List<Travellagreement> findRange(int[] range);

    int count();
    
}
