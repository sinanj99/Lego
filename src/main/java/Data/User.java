/*
 This class is used to create a user with the given fields. 
 */
package Data;

/**
 * Mirrors the user-table in the database, and is primarily instantiated in the
 * user mappers where a given user is returned and forwarded to the logic-layer
 * where a user is validated. Is also instantiated in presentation-layer when it is checked
 * if there is already a user in the session.
 * @author sinanjasar
 */

public class User {
    private int user_id; 
    private String username;
    private String password;
    private int balance;
    private int isAdmin;

    public User(int user_id, String username, String password, int balance, int isAdmin) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public float getBalance() {
        return balance;
    }

    public int getIsAdmin() {
        return isAdmin;
    }
    
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getUser_id() {
        return user_id;
    }

    
    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", username=" + username + ", password=" + password + ", balance=" + balance + ", isAdmin=" + isAdmin + '}';
    }
    
}
