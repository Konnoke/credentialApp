/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NavigationUI;

import java.util.ArrayList;

/**
 *
 * @author Hassan
 */
public class Register extends UserList {
    
    public UserList userList;


    public ArrayList<String> usernames;
    public ArrayList<String> passwords;
    

    public void addUser(String username, String password)   {
        
        usernames = userList.getUsernames();
        passwords = userList.getValidPasswords();      
        usernames.add(username);
        passwords.add(password);
      
    }
    
    
    
}
