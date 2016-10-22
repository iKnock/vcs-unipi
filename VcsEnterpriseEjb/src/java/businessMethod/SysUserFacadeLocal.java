/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessMethod;

import entity.SysUser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author meknock
 */
@Local
public interface SysUserFacadeLocal {

    void create(SysUser sysUser);

    void edit(SysUser sysUser);

    void remove(SysUser sysUser);

    SysUser find(Object id);

    List<SysUser> findAll();

    List<SysUser> findRange(int[] range);

    int count();

    List<SysUser> authenticateUser(String userName, String password);

    SysUser getUserByUserName(String userName);
    
}
