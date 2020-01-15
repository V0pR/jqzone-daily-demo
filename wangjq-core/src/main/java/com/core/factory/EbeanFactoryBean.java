package com.zqt.factory;

import com.google.common.collect.Lists;
import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.annotation.Platform;
import io.ebean.config.CurrentUserProvider;
import io.ebean.config.DbMigrationConfig;
import io.ebean.config.JsonConfig;
import io.ebean.config.ServerConfig;
import io.ebean.spring.txn.SpringJdbcTransactionManager;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("dataSource")
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

        config.setExternalTransactionManager(new SpringJdbcTransactionManager());

        config.setDdlGenerate(ddlGenerate);
        config.setDdlRun(ddlRun);
        config.setPackages(Lists.newArrayList(String.join(",", searchPackages)));

        config.setDataSource(dataSource);

        DbMigrationConfig dbMigrationConfig = new DbMigrationConfig();
        dbMigrationConfig.setRunMigration(migrationRun);
        dbMigrationConfig.setPlatform(Platform.MYSQL);
        //dbMigrationConfig.setPatchResetChecksumOn("5.66");
        config.setMigrationConfig(dbMigrationConfig);

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
