/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Reservationtournage;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author l_a-b
 */
@Stateless
public class ReservationtournageFacade extends AbstractFacade<Reservationtournage> {

    @PersistenceContext(unitName = "com.mycompany_LAZARSEMLALIJSF_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservationtournageFacade() {
        super(Reservationtournage.class);
    }
    
}
