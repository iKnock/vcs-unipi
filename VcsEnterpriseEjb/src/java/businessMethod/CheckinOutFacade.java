/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessMethod;

import entity.CheckinOut;
import entity.VisitorAppointment;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author meknock
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CheckinOutFacade extends AbstractFacade<CheckinOut> implements CheckinOutFacadeLocal, businessMethod.CheckinOutFacadeRemote {

    @PersistenceContext(unitName = "VcsEnterpriseEjbPU")
    private EntityManager em;

    @Resource
    private EJBContext context;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CheckinOutFacade() {
        super(CheckinOut.class);
    }

    @Override
    public void create(CheckinOut checkinOut) {
        em.persist(checkinOut);
    }

    @Override
    public void remove(CheckinOut entity) {      
        em.remove(em.merge(entity));        
    }

    @Override
    public void edit(CheckinOut entity) {
        UserTransaction userTransaction = context.getUserTransaction();
        try {
            userTransaction.begin();
            em.merge(entity);
            userTransaction.commit();
        } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException e) {
            try {
                userTransaction.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex) {
            }
        }
    }

    @Override
    public void updateAppointmentStatus(Integer appId, String status) {
        int updated = em.createNativeQuery("UPDATE tbl_appointment ta SET ta.status = ? WHERE ta.app_id = ?").setParameter(1, status).setParameter(2, appId).executeUpdate();
    }

    @Override
    public List<VisitorAppointment> getPendingApp() {
        Query query = em.createNativeQuery("SELECT ta.app_id, ta.inviter_id, ta.visitor_id, ta.app_date, ta.app_time, ta.status, ta.remark, tv.visitor_name, tv.visitor_sex, tv.visitor_age, tv.description, tsu.user_id, tsu.full_name, tsu.department_name, tsu.`position` FROM tbl_appointment ta INNER JOIN tbl_visitor tv ON ta.visitor_id = tv.visitor_id INNER JOIN tbl_sys_user tsu ON tsu.user_id = ta.inviter_id WHERE ta.status='ACTIVE'", VisitorAppointment.class);
        List<VisitorAppointment> vistApp = query.getResultList();
        return vistApp;
    }

    @Override
    public void atomicCheckIn(CheckinOut checkinOut, Integer appId, String status) {
        UserTransaction utx = context.getUserTransaction();
        try {
            utx.begin();
            create(checkinOut);
            updateAppointmentStatus(appId, status);
            utx.commit();
        } catch (NotSupportedException | IllegalStateException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex1) {
            }
        }
    }

    @Override
    public void atomicRemoveCheckIn(CheckinOut checkIn, Integer appId, String status) {
        UserTransaction utx = context.getUserTransaction();
        try {
            utx.begin();
            remove(checkIn);
            updateAppointmentStatus(appId, status);
            utx.commit();
        } catch (NotSupportedException | IllegalStateException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException ex) {
            try {
                utx.rollback();
                System.out.println("roll backed tnx");
            } catch (IllegalStateException | SecurityException | SystemException ex1) {
            }
        }
    }
}
