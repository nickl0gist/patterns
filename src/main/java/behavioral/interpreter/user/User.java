package behavioral.interpreter.user;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created on 30.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> represents someone who is goin to get access to Report.
 */
public class User {

    // List of permissions which would be checked against set of permissions in Report.
    @Getter
    private final List<String> permissions;

    @Getter
    private final String username;

    public User(String username, String... permissions) {
        this.username = username;
        this.permissions = new ArrayList<>();

        // Each given permission would be stored in lower case.
        Stream.of(permissions).forEach(e->this.permissions.add(e.toLowerCase()));
    }
}
