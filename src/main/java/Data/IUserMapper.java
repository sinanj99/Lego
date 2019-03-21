/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.DuplicateException;

/**
 *
 * @author sinanjasar
 */
public abstract class IUserMapper {
    
    public static IUserMapper instance() {
        return UserMapper.getInstance();
    }
    /**
     * Selects and returns a specific user-object from the 'user'-table in the
     * database.
     *
     * @param username is used in the WHERE clause to find a specified user
     * @return a specified user defined by the username
     */
    public abstract User getUser(String username);
    /**
     * Inserts a new user into user-tabel with the specified data.
     *
     * @param name name of the user to be inserted
     * @param password password of the user to be inserted
     * @param balance balance of the user to be inserted
     * @throws Logic.DuplicateException if user does already exist in dB
     */
    public abstract void insertUser(String name, String password, int balance) throws DuplicateException;
    
}
