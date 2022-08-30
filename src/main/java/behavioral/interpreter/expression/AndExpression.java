package behavioral.interpreter.expression;

import behavioral.interpreter.user.User;

/**
 * Created on 30.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> "AND" Non-Terminal Expression.
 */
public class AndExpression implements PermissionExpression{

    private final PermissionExpression ex1;
    private final PermissionExpression ex2;

    public AndExpression(PermissionExpression ex1, PermissionExpression ex2) {
        this.ex1 = ex1;
        this.ex2 = ex2;
    }

    @Override
    public boolean interpret(User user) {
        return ex1.interpret(user) && ex2.interpret(user);
    }

    @Override
    public String toString() {
        return ex1 + " AND " + ex2;
    }
}
