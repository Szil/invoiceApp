package view;

import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class AddProduct extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox ccbTermekek;
    private JButton btnUjTetel;
    private JSpinner spinner1;

    public AddProduct(Frame parent) {
        super(parent);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        btnUjTetel.setActionCommand("btnUjTermek");
        ccbTermekek.setActionCommand("ccbTermekek");

        buttonOK.setActionCommand("buttonOK");

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public void fillTermekBox(List<Product> prodList) {
        ccbTermekek.removeAllItems();
        if (prodList.isEmpty()) {
            ccbTermekek.addItem("Nincs termék még");
        } else
            for (Product product : prodList) {
                ccbTermekek.addItem(product.getProdName());
            }
    }

    public void addProductListener(ActionListener apl) {
        btnUjTetel.addActionListener(apl);
        ccbTermekek.addActionListener(apl);
        buttonOK.addActionListener(apl);
    }

    public void showDialog(Component component) {
        pack();
        setVisible(true);
        setLocationRelativeTo(component);
    }
}
