/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NavigationUI;

/**
 *
 * @author Hassan
 */
public class User {
    
    String username;
    String password;
   
    
    public User(String _username, String _password)  {
        this.username = _username;
        this.password = _password;
    }
    
    public String getUsername()   {
        return username;
    }
    
    void setUsername(String _username)   {
        this.username = _username;
    }
    
    public String getPassword()    {
        return password;
    }
    
    public void setPassword(String _password)   {
        this.password = _password;
    }
    
    
      
}
