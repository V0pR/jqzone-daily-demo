package com.core.migration;

import io.ebean.annotation.Platform;
import io.ebean.dbmigration.DbMigration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * Generate the DB Migration.
 * <p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("default")
public class GenerateDbMigration {

    @Test
    public void dbMigration() throws IOException {

        DbMigration dbMigration = DbMigration.create();
        dbMigration.setPlatform(Platform.MYSQL);
        dbMigration.setVersion("1.01");
        dbMigration.setName("20200318");
        dbMigration.setStrictMode(true);
        dbMigration.generateMigration();
    }
}
