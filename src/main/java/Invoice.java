import com.avaje.ebean.EbeanServer;
import controller.EbeanConf;
import controller.MainCtrl;
import view.MainWindow;

/**
 * Created by Gergo on 2014.06.23..
 */
public class Invoice {

    protected static EbeanConf ebeanConf = new EbeanConf();
    protected static EbeanServer model;
    protected static MainCtrl controller;
    protected static MainWindow view;

    public static void main(String[] args) {
        model = ebeanConf.getEbeanServer();
        view = new MainWindow();
        controller = new MainCtrl(model, view);
    }
}
