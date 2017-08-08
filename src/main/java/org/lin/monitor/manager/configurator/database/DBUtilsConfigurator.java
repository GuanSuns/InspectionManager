package org.lin.monitor.manager.configurator.database;

import org.lin.monitor.manager.parser.database.LocalDatabaseConfigParser;
import org.suns.database.utils.config.DBConfig;
import org.suns.database.utils.config.DBType;

public class DBUtilsConfigurator {
    private LocalDatabaseConfigParser databaseConfigParser;

    public DBUtilsConfigurator() throws Exception{
        this.databaseConfigParser = new LocalDatabaseConfigParser();
    }

    public void configure() throws Exception {
        if (databaseConfigParser == null) {
            throw new Exception("Uninitialized database config parser");
        }

        String driver = databaseConfigParser.getDriver();
        DBConfig.setDriver(driver);

        String dbURL = databaseConfigParser.getUrl();
        DBConfig.setUrl(dbURL);

        String username = databaseConfigParser.getUserName();
        DBConfig.setName(username);

        String password = databaseConfigParser.getPassword();
        DBConfig.setPassword(password);

        int defaultNullValue = databaseConfigParser.getDefaultNullValue();
        DBConfig.setDefaultNumericNullValue(defaultNullValue);

        DBType dbType = databaseConfigParser.getDbType();
        switch (dbType){
            case mySQL:
                DBConfig.setDbType(DBType.mySQL);
                DBConfig.setConfigToMySQL();
                break;
            case oracle:
                DBConfig.setDbType(DBType.oracle);
                DBConfig.setConfigToOracle();
                break;
            default:
                break;
        }
    }
}
