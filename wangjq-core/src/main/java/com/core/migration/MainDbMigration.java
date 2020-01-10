package com.core.migration;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.annotation.Platform;
import io.ebean.dbmigration.DbMigration;

import java.io.IOException;

/**
 * Generate the DB Migration.
 * <p>
 * 生成Migration配置文件，根据model生成，生成文件请不要随意修改
 */
public class MainDbMigration {

    private EbeanServer ebeanServer = Ebean.getDefaultServer();

    public static void main(String[] args) {
        try {
            DbMigration dbMigration = DbMigration.create();
            dbMigration.setPlatform(Platform.MYSQL);
            dbMigration.setVersion("1.01");
            dbMigration.setName("20200106");
            dbMigration.setStrictMode(true);
            dbMigration.generateMigration();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
