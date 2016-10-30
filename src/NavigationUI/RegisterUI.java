/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NavigationUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
public class RegisterUI extends Register {
    
    JFrame regUI;
    
    public void buildRegistry()   {
        
        regUI = new JFrame("Register");
        regUI.setSize(400, 150);
        regUI.setLocationRelativeTo(null);
        regUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        regUI.add(panel);
        Register(panel);

        regUI.setVisible(true);        
    }   
    
    public void Register(JPanel panel) {
        
        panel.setLayout(null);
        
        JLabel userLabel = new JLabel("Choose Username");
        userLabel.setBounds(10, 10, 150, 25);
        panel.add(userLabel);
        
        final JTextField userText = new JTextField(20);
        userText.setBounds(200, 10, 160, 25);
        panel.add(userText);
        
        JLabel passwordLabel = new JLabel("Choose Password");
        passwordLabel.setBounds(10, 40, 150, 25);
        panel.add(passwordLabel);
        
        final JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(200, 40, 160, 25);
        panel.add(passwordText);
        
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(10, 80, 100, 25);
        panel.add(registerButton);

        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(280, 80, 100, 25);
        panel.add(cancelButton);    
        
        
        registerButton.addActionListener(new ActionListener()      {
            @Override
            public void actionPerformed(ActionEvent b) {
                Register register = new Register();
                String user = userText.getText().trim();
                String pass = passwordText.getText().trim();
                register.addUser(user, pass); 
                regUI.dispose();
            }
                
        });
    
    
    
    }
}
