package org.lin.monitor.manager.configurator.connector;

import org.lin.monitor.manager.config.ConnectorParserConfig;
import org.lin.monitor.manager.parser.connector.ConnectorParser;
import org.lin.monitor.manager.parser.connector.HostConfig;
import org.lin.monitor.manager.parser.utils.ParserUtils;
import org.suns.data.collector.config.sheet429.Sheet429CoreConfig;
import org.suns.data.collector.config.sheet429.Sheet429PersonalConfig;
import org.suns.host.config.AppCluster;

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

        AppCluster coreHosts = connectorParser.getDatabaseInspectionConfig()
                .getPersonal().getClusterByName(ConnectorParserConfig.getDbInspectionPersonalCoreDatabaseTag());
        String[] hosts = new String[1];
        String[] users = new String[1];
        String[] passwords = new String[1];
        String[] sids = new String[1];
        int[] ports = new int[1];

        ParserUtils.copyDBHostInfoToArray(coreHosts.getHosts()
                , hosts, users, passwords, ports, sids, 1);

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

        AppCluster taxationCluster = connectorParser.getDatabaseInspectionConfig()
                .getCore().getClusterByName(ConnectorParserConfig.getDbInspectionCoreTaxationHostsTag());
        String[] taxationHosts = new String[1];
        String[] taxationUsers = new String[1];
        String[] taxationPasswords = new String[1];
        String[] taxationSids = new String[1];
        int[] taxationPorts = new int[1];

        ParserUtils.copyDBHostInfoToArray(taxationCluster.getHosts(), taxationHosts
                , taxationUsers, taxationPasswords
                , taxationPorts, taxationSids, 1);

        Sheet429CoreConfig.setInspectedHosts1(taxationHosts);
        Sheet429CoreConfig.setPasswords1(taxationPasswords);
        Sheet429CoreConfig.setPorts1(taxationPorts);
        Sheet429CoreConfig.setUsers1(taxationUsers);
        Sheet429CoreConfig.setSid1(taxationSids);

        AppCluster queryCluster = connectorParser.getDatabaseInspectionConfig()
                .getCore().getClusterByName(ConnectorParserConfig.getDbInspectionCoreQueryHostsTag());

        String[] queryHosts = new String[1];
        String[] queryUsers = new String[1];
        String[] queryPasswords = new String[1];
        String[] querySids = new String[1];
        int[] queryPorts = new int[1];

        ParserUtils.copyDBHostInfoToArray(queryCluster.getHosts(), queryHosts
                , queryUsers, queryPasswords
                , queryPorts, querySids, 1);

        Sheet429CoreConfig.setInspectedHosts3(queryHosts);
        Sheet429CoreConfig.setPasswords3(queryPasswords);
        Sheet429CoreConfig.setPorts3(queryPorts);
        Sheet429CoreConfig.setUsers3(queryUsers);
        Sheet429CoreConfig.setSid3(querySids);

        AppCluster integrationCluster = connectorParser.getDatabaseInspectionConfig()
                .getCore().getClusterByName(ConnectorParserConfig.getDbInspectionCoreIntegrationHostsTag());

        String[] integrationHosts = new String[1];
        String[] integrationUsers = new String[1];
        String[] integrationPasswords = new String[1];
        String[] integrationSids = new String[1];
        int[] integrationPorts = new int[1];

        ParserUtils.copyDBHostInfoToArray(integrationCluster.getHosts(), integrationHosts
                , integrationUsers, integrationPasswords
                , integrationPorts, integrationSids, 1);

        Sheet429CoreConfig.setInspectedHosts2(integrationHosts);
        Sheet429CoreConfig.setPasswords2(integrationPasswords);
        Sheet429CoreConfig.setPorts2(integrationPorts);
        Sheet429CoreConfig.setUsers2(integrationUsers);
        Sheet429CoreConfig.setSid2(integrationSids);
    }
}

