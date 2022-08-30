package behavioral.interpreter;

import behavioral.interpreter.expression.ExpressionBuilder;
import behavioral.interpreter.expression.PermissionExpression;
import behavioral.interpreter.report.Report;
import behavioral.interpreter.user.User;
import lombok.extern.slf4j.Slf4j;

/**
 * Created on 30.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Study of Interpreter Design Pattern
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        Report report1 = new Report("\"Travel allowance report\"", "Admin Or Manager");
        ExpressionBuilder builder = new ExpressionBuilder();
        PermissionExpression expressionTree = builder.build(report1);

        log.info("Generated expression tree for report {}: {}", report1.getName(), expressionTree);

        User adminUser = new User("Jane Doe", "Admin");
        User accountantUser = new User("John Smith", "accountant");

        log.info("User {} access to report {}: {}.", adminUser.getUsername(), report1.getName(), expressionTree.interpret(adminUser) ? "ENABLED" : "DISABLED");
        log.info("User {} access to report {}: {}.", accountantUser.getUsername(), report1.getName(), expressionTree.interpret(accountantUser) ? "ENABLED" : "DISABLED");
    }
}
