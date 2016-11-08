/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NavigationUI;

import java.awt.Component;
import javax.swing.JTable;

/**
 *
 * @author Zarathustra aka Kevin
 */
public class PasswordCellRenderer {
    private static final String ASTERISKS = "************************";

    //@Override
    public PasswordCellRenderer getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4, int arg5) {
        int length =0;
        if (arg1 instanceof String) {
            length =  ((String) arg1).length();
        } else if (arg1 instanceof char[]) {
            length = ((char[])arg1).length;
        }
        setText(asterisks(length));
        return this;
    }

    private String asterisks(int length) {
        if (length > ASTERISKS.length()) {
            StringBuilder sb = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                sb.append('*');
            }
            return sb.toString();
        } else {
            return ASTERISKS.substring(0, length);
        }
    }

    private void setText(String asterisks) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
