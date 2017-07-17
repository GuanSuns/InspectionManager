package org.lin.inspection.manager.parser.connector.database;

import org.jdom.Element;
import org.lin.inspection.manager.config.ConnectorParserConfig;

/**
 * Created by guanl on 7/15/2017.
 */
public class InnerDatabaseInspectionConfigParser {
    private Element rootElem;
    private Element databaseInspectionRootElem;
    private InnerCoreDatabaseConfigParser coreDatabaseInspectionParser;
    private InnerPersonalDatabaseConfigParser personalDatabaseInspectionParser;

    public InnerDatabaseInspectionConfigParser(Element rootElem) {
        this.rootElem = rootElem;
        this.databaseInspectionRootElem = null;
        this.personalDatabaseInspectionParser = null;
    }

    public InnerDatabaseInspectionConfigParser() {
        this.rootElem = null;
        this.databaseInspectionRootElem = null;
        this.personalDatabaseInspectionParser = null;
        this.coreDatabaseInspectionParser = null;
    }

    private void initConnectorConfigRoot() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        databaseInspectionRootElem = rootElem
                .getChild(ConnectorParserConfig.getDatabaseInspectionConfigRootTag());

        if(databaseInspectionRootElem == null){
            throw new Exception("Unexpected XML Config file format: missing database inspection element");
        }
    }

    public InnerPersonalDatabaseConfigParser getPersonal() throws Exception{
        if(personalDatabaseInspectionParser != null){
            return personalDatabaseInspectionParser;
        }

        if(databaseInspectionRootElem == null){
            initConnectorConfigRoot();
        }

        personalDatabaseInspectionParser = new InnerPersonalDatabaseConfigParser(databaseInspectionRootElem);
        return personalDatabaseInspectionParser;
    }

    public InnerCoreDatabaseConfigParser getCore() throws Exception{
        if(coreDatabaseInspectionParser != null){
            return coreDatabaseInspectionParser;
        }

        if(databaseInspectionRootElem == null){
            initConnectorConfigRoot();
        }

        coreDatabaseInspectionParser = new InnerCoreDatabaseConfigParser(databaseInspectionRootElem);
        return coreDatabaseInspectionParser;
    }
}
