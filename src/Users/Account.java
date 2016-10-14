/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

/**
 *
 * @author Zarathustra
 */
public class Account {

    private String username;
    private String password;
    private String[][] accounts = {{"jesper", "abc123"}, {"christian", "abc123"}};

    public Account(String user, String pass) {
        username = user;
        password = pass;
    }

    public boolean auth() {
        if ((username == accounts[0][0]) && (password == accounts[0][1])) {
            return true;
        } else {
            return false;
        }
    }

}
