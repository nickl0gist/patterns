package behavioral.visitor.visitor;

import behavioral.visitor.employee.Manager;
import behavioral.visitor.employee.Programmer;
import behavioral.visitor.employee.ProjectLead;
import behavioral.visitor.employee.VicePresident;

/**
 * Created on 09.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Common interface for Visitors
 */
public interface Visitor {

    void visit(Programmer programmer);

    void visit(ProjectLead lead);

    void visit(VicePresident vp);

    void visit(Manager manager);
}
