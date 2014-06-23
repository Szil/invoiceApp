package controller;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.MySqlPlatform;
import model.user;

/**
 * Created by Gergo on 2014.06.22..
 */
public class EbeanConf {

    private ServerConfig config = new ServerConfig();
    private DataSourceConfig mysqlDb = new DataSourceConfig();
    private EbeanServer server;

    public EbeanConf() {
        // specify the config
        config.setName("mysql");

        // Define DataSource parameters
        mysqlDb.setDriver("com.mysql.jdbc.Driver");
        mysqlDb.setUsername("root");
        mysqlDb.setPassword("root");
        mysqlDb.setUrl("jdbc:mysql://127.0.0.1:3306/newInvoice");
        mysqlDb.setHeartbeatSql("select 1");
        config.setDatabasePlatform(new MySqlPlatform());

        // automatically determine the DatabasePlatform
        // using the jdbc driver
        config.setDataSourceConfig(mysqlDb);

        // set dll config
        config.setDdlGenerate(true);
        config.setDdlRun(false);

        config.setDefaultServer(true);
        config.setRegister(false);


        // specify the entity classes (and listeners etc)
        // ... if these are not specified Ebean will search
        // ... the classpath looking for entity classes.
        config.addClass(user.class);


// create the EbeanServer instance

    }

    public EbeanServer getEbeanServer() {
        return server = EbeanServerFactory.create(config);
    }
}
