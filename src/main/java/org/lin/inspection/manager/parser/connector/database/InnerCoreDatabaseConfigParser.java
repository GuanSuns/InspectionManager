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
public class InnerCoreDatabaseConfigParser {
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
            init();
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

        Element taxationHostsElem = coreElem.getChild(ConnectorParserConfig.getDbInspectionCoreTaxationHostsTag());
        if(taxationHostsElem == null){
            throw new Exception("Unexpected XML Config file format: missing core Taxation Hosts element");
        }

        List taxationHosts = taxationHostsElem.getChildren(ConnectorParserConfig.getHostTag());
        if(taxationHosts == null || taxationHosts.isEmpty()){
            throw new Exception("Unexpected XML Config file format: empty core Taxation Hosts");
        }

        ArrayList<HostConfig> hosts = new ArrayList<>();
        for (Iterator it = taxationHosts.iterator(); it.hasNext();) {
            Element hostElem = (Element)it.next();
            HostConfig host = new HostConfig();
            host.copyDbHostFromElement(hostElem);
            hosts.add(host);
        }
        return hosts;
    }

    public ArrayList<HostConfig> getIntegrationHosts() throws Exception{
        if(coreElem == null){
            init();
        }

        Element integrationHostsElem = coreElem.getChild(ConnectorParserConfig.getDbInspectionCoreIntegrationHostsTag());
        if(integrationHostsElem == null){
            throw new Exception("Unexpected XML Config file format: missing core Integration Hosts element");
        }

        List integrationHosts = integrationHostsElem.getChildren(ConnectorParserConfig.getHostTag());
        if(integrationHosts == null || integrationHosts.isEmpty()){
            throw new Exception("Unexpected XML Config file format: empty core Integration Hosts");
        }

        ArrayList<HostConfig> hosts = new ArrayList<>();
        for (Iterator it = integrationHosts.iterator(); it.hasNext();) {
            Element hostElem = (Element)it.next();
            HostConfig host = new HostConfig();
            host.copyDbHostFromElement(hostElem);
            hosts.add(host);
        }
        return hosts;
    }

    public ArrayList<HostConfig> getQueryHosts() throws Exception{
        if(coreElem == null){
            init();
        }

        Element queryHostsElem = coreElem.getChild(ConnectorParserConfig.getDbInspectionCoreQueryHostsTag());
        if(queryHostsElem == null){
            throw new Exception("Unexpected XML Config file format: missing core Query Hosts element");
        }

        List queryHosts = queryHostsElem.getChildren(ConnectorParserConfig.getHostTag());
        if(queryHosts == null || queryHosts.isEmpty()){
            throw new Exception("Unexpected XML Config file format: empty core Query Hosts");
        }

        ArrayList<HostConfig> hosts = new ArrayList<>();
        for (Iterator it = queryHosts.iterator(); it.hasNext();) {
            Element hostElem = (Element)it.next();
            HostConfig host = new HostConfig();
            host.copyDbHostFromElement(hostElem);
            hosts.add(host);
        }
        return hosts;
    }
}
