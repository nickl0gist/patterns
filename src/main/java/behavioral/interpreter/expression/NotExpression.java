package behavioral.interpreter.expression;

import behavioral.interpreter.user.User;

/**
 * Created on 30.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> "NOT" Non-Terminal Expression.
 */
public class NotExpression implements PermissionExpression{
    private final PermissionExpression ex1;

    public NotExpression(PermissionExpression ex1) {
        this.ex1 = ex1;
    }

    @Override
    public boolean interpret(User user) {
        return ex1.interpret(user);
    }

    @Override
    public String toString() {
        return "NOT " + ex1;
    }
}
