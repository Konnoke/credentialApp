/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NavigationUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    JFrame menuUI;
    
    
    public void buildUI()   {
        
        menuUI = new JFrame("HomePage");
        menuUI.setSize(400, 150);
        menuUI.setLocationRelativeTo(null);
        menuUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        menuUI.add(panel);
        LoginUI(panel);

        menuUI.setVisible(true);        
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
        
        logoutButton.addActionListener(new ActionListener()   {
        
            @Override
            public void actionPerformed(ActionEvent e)  {

                menuUI.setVisible(false);
                
            }
        });  
        
        add.addActionListener(new ActionListener()    {

            @Override
            public void actionPerformed(ActionEvent o) {
                AddCredentialUI add = new AddCredentialUI();
                add.buildUI();
            }
        });
        
        
        
    }
    
    
    
}
