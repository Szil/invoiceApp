package view;

import model.Currency;
import model.Organisation;
import model.Partner;
import model.Products;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

/*
 * @author Adam
 */
public class SzamlaKeszitesDialog extends JDialog implements InvoiceInterface, Runnable {

    public SzamlaKeszitesDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        run();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        ccbFiztesiMod = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtNumOfCopy = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        ccbPenzemek = new JComboBox<Currency>();
        txtFullfilDate = new javax.swing.JTextField();
        txtDueDate = new javax.swing.JTextField();
        txtIssueDate = new javax.swing.JTextField();
        txtSorszam = new javax.swing.JTextField();
        txtSzlaSzam = new JLabel();
        jPanel8 = new javax.swing.JPanel();
        txtPartnerTaxNum = new javax.swing.JTextField();
        txtPartnerAccount = new javax.swing.JTextField();
        txtPartnerAddress = new javax.swing.JTextField();
        txtPartnerName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtPartnerPhone = new javax.swing.JTextField();
        txtPartnerEmail = new javax.swing.JTextField();
        ccbPartner = new javax.swing.JComboBox<Partner>();
        lbSzamlaS = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        txtOrgPhone = new javax.swing.JTextField();
        txtOrgTaxNum = new javax.swing.JTextField();
        txtOrgAccount = new javax.swing.JTextField();
        txtOrgAddress = new javax.swing.JTextField();
        txtOrgName = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtOrgEmail = new javax.swing.JTextField();
        ccbKiallito = new javax.swing.JComboBox<Organisation>();
        btnUjTetel = new javax.swing.JButton();
        btnModosit = new javax.swing.JButton();
        btnTorles = new javax.swing.JButton();
        btnMentes = new javax.swing.JButton();
        btnPrintView = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOssz = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        txtOsszesen = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTetelek = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        ;
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Invoice " + verzio + " -  Számlakészítés");
        setBackground(new java.awt.Color(204, 204, 204));
        setBounds((int) ((kijelzoMeret.width / 2 - 512)),
                (int) ((kijelzoMeret.height / 2) - 375), 1024, 720);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setForeground(new java.awt.Color(102, 102, 102));
        setIconImage(new Helper().createImageIcon(defIconPath).getImage());
        setMaximumSize(new java.awt.Dimension(1024, 720));
        setMinimumSize(new java.awt.Dimension(1024, 720));
        setModal(true);
        setName("Szamlakeszites"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1024, 720));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(780, 100));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("VTSZ/SZJ/TESZOR Megnevezés");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Cikkszám");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Menny. M. Egys.");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Egységár");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Nettó");


        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("ÁFA%");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("ÁFA");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Bruttó");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel18)
                                                .addGap(52, 52, 52)
                                                .addComponent(jLabel5)))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel8))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabel11)
                                                .addGap(92, 92, 92)
                                                .addComponent(jLabel12))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(101, 101, 101)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel5)
                                                                .addComponent(jLabel18))
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel20)
                                                                .addComponent(jLabel12)
                                                                .addComponent(jLabel11)
                                                                .addComponent(jLabel9)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        ccbFiztesiMod.setBackground(new java.awt.Color(204, 255, 204));
        ccbFiztesiMod.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ccbFiztesiMod.setForeground(new java.awt.Color(0, 0, 204));
        ccbFiztesiMod.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Fizetési mód", "Átutalás 8 nap", "Átutalás 10 nap", "Átutalás 15 nap"}));
        ccbFiztesiMod.setToolTipText("Fizetési mód");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Teljesítés:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Kelt:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Fizetési határidő:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Példány:");

        txtNumOfCopy.setBackground(new java.awt.Color(204, 255, 255));
        txtNumOfCopy.setPreferredSize(new java.awt.Dimension(50, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Sorszám:");

        ccbPenzemek.setBackground(new java.awt.Color(204, 255, 204));
        ccbPenzemek.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ccbPenzemek.setForeground(new java.awt.Color(0, 0, 204));
        //ccbPenzemek.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Pénznem", "HUF", "EUR", "USD"}));
        ccbPenzemek.setPreferredSize(new java.awt.Dimension(80, 21));
        ccbPenzemek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        txtFullfilDate.setBackground(new java.awt.Color(204, 255, 255));
        txtFullfilDate.setPreferredSize(new java.awt.Dimension(73, 20));

        txtDueDate.setBackground(new java.awt.Color(204, 255, 255));
        txtDueDate.setPreferredSize(new java.awt.Dimension(73, 20));

        txtIssueDate.setBackground(new java.awt.Color(204, 255, 255));
        txtIssueDate.setPreferredSize(new java.awt.Dimension(73, 20));

        txtSorszam.setBackground(new java.awt.Color(204, 255, 255));
        txtSorszam.setPreferredSize(new java.awt.Dimension(65, 20));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(ccbFiztesiMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ccbPenzemek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFullfilDate, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumOfCopy, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSorszam, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ccbFiztesiMod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel16)
                                        .addComponent(txtNumOfCopy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel17)
                                        .addComponent(txtFullfilDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtIssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ccbPenzemek, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSorszam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtSzlaSzam.setBackground(new java.awt.Color(204, 255, 204));
        txtSzlaSzam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSzlaSzam.setForeground(new java.awt.Color(0, 0, 204));
        txtSzlaSzam.setPreferredSize(new java.awt.Dimension(144, 21));

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));

        txtPartnerTaxNum.setBackground(new java.awt.Color(204, 255, 255));
        txtPartnerTaxNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtPartnerAccount.setBackground(new java.awt.Color(204, 255, 255));
        txtPartnerAccount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtPartnerAddress.setBackground(new java.awt.Color(204, 255, 255));
        txtPartnerAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtPartnerName.setBackground(new java.awt.Color(204, 255, 255));
        txtPartnerName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel7.setText("Vevő");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Cím:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Számlaszám:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Adószám:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Telefon, E-mail:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel32.setText("Név:");

        txtPartnerPhone.setBackground(new java.awt.Color(204, 255, 255));
        txtPartnerPhone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtPartnerEmail.setBackground(new java.awt.Color(204, 255, 255));
        txtPartnerEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        ccbPartner.setBackground(new java.awt.Color(204, 255, 204));
        ccbPartner.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ccbPartner.setForeground(new java.awt.Color(0, 0, 204));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel4))
                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel32))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPartnerName)
                                        .addComponent(txtPartnerAddress)
                                        .addComponent(txtPartnerAccount)
                                        .addComponent(txtPartnerTaxNum)
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ccbPartner, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(txtPartnerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPartnerEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(ccbPartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPartnerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel32))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtPartnerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPartnerAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPartnerTaxNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtPartnerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtPartnerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        lbSzamlaS.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbSzamlaS.setForeground(new java.awt.Color(0, 0, 204));
        lbSzamlaS.setText("Számla");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("A számla x példányban készült. Ez a számla a(z): 2/2, eredeti.");

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));

        txtOrgPhone.setBackground(new java.awt.Color(204, 255, 255));
        txtOrgPhone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtOrgTaxNum.setBackground(new java.awt.Color(204, 255, 255));
        txtOrgTaxNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtOrgAccount.setBackground(new java.awt.Color(204, 255, 255));
        txtOrgAccount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtOrgAddress.setBackground(new java.awt.Color(204, 255, 255));
        txtOrgAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtOrgName.setBackground(new java.awt.Color(204, 255, 255));
        txtOrgName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel27.setText("Eladó");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel28.setText("Cím:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel29.setText("Számlaszám:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel30.setText("Adószám:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel31.setText("Telefon, E-mail:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Név:");

        txtOrgEmail.setBackground(new java.awt.Color(204, 255, 255));
        txtOrgEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        ccbKiallito.setBackground(new java.awt.Color(204, 255, 204));
        ccbKiallito.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ccbKiallito.setForeground(new java.awt.Color(0, 0, 204));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
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
                                        .addComponent(txtOrgName)
                                        .addComponent(txtOrgAddress)
                                        .addComponent(txtOrgAccount)
                                        .addComponent(txtOrgTaxNum)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addComponent(jLabel27)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ccbKiallito, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addComponent(txtOrgPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtOrgEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel27)
                                        .addComponent(ccbKiallito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtOrgName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtOrgAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel28))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtOrgAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel29))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtOrgTaxNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel30))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtOrgPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel31)
                                        .addComponent(txtOrgEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUjTetel.setBackground(new java.awt.Color(204, 255, 204));
        btnUjTetel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUjTetel.setForeground(new java.awt.Color(0, 0, 204));
        btnUjTetel.setText("Új tétel");
        btnUjTetel.setPreferredSize(new java.awt.Dimension(73, 25));
        btnUjTetel.setActionCommand("btnUjTetel");

        btnModosit.setBackground(new java.awt.Color(204, 255, 204));
        btnModosit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModosit.setForeground(new java.awt.Color(0, 0, 204));
        btnModosit.setText("Módosítás");
        btnModosit.setPreferredSize(new java.awt.Dimension(80, 25));
        btnModosit.setActionCommand("btnModosit");

        btnTorles.setBackground(new java.awt.Color(204, 255, 204));
        btnTorles.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTorles.setForeground(new java.awt.Color(255, 0, 0));
        btnTorles.setText("Törlés");
        btnTorles.setToolTipText("Számla törlése, amennyiben még nem lett elmentve.");
        btnTorles.setPreferredSize(new java.awt.Dimension(73, 23));
        btnTorles.setActionCommand("btnTorles");

        btnMentes.setBackground(new java.awt.Color(204, 255, 204));
        btnMentes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMentes.setForeground(new java.awt.Color(0, 153, 0));
        btnMentes.setText("Mentés");
        btnMentes.setPreferredSize(new java.awt.Dimension(73, 25));
        btnMentes.setActionCommand("btnMentes");

        btnPrintView.setBackground(new java.awt.Color(204, 255, 204));
        btnPrintView.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPrintView.setForeground(new java.awt.Color(0, 0, 204));
        btnPrintView.setText("Nyomtatási kép");
        btnPrintView.setActionCommand("btnPrintView");

        btnPrint.setBackground(new java.awt.Color(204, 255, 204));
        btnPrint.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(0, 0, 204));
        btnPrint.setText("Nyomtatás");
        btnPrint.setPreferredSize(new java.awt.Dimension(73, 25));
        btnPrint.setActionCommand("btnPrint");

        tblOssz.setBackground(new java.awt.Color(204, 204, 204));
        tblOssz.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblOssz.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"                             27%", null, null, null},
                        {"                    ÁFA részletezése:", null, null, null}
                },
                new String[]{
                        "Összesen:", "ÁFA alap", "ÁFA összege", "Bruttó érték"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tblOssz.setToolTipText("Összesítő táblázat");
        tblOssz.setGridColor(new java.awt.Color(0, 0, 0));
        tblOssz.setRowHeight(18);
        tblOssz.getTableHeader().setResizingAllowed(false);
        tblOssz.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblOssz);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Összesen:");

        txtOsszesen.setEditable(false);
        txtOsszesen.setBackground(new java.awt.Color(204, 255, 51));
        txtOsszesen.setPreferredSize(new java.awt.Dimension(264, 20));

        tblTetelek.setBackground(new java.awt.Color(204, 255, 255));
        tblTetelek.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tetelModel = new DefaultTableModel(new Object[][]{}, new String[]{"Cikkszám", "Megnevezés", "Mennyiség / Egys.", "Egységár", "Nettó", "ÁFA%", "ÁFA", "Bruttó"});
        tblTetelek.setModel(tetelModel);
        tblTetelek.setCellSelectionEnabled(true);
        tblTetelek.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblTetelek.setGridColor(new java.awt.Color(0, 0, 0));
        tblTetelek.setMaximumSize(new java.awt.Dimension(600, 550));
        tblTetelek.setMinimumSize(new java.awt.Dimension(600, 550));
        tblTetelek.setPreferredSize(new java.awt.Dimension(600, 630));
        tblTetelek.setRowHeight(17);
        tblTetelek.getTableHeader().setResizingAllowed(false);
        tblTetelek.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblTetelek);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setMaximumSize(new java.awt.Dimension(15, 15));
        jPanel2.setMinimumSize(new java.awt.Dimension(15, 15));
        jPanel2.setPreferredSize(new java.awt.Dimension(15, 15));
        jPanel2.setRequestFocusEnabled(false);

        jLabel26.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel26.setText("A számla az Invoice ver 1.5 programmal lett generálva és megfelel a(z) __________ kormányrendeletnek.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 9, Short.MAX_VALUE)
                                .addComponent(jLabel26))
        );

        jMenuBar1.setPreferredSize(new java.awt.Dimension(1024, 21));

        jMenu1.setText("Fájl");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Szerkesztés");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Súgó");
        jMenuBar1.add(jMenu3);

        jMenuBar1.add(Box.createHorizontalGlue());
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
                        .addComponent(jScrollPane3)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtSzlaSzam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbSzamlaS)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel25)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUjTetel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModosit, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnTorles, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtOsszesen, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnMentes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnPrintView, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2))))
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSzlaSzam, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lbSzamlaS)
                                                .addComponent(jLabel25)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                .addGap(1, 1, 1)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel23)
                                        .addComponent(txtOsszesen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnUjTetel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnModosit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnTorles, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnMentes, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnPrintView, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{btnPrintView, btnUjTetel, btnModosit, btnTorles, btnMentes, btnPrint});

        getAccessibleContext().setAccessibleDescription("Számlakészítés");
        getAccessibleContext().setAccessibleParent(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        //PÉNZNEM VÁLASZTÓ
    }//GEN-LAST:event_jComboBox2ActionPerformed

    @Override
    public void run() {
        initComponents();

    }

    public void addSzamlazasListener(ActionListener szrl) {
        btnUjTetel.addActionListener(szrl);
        btnMentes.addActionListener(szrl);
        btnModosit.addActionListener(szrl);
        btnPrint.addActionListener(szrl);
        btnPrintView.addActionListener(szrl);
        btnTorles.addActionListener(szrl);
    }

    public void fillCurrencies(List<Currency> currencies) {
        ccbPenzemek.removeAllItems();
        if (currencies.isEmpty()) {
            ccbPenzemek.addItem("Nincs");
        } else
            for (Currency currency : currencies) {
                ccbPenzemek.addItem(currency);
            }
    }

    public void fillOrgData(Organisation org) {
        txtOrgName.setText(org.getName());
        txtOrgAddress.setText(org.getAddress());
    }

    public void addTetelToTable(Vector qnt) {
        //DefaultTableModel mdl = (DefaultTableModel) tblTetelek.getModel();

        tetelModel.addRow(qnt);
        //mdl.addRow(qnt);
        //System.out.println(mdl.getDataVector());
        tblTetelek.setModel(tetelModel);
    }

    public void fillTetelTable(List<Products> productsList) {

    }

    public void fillCBPartner(List<Partner> partners) {
        ccbPartner.removeAllItems();
        if (partners.isEmpty()) {
            ccbPartner.addItem("Még nincs");
        } else
            for (Partner prt : partners) {
                ccbPartner.addItem(prt);
            }
    }

    public void setTxtSzlaSzam(String txt) {
        lbSzamlaS.setText("Számla - " + txt);
    }

    public void fillCBKiallito(List<Organisation> organisations) {
        ccbKiallito.removeAllItems();
        if (organisations.isEmpty()) {
            ccbKiallito.addItem("Még nincs");
        } else
            for (Organisation org : organisations) {
                ccbKiallito.addItem(org);
            }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrintView;
    private javax.swing.JButton btnUjTetel;
    private javax.swing.JButton btnModosit;
    private javax.swing.JButton btnTorles;
    private javax.swing.JButton btnMentes;
    private javax.swing.JButton btnPrint;
    private javax.swing.JComboBox ccbFiztesiMod;
    private javax.swing.JComboBox ccbPenzemek;
    private JLabel txtSzlaSzam;
    private javax.swing.JComboBox ccbKiallito;
    private javax.swing.JComboBox ccbPartner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbSzamlaS;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblOssz;
    private javax.swing.JTable tblTetelek;
    private javax.swing.JTextField txtOsszesen;
    private javax.swing.JTextField txtPartnerTaxNum;
    private javax.swing.JTextField txtOrgPhone;
    private javax.swing.JTextField txtOrgTaxNum;
    private javax.swing.JTextField txtOrgEmail;
    private javax.swing.JTextField txtPartnerPhone;
    private javax.swing.JTextField txtPartnerEmail;
    private javax.swing.JTextField txtPartnerAddress;
    private javax.swing.JTextField txtFullfilDate;
    private javax.swing.JTextField txtOrgAddress;
    private javax.swing.JTextField txtPartnerName;
    private javax.swing.JTextField txtOrgName;
    private javax.swing.JTextField txtSorszam;
    private javax.swing.JTextField txtNumOfCopy;
    private javax.swing.JTextField txtDueDate;
    private javax.swing.JTextField txtPartnerAccount;
    private javax.swing.JTextField txtOrgAccount;
    private javax.swing.JTextField txtIssueDate;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel tetelModel;
}
