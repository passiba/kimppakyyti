/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package passiba.kimppakyyti2.driver.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import passiba.kimppakyyti2.entities.TravellerDestination;

/**
 *
 * @author pauline
 */
@Stateless
public class TravellerDestinationFacade extends AbstractFacade<TravellerDestination> implements TravellerDestinationFacadeLocal {
    @PersistenceContext(unitName = "passiba_kimppakyyti2_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TravellerDestinationFacade() {
        super(TravellerDestination.class);
    }
    
}
