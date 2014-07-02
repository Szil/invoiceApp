package controller;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.dbplatform.MySqlPlatform;
import model.*;

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
        mysqlDb.setUrl("jdbc:mysql://sidhean.noip.me:3306/newInvoice");
        mysqlDb.setHeartbeatSql("select 1");
        config.setDatabasePlatform(new MySqlPlatform());

        // automatically determine the DatabasePlatform
        // using the jdbc driver
        config.setDataSourceConfig(mysqlDb);

        // set dll config
        // set true to generate all table
        config.setDdlGenerate(false);
        config.setDdlRun(false);

        config.setDefaultServer(true);
        config.setRegister(false);


        // specify the entity classes (and listeners etc)
        // ... if these are not specified Ebean will search
        // ... the classpath looking for entity classes.
        config.addClass(User.class);
        config.addClass(Organisation.class);
        config.addClass(Invoice.class);
        config.addClass(Partner.class);
        config.addClass(Product.class);
        config.addClass(Products.class);
        config.addClass(Currency.class);


// create the EbeanServer instance

    }

    public EbeanServer getEbeanServer() {
        return server = EbeanServerFactory.create(config);
    }
}
