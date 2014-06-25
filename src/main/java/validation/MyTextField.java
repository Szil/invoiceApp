package validation;

import javax.swing.*;

/**
 * Created by Gergo on 2014.06.24..
 */
public class MyTextField extends JTextField {

    public boolean isHasText() {
        if (getText() != "") return true;
        return false;
    }
}
