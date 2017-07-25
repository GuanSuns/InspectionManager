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
public class InnerCoreDatabaseConfigParser extends AbstractInnerDBInspectionConfigParser{
    private Element databaseInspectionElem;
    private Element coreElem;

    public InnerCoreDatabaseConfigParser(Element databaseInspectionElem) {
        this.databaseInspectionElem = databaseInspectionElem;
        this.coreElem = null;
    }

    public InnerCoreDatabaseConfigParser() {
        this.databaseInspectionElem = null;
        this.coreElem = null;
    }

    private void init() throws Exception{
        if(databaseInspectionElem == null){
            throw new Exception("Uninitialized databaseInspection Elem");
        }

        coreElem = databaseInspectionElem.getChild(ConnectorParserConfig.getDbInspectionCoreDatabaseTag());
        if(coreElem == null){
            throw new Exception("Unexpected XML Config file format: missing CoreDatabase element");
        }
    }

    public ArrayList<HostConfig> getTaxationHosts() throws Exception{
        if(coreElem == null){
            init();
        }
        return copyHostsFromElemList(getDBHostsList(coreElem
                , ConnectorParserConfig.getDbInspectionCoreTaxationHostsTag()));
    }

    public ArrayList<HostConfig> getTaxationOSInspectionHosts() throws Exception{
        if(coreElem == null){
            init();
        }
        List dbHostList = getDBHostsList(coreElem
                , ConnectorParserConfig.getDbInspectionCoreTaxationHostsTag());
        return getOSInspectionHosts(dbHostList);
    }

    public ArrayList<HostConfig> getIntegrationHosts() throws Exception{
        if(coreElem == null){
            init();
        }
        return copyHostsFromElemList(getDBHostsList(coreElem
                , ConnectorParserConfig.getDbInspectionCoreIntegrationHostsTag()));
    }

    public ArrayList<HostConfig> getIntegrationOSInspectionHosts() throws Exception{
        if(coreElem == null){
            init();
        }
        List dbHostList = getDBHostsList(coreElem
                , ConnectorParserConfig.getDbInspectionCoreIntegrationHostsTag());
        return getOSInspectionHosts(dbHostList);
    }

    public ArrayList<HostConfig> getQueryHosts() throws Exception{
        if(coreElem == null){
            init();
        }
        return copyHostsFromElemList(getDBHostsList(coreElem
                , ConnectorParserConfig.getDbInspectionCoreQueryHostsTag()));
    }

    public ArrayList<HostConfig> getQueryOSInspectionHosts() throws Exception{
        if(coreElem == null){
            init();
        }
        List dbHostList = getDBHostsList(coreElem
                , ConnectorParserConfig.getDbInspectionCoreQueryHostsTag());
        return getOSInspectionHosts(dbHostList);
    }
}
