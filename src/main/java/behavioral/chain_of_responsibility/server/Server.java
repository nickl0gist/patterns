package behavioral.chain_of_responsibility.server;

import behavioral.chain_of_responsibility.middleware.BasicMiddleware;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 26.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Server Emulation.
 */
@Slf4j
public class Server {
    private Map<String, String> users = new HashMap<>();

    @Setter
    private BasicMiddleware middleware;

    public boolean logIn(String email, String password) {
        if (middleware.check(email, password)) {
            log.info("Authorization have been successful!");
            // Some additional actions with server.
            return true;
        }
        return false;
    }

    public void register(String email, String password) {
        users.put(email, password);
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

    public boolean isValidPassword(String email, String password) {
        return users.get(email).equals(password);
    }
}
