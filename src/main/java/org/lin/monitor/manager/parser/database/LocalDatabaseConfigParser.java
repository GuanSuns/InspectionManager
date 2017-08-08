package org.lin.monitor.manager.parser.database;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.lin.monitor.manager.config.LocalDatabaseParserConfig;
import org.suns.database.utils.config.DBType;

public class LocalDatabaseConfigParser {
    private Document localDatabaseConfigDoc;
    private Element rootElem;

    public LocalDatabaseConfigParser() throws Exception{
        init();
    }

    private void init() throws Exception{
        SAXBuilder builder= new SAXBuilder();
        localDatabaseConfigDoc = builder.build(LocalDatabaseParserConfig.getRootDirectory()
                + LocalDatabaseParserConfig.getLocalDatabaseConfigXML());
        rootElem = localDatabaseConfigDoc.getRootElement();

        if(rootElem == null){
            throw new Exception("Unexpected XML Config file format: missing root element");
        }
    }

    public DBType getDbType() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        Element databaseTypeElem = rootElem.getChild(LocalDatabaseParserConfig.getDatabaseTypeTag());
        if(databaseTypeElem == null){
            throw new Exception("Unexpected XML Config file format: missing databaseType element");
        }

        String strDBType = databaseTypeElem.getText();

        if(strDBType.equals("mySQL")){
            return DBType.mySQL;
        }else if(strDBType.equals("oracle")){
            return DBType.oracle;
        }else{
            throw new Exception("Invalid database type " + strDBType);
        }
    }

    public String getDriver() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        Element driverElem = rootElem.getChild(LocalDatabaseParserConfig.getDriverTag());
        if(driverElem == null){
            throw new Exception("Unexpected XML Config file format: missing driver element");
        }

        return driverElem.getText();
    }

    public String getUrl() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        Element urlElem = rootElem.getChild(LocalDatabaseParserConfig.getUrlTag());
        if(urlElem == null){
            throw new Exception("Unexpected XML Config file format: missing url element");
        }

        return urlElem.getText();
    }

    public String getUserName() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        Element usernameElem = rootElem.getChild(LocalDatabaseParserConfig.getUsernameTag());
        if(usernameElem == null){
            throw new Exception("Unexpected XML Config file format: missing username element");
        }

        return usernameElem.getText();
    }
    
    public String getPassword() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        Element passwordElem = rootElem.getChild(LocalDatabaseParserConfig.getPasswordTag());
        if(passwordElem == null){
            throw new Exception("Unexpected XML Config file format: missing password element");
        }

        return passwordElem.getText();
    }

    public int getDefaultNullValue() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        Element defaultNullValueElem = rootElem.getChild(LocalDatabaseParserConfig.getDefaultNumericNullValueTag());
        if(defaultNullValueElem == null){
            throw new Exception("Unexpected XML Config file format: missing defaultNumericNullValue element");
        }

        return Integer.valueOf(defaultNullValueElem.getText());
    }
}
