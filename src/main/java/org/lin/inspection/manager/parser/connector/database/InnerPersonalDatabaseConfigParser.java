package org.lin.inspection.manager.parser.connector.database;

import org.jdom.Element;
import org.lin.inspection.manager.config.ConnectorParserConfig;

/**
 * Created by guanl on 7/15/2017.
 */
public class InnerPersonalDatabaseConfigParser {
    private Element databaseInspectionElem;
    private Element personalElem;

    public InnerPersonalDatabaseConfigParser(Element databaseInspectionElem) {
        this.databaseInspectionElem = databaseInspectionElem;
        this.personalElem = null;
    }

    public InnerPersonalDatabaseConfigParser() {
        this.databaseInspectionElem = null;
        this.personalElem = null;
    }

    private void init() throws Exception{
        if(databaseInspectionElem == null){
            init();
        }

        personalElem = databaseInspectionElem.getChild(ConnectorParserConfig.getPersonalDatabaseTag());
        if(personalElem == null){
            throw new Exception("Unexpected XML Config file format: missing PersonalDatabase element");
        }
    }
}
