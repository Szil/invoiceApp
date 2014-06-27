//2014-05-04
package view;

import javax.swing.*;
import java.awt.*;

/*
 * @author User
 */
public interface InvoiceInterface {

    public Toolkit toolkit = Toolkit.getDefaultToolkit();
    public Dimension kijelzoMeret = toolkit.getScreenSize();
    public JFrame mainFrame = new JFrame();
    public String verzio = "1.666";
    public JOptionPane dialogusAblak = new JOptionPane();
    public String defIconPath = "/assets/invoice_ico.png";
    public String defCompLogoPath = "/assets/InvoiceDefaultCompanyLogo_190_116px.png";
}
