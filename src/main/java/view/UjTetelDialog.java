package view;

import model.Product;
import validation.MyTextField;

import javax.swing.*;
import java.awt.event.ActionListener;

import static view.InvoiceInterface.defIconPath;
import static view.InvoiceInterface.kijelzoMeret;

/**
 * @author Adrenalin
 */
public class UjTetelDialog extends javax.swing.JDialog implements Runnable {

    /**
     * Creates new form NewKiallDialog
     */
    public UjTetelDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        run();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        txtTaxPercent = new MyTextField();
        txtUnitPrice = new MyTextField();
        txtUnitofMeasure = new MyTextField();
        txtSku = new MyTextField();
        txtProdName = new MyTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ccbCurrency = new MyTextField();
        btnMentes = new javax.swing.JButton();
        btnMegse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Invoice 1.5  -  Új tétel felvétele");
        setBounds((int) (((kijelzoMeret.width / 2) - 270)),
                (int) ((kijelzoMeret.height / 2) - 200), 540, 260);
        setIconImage(new helper().createImageIcon(defIconPath).getImage());
        setMaximumSize(new java.awt.Dimension(540, 260));
        setMinimumSize(new java.awt.Dimension(540, 260));
        setPreferredSize(new java.awt.Dimension(570, 260));
        setResizable(false);

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTaxPercent.setBackground(new java.awt.Color(204, 255, 255));
        txtTaxPercent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtUnitPrice.setBackground(new java.awt.Color(204, 255, 255));
        txtUnitPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtUnitofMeasure.setBackground(new java.awt.Color(204, 255, 255));
        txtUnitofMeasure.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtSku.setBackground(new java.awt.Color(204, 255, 255));
        txtSku.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtProdName.setBackground(new java.awt.Color(204, 255, 255));
        txtProdName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel27.setText("Termék:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel28.setText("Cikkszám:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel29.setText("Mennyiségi egység:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel30.setText("Egységár:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel31.setText("Áfakulcs, Pénznem:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Megnevezés:");

        ccbCurrency.setBackground(new java.awt.Color(204, 255, 255));
        ccbCurrency.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnMentes.setBackground(new java.awt.Color(204, 255, 204));
        btnMentes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMentes.setForeground(new java.awt.Color(0, 153, 0));
        btnMentes.setText("Mentés");
        btnMentes.setMaximumSize(new java.awt.Dimension(85, 30));
        btnMentes.setMinimumSize(new java.awt.Dimension(85, 30));
        btnMentes.setPreferredSize(new java.awt.Dimension(85, 30));
        btnMentes.setActionCommand("btnMentes");

        btnMegse.setBackground(new java.awt.Color(204, 255, 204));
        btnMegse.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMegse.setForeground(new java.awt.Color(0, 0, 204));
        btnMegse.setText("Mégse");
        btnMegse.setMaximumSize(new java.awt.Dimension(85, 30));
        btnMegse.setMinimumSize(new java.awt.Dimension(85, 30));
        btnMegse.setPreferredSize(new java.awt.Dimension(85, 30));
        btnMegse.setActionCommand("btnMegse");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel31)
                                                                        .addComponent(jLabel30))
                                                                .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING))
                                                        .addComponent(jLabel28)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtProdName)
                                                        .addComponent(txtSku)
                                                        .addComponent(txtUnitofMeasure)
                                                        .addComponent(txtUnitPrice)
                                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                                .addComponent(jLabel27)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                                .addComponent(txtTaxPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(ccbCurrency, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnMentes, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnMegse, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{btnMegse, btnMentes});

        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtProdName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtSku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel28))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtUnitofMeasure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel29))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel30))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTaxPercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel31)
                                        .addComponent(ccbCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnMentes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnMegse, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{btnMegse, btnMentes});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        initComponents();
    }

    public void addUjTetelListener(ActionListener kkl) {
        btnMentes.addActionListener(kkl);
        btnMegse.addActionListener(kkl);
    }

    public Product getSortOfValidatedData() {
        Product newProd = new Product();
        if (txtTaxPercent.isHasText() && txtSku.isHasText() && txtProdName.isHasText() && txtUnitPrice.isHasText()) {
            newProd.setUnitOfMeasure(txtUnitofMeasure.getText());
            newProd.setCurrency(0);
            newProd.setProdName(txtProdName.getText());
            newProd.setTax_Percent(Double.parseDouble(txtTaxPercent.getText()) / 100);
            newProd.setUnitPrice(Double.parseDouble(txtUnitPrice.getText()));
            newProd.setSku(txtSku.getText());
            return newProd;
        } else return null;
    }

    public void showInfoDialog(String message) {
        mainInfoDialog.showMessageDialog(null, message, "Invoice", JOptionPane.INFORMATION_MESSAGE);
    }

    public void disposeTetelDialog() {
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMegse;
    private javax.swing.JButton btnMentes;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel9;
    private MyTextField txtTaxPercent;
    private MyTextField txtUnitPrice;
    private MyTextField ccbCurrency;
    private MyTextField txtSku;
    private MyTextField txtProdName;
    private MyTextField txtUnitofMeasure;
    // End of variables declaration//GEN-END:variables
    private JOptionPane mainInfoDialog;
}
