/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessMethod;

import entity.Visitor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author meknock
 */
@Stateless
public class VisitorFacade extends AbstractFacade<Visitor> implements VisitorFacadeLocal, businessMethod.VisitorFacadeRemote {
    @PersistenceContext(unitName = "VcsEnterpriseEjbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VisitorFacade() {
        super(Visitor.class);
    }
    
}
