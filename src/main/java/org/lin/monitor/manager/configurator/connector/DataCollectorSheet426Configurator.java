package org.lin.monitor.manager.configurator.connector;

import org.lin.monitor.manager.parser.connector.ConnectorParser;
import org.lin.monitor.manager.parser.connector.HostConfig;
import org.suns.data.collector.config.sheet426.Sheet426CoreConfig;
import org.suns.data.collector.config.sheet426.Sheet426PersonalConfig;

import java.util.ArrayList;

/**
 * Created by guanl on 7/17/2017.
 */
public class DataCollectorSheet426Configurator {
    private ConnectorParser connectorParser;

    public DataCollectorSheet426Configurator(ConnectorParser connectorParser) {
        this.connectorParser = connectorParser;
    }

    public DataCollectorSheet426Configurator() {
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
                .getPersonal().getCoreOSInspectionHosts();
        int sizeHost = coreHosts.size();
        String[] hosts = new String[sizeHost];
        String[] users = new String[sizeHost];
        String[] passwords = new String[sizeHost];
        String[] logPaths = new String[sizeHost];
        int[] ports = new int[sizeHost];
        copyFromHostConfigArray(coreHosts, hosts, users, passwords, ports, logPaths);
        Sheet426PersonalConfig.setInspectedHosts2(hosts);
        Sheet426PersonalConfig.setPasswords2(passwords);
        Sheet426PersonalConfig.setPorts2(ports);
        Sheet426PersonalConfig.setUsers2(users);
        Sheet426PersonalConfig.setLogPath2(logPaths);
    }

    public void configureCore() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        ArrayList<HostConfig> taxationHostConfigs = connectorParser.getDatabaseInspectionConfig()
                .getCore().getTaxationOSInspectionHosts();
        int taxationSize = taxationHostConfigs.size();
        String[] taxationHosts = new String[taxationSize];
        String[] taxationUsers = new String[taxationSize];
        String[] taxationPasswords = new String[taxationSize];
        String[] taxationLogPaths = new String[taxationSize];
        int[] taxationPorts = new int[taxationSize];
        copyFromHostConfigArray(taxationHostConfigs, taxationHosts, taxationUsers, taxationPasswords, taxationPorts, taxationLogPaths);
        Sheet426CoreConfig.setInspectedHosts2(taxationHosts);
        Sheet426CoreConfig.setPasswords2(taxationPasswords);
        Sheet426CoreConfig.setPorts2(taxationPorts);
        Sheet426CoreConfig.setUsers2(taxationUsers);
        Sheet426CoreConfig.setLogPath2(taxationLogPaths);

        ArrayList<HostConfig> queryHostConfigs = connectorParser.getDatabaseInspectionConfig()
                .getCore().getQueryOSInspectionHosts();
        int querySize = queryHostConfigs.size();
        String[] queryHosts = new String[querySize];
        String[] queryUsers = new String[querySize];
        String[] queryPasswords = new String[querySize];
        String[] queryLogPaths = new String[querySize];
        int[] queryPorts = new int[querySize];
        copyFromHostConfigArray(queryHostConfigs, queryHosts, queryUsers, queryPasswords, queryPorts, queryLogPaths);
        Sheet426CoreConfig.setInspectedHosts3(queryHosts);
        Sheet426CoreConfig.setPasswords3(queryPasswords);
        Sheet426CoreConfig.setPorts3(queryPorts);
        Sheet426CoreConfig.setUsers3(queryUsers);
        Sheet426CoreConfig.setLogPath3(queryLogPaths);

        ArrayList<HostConfig> integrationHostConfigs = connectorParser.getDatabaseInspectionConfig()
                .getCore().getIntegrationOSInspectionHosts();
        int integrationSize = integrationHostConfigs.size();
        String[] integrationHosts = new String[integrationSize];
        String[] integrationUsers = new String[integrationSize];
        String[] integrationPasswords = new String[integrationSize];
        String[] integrationLogPaths = new String[integrationSize];
        int[] integrationPorts = new int[integrationSize];
        copyFromHostConfigArray(integrationHostConfigs, integrationHosts, integrationUsers, integrationPasswords, integrationPorts, integrationLogPaths);
        Sheet426CoreConfig.setInspectedHosts4(integrationHosts);
        Sheet426CoreConfig.setPasswords4(integrationPasswords);
        Sheet426CoreConfig.setPorts4(integrationPorts);
        Sheet426CoreConfig.setUsers4(integrationUsers);
        Sheet426CoreConfig.setLogPath4(integrationLogPaths);
    }

    private void copyFromHostConfigArray(ArrayList<HostConfig> hostsConfig
            ,String[] hosts, String[] users
            , String[] passwords, int[] ports, String[] logPaths){
        int size = hostsConfig.size();

        for(int i=0; i<size; i++){
            hosts[i] = hostsConfig.get(i).getIp();
            users[i] = hostsConfig.get(i).getUser();
            passwords[i] = hostsConfig.get(i).getPassword();
            ports[i] = hostsConfig.get(i).getPort();
            logPaths[i] = hostsConfig.get(i).getLogPath();            
        }
    }
}
