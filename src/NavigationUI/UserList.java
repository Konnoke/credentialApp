/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NavigationUI;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Hassan
 */
public class UserList {
    
    
    
    public HashMap<String, String> users;
    public User newUser;
    String a;
    String b;
    public ArrayList<String> usernames;
    public ArrayList<String> passwords;
     
    
    public UserList ()   {
        
        users = new HashMap();
        newUser = new User(a, b);
        usernames = new ArrayList();
        passwords = new ArrayList();
        
        usernames.add("xyz1934");
        usernames.add("yib5063");
        usernames.add("uye0938");
        
        passwords.add("12345");
        passwords.add("1234"); 
        passwords.add("123456");
        
    }
    
    public void addUser(String a)   {
        newUser.getUsername();
        newUser.setUsername(a);
        //users.add(newUser);
    }
    
    public void add(String username, String password)   {
        
        a = username;
        b = password;
        
        newUser.setUsername(username);
        newUser.setPassword(password);
        
        //users.add(username, password);
    }
    
    public ArrayList<String> getUsernames()  {
        return usernames;
    }
    
    public ArrayList<String> getValidPasswords()   {
        return passwords;
    }
    

    
    
    
    
    
    
    
    
}
