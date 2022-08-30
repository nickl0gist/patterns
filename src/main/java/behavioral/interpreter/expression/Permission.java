package behavioral.interpreter.expression;

import behavioral.interpreter.user.User;

/**
 * Created on 30.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Terminal Expression. Represents single particular rule.
 */
public class Permission implements PermissionExpression{

    private final String permission;

    public Permission(String permission) {
        this.permission = permission.toLowerCase();
    }

    @Override
    public boolean interpret(User user) {
        return user.getPermissions().contains(permission);
    }

    @Override
    public String toString() {
        return permission;
    }
}
