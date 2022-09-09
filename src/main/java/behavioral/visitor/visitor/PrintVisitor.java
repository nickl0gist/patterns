package behavioral.visitor.visitor;

import behavioral.visitor.employee.*;
import behavioral.visitor.rating.Rating;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created on 09.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Implementation of Visitor.
 */
@Slf4j
@NoArgsConstructor
public class PrintVisitor implements Visitor {

    private Rating rating;

    public PrintVisitor(Rating rating) {
        this.rating = rating;
    }

    @Override
    public void visit(Programmer programmer) {
        String msg = programmer.getName() + " is a " + programmer.getSkill() + " programmer.";
        msg += getRatings(programmer);
        log.info(msg);
    }

    @Override
    public void visit(ProjectLead lead) {
        String msg = lead.getName() + " is a Project Lead with " + lead.getDirectReports().size() + " programmers reporting.";
        msg += getRatings(lead);
        log.info(msg);
    }

    @Override
    public void visit(Manager manager) {
        String msg = manager.getName()+" is a Manager with "+manager.getDirectReports().size()+" leads reporting.";
        msg += getRatings(manager);
        log.info(msg);
    }

    @Override
    public void visit(VicePresident vp) {
        String msg = vp.getName()+" is a Vice President with "+vp.getDirectReports().size()+" managers reporting.";
        msg += getRatings(vp);
        log.info(msg);
    }

    private String getRatings(Employee emp) {
        if (rating != null) {
            return "\n\tRatings: Personal=" + emp.getPerformanceRating()
                    + "  Final=" + rating.getFinalRating(emp.getEmployeeId());
        } else {
            return "";
        }
    }
}
