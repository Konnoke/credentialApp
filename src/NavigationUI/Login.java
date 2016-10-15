/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NavigationUI;

import java.util.ArrayList;

/**
 *
 * @author Zarathustra
 */
public class Login extends UserList {
    
    private UserList userList;


    private ArrayList<String> usernames;
    private ArrayList<String> passwords;

    
    public boolean authenticate(String username, String password)   {

        usernames = new ArrayList();
        userList = new UserList();
        usernames = userList.getUsernames();
        passwords = new ArrayList();
        passwords = userList.getValidPasswords();
        
        for (int i = 0; i < usernames.size(); i++)   {
            if (usernames.get(i).equals(username) && passwords.get(i).equals(password))   {
                return true;
            } 
        }
        return false;
    }
}
