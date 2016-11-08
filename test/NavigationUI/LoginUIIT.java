/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NavigationUI;

import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zarathustra
 */
public class LoginUIIT {
    
    public LoginUIIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of buildUI method, of class LoginUI.
     */
    @Test
    public void testBuildUI() {
        System.out.println("buildUI");
        LoginUI instance = new LoginUI();
        instance.buildUI();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of LoginUI method, of class LoginUI.
     */
    @Test
    public void testLoginUI() {
        System.out.println("LoginUI");
        JPanel panel = null;
        LoginUI instance = new LoginUI();
        instance.LoginUI(panel);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
