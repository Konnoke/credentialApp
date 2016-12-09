/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NavigationUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Zarathustra
 */
public class Dashboard4 extends LoginUI {
    
    private static final int FRAME_WIDTH = 900;
    private static final int FRAME_HEIGHT = 400;
    static JTable tableCredential;
    static int ID = 0;
    String user;
    
    public void Dashboard4() {
        initComponents();
        
    }

    private void initComponents(){
        
        
        final JFrame frame = new JFrame();
        final JPanel buttonPanel = new JPanel();
        frame.add(buttonPanel);
        buttonPanel.setLayout(null);

        // Set up Add button and its location
        final JButton buttonAdd = new JButton(" Add ");
        buttonAdd.setBounds(50, 325, 100, 20);
        buttonPanel.add(buttonAdd);


        // Set up Exit button and its location
        final JButton buttonExit = new JButton("Exit");
        buttonExit.setBounds(200, 325, 100, 20);
        buttonPanel.add(buttonExit);
        
        
        // Set up of columns in the table
        String[] columns = { "ID", "Website", "Username", "Password" };
        // Set up of the table with the appropriate column headers
        final DefaultTableModel model = new DefaultTableModel(null, columns);
        final JTable credentialTable = new JTable();
        credentialTable.setModel(model);
        JScrollPane scrollPane = new JScrollPane(credentialTable);
        scrollPane.setBounds(300, 20, 550, 300);
        buttonPanel.add(scrollPane);        
        
        
        String userName = LoginUI.user;

        // Method for exit button
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        // Set up Save button and its location
        final JButton buttonSave = new JButton("Save");
        buttonSave.setBounds(350, 325, 100, 20);
        buttonPanel.add(buttonSave);

        // Set up Save button method
        buttonSave.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            String text = "hey";
            String key = "boo";	
            

                File filename = new File("credential.txt");
                
                    try{    
                        FileWriter fw = new FileWriter(filename);
                        BufferedWriter bw = new BufferedWriter(fw);
                         for (int i = 0 ; i < model.getRowCount(); i++) {

                            for(int j = 0 ; j < model.getColumnCount();j++)
                        {
                            ///System.out.println(model.getColumnName(j));
                            bw.write(model.getColumnName(j));
                            bw.write(": ");
                            bw.write(model.getValueAt(i, j)+ " ");
                            //System.out.println(model.getValueAt(i, j));
                            //fw.write(tableCredential.getValueAt(i, j)+ " ");                           
                        } 
                           
                      }
                         bw.close();
                     }
                    catch(Exception ex){

                    ex.printStackTrace();

                    }           
            }});            

        // Set up Load button and its location
        final JButton buttonLoad =  new JButton("Load");
        buttonLoad.setBounds(500, 325, 100, 20);
        buttonPanel.add(buttonLoad);

        // Method for load button
        buttonLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String line;
                BufferedReader reader;
                    try{       
                        
                        
                        
                        reader = new BufferedReader(new FileReader("credentialInfo.txt"));
                        while((line = reader.readLine()) != null) 
                        {
                           tableCredential.add(null, line.split(", ")); 
                        }
                        reader.close();
                     }
                    catch(Exception ex){

                ex.printStackTrace();

                    }

            }
        });
        // Set up Labels for name, hours, and pay rate
        final JLabel labelWebsite = new JLabel("Enter Website Name: ");
        labelWebsite.setBounds(20, 5, 150, 100);
        buttonPanel.add(labelWebsite);

        final JLabel labelUsername = new JLabel("Enter Username: ");
        labelUsername.setBounds(20, 60, 150, 100);
        buttonPanel.add(labelUsername);

        final JLabel labelPassword = new JLabel("Enter Password");
        labelPassword.setBounds(20, 115, 150, 100);
        buttonPanel.add(labelPassword);



        // Set up textboxes for all expected inputs
        final JTextField textWebsite = new JTextField();
        textWebsite.setBounds(180, 40, 100, 25);
        buttonPanel.add(textWebsite);

        final JTextField textUsername = new JTextField();
        textUsername.setBounds(180, 95, 100, 25);
        buttonPanel.add(textUsername);

        final JTextField textPassword = new JTextField();
        textPassword.setBounds(180, 150, 100, 25);
        buttonPanel.add(textPassword);



        // Save button methods, including validation checking
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textWebsite.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Error: no Website name");
                    return;
                }

                if (textUsername.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Error: no Username");
                    return;
                }


                if (textPassword.getText().length()==0){
                    JOptionPane.showMessageDialog(null, "Error: no password ");
                    return;
                }


                // Add an ID number to each entry and add the entry to the table
                ID++;
                model.addRow(new Object[] { String.valueOf(ID),
                        textWebsite.getText(), textUsername.getText(),
                        textPassword.getText(), });


                // Once entry is added to the table, the text fields are cleared for the next entry
                textUsername.setText("");
                textWebsite.setText("");
                textPassword.setText("");

            }
        });     

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        frame.setLocationRelativeTo(null);
    }


    
    
    
}
        
                