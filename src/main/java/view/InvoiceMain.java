/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;

import static view.InvoiceInterface.*;

//import javax.swing.JDialog;
//import javax.swing.JToolBar;

/**
 *
 * @author Adrenalin
 */
public class InvoiceMain extends JFrame implements Runnable {

    /**
     * Creates new form InvoiceMain
     */
    public InvoiceMain() {
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

        jMenuItem1 = new javax.swing.JMenuItem();
        pnlInfoBar = new javax.swing.JPanel();
        lbInfoBar = new javax.swing.JLabel();
        btnUjSzla = new javax.swing.JButton();
        btnSztorno = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSzla = new JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        btnFrissit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        pnlLogin = new javax.swing.JPanel();
        txtFelhaszNev = new javax.swing.JTextField();
        lbFelhaszNev = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        lbPass = new javax.swing.JLabel();
        btnBejelentkez = new javax.swing.JButton();
        btnKijelentkez = new javax.swing.JButton();
        txtLoginInfo = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        cbbSzKor = new javax.swing.JComboBox();
        btnUjKiallito = new javax.swing.JButton();
        ccbSzlaFajta = new javax.swing.JComboBox();
        ccbPartner = new javax.swing.JComboBox();
        ccbDatumRend = new javax.swing.JComboBox();
        lbSzlaRend = new javax.swing.JLabel();
        lbSzures = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFalj = new javax.swing.JMenu(); //Fájl
        miUjSzamla = new JMenuItem("Új számla");
        menuFalj.add(miUjSzamla);
        //new javax.swing.JToolBar.Separator()

        miUjSzamla.setActionCommand("miUjSzamla");
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miKilepes = new javax.swing.JMenuItem();
        jMenu2 = //Szerkesztés
        new javax.swing.JMenu();
        JMenuItem szerk1 = new JMenuItem("Szerkesztés_1");
        jMenu2.add(szerk1);
        JMenuItem szerk2 = new JMenuItem("Szerkesztés_2");
        jMenu2.add(szerk2);
        jMenu3 = //Beállítások
        new javax.swing.JMenu();
        JMenuItem testreszabas = new JMenuItem("Testreszabás");
        jMenu3.add(testreszabas);
        jMenu4 = new javax.swing.JMenu()
        ;
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Invoice 1.5");
        setBounds((int) (((kijelzoMeret.width / 2) - 500)),
                (int) ((kijelzoMeret.height / 2) - 360), 1000, 700);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        setIconImage(new helper().createImageIcon(defIconPath).getImage());
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(1000, 700));
        setResizable(false);

        pnlInfoBar.setBackground(new java.awt.Color(204, 204, 204));
        pnlInfoBar.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Info Bar"));
        pnlInfoBar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pnlInfoBar.setMaximumSize(new java.awt.Dimension(32767, 40));
        pnlInfoBar.setMinimumSize(new java.awt.Dimension(0, 40));
        pnlInfoBar.setPreferredSize(new java.awt.Dimension(1000, 40));
        pnlInfoBar.setRequestFocusEnabled(false);

        lbInfoBar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbInfoBar.setForeground(new java.awt.Color(204, 0, 0));
        lbInfoBar.setText("Kérem válassza ki a hozzáférési szintjét és ennek megfelelően jelentkezzen be!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(pnlInfoBar);
        pnlInfoBar.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbInfoBar)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbInfoBar)
                                .addGap(0, 33, Short.MAX_VALUE))
        );

        btnUjSzla.setBackground(new java.awt.Color(204, 255, 204));
        btnUjSzla.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUjSzla.setForeground(new java.awt.Color(0, 0, 204));
        btnUjSzla.setText("Új számla");
        btnUjSzla.setMaximumSize(new java.awt.Dimension(120, 44));
        btnUjSzla.setMinimumSize(new java.awt.Dimension(120, 44));
        btnUjSzla.setPreferredSize(new java.awt.Dimension(120, 44));
        btnUjSzla.setActionCommand("btnUjSzla");

        btnSztorno.setBackground(new java.awt.Color(204, 255, 204));
        btnSztorno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSztorno.setForeground(new java.awt.Color(0, 0, 204));
        btnSztorno.setText("Sztornózás");
        btnSztorno.setActionCommand("btnSztorno");

        tbSzla.setAutoCreateRowSorter(true);
        tbSzla.setBackground(new java.awt.Color(204, 255, 255));
        tbSzla.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbSzla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String[]{
                        "Számlaszám", "Partner", "Kelt", "Fizetési határidő", "Nettó összeg", "Bruttó összeg"
                }
        ));
        tbSzla.setColumnSelectionAllowed(true);
        tbSzla.setGridColor(new java.awt.Color(0, 0, 0));
        tbSzla.setMaximumSize(new java.awt.Dimension(900, 700));
        tbSzla.setMinimumSize(new java.awt.Dimension(900, 700));
        tbSzla.setPreferredSize(new java.awt.Dimension(900, 1000));
        jScrollPane1.setViewportView(tbSzla);

        btnFrissit.setBackground(new java.awt.Color(204, 255, 204));
        btnFrissit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFrissit.setForeground(new java.awt.Color(0, 153, 0));
        btnFrissit.setText("Frissítés");
        btnFrissit.setActionCommand("btnFrissit");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new helper().createImageIcon(defCompLogoPath)); // NOI18N
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jSeparator2.setMaximumSize(new java.awt.Dimension(900, 700));
        jSeparator2.setMinimumSize(new java.awt.Dimension(900, 700));
        jSeparator2.setPreferredSize(new java.awt.Dimension(900, 2));

        pnlLogin.setBackground(new java.awt.Color(204, 204, 204));
        pnlLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbFelhaszNev.setText("Felhasználónév:");

        txtFelhaszNev.setBackground(new java.awt.Color(204, 255, 255));
        txtFelhaszNev.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbPass.setText("Jelszó:");

        txtPass.setBackground(new java.awt.Color(204, 255, 255));
        txtPass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        btnBejelentkez.setBackground(new java.awt.Color(204, 255, 204));
        btnBejelentkez.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBejelentkez.setForeground(new java.awt.Color(0, 0, 204));
        btnBejelentkez.setText("Bejelentkezés");

        btnKijelentkez.setBackground(new java.awt.Color(204, 255, 204));
        btnKijelentkez.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnKijelentkez.setForeground(new java.awt.Color(0, 0, 204));
        btnKijelentkez.setText("Kijelentkezés");
        btnKijelentkez.setEnabled(false);

        txtLoginInfo.setEditable(false);
        txtLoginInfo.setBackground(new java.awt.Color(204, 255, 51));
        txtLoginInfo.setFont(new java.awt.Font("Verdana", 1, 9)); // NOI18N
        txtLoginInfo.setForeground(new java.awt.Color(204, 0, 0));
        txtLoginInfo.setText("Ön még nem jelentkezett be!");
        txtLoginInfo.setMaximumSize(new java.awt.Dimension(300, 24));
        txtLoginInfo.setMinimumSize(new java.awt.Dimension(300, 24));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtLoginInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lbFelhaszNev)
                                                        .addComponent(lbPass))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(txtFelhaszNev, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(btnBejelentkez)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btnKijelentkez))
                                                        .addComponent(txtPass))))
                                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBejelentkez, btnKijelentkez});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{txtPass, txtFelhaszNev});

        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtFelhaszNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbFelhaszNev))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbPass))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnBejelentkez, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnKijelentkez))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLoginInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBejelentkez, btnKijelentkez});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{txtPass, txtFelhaszNev, txtLoginInfo});

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 40));

        cbbSzKor.setBackground(new java.awt.Color(204, 255, 204));
        cbbSzKor.setForeground(new java.awt.Color(0, 0, 204));
        cbbSzKor.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Hozzáférési szint kiválasztása...", "Könyvelő", "Számlázó"}));
        cbbSzKor.setMaximumSize(new java.awt.Dimension(280, 30));
        cbbSzKor.setMinimumSize(new java.awt.Dimension(280, 30));
        cbbSzKor.setPreferredSize(new java.awt.Dimension(280, 30));
        cbbSzKor.setActionCommand("cbbSzKor");

        btnUjKiallito.setBackground(new java.awt.Color(204, 255, 204));
        btnUjKiallito.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        btnUjKiallito.setForeground(new java.awt.Color(0, 0, 204));
        btnUjKiallito.setText("Új kiállító felvétele");
        btnUjKiallito.setMaximumSize(new java.awt.Dimension(300, 23));
        btnUjKiallito.setMinimumSize(new java.awt.Dimension(300, 23));
        btnUjKiallito.setPreferredSize(new java.awt.Dimension(300, 23));
        btnUjKiallito.setActionCommand("btnUjKiallito");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbbSzKor, 0, 220, Short.MAX_VALUE)
                                        .addComponent(btnUjKiallito, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUjKiallito, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(cbbSzKor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{btnUjKiallito, cbbSzKor});

        ccbSzlaFajta.setBackground(new java.awt.Color(204, 255, 204));
        ccbSzlaFajta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ccbSzlaFajta.setForeground(new java.awt.Color(0, 0, 204));
        ccbSzlaFajta.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Fajta szerint", "Számla", "Sztornó - számla"}));

        ccbPartner.setBackground(new java.awt.Color(204, 255, 204));
        ccbPartner.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ccbPartner.setForeground(new java.awt.Color(0, 0, 204));
        ccbPartner.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Partner kiválasztása"}));

        ccbDatumRend.setBackground(new java.awt.Color(204, 255, 204));
        ccbDatumRend.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ccbDatumRend.setForeground(new java.awt.Color(0, 0, 204));
        ccbDatumRend.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Dátum szerint  csökkenő", "Dátum szerint növekvő"}));
        ccbDatumRend.setActionCommand("ccbDatumRend");

        lbSzlaRend.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbSzlaRend.setText("Számlák rendezése:");

        lbSzures.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbSzures.setText("Szűrés:");

        menuFalj.setText("Fájl");
        menuFalj.add(jSeparator1);

        miKilepes.setText("Kilépés");
        miKilepes.setActionCommand("miKilepes");
        menuFalj.add(miKilepes);

        jMenuBar1.add(menuFalj);

        jMenu2.setText("Szerkesztés");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Beállítások");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Súgó");

        jMenuItem2.setText("Help");
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        jMenuBar1.add(Box.createHorizontalGlue());
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(pnlInfoBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbSzlaRend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ccbDatumRend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(lbSzures)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ccbSzlaFajta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ccbPartner, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnFrissit, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUjSzla, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSztorno)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnUjSzla, btnSztorno});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFrissit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ccbSzlaFajta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ccbPartner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ccbDatumRend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSzlaRend)
                    .addComponent(lbSzures))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUjSzla, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSztorno, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlInfoBar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        getAccessibleContext().setAccessibleDescription("Main Window");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
        initComponents();
    }

    public void showWindow() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }

    public void addLoginListener(ActionListener lll) {
        btnBejelentkez.addActionListener(lll);
    }

    public void addBtnListener(ActionListener btnListener) {
        btnUjSzla.addActionListener(btnListener);
        btnFrissit.addActionListener(btnListener);
        btnUjKiallito.addActionListener(btnListener);
        miKilepes.addActionListener(btnListener);
        miUjSzamla.addActionListener(btnListener);
    }

    public void showKilepesPromt() {
        int selectedOption = JOptionPane.showConfirmDialog(null, "Biztos hogy ki akarsz lépni?", "Kilépés", JOptionPane.YES_NO_OPTION);
        if (selectedOption == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void showWarningDialog(String message) {
        mainInfoDialog.showMessageDialog(null, message, "Invoice", JOptionPane.WARNING_MESSAGE);
    }

    public void showInfoDialog(String message) {
        mainInfoDialog.showMessageDialog(null, message, "Invoice", JOptionPane.INFORMATION_MESSAGE);
    }

    public String getLoginName() {
        return txtFelhaszNev.getText();
    }

    public String getLoginPass() {
        return txtPass.getText();
    }

    public void applyRole(String role) {
        switch (role) {
            case "KONYVELO":
                btnUjKiallito.setEnabled(false);
                btnBejelentkez.setEnabled(false);
                btnUjSzla.setEnabled(false);
                break;
            case "SZAMLAZO":
                break;
            case "ADMINISZTRATOR":
                showInfoDialog("Felhasználó kezelésre a Webes felületen van lehetőség.");
                break;
        }
    }

    public boolean isRootCheckingEnabled() {
        return this.rootPaneCheckingEnabled;
    }

    public void setTxtLoginInfo(String info) {
        txtLoginInfo.setText(info);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBejelentkez;
    private javax.swing.JButton btnKijelentkez;
    private javax.swing.JButton btnUjSzla;
    private javax.swing.JButton btnSztorno;
    private javax.swing.JButton btnUjKiallito;
    private javax.swing.JButton btnFrissit;
    private javax.swing.JComboBox cbbSzKor;
    private javax.swing.JComboBox ccbSzlaFajta;
    private javax.swing.JComboBox ccbPartner;
    private javax.swing.JComboBox ccbDatumRend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbFelhaszNev;
    private javax.swing.JLabel lbPass;
    private javax.swing.JLabel lbSzures;
    private javax.swing.JLabel lbSzlaRend;
    private javax.swing.JLabel lbInfoBar;
    private javax.swing.JMenu menuFalj;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem miKilepes;
    private javax.swing.JPanel pnlInfoBar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tbSzla;
    private javax.swing.JTextField txtFelhaszNev;
    private javax.swing.JTextField txtLoginInfo;
    // End of variables declaration//GEN-END:variables
    private JOptionPane mainInfoDialog;
    private JMenuItem miUjSzamla;
}
