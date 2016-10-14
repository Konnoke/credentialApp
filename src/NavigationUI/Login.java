/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NavigationUI;
/**
 *
 * @author Zarathustra
 */
public class Login {
    String username = "yib5063";
    String password = "password";
    String msg = " ";
    
    public static boolean authenticate(String username, String password)   {
        return username.equals(username) && password.equals(password);
    }
     
     
}
