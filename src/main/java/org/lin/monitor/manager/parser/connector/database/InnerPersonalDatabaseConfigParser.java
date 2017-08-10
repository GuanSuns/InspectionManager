package org.lin.monitor.manager.parser.connector.database;

import org.jdom.Element;
import org.lin.monitor.manager.config.ConnectorParserConfig;
import org.lin.monitor.manager.parser.connector.HostConfig;
import org.suns.host.config.AppHost;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guanl on 7/15/2017.
 */
public class InnerPersonalDatabaseConfigParser extends AbstractInnerDBInspectionConfigParser{
    private Element databaseInspectionElem;
    private Element personalElem;

    public InnerPersonalDatabaseConfigParser(Element databaseInspectionElem) {
        this.databaseInspectionElem = databaseInspectionElem;
        this.personalElem = null;
    }

    @Override
    protected Element getRootElement() throws Exception {
        if(personalElem == null){
            init();
        }
        return personalElem;
    }

    private void init() throws Exception{
        if(databaseInspectionElem == null){
            throw new Exception("Uninitialized databaseInspection Elem");
        }

        personalElem = databaseInspectionElem.getChild(ConnectorParserConfig.getDbInspectionPersonalDatabaseTag());
        if(personalElem == null){
            throw new Exception("Unexpected XML Config file format: missing PersonalDatabase element");
        }
    }
}
