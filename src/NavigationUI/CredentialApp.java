/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NavigationUI;

import Users.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Kevin Baik aka Zarathustra aka Konnoke aka Misindexed Orange Hat
 */
public class CredentialApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");
        frame.setSize(400, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        LoginUI(panel);

        frame.setVisible(true);
    }

    private static void LoginUI(JPanel panel) {
        
        panel.setLayout(null);
        
        JLabel userLabel = new JLabel("User Login");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);
        
        JTextField userText = new JTextField(20);
        userText.setBounds(200, 10, 160, 25);
        panel.add(userText);
        
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 80, 25);
        panel.add(passwordLabel);
        
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(200, 40, 160, 25);
        panel.add(passwordText);
        
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 100, 25);
        panel.add(loginButton);
        
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(280, 80, 100, 25);
        panel.add(registerButton);
    }

}
