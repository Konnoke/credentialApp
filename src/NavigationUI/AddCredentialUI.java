/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NavigationUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Hassan
 */
public class AddCredentialUI extends JDialog {
    
    JTextField passwordText; 
    JTextField userText;

    

    public void buildUI()   {
        
        JFrame addUI = new JFrame("Login");
        addUI.setSize(400, 150);
        addUI.setLocationRelativeTo(null);
        addUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        addUI.add(panel);
        LoginUI(panel);

        addUI.setVisible(true);   
    }    
    
       

    public void LoginUI(JPanel panel) {
        
        panel.setLayout(new FlowLayout());

        JButton addUsername = new JButton("Add a Username");
        addUsername.setBounds(10, 80, 100, 25);
        panel.add(addUsername); 
        
        JButton addPassword = new JButton("Add a Password");
        addPassword.setBounds(10, 80, 100, 25);
        panel.add(addPassword);
        
        JButton addUser_Pass = new JButton("Add a Username and Passsword");
        addUser_Pass.setBounds(10, 80, 100, 25);
        panel.add(addUser_Pass);     
                
        JButton logoutButton = new JButton("Cancel");
        logoutButton.setBounds(10, 80, 100, 25);
        panel.add(logoutButton);  
    
        
        addUsername.addActionListener(new ActionListener()    {

            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

    }
}
