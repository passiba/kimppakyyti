/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passiba.kimppakyyti2.login.service;

import java.security.Principal;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import passiba.kimppakyyti2.login.bean.AnonymousUser;
import passiba.kimppakyyti2.entities.Users;

/**
 *
 * @author pauline
 */
@Stateless
public class TravellerSessionBean implements TravellerSessionBeanLocal {
    
     /**
     * Persistence Context
     */
    @PersistenceContext(unitName="passiba_kimppakyyti2_war_1.0-SNAPSHOTPU")
    private EntityManager entityManager;
    
    /**
     * EJB Session Context
     */
    @Resource
    private SessionContext context;
    

    @Override
    public Users getUser(long userId) {
        return entityManager.find(Users.class,userId);
    }

    @Override
    public Users getUser(String phonenumber) {
        TypedQuery<Users> q = entityManager.createQuery("select u from Users u where u.phonenumber = :phonenumber",Users.class);
        q.setParameter("phonenumber",phonenumber);
        List<Users> usersarray = q.getResultList();
        if(usersarray.size() == 1) {
            return usersarray.get(0);
        } else if (usersarray.size() > 1) {
            throw new RuntimeException("phonenumber should be unique.");
        }
        return null;
    }

    @Override
    public void createUser(Users user) {
        entityManager.persist(user);
    }

    @Override
    public Users getAuthenticatedUser() {
       Principal principal = context.getCallerPrincipal();
        Users user;
        String number = principal.getName();
        if(number.equals("ANONYMOUS")) {
            user = new AnonymousUser();
        } else {
            user = this.getUser(number);
        }
        return user;
    }

    @Override
    public boolean isAuthenticated() {
       Principal p = context.getCallerPrincipal();
        if(p != null) {
            if(p.getName() != null && p.getName().length() > 0 && !p.getName().toUpperCase().equals("ANONYMOUS")) {
                return true;
            }
        }
        return false;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
