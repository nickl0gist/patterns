package behavioral.visitor.employee;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;

/**
 * Created on 09.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public abstract class AbstractEmployee implements Employee{
    @Getter
    @Setter
    private int performanceRating;

    @Getter
    private final  String name;

    private static int employeeIdCounter = 101;

    @Getter
    private final int employeeId;

    AbstractEmployee(String name) {
        this.name = name;
        employeeId = employeeIdCounter++;
    }

    @Override
    public Collection<Employee> getDirectReports() {
        return Collections.emptyList();
    }

}
