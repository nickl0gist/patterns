package behavioral.interpreter.expression;

import behavioral.interpreter.user.User;

/**
 * Created on 30.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 */
public interface PermissionExpression {

    /**
     * @param user User object used as Context holder.
     * @return True or False based on List of User permissions compared to needed permissions in Report.
     */
    boolean interpret(User user);
}
