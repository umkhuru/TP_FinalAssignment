package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.Login;

import java.util.Map;

/**
 * Created by student on 2015/10/24.
 */
public class LoginFactory {

    public static Login createLogin(Map<String, String> value)
    {
        Login login = new Login
                .Builder(value.get("username"))
                .password(value.get("password"))
                .build();

        return login;
    }
}
