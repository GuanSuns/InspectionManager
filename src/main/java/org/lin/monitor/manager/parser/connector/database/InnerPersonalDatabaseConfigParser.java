package org.lin.monitor.manager.parser.connector.database;

import org.jdom.Element;
import org.lin.monitor.manager.config.ConnectorParserConfig;
import org.lin.monitor.manager.parser.connector.HostConfig;

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

    public InnerPersonalDatabaseConfigParser() {
        this.databaseInspectionElem = null;
        this.personalElem = null;
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

    private List getCoreHostsList() throws Exception{
        if(personalElem == null){
            init();
        }
        return getDBHostsList(personalElem, ConnectorParserConfig.getDbInspectionPersonalCoreDatabaseTag());
    }

    public ArrayList<HostConfig> getCoreHosts() throws Exception{
        List coreHosts = getCoreHostsList();
        return copyHostsFromElemList(coreHosts);
    }

    public ArrayList<HostConfig> getCoreOSInspectionHosts() throws Exception{
        List coreHosts = getCoreHostsList();
        return getOSInspectionHosts(coreHosts);
    }
}
