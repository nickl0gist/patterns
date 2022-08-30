package behavioral.interpreter.expression;

import behavioral.interpreter.report.Report;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created on 30.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Parse and builds abstract syntax tree.
 */
@Slf4j
public class ExpressionBuilder {

    private Stack<PermissionExpression> permissions = new Stack<>();

    private Stack<String> operators = new Stack<>();

    public PermissionExpression build(Report report){
        parse(report.getPermission());
        buildExpression();

        // Error occurred if there more than one element in permissions stack after buildExpression() or operators is not Empty.
        if (permissions.size() > 1 || !operators.isEmpty()){
            log.info("ERROR!");
        }
        return permissions.pop();
    }

    private void parse(String permission) {
        // Tokenize given string - Splits given string by spaces.
        StringTokenizer tokenizer = new StringTokenizer(permission.toLowerCase());
        while(tokenizer.hasMoreTokens()){
            String token= tokenizer.nextToken();
            // If we get any of AND OR NOT string that means we are passing this Non-Terminal Expression to operators
            switch (token){
                case "and":
                case "not":
                case "or":
                    operators.push(token);
                    break;
                default:
                    // If anything else found which is not "OR AND NOT" expression it means we get some of permission
                    // value and store it in permission stack.
                    permissions.push(new Permission(token));
                    break;
            }
        }
    }

    /**
     * Builds Expression depending on operators stored in <code>operators</code> property and ads these one particular
     * Expression to permissions Stack. Before particular Expression is added all permissions added in parse method pop out.
     * At the end permission stack has to have only one element inside and operators should be Empty.
     */
    private void buildExpression() {
        while (!operators.isEmpty()){
            String operator = operators.pop();
            PermissionExpression p1;
            PermissionExpression p2;
            PermissionExpression expression;
            switch (operator){
                case "not":
                    p1 = permissions.pop();
                    expression = new NotExpression(p1);
                    break;
                case "and":
                    p1 = permissions.pop();
                    p2 = permissions.pop();
                    expression = new AndExpression(p1, p2);
                    break;
                case "or":
                    p1 = permissions.pop();
                    p2 = permissions.pop();
                    expression = new OrExpression(p1, p2);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown operator: " + operator);
            }
            permissions.push(expression);
        }
    }
}
