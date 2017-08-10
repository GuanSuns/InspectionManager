package org.lin.monitor.manager.parser.connector.database;

import org.jdom.Element;
import org.lin.monitor.manager.config.ConnectorParserConfig;
import org.lin.monitor.manager.parser.connector.HostConfig;
import org.lin.monitor.manager.parser.utils.ParserUtils;
import org.suns.host.config.AppCluster;
import org.suns.host.config.AppHost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractInnerDBInspectionConfigParser {

    protected HashMap<String, AppCluster> clusterNameMap = null;
    protected ArrayList<AppCluster> clusters = null;
    protected abstract Element getRootElement() throws Exception;

    public AppCluster getClusterByName(String clusterName) throws Exception{
        if(clusterNameMap == null || clusters == null){
            initClusterNameHostsInfo();
        }

        if(!clusterNameMap.containsKey(clusterName)){
            return null;
        }else {
            return clusterNameMap.get(clusterName);
        }
    }

    public ArrayList<AppCluster> getClustersList() {
        return clusters;
    }

    protected void initClusterNameHostsInfo() throws Exception{
        clusters = new ArrayList<>();
        clusterNameMap = new HashMap<>();

        Element rootElem = getRootElement();

        List clustersElems = rootElem.getChildren(ConnectorParserConfig.getDatabaseClusterTag());
        if(clustersElems == null || clustersElems.isEmpty()){
            throw new Exception("Unexpected Excel Format: Missing "
                    + ConnectorParserConfig.getDatabaseClusterTag() + "elements");
        }

        for (Iterator it = clustersElems.iterator(); it.hasNext();) {
            Element clusterElem = (Element)it.next();

            AppCluster cluster = new AppCluster();

            String name = ParserUtils.getStringFromAttr(clusterElem
                    , ConnectorParserConfig.getNameAttr());
            String printedName = ParserUtils.getStringFromAttr(clusterElem
                    , ConnectorParserConfig.getPrintedNameAttr());

            cluster.setName(name);
            cluster.setPrintedName(printedName);
            cluster.setHosts(getClusterHosts(clusterElem));

            clusters.add(cluster);
            clusterNameMap.put(cluster.getName(), cluster);
        }
    }

    private ArrayList<AppHost> getClusterHosts(Element clusterElem) throws Exception{
        List clusterHostsElems = clusterElem.getChildren(ConnectorParserConfig.getHostTag());
        if(clusterHostsElems == null || clusterHostsElems.isEmpty()){
            throw new Exception("Unexpected XML Format: empty Hosts cluster element");
        }

        return copyHostsFromElemList(clusterHostsElems);
    }

    protected ArrayList<AppHost> copyHostsFromElemList(List hostDBElems)
            throws Exception{
        ArrayList<AppHost> hosts = new ArrayList<AppHost>();
        for (Iterator it = hostDBElems.iterator(); it.hasNext();) {
            Element hostElem = (Element)it.next();
            HostConfig host = new HostConfig();
            host.copyDbHostFromElement(hostElem);

            InnerOSInspectionHost innerOSInspectionHost
                    = new InnerOSInspectionHost(hostElem);
            host.setInspectionHost(innerOSInspectionHost.getOSInspectionHost());

            hosts.add(host.toAppHost());
        }
        return hosts;
    }

    public class InnerOSInspectionHost {
        private Element inspectDBOSElem;

        InnerOSInspectionHost(Element hostElem) throws Exception{
            if(hostElem == null){
                throw new Exception("Uninitialized argument hostElem");
            }

            inspectDBOSElem = hostElem.getChild(ConnectorParserConfig
                    .getInspectionOSHostTag());
            if(inspectDBOSElem == null){
                throw new Exception("Unexpected XML Config file format: missing OSInspection element");
            }
        }

        AppHost getOSInspectionHost() throws Exception{
            HostConfig hostConfig = new HostConfig();
            hostConfig.copyDbOSHostFromElement(inspectDBOSElem);
            return hostConfig.toAppHost();
        }
    }
}
