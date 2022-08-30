package behavioral.interpreter.report;

import lombok.Getter;

/**
 * Created on 30.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Represents Report instance which has permission property to allow access based on it's value.
 */
public class Report {

    @Getter
    private final String name;

    // "NOT ADMIN", "FINANCE_USER AND ADMIN"
    @Getter
    private final String permission;

    public Report(String name, String permissions) {
        this.name = name;
        this.permission = permissions;
    }
}
