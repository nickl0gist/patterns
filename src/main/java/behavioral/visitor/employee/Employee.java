package behavioral.visitor.employee;

import behavioral.visitor.visitor.Visitor;

import java.util.Collection;

/**
 * Created on 09.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Interface for Employees which stands for Element in UML
 */
public interface Employee {

    int getPerformanceRating();

    void setPerformanceRating(int rating);

    Collection<Employee> getDirectReports();

    int getEmployeeId();

    void accept(Visitor visitor);
}
