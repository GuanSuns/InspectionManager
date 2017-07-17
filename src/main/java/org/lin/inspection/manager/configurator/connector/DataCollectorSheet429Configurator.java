package org.lin.inspection.manager.configurator.connector;

import org.lin.inspection.manager.parser.connector.ConnectorParser;
import org.lin.inspection.manager.parser.connector.HostConfig;
import org.suns.data.collector.config.sheet429.Sheet429CoreConfig;
import org.suns.data.collector.config.sheet429.Sheet429PersonalConfig;

import java.util.ArrayList;

/**
 * Created by guanl on 7/17/2017.
 */
public class DataCollectorSheet429Configurator {
    private ConnectorParser connectorParser;

    public DataCollectorSheet429Configurator(ConnectorParser connectorParser) {
        this.connectorParser = connectorParser;
    }

    public DataCollectorSheet429Configurator() {
        this.connectorParser = null;
    }

    public ConnectorParser getConnectorParser() {
        return connectorParser;
    }

    public void setConnectorParser(ConnectorParser connectorParser) {
        this.connectorParser = connectorParser;
    }

    public void configurePersonal() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        ArrayList<HostConfig> coreHosts = connectorParser.getDatabaseInspectionConfig()
                .getPersonal().getCoreHosts();
        String[] hosts = new String[1];
        String[] users = new String[1];
        String[] passwords = new String[1];
        String[] sids = new String[1];
        int[] ports = new int[1];
        copyFromHostConfigArray(coreHosts, hosts, users, passwords, ports, sids);
        Sheet429PersonalConfig.setInspectedHosts(hosts);
        Sheet429PersonalConfig.setPasswords(passwords);
        Sheet429PersonalConfig.setPorts(ports);
        Sheet429PersonalConfig.setUsers(users);
        Sheet429PersonalConfig.setSid(sids);
    }

    public void configureCore() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        ArrayList<HostConfig> taxationHostConfigs = connectorParser.getDatabaseInspectionConfig()
                .getCore().getTaxationHosts();
        String[] taxationHosts = new String[1];
        String[] taxationUsers = new String[1];
        String[] taxationPasswords = new String[1];
        String[] taxationSids = new String[1];
        int[] taxationPorts = new int[1];
        copyFromHostConfigArray(taxationHostConfigs, taxationHosts, taxationUsers, taxationPasswords, taxationPorts, taxationSids);
        Sheet429CoreConfig.setInspectedHosts1(taxationHosts);
        Sheet429CoreConfig.setPasswords1(taxationPasswords);
        Sheet429CoreConfig.setPorts1(taxationPorts);
        Sheet429CoreConfig.setUsers1(taxationUsers);
        Sheet429CoreConfig.setSid1(taxationSids);

        ArrayList<HostConfig> queryHostConfigs = connectorParser.getDatabaseInspectionConfig()
                .getCore().getQueryHosts();
        String[] queryHosts = new String[1];
        String[] queryUsers = new String[1];
        String[] queryPasswords = new String[1];
        String[] querySids = new String[1];
        int[] queryPorts = new int[1];
        copyFromHostConfigArray(queryHostConfigs, queryHosts, queryUsers, queryPasswords, queryPorts, querySids);
        Sheet429CoreConfig.setInspectedHosts3(queryHosts);
        Sheet429CoreConfig.setPasswords3(queryPasswords);
        Sheet429CoreConfig.setPorts3(queryPorts);
        Sheet429CoreConfig.setUsers3(queryUsers);
        Sheet429CoreConfig.setSid3(querySids);

        ArrayList<HostConfig> integrationHostConfigs = connectorParser.getDatabaseInspectionConfig()
                .getCore().getIntegrationHosts();
        String[] integrationHosts = new String[1];
        String[] integrationUsers = new String[1];
        String[] integrationPasswords = new String[1];
        String[] integrationSids = new String[1];
        int[] integrationPorts = new int[1];
        copyFromHostConfigArray(integrationHostConfigs, integrationHosts, integrationUsers, integrationPasswords, integrationPorts, integrationSids);
        Sheet429CoreConfig.setInspectedHosts2(integrationHosts);
        Sheet429CoreConfig.setPasswords2(integrationPasswords);
        Sheet429CoreConfig.setPorts2(integrationPorts);
        Sheet429CoreConfig.setUsers2(integrationUsers);
        Sheet429CoreConfig.setSid2(integrationSids);
    }

    private void copyFromHostConfigArray(ArrayList<HostConfig> hostsConfig
            ,String[] hosts, String[] users
            , String[] passwords, int[] ports, String[] sids){
        final int size = 1;

        for(int i=0; i<size; i++){
            hosts[i] = hostsConfig.get(i).getIp();
            users[i] = hostsConfig.get(i).getUser();
            passwords[i] = hostsConfig.get(i).getPassword();
            ports[i] = hostsConfig.get(i).getPort();
            sids[i] = hostsConfig.get(i).getSid();
        }
    }
}

