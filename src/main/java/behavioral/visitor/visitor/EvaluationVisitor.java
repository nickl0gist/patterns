package behavioral.visitor.visitor;

import behavioral.visitor.employee.*;
import behavioral.visitor.rating.PerformanceRating;
import behavioral.visitor.rating.Rating;
import lombok.Getter;

/**
 * Created on 09.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> This visitor evaluates employees but takes into consideration performance of team as well.
 */
public class EvaluationVisitor implements Visitor {

    @Getter
    private final Rating ratings = new Rating();

    /**
     * Programmer has only his own ratings.
     */
    @Override
    public void visit(Programmer programmer) {
        PerformanceRating finalRating = new PerformanceRating(programmer.getEmployeeId(), programmer.getPerformanceRating());
        finalRating.setFinalRating(programmer.getPerformanceRating());
        ratings.put(programmer.getEmployeeId(),
                finalRating);
    }

    /**
     * ProjectLead total rating consist of 75% of his own rating and 25% of team's rating.
     */
    @Override
    public void visit(ProjectLead lead) {
        PerformanceRating finalRating = new PerformanceRating(lead.getEmployeeId(), lead.getPerformanceRating());
        int teamAverage = getTeamAverage(lead);
        int rating = Math.round(0.75f * lead.getPerformanceRating() + 0.25f*teamAverage);
        finalRating.setFinalRating(rating);
        finalRating.setTeamAverageRating(teamAverage);
        ratings.put(lead.getEmployeeId(),
                finalRating);
    }

    /**
     * Manager total rating consist of 50% of his own rating and 50% of team's rating.
     */
    @Override
    public void visit(Manager manager) {
        PerformanceRating finalRating = new PerformanceRating(manager.getEmployeeId(), manager.getPerformanceRating());

        int teamAverage = getTeamAverage(manager);
        int rating = Math.round(0.5f * manager.getPerformanceRating() + 0.5f*teamAverage);
        finalRating.setFinalRating(rating);
        finalRating.setTeamAverageRating(teamAverage);

        ratings.put(manager.getEmployeeId(),
                finalRating);
    }

    /**
     * VicePresident total rating consist of 25% of his own rating and 75% of team's rating.
     */
    @Override
    public void visit(VicePresident vp) {
        PerformanceRating finalRating = new PerformanceRating(vp.getEmployeeId(), vp.getPerformanceRating());

        int teamAverage = getTeamAverage(vp);
        int rating = Math.round(0.25f * vp.getPerformanceRating() + 0.75f*teamAverage);
        finalRating.setFinalRating(rating);
        finalRating.setTeamAverageRating(teamAverage);

        ratings.put(vp.getEmployeeId(),
                finalRating);
    }

    private int getTeamAverage(Employee emp) {
        return (int)Math.round(
                emp.getDirectReports()
                        .stream()
                        .mapToDouble(Employee::getPerformanceRating)
                        .average()
                        .orElse(0.0)
        );
    }
}
