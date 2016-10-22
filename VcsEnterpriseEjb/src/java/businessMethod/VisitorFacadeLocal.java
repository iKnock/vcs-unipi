/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessMethod;

import entity.Visitor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author meknock
 */
@Local
public interface VisitorFacadeLocal {

    void create(Visitor visitor);

    void edit(Visitor visitor);

    void remove(Visitor visitor);

    Visitor find(Object id);

    List<Visitor> findAll();

    List<Visitor> findRange(int[] range);

    int count();
    
}
