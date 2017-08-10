package org.lin.monitor.manager.configurator.connector;

import org.lin.monitor.manager.config.ConnectorParserConfig;
import org.lin.monitor.manager.parser.connector.ConnectorParser;
import org.lin.monitor.manager.parser.connector.HostConfig;
import org.lin.monitor.manager.parser.utils.ParserUtils;
import org.suns.data.collector.config.sheet423.Sheet423CoreConfig;
import org.suns.data.collector.config.sheet423.Sheet423PersonalConfig;
import org.suns.host.config.AppCluster;

import java.util.ArrayList;

/**
 * Created by guanl on 7/17/2017.
 */
public class DataCollectorSheet423Configurator {
    private ConnectorParser connectorParser;

    public DataCollectorSheet423Configurator(ConnectorParser connectorParser) {
        this.connectorParser = connectorParser;
    }

    public DataCollectorSheet423Configurator() {
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

        Sheet423PersonalConfig.setInspectedHosts(hosts);
        Sheet423PersonalConfig.setPasswords(passwords);
        Sheet423PersonalConfig.setPorts(ports);
        Sheet423PersonalConfig.setUsers(users);
        Sheet423PersonalConfig.setSid(sids);
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

        Sheet423CoreConfig.setInspectedHosts2(taxationHosts);
        Sheet423CoreConfig.setPasswords2(taxationPasswords);
        Sheet423CoreConfig.setPorts2(taxationPorts);
        Sheet423CoreConfig.setUsers2(taxationUsers);
        Sheet423CoreConfig.setSid2(taxationSids);

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

        Sheet423CoreConfig.setInspectedHosts3(queryHosts);
        Sheet423CoreConfig.setPasswords3(queryPasswords);
        Sheet423CoreConfig.setPorts3(queryPorts);
        Sheet423CoreConfig.setUsers3(queryUsers);
        Sheet423CoreConfig.setSid3(querySids);

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

        Sheet423CoreConfig.setInspectedHosts4(integrationHosts);
        Sheet423CoreConfig.setPasswords4(integrationPasswords);
        Sheet423CoreConfig.setPorts4(integrationPorts);
        Sheet423CoreConfig.setUsers4(integrationUsers);
        Sheet423CoreConfig.setSid4(integrationSids);
    }
}
