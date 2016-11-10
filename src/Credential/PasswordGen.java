package Credential;

/**
 *
 * @author EddieVeneziale
 */

import java.util.*;

public class PasswordGen {
    public static void main(String[] args) {
    
        Scanner scan = new Scanner (System.in);
        Random r = new Random ();
        
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"}; 
        
        System.out.println("\nRandom Passsword Generator\n____________");
        System.out.print("How many characters would you like the password to contain?\t");
        int c = scan.nextInt ();
        int nc = 0-c;
        int c2 = c / 2;
        int nc2 = 0-c2;
        int ncm = (nc+1) / 2;
        
        if(c%2 == 0) {
            for(int x = nc2;x < 0;x++) {
                int alphaNum = r.nextInt(26);
                System.out.print(alphabet[alphaNum]);
                int numNum = r.nextInt(10);
                System.out.print(numNum);
            }  
        }
        else {
            for(int x = ncm;x < 0;x++) {
                int alphaNum = r.nextInt(26);
                System.out.print(alphabet[alphaNum]);
                int numNum = r.nextInt(10);
                System.out.print(numNum);
            }   
            int numNum = r.nextInt(10);
            System.out.print(numNum);
        }
        
        System.out.println("\n____________\n");
    }
 }

