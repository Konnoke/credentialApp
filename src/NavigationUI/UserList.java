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
public class UserList {
    
    
    
    public ArrayList<String> usernames;
    public ArrayList<String> passwords;
     
    
    public UserList ()   {
        
        usernames = new ArrayList();
        passwords = new ArrayList();
        
        usernames.add("xyz1934");
        usernames.add("yib5063");
        usernames.add("uye0938");
        
        passwords.add("12345");
        passwords.add("1234"); 
        passwords.add("123456");
        
    }
    
    public ArrayList<String> getUsernames()  {
        return usernames;
    }
    
    public ArrayList<String> getValidPasswords()   {
        return passwords;
    }
    

    
    
    
    
    
    
    
    
}
