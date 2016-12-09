/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NavigationUI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

/**
 *
 * @author Hassan
 */
public class Register2 {
    
    public UserList userList;
    private static SecretKeySpec secretKey;
    private static byte[] key;
    File inputFile = new File("test.xml"); 
 

    
    public void textFile (String username, String password)  {
        
        String user = username;
        File filename = new File(user + ".txt");
        
        if (filename.exists())   {
            System.out.println("Username Already Exists");
        } else  {            
            try {
                
                FileWriter fw = new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write("username: " + username + " ");
                bw.write("password: " + password);

                bw.close();

                System.out.println("Done");                
        } catch (IOException e)   {
                e.printStackTrace();
        }            
        }        
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
            
           if (inputFile.exists())   {
               
                String inputfile = ("C:\\Users\\Hassan\\Documents\\GitHub\\credentialApp\\test.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(inputFile);
                //doc.getDocumentElement().normalize();
                Node user = doc.getFirstChild();
                //Node newUser = user.appendChild(doc.createElement("Account"));
                Element u = doc.createElement("Account");
                user.appendChild(u);
                Attr attr = doc.createAttribute("id");
                attr.setValue(text);
                u.setAttributeNode(attr);
                u.setIdAttribute("id", true);
                Attr attr2 = doc.createAttribute("pass");
                attr2.setValue(key);
                u.setAttributeNode(attr2);
                //u.setAttribute("pass", key);  
                //u.setAttribute("id", text);    
                //user.appendChild(u);

                //newUser.setAttribute(username, password);

               TransformerFactory transformerFactory = TransformerFactory.newInstance();
               Transformer transformer = transformerFactory.newTransformer();
               DOMSource source = new DOMSource(doc);
               StreamResult result = new StreamResult(new File("test.xml"));
               transformer.transform(source, result);                              
           }  else {

                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.newDocument();
                    // root element
                    Element rootElement = doc.createElement("User");
                    doc.appendChild(rootElement);    
                    
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File("C:\\Users\\Hassan\\Documents\\GitHub\\credentialApp\\test.xml"));
                    transformer.transform(source, result);
                    // Output to console for testing
                    StreamResult consoleResult = new StreamResult(System.out);
                    transformer.transform(source, consoleResult);                    
           }              
        } catch (ParserConfigurationException | SAXException | IOException | DOMException | TransformerException e) 
        {
        }    
        
    }
    
    
    
}
