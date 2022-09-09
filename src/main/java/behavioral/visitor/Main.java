package behavioral.visitor;

import behavioral.visitor.employee.*;
import behavioral.visitor.visitor.EvaluationVisitor;
import behavioral.visitor.visitor.PrintVisitor;
import behavioral.visitor.visitor.Visitor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Random;

/**
 * Created on 09.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Study of Visitor Design Pattern
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        Employee emps = buildOrganization();
        Visitor visitor = new PrintVisitor();

        visitOrgStructure(emps, visitor);
        log.info("***************************************");

        //Perform a fake evaluation
        appraisal(emps, new Random(new Date().getTime()));

        EvaluationVisitor visitor2 = new EvaluationVisitor();
        //Carry out final evaluation where we consider team performance
        visitOrgStructure(emps, visitor2);

        //create new print visitor with final ratings taken from evaluation visitor
        visitor = new PrintVisitor(visitor2.getRatings());
        visitOrgStructure(emps, visitor);

    }

    private static Employee buildOrganization() {

        Programmer p1 = new Programmer("Jim","C++");
        Programmer p2 = new Programmer("Dwight","PHP");

        Programmer p3 = new Programmer("Andrew","C#");
        Programmer p4 = new Programmer("Pam","C++");

        ProjectLead pl1 = new ProjectLead("Angela", p1, p2);
        ProjectLead pl2 = new ProjectLead("Filiz", p3, p4);

        Manager m1 = new Manager("Kevin", pl1);
        Manager m2 = new Manager("Tobi", pl2);

        return new VicePresident("Michael Scott", m1,m2);
    }

    /**
     * Set visitor to each of the element of Org structure recursively.
     * @param emp {@linkplain Employee}
     * @param visitor {@linkplain Visitor}
     */
    private static void visitOrgStructure(Employee emp, Visitor visitor) {
        emp.accept(visitor);
        emp.getDirectReports().forEach(e->visitOrgStructure(e, visitor));
    }

    /**
     * This method assigns some random values to performance rating field of employees an sub-employees recursively
     * @param emp {@linkplain Employee}
     */
    private static void appraisal(Employee emp, Random random) {
        int rating = random.nextInt(6);
        emp.setPerformanceRating(Math.max(rating, 1));
        emp.getDirectReports().forEach(r -> appraisal(r, random));
    }
}
