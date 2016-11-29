/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NavigationUI;


import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

import static java.awt.SystemColor.text;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Zarathustra
 */
public class Login extends Register {
    
    private UserList userList;

    private static SecretKeySpec secretKey;
    private static byte[] key;
    
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
    
    public void setKey(String myKey) 
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    
    public String decryptS(String strToDecrypt, String secret) 
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } 
        catch (Exception e) 
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
       
    public boolean authenticate2 (String username, String password)   {
        
      try {	
         File inputFile = new File("test.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         NodeList nList = doc.getElementsByTagName("Account");
         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;
            String u, p;
            String user_name = null;
            String pass_word = null;
            u = eElement.getAttribute("UserID");
             //find HASSANRASHID! and replace with &#
            //user_name = u.replaceAll("HASSANRASHID!", xml11pattern);  
            //u = java.net.URLDecoder.decode(u, "UTF-8"); 
            p = eElement.getAttribute("PasswordID");
            //find HASSANRASHID! and replace with &#
            //pass_word = p.replaceAll("HASSANRASHID!", xml11pattern);
            //p = java.net.URLDecoder.decode(p, "UTF-8"); 
            
            //PrintWriter out = new PrintWriter("file2.txt");
            //out.println(u);
            //out.println(p);
            //out.close();
     
            //************* DECRYPTION PHASE
            String decrypted_username=null;
            String decrypted_password=null;

            String key_static="Hassan99993421!@";
            decrypted_username=decryptS(u,key_static);
            decrypted_password=decryptS(p,key_static);

            //PrintWriter out2 = new PrintWriter("file3.txt");
            //out2.println(decrypted_username);
            //out2.println(decrypted_password);
            //out2.close();

            //System.err.println(decrypted_username);
            //System.err.println(decrypted_password);

            //************* END DECRYP PHASE
            if (decrypted_username.equals(username) && decrypted_password.equals(password)) {
               return true;
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }                      
        return false;
    }
}
