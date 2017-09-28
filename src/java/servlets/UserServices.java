package servlets;

import java.io.Serializable;

/**
 *
 * @author Sean Jeske
 */
public class UserServices implements Serializable{
    
    private String username;
    private String password;
    
    public UserServices()
    {
        this.username = "";
        this.password = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}