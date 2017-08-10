package org.lin.monitor.manager.parser.utils;


import org.jdom.Element;
import org.lin.monitor.manager.config.ConnectorParserConfig;
import org.lin.monitor.manager.config.DailyAppParserConfig;
import org.lin.monitor.manager.config.SchedulerConfig;
import org.lin.monitor.manager.parser.connector.HostConfig;
import org.lin.monitor.manager.utils.Pair;
import org.suns.host.config.AppCluster;
import org.suns.host.config.AppHost;
import org.suns.host.config.WebLogicServer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParserUtils {
    public static String getStringFromElement(Element rootElem
            , String tag) throws Exception{
        if(rootElem == null || tag == null || tag.equals("")){
            throw new Exception("Uninitialized argument");
        }

        Element childElem = rootElem.getChild(tag);
        if(childElem == null){
            throw new Exception("Unexpected XML Format: missing " + tag + " element");
        }

        return childElem.getText();
    }

    public static String getStringFromAttr(Element rootElem
            , String tag) throws Exception{
        if(rootElem == null || tag == null || tag.equals("")){
            throw new Exception("Uninitialized argument");
        }

        String result = rootElem.getAttributeValue(tag);
        if(result == null){
            throw new Exception("Unexpected XML Format: missing " + tag + " attribute");
        }

        return result;
    }

    public static int getIntFromElement(Element rootElem
            , String tag) throws Exception{
        if(rootElem == null || tag == null || tag.equals("")){
            throw new Exception("Uninitialized argument");
        }

        Element childElem = rootElem.getChild(tag);
        if(childElem == null){
            throw new Exception("Unexpected XML Format: missing " + tag + " element");
        }

        return Integer.valueOf(childElem.getText());
    }

    public static int getIntFromAttr(Element rootElem
            , String tag) throws Exception{
        if(rootElem == null || tag == null || tag.equals("")){
            throw new Exception("Uninitialized argument");
        }

        String result = rootElem.getAttributeValue(tag);
        if(result == null || result.equals("")){
            throw new Exception("Unexpected XML Format: missing " + tag + " attribute");
        }

        return Integer.valueOf(result);
    }

    public static ArrayList<Pair<Integer, Integer>> extractTimeArrayFromElem(Element rootElem
            , String tag) throws Exception{
        if(rootElem == null || tag == null || tag.equals("")){
            throw new Exception("Uninitialized argument");
        }

        List timeElems = rootElem.getChildren(tag);
        if(timeElems == null || timeElems.isEmpty()){
            throw new Exception("Unexpected XML Config file format: empty element");
        }

        ArrayList<Pair<Integer, Integer>> timePairs = new ArrayList<>();
        for (Iterator it = timeElems.iterator(); it.hasNext();) {
            Element timeElem = (Element)it.next();
            int hour = getIntFromAttr(timeElem, SchedulerConfig.getHourAttr());
            int minute = getIntFromAttr(timeElem, SchedulerConfig.getMinuteAttr());
            Pair<Integer, Integer> timePair = new Pair<>(hour,minute);
            timePairs.add(timePair);
        }
        return timePairs;
    }

    public static ArrayList<WebLogicServer> extractWebLogicServersFromRootElem(Element rootElem
            , String tag) throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized argument");
        }

        List webLogicServerElems = rootElem.getChildren(DailyAppParserConfig.getWebLogicServerTag());
        if(webLogicServerElems == null || webLogicServerElems.isEmpty()){
            throw new Exception("Unexpected XML Config file format: empty " + tag + " element");
        }

        ArrayList<WebLogicServer> webLogicServers = new ArrayList<>();
        for (Iterator it = webLogicServerElems.iterator(); it.hasNext();) {
            Element webLogicServerElem = (Element)it.next();
            WebLogicServer webLogicServer = new WebLogicServer();

            webLogicServer.setUser(getStringFromAttr(webLogicServerElem
                    , ConnectorParserConfig.getUserAttr()));
            webLogicServer.setPassword(getStringFromAttr(webLogicServerElem
                    , ConnectorParserConfig.getPasswordAttr()));
            webLogicServer.setIp(getStringFromAttr(webLogicServerElem
                    , ConnectorParserConfig.getIpAttr()));
            webLogicServer.setPort(getIntFromAttr(webLogicServerElem
                    , ConnectorParserConfig.getPortAttr()));

            extractClustersIntoWebLogicServer(webLogicServer, webLogicServerElem);
            webLogicServers.add(webLogicServer);
        }

        return webLogicServers;
    }

    public static void extractClustersIntoWebLogicServer(WebLogicServer webLogicServer
            , Element webLogicElem) throws Exception{
        if(webLogicElem == null){
            throw new Exception("Uninitialized argument");
        }

        List clusterElems = webLogicElem.getChildren(DailyAppParserConfig.getClusterTag());
        if(clusterElems == null || clusterElems.isEmpty()){
            throw new Exception("Unexpected XML Config file format: empty webLogicServer element");
        }

        ArrayList<AppCluster> clusters = new ArrayList<>();
        for (Iterator it = clusterElems.iterator(); it.hasNext();) {
            Element clusterElem = (Element)it.next();
            AppCluster cluster = new AppCluster();

            cluster.setName(getStringFromAttr(clusterElem
                    , ConnectorParserConfig.getNameAttr()));
            extractHostsIntoClusters(cluster, clusterElem);

            clusters.add(cluster);
        }
        webLogicServer.setClusters(clusters);
    }

    public static void extractHostsIntoClusters(AppCluster cluster
            , Element clusterElem) throws Exception{
        if(clusterElem == null){
            throw new Exception("Uninitialized argument");
        }

        List hostsElems = clusterElem.getChildren(ConnectorParserConfig.getHostTag());
        if(hostsElems == null || hostsElems.isEmpty()){
            throw new Exception("Unexpected XML Config file format: empty cluster element");
        }

        ArrayList<AppHost> hosts = new ArrayList<>();
        for (Iterator it = hostsElems.iterator(); it.hasNext();) {
            Element hostElem = (Element)it.next();
            AppHost host = new AppHost();

            HostConfig hostConfig = new HostConfig();
            hostConfig.copyFromElement(hostElem);

            host.setIp(hostConfig.getIp());
            host.setPassword(hostConfig.getPassword());
            host.setPort(hostConfig.getPort());
            host.setUser(hostConfig.getUser());

            List serverElems = hostElem.getChildren(ConnectorParserConfig.getServerTag());
            if(serverElems == null || serverElems.isEmpty()){
                throw new Exception("Unexpected XML Config file format: empty host element");
            }
            ArrayList<String> servers = new ArrayList<>();
            for (Iterator itServer = serverElems.iterator(); itServer.hasNext();) {
                Element serverElem = (Element) itServer.next();
                String server = getStringFromAttr(serverElem
                        , ConnectorParserConfig.getNameAttr());
                servers.add(server);
            }

            host.setServers(servers);
            hosts.add(host);
        }

        cluster.setHosts(hosts);
    }

    public static void copyDBHostInfoToArray(ArrayList<AppHost> appHosts
            , String[] hosts, String[] users
            , String[] passwords, int[] ports, String[] sids, int size){

        for(int i=0; i<size; i++){
            hosts[i] = appHosts.get(i).getIp();
            users[i] = appHosts.get(i).getUser();
            passwords[i] = appHosts.get(i).getPassword();
            ports[i] = appHosts.get(i).getPort();
            sids[i] = appHosts.get(i).getSid();
        }
    }

    public static void copyDBOSHostInfoToArray(ArrayList<AppHost> appHosts
            ,String[] hosts, String[] users, String[] passwords
            , int[] ports, String[] sids, String[] logs
            , String[] cpuScripts, String[] memoryScripts
            , String[] diskScripts, int size){

        copyDBHostInfoToArray(appHosts, hosts
                , users, passwords, ports, sids, size);

        for(int i=0; i<size; i++){
            logs[i] = appHosts.get(i).getLogPath();
            cpuScripts[i] = appHosts.get(i).getScriptCPUPath();
            memoryScripts[i] = appHosts.get(i).getScriptMemoryPath();
            diskScripts[i] = appHosts.get(i).getScriptDiskPath();
        }
    }
}
