/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NavigationUI;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
//import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

/**
 *
 * @author Hassan
 */
public class Register {
    
    public UserList userList;
    private static SecretKeySpec secretKey;
    private static byte[] key;
    

    public void addUser(String username, String password)   {
        
        //usernames = userList.getUsernames();
        //passwords = userList.getValidPasswords();      
        //usernames.add(username);
        //passwords.add(password);
      
    }
    
//    public void setKey(String myKey) 
//    {
//        MessageDigest sha = null;
//        try {
//            key = myKey.getBytes("UTF-8");
//            sha = MessageDigest.getInstance("SHA-1");
//            key = sha.digest(key);
//            key = Arrays.copyOf(key, 16); 
//            secretKey = new SecretKeySpec(key, "AES");
//        } 
//        catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } 
//        catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }   
//    public String encryptS(String strToEncrypt, String secret) 
//    {
//        try
//        {
//            setKey(secret);
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
//        } 
//        catch (Exception e) 
//        {
//            System.out.println("Error while encrypting: " + e.toString());
//        }
//        return null;
//    }
        
    public void AppendXML(String text, String key)  {
        
        String username = text;
        String password = key;

//        String key_static="Hassan99993421!@";
//        username=encryptS(text,key_static);
//        password=encryptS(key,key_static);
        //PrintWriter out = new PrintWriter("file1.txt");
        //out.println(username);
        //out.println(password);
        //out.close();
        //username=java.net.URLEncoder.encode(username, "UTF-8");
        //password=java.net.URLEncoder.encode(password, "UTF-8");       
        
        try {	
           File inputFile = new File("test.xml");
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           Document doc = dBuilder.parse(inputFile);
           doc.getDocumentElement().normalize();
           Node user = doc.getFirstChild();
           //Node newUser = user.appendChild(doc.createElement("Account"));
           Element u = doc.createElement("Account");
           u.setAttribute("UserID", text);
           u.setAttribute("PasswordID", key);
           user.appendChild(u);

           //newUser.setAttribute(username, password);

          TransformerFactory transformerFactory = TransformerFactory.newInstance();
          Transformer transformer = transformerFactory.newTransformer();
          DOMSource source = new DOMSource(doc);
          StreamResult result = new StreamResult(new File("test.xml"));
          transformer.transform(source, result);         
        } catch (ParserConfigurationException | SAXException | IOException | DOMException | TransformerException e) 
        {
        }    
        
    }
    
    
    
}
