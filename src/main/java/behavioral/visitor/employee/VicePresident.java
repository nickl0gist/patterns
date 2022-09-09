package behavioral.visitor.employee;

import behavioral.visitor.visitor.Visitor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 09.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Implementation of Employee Interface
 */
public class VicePresident extends AbstractEmployee{

    @Getter
    private final List<Employee> directReports = new ArrayList<>();

    public VicePresident(String name, Employee...employees) {
        super(name);
        directReports.addAll(Arrays.asList(employees));
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
