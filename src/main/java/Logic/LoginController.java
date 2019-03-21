/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.IUserMapper;
import Data.User;

/**
 *
 * @author sinanjasar
 */
public class LoginController {

    /**
     * Checks if inserted password matches password for the user with the
     * specified username in the database.
     *
     * @param username username of the user whose password needs validation.
     * @param password password of the user that needs validation.
     * @return boolean
     */
    
    public static boolean doesMatch(String username, String password){
        if (username == null || username.isEmpty()) {
            return false;
        }
        else if (password == null || password.isEmpty()) {
            return false;
        }
        User user = IUserMapper.instance().getUser(username);
        return password.equals(user.getPassword());
    }
}
