package edu.mum.cs.cs525.project.banking.ui.bank;

import javax.swing.*;

/**
 * Created by Razib Mollick on 1/31/2016.
 */
public class InputValidation extends InputVerifier {
    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();

        if ("".equals(text))
        {
            return false;
        }

        return true;
        }
}
