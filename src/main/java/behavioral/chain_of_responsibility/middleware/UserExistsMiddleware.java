package behavioral.chain_of_responsibility.middleware;

import behavioral.chain_of_responsibility.server.Server;
import lombok.extern.slf4j.Slf4j;

/**
 * Created on 26.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Check given password
 */
@Slf4j
public class UserExistsMiddleware extends BasicMiddleware{

    private final Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    @Override
    public boolean check(String email, String password) {
        log.info("Current UserExistsMiddleware...");
        if (!server.hasEmail(email)) {
            log.info("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            log.info("Wrong password!");
            return false;
        }
        return checkNext(email, password);
    }
}
