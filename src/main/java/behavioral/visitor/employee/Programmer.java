package behavioral.visitor.employee;

import behavioral.visitor.visitor.Visitor;
import lombok.Getter;

/**
 * Created on 09.09.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Implementation of Employee Interface
 */
public class Programmer extends AbstractEmployee{

    @Getter
    private final String skill;

    public Programmer(String name, String skill) {
        super(name);
        this.skill = skill;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
