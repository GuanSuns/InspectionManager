package org.lin.inspection.manager.parser.connector.database;

import org.jdom.Element;
import org.lin.inspection.manager.config.ConnectorParserConfig;

/**
 * Created by guanl on 7/15/2017.
 */
public class InnerDatabaseInspectionConfigParser {
    private Element rootElem;
    private Element databaseInspectionRootElem;

    public InnerDatabaseInspectionConfigParser(Element rootElem) {
        this.rootElem = rootElem;
        this.databaseInspectionRootElem = null;
    }

    public InnerDatabaseInspectionConfigParser() {
        this.rootElem = null;
        this.databaseInspectionRootElem = null;
    }

    private void initConnectorConfigRoot() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        databaseInspectionRootElem = rootElem
                .getChild(ConnectorParserConfig.getDatabaseInspectionfigRootTag());

        if(databaseInspectionRootElem == null){
            throw new Exception("Unexpected XML Config file format: missing database inspection element");
        }
    }
}
