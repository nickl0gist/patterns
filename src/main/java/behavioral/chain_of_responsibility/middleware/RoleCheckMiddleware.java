package behavioral.chain_of_responsibility.middleware;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on 26.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Check Role of the User.
 */
@Slf4j
public class RoleCheckMiddleware extends BasicMiddleware{
    @Override
    public boolean check(String email, String password) {
        log.info("Current RoleCheckMiddleware...");
        if (email.equals("admin@example.com")) {
            log.info("Hello, admin!");
            return true;
        }
        log.info("Hello, user!");
        return checkNext(email, password);
    }
}
