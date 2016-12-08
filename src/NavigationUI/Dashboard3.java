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
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Random;
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
public class Dashboard3 extends javax.swing.JFrame {

    private static final int FRAME_WIDTH = 900;
    private static final int FRAME_HEIGHT = 400;
    static JTable tableCredential;
    static int ID = 0;

    public Dashboard3() {
        initComponents();

    }

    private void initComponents() {

        final JFrame frame = new JFrame();
        final JPanel buttonPanel = new JPanel();
        frame.add(buttonPanel);
        buttonPanel.setLayout(null);

        // Set up Add button and its location
        final JButton buttonAdd = new JButton(" Add ");
        buttonAdd.setBounds(50, 325, 100, 20);
        buttonPanel.add(buttonAdd);
        ///* Set up Generate Random Password Button
        final JButton buttonRandom = new JButton("Generate Random Password");
        buttonRandom.setBounds(40, 200, 200, 20);
        buttonPanel.add(buttonRandom);
        
        

        //*/
        // Set up Exit button and its location
        final JButton buttonExit = new JButton("Exit");
        buttonExit.setBounds(200, 325, 100, 20);
        buttonPanel.add(buttonExit);

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
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    BufferedWriter bfw = new BufferedWriter(new FileWriter("credentialInfo.txt"));

                    for (int i = 0; i < tableCredential.getRowCount(); i++) {

                        for (int j = 0; j < tableCredential.getColumnCount(); j++) {
                            bfw.newLine();
                            bfw.write((String) (tableCredential.getValueAt(i, j)));
                            bfw.write("\t");;
                        }
                    }
                    bfw.close();
                } catch (Exception ex) {

                    ex.printStackTrace();
                }
            }
        });

        // Set up Load button and its location
        final JButton buttonLoad = new JButton("Load");
        buttonLoad.setBounds(500, 325, 100, 20);
        buttonPanel.add(buttonLoad);

        // Method for load button
        buttonLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String line;
                BufferedReader reader;
                try {

                    reader = new BufferedReader(new FileReader("credentialInfo.txt"));
                    while ((line = reader.readLine()) != null) {
                        tableCredential.add(null, line.split(", "));
                    }
                    reader.close();
                } catch (Exception ex) {

                    ex.printStackTrace();

                }

            }
        });
        // Set up Labels for website, username, password, and random password
        final JLabel labelWebsite = new JLabel("Enter Website Name: ");
        labelWebsite.setBounds(20, 5, 150, 100);
        buttonPanel.add(labelWebsite);

        final JLabel labelUsername = new JLabel("Enter Username: ");
        labelUsername.setBounds(20, 60, 150, 100);
        buttonPanel.add(labelUsername);

        final JLabel labelPassword = new JLabel("Enter Password:");
        labelPassword.setBounds(20, 115, 150, 100);
        buttonPanel.add(labelPassword);
        /*
        final JLabel labelRandomPassword = new JLabel("Random Password:");
        labelPassword.setBounds(20, 150, 150, 100);
        buttonPanel.add(labelRandomPassword);
        //*/
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
        /*
        final JTextField textRandom = new JTextField();
        textPassword.setBounds(160, 190, 100, 25);
        buttonPanel.add(textRandom);
        //*/
        // Set up of columns in the table
        String[] columns = {"ID", "Website", "Username", "Password"};
        // Set up of the table with the appropriate column headers
        final DefaultTableModel model = new DefaultTableModel(null, columns);
        final JTable credentialTable = new JTable();
        credentialTable.setModel(model);
        JScrollPane scrollPane = new JScrollPane(credentialTable);
        scrollPane.setBounds(300, 20, 550, 300);
        buttonPanel.add(scrollPane);

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

                if (textPassword.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Error: no password ");
                    return;
                }

                // Add an ID number to each entry and add the entry to the table
                ID++;
                model.addRow(new Object[]{String.valueOf(ID),
                    textWebsite.getText(), textUsername.getText(),
                    textPassword.getText(),});

                // Once entry is added to the table, the text fields are cleared for the next entry
                textUsername.setText("");
                textWebsite.setText("");
                textPassword.setText("");

            }
        });
        ///*
        buttonRandom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
                StringBuilder generatedString = new StringBuilder();
                Random rnd = new Random();
                while (generatedString.length() < 12) {
                    int index = (int) (rnd.nextFloat() * CHARS.length());
                    generatedString.append(CHARS.charAt(index));
                }
                String generatedStringStr = generatedString.toString();
                textPassword.setText(generatedStringStr);
            }
        });
        //*/

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        frame.setLocationRelativeTo(null);
    }

}
