/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NavigationUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Hassan
 */
public class Menu {
    
    JTextField passwordText; 
    JTextField userText;
    
    
    public void buildUI()   {
        
        JFrame frame = new JFrame("HomePage");
        frame.setSize(400, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);
        LoginUI(panel);

        frame.setVisible(true);        
    }   

public void LoginUI(JPanel panel) {
        
        panel.setLayout(new FlowLayout());

        JButton viewAccount = new JButton("View Account");
        viewAccount.setBounds(10, 80, 100, 25);
        panel.add(viewAccount); 
        
        JButton viewCredentials = new JButton("View Credentials");
        viewCredentials.setBounds(10, 80, 100, 25);
        panel.add(viewCredentials);
        
        JButton add = new JButton("Add Credentials");
        add.setBounds(10, 80, 100, 25);
        panel.add(add);     
                
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(10, 80, 100, 25);
        panel.add(logoutButton);
        
    }
    
    
    
}
