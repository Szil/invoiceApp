/*
 * Created by JFormDesigner on Thu Jun 26 13:35:57 CEST 2014
 */

package view;

import com.jgoodies.forms.factories.Borders;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import model.Product;
import model.Products;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author GergÅ Nemes
 */
public class UjTetel extends JDialog implements Runnable {
    public UjTetel(Frame owner) {
        super(owner);
        run();
    }

    public UjTetel(Dialog owner) {
        super(owner);
        run();
    }

    @Override
    public void run() {
        initComponents();
        btnAddTermek.setActionCommand("btnAddTermek");
        okButton.setActionCommand("btnOK");
        cancelButton.setActionCommand("btnCancel");
        ccbTermekek.setActionCommand("ccbTermekek");
    }

    public void showUjTetel() {
        setVisible(true);
    }

    public void disposeUjTetel() {
        dispose();
    }

    public void addUjTetelListener(ActionListener utl) {
        btnAddTermek.addActionListener(utl);
        okButton.addActionListener(utl);
        cancelButton.addActionListener(utl);
        ccbTermekek.addActionListener(utl);
    }

    public void fillTermekBox(java.util.List<Product> prodList) {
        ccbTermekek.removeAllItems();
        if (prodList.isEmpty()) {
            ccbTermekek.addItem("Nincs termék még");
        } else
            for (Product product : prodList) {
                ccbTermekek.addItem(product);
            }
    }

    public Products getUjTetel() {
        Products newProd = new Products();
        Product selProd = (Product) ccbTermekek.getSelectedItem();
        newProd.setProdId(selProd);
        newProd.setQuantity((Integer) spDarab.getValue());
        return newProd;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - GergÅ Nemes
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        ccbTermekek = new JComboBox();
        btnAddTermek = new JButton();
        lbDarab = new JLabel();
        spDarab = new JSpinner();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("Invoice");
        setMinimumSize(new Dimension(200, 100));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(Borders.createEmptyBorder("7dlu, 7dlu, 7dlu, 7dlu"));
            dialogPane.setPreferredSize(new Dimension(395, 140));
            dialogPane.setMinimumSize(new Dimension(280, 100));

            // JFormDesigner evaluation mark
            /*dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), dialogPane.getBorder()
            ));*/
            dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });

            dialogPane.setLayout(new FormLayout(
                    "pref, $rgap, pref",
                    "3*(default, $lgap), default"));

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridLayout());

                //---- ccbTermekek ----
                ccbTermekek.setPreferredSize(new Dimension(180, 30));
                contentPanel.add(ccbTermekek);
            }
            dialogPane.add(contentPanel, CC.xy(1, 1));

            //---- btnAddTermek ----
            btnAddTermek.setText("\u00daj term\u00e9k");
            dialogPane.add(btnAddTermek, CC.xy(3, 1));

            //---- lbDarab ----
            lbDarab.setText("Darabsz\u00e1m:");
            lbDarab.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lbDarab.setFocusable(false);
            lbDarab.setHorizontalTextPosition(SwingConstants.LEFT);
            dialogPane.add(lbDarab, CC.xy(1, 5));

            //---- spDarab ----
            spDarab.setPreferredSize(new Dimension(70, 30));
            spDarab.setModel(new SpinnerNumberModel(1, 1, null, 1));
            dialogPane.add(spDarab, CC.xy(3, 5));

            //======== buttonBar ========
            {
                buttonBar.setBorder(Borders.createEmptyBorder("5dlu, 0dlu, 0dlu, 0dlu"));
                buttonBar.setLayout(new FormLayout(
                        "$glue, $button, $rgap, $button",
                        "default"));

                //---- okButton ----
                okButton.setText("OK");
                buttonBar.add(okButton, CC.xy(2, 1));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                buttonBar.add(cancelButton, CC.xy(4, 1));
            }
            dialogPane.add(buttonBar, CC.xy(3, 7));
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - GergÅ Nemes
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JComboBox ccbTermekek;
    private JButton btnAddTermek;
    private JLabel lbDarab;
    private JSpinner spDarab;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
