package org.lin.inspection.manager.parser.connector.database;

import org.jdom.Element;
import org.lin.inspection.manager.config.ConnectorParserConfig;
import org.lin.inspection.manager.parser.connector.HostConfig;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AbstractInnerDBInspectionConfigParser {
    protected ArrayList<HostConfig> copyHostsFromElemList(List hostDBElems)
            throws Exception{
        ArrayList<HostConfig> hosts = new ArrayList<HostConfig>();
        for (Iterator it = hostDBElems.iterator(); it.hasNext();) {
            Element hostElem = (Element)it.next();
            HostConfig host = new HostConfig();
            host.copyDbHostFromElement(hostElem);
            hosts.add(host);
        }
        return hosts;
    }

    protected ArrayList<HostConfig> getOSInspectionHosts(List hostsDBElems)
            throws Exception{
        ArrayList<HostConfig> hosts = new ArrayList<>();
        for (Iterator it = hostsDBElems.iterator(); it.hasNext();) {
            Element hostDBElem = (Element)it.next();
            InnerOSInspection innerOSInspection = new InnerOSInspection(hostDBElem);
            HostConfig host = innerOSInspection.getOSInspectionHost();
            hosts.add(host);
        }
        return hosts;
    }

    protected List getDBHostsList(Element rootElem, String tag) throws Exception{
        Element dbHostsElem = rootElem.getChild(tag);
        if(dbHostsElem == null){
            throw new Exception("Unexpected XML Config file format: missing " + tag + " element");
        }

        List coreHosts = dbHostsElem.getChildren(ConnectorParserConfig.getHostTag());
        if(coreHosts == null || coreHosts.isEmpty()){
            throw new Exception("Unexpected XML Config file format: empty Hosts List");
        }

        return coreHosts;
    }

    public class InnerOSInspection{
        private Element inspectOSElem;

        public InnerOSInspection(Element hostElem) throws Exception{
            if(hostElem == null){
                throw new Exception("Uninitialized argument hostElem");
            }

            inspectOSElem = hostElem.getChild(ConnectorParserConfig
                    .getInspectionOSHostTag());
            if(inspectOSElem == null){
                throw new Exception("Unexpected XML Config file format: missing OSInspection element");
            }
        }

        public HostConfig getOSInspectionHost() throws Exception{
            HostConfig hostConfig = new HostConfig();
            hostConfig.copyFromElement(inspectOSElem);
            return hostConfig;
        }
    }
}
