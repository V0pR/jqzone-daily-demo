package com.migration;

import io.ebean.EbeanServer;
import io.ebean.annotation.Platform;
import io.ebean.dbmigration.DbMigration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

/**
 * Generate the DB Migration.
 * <p>
 * 生成Migration配置文件，根据model生成，生成文件请不要随意修改
 */
@SpringBootTest
@ActiveProfiles("default")
public class MainDbMigration {

    @Autowired
    private EbeanServer ebeanServer;

    @Test
    public void generateMigration() throws IOException {

        // generate a migration using drops from a prior version
//        System.setProperty("ddl.migration.pendingDropsFor", "3.92");
        DbMigration dbMigration = DbMigration.create();
        dbMigration.setPlatform(Platform.MYSQL);
        // generate the migration ddl and xml
        // ... with EbeanServer in "offline" mode
        dbMigration.setVersion("1.01");
        dbMigration.setName("20200106");
        dbMigration.setStrictMode(true);
        dbMigration.generateMigration();
    }
}
