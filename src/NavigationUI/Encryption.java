/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NavigationUI;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Hassan
 */
public class Encryption {
    
    
    
    
    
   
   public void encrypt(String text, String key)   {
        
    
       
    try     {    
        Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] encrypted = cipher.doFinal(text.getBytes());
        String e = new String(encrypted);
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        String decrypted = new String(cipher.doFinal(encrypted));
        System.err.println(decrypted);
        
        }
    catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
    
//    public void decrypt(String text, String key, String e)   {
//    
//    try     {    
//        
//        Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
//        Cipher cipher = Cipher.getInstance("AES");
//        byte[] en = e.getBytes();
//        cipher.init(Cipher.DECRYPT_MODE, aesKey);
//        String decrypted = new String(cipher.doFinal(en));
//        System.err.println(decrypted);
//        
//        }
//    catch(Exception ed) 
//        {
//            ed.printStackTrace();
//        }        
//    
//    }
    
    public static void main(String[] args) 
    {
        Encryption app = new Encryption();
        app.encrypt("Hassan", "1234567891234567");
        //app.decrypt(text, "1234567891234567", e);
    }    
}
