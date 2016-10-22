/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessMethod;

import entity.SysUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author meknock
 */
@Stateless
public class SysUserFacade extends AbstractFacade<SysUser> implements SysUserFacadeLocal, businessMethod.SysUserFacadeRemote {

    @PersistenceContext(unitName = "VcsEnterpriseEjbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SysUserFacade() {
        super(SysUser.class);
    }

    @Override
    public List<SysUser> authenticateUser(String userName, String password) {
        Query query = em.createNativeQuery("SELECT tsu.user_id, tsu.full_name, tsu.sex, tsu.department_name, tsu.description, tsu.`position`, tsu.status, tsu.user_name, tsu.password FROM tbl_sys_user tsu WHERE tsu.user_name = ? AND tsu.password = ?", SysUser.class).setParameter(1, userName).setParameter(2, password);
        List<SysUser> sysUsers = query.getResultList();
        return sysUsers;
    }

    @Override
    public SysUser getUserByUserName(String userName) {
        try {
            Query query = em.createNativeQuery("select * from tbl_sys_user where user_name = ?", SysUser.class).setParameter(1, userName);
            SysUser sysUsers = (SysUser) query.getSingleResult();
            return sysUsers;
        } catch (Exception e) {
            return null;
        }
    }
}
