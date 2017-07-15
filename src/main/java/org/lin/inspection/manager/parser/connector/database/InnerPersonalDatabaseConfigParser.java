package org.lin.inspection.manager.parser.connector.database;

import org.jdom.Element;
import org.lin.inspection.manager.config.ConnectorParserConfig;
import org.lin.inspection.manager.parser.connector.HostConfig;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

        personalElem = databaseInspectionElem.getChild(ConnectorParserConfig.getDbInspectionPersonalDatabaseTag());
        if(personalElem == null){
            throw new Exception("Unexpected XML Config file format: missing PersonalDatabase element");
        }
    }

    public ArrayList<HostConfig> getCoreHosts() throws Exception{
        if(personalElem == null){
            init();
        }

        Element coreHostsElem = personalElem.getChild(ConnectorParserConfig.getDbInspectionPersonalCoreDatabaseTag());
        if(coreHostsElem == null){
            throw new Exception("Unexpected XML Config file format: missing personal Core Hosts element");
        }

        List coreHosts = coreHostsElem.getChildren(ConnectorParserConfig.getHostTag());
        if(coreHosts == null || coreHosts.isEmpty()){
            throw new Exception("Unexpected XML Config file format: empty personal Core Hosts");
        }

        ArrayList<HostConfig> hosts = new ArrayList<HostConfig>();
        for (Iterator it = coreHosts.iterator(); it.hasNext();) {
            Element hostElem = (Element)it.next();
            HostConfig host = new HostConfig();
            host.copyFromElement(hostElem);
            hosts.add(host);
        }
        return hosts;
    }
}
