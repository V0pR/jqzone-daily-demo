package com.core.factory;

import com.google.common.collect.Lists;
import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.annotation.Platform;
import io.ebean.config.CurrentUserProvider;
import io.ebean.config.DbMigrationConfig;
import io.ebean.config.JsonConfig;
import io.ebean.config.ServerConfig;
import io.ebean.spring.txn.SpringJdbcTransactionManager;
import org.bouncycastle.util.Strings;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.ZoneId;


/**
 * Spring factory for creating the EbeanServer singleton.
 */
@Component
public class EbeanFactoryBean implements FactoryBean<EbeanServer> {

    @Value("${ebean.db.ddl.generate}")
    private Boolean ddlGenerate;

    @Value("${ebean.db.ddl.run}")
    private Boolean ddlRun;

    @Value("${ebean.db.search.packages}")
    private String searchPackages;

    @Value("${ebean.migration.run}")
    private Boolean migrationRun;


    @Autowired
    private DataSource dataSource;

    @Autowired
    private CurrentUserProvider currentUserProvider;

    @Override
    public EbeanServer getObject() {

        ServerConfig config = new ServerConfig();

        config.loadFromProperties();

        config.setName("db");
        config.setCurrentUserProvider(currentUserProvider);

        config.setDataTimeZone(ZoneId.systemDefault().getId());
        config.setJsonDate(JsonConfig.Date.MILLIS);
        config.setJsonDateTime(JsonConfig.DateTime.MILLIS);

//        // set the spring's datasource and transaction manager.
        config.setExternalTransactionManager(new SpringJdbcTransactionManager());

        config.setDdlGenerate(ddlGenerate);
        config.setDdlRun(ddlRun);
        config.setPackages(Lists.newArrayList(Strings.split(searchPackages, ',')));

        //set datasource
        config.setDataSource(dataSource);

        //set migrationConfig
        DbMigrationConfig dbMigrationConfig = new DbMigrationConfig();
        dbMigrationConfig.setRunMigration(migrationRun);
        dbMigrationConfig.setPlatform(Platform.MYSQL);
        dbMigrationConfig.setPatchResetChecksumOn("5.66,7.2,7.36,7.31,7.32,7.42,7.46,7.59,7.57,7.59,7.58,7.61,7.62,7.63");
        config.setMigrationConfig(dbMigrationConfig);

        // set as default and register so that Model can be
        // used if desired for save() and update() etc
        config.setDefaultServer(true);
        config.setRegister(true);
        config.setDocStoreOnly(false);

        return EbeanServerFactory.create(config);
    }

    @Override
    public Class<?> getObjectType() {
        return EbeanServer.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
