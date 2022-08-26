package behavioral.chain_of_responsibility;

import behavioral.chain_of_responsibility.middleware.BasicMiddleware;
import behavioral.chain_of_responsibility.middleware.LimitMiddleware;
import behavioral.chain_of_responsibility.middleware.RoleCheckMiddleware;
import behavioral.chain_of_responsibility.middleware.UserExistsMiddleware;
import behavioral.chain_of_responsibility.server.Server;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created on 26.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Study of Chain Responsibility Design Pattern (CDRP). Check fails only if next Handler cannot handle request.
 * In canonical CDRP chaining stops once any Handler reached which can handle the request.
 */
@Slf4j
public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    public static void main(String[] args) throws IOException {
        init();

        boolean success;
        do {
            log.info("Enter email: ");
            String email = reader.readLine();
            log.info("Input password: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);
    }

    private static void init() {
        server = new Server();
        server.register("admin@example.com", "1234567890");
        server.register("user@example.com", "simple123");

        // Validations linked in one chain. Client is allowed to build any sequences of Handlers using same components.
        BasicMiddleware middleware = BasicMiddleware.link(
                new LimitMiddleware(2),
                new UserExistsMiddleware(server),
                new RoleCheckMiddleware()
        );

        // Server obtains The chain from clients code.
        server.setMiddleware(middleware);
    }
}
