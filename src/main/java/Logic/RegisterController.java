/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;


import Data.IUserMapper;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author sinanjasar
 */
public class RegisterController {
    public static final Pattern VALID_PASSWORD_REGEX
            = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_USERNAME_REGEX
            = Pattern.compile("^[a-z0-9_-]{3,15}$", Pattern.CASE_INSENSITIVE);



    /**
     * Checks if password of new user matches valid password-regex.
     *
     * @param password password of new user which is matched with regex.
     * @return boolean
     */
    public static boolean validatePassword(String password) {
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);
        return matcher.find();
    }

    /**
     * Checks if username of new user matches valid username-regex.
     *
     * @param username username of user which is matched with regex.
     * @return boolean
     */
    public static boolean validateUsername(String username) {
        Matcher matcher = VALID_USERNAME_REGEX.matcher(username);
        return matcher.find();
    }
}
