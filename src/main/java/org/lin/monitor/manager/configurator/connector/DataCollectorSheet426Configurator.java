package org.lin.monitor.manager.configurator.connector;

import org.lin.monitor.manager.config.ConnectorParserConfig;
import org.lin.monitor.manager.parser.connector.ConnectorParser;
import org.lin.monitor.manager.parser.connector.HostConfig;
import org.lin.monitor.manager.parser.utils.ParserUtils;
import org.suns.data.collector.config.sheet426.Sheet426CoreConfig;
import org.suns.data.collector.config.sheet426.Sheet426PersonalConfig;
import org.suns.host.config.AppCluster;

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

        AppCluster coreCluster = connectorParser.getDatabaseInspectionConfig()
                .getPersonal().getClusterByName(ConnectorParserConfig.getDbInspectionPersonalCoreDatabaseTag());

        int coreSize = coreCluster.getOSInspectionHosts().size();
        String[] coreHosts = new String[coreSize];
        String[] coreUsers = new String[coreSize];
        String[] corePasswords = new String[coreSize];
        String[] coreLogPaths = new String[coreSize];
        String[] coreSids = new String[coreSize];
        String[] coreCPUScriptPaths = new String[coreSize];
        String[] coreMemoryScriptPaths = new String[coreSize];
        String[] coreDiskScriptPaths = new String[coreSize];
        int[] corePorts = new int[coreSize];

        ParserUtils.copyDBOSHostInfoToArray(coreCluster.getOSInspectionHosts()
                , coreHosts, coreUsers, corePasswords
                , corePorts, coreSids, coreLogPaths
                , coreCPUScriptPaths, coreMemoryScriptPaths
                , coreDiskScriptPaths, coreSize);
        
        Sheet426PersonalConfig.setInspectedHosts2(coreHosts);
        Sheet426PersonalConfig.setPasswords2(corePasswords);
        Sheet426PersonalConfig.setPorts2(corePorts);
        Sheet426PersonalConfig.setUsers2(coreUsers);
        Sheet426PersonalConfig.setLogPath2(coreLogPaths);
    }

    public void configureCore() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        AppCluster taxationCluster = connectorParser.getDatabaseInspectionConfig()
                .getCore().getClusterByName(ConnectorParserConfig.getDbInspectionCoreTaxationHostsTag());
        
        int taxationSize = taxationCluster.getOSInspectionHosts().size();
        String[] taxationHosts = new String[taxationSize];
        String[] taxationUsers = new String[taxationSize];
        String[] taxationPasswords = new String[taxationSize];
        String[] taxationLogPaths = new String[taxationSize];
        String[] taxationSids = new String[taxationSize];
        String[] taxationCPUScriptPaths = new String[taxationSize];
        String[] taxationMemoryScriptPaths = new String[taxationSize];
        String[] taxationDiskScriptPaths = new String[taxationSize];
        int[] taxationPorts = new int[taxationSize];

        ParserUtils.copyDBOSHostInfoToArray(taxationCluster.getOSInspectionHosts()
                , taxationHosts, taxationUsers, taxationPasswords
                , taxationPorts, taxationSids, taxationLogPaths
                , taxationCPUScriptPaths, taxationMemoryScriptPaths
                , taxationDiskScriptPaths, taxationSize);
        
        Sheet426CoreConfig.setInspectedHosts2(taxationHosts);
        Sheet426CoreConfig.setPasswords2(taxationPasswords);
        Sheet426CoreConfig.setPorts2(taxationPorts);
        Sheet426CoreConfig.setUsers2(taxationUsers);
        Sheet426CoreConfig.setLogPath2(taxationLogPaths);

        AppCluster queryCluster = connectorParser.getDatabaseInspectionConfig()
                .getCore().getClusterByName(ConnectorParserConfig.getDbInspectionCoreQueryHostsTag());

        int querySize = queryCluster.getOSInspectionHosts().size();
        String[] queryHosts = new String[querySize];
        String[] queryUsers = new String[querySize];
        String[] queryPasswords = new String[querySize];
        String[] queryLogPaths = new String[querySize];
        String[] querySids = new String[querySize];
        String[] queryCPUScriptPaths = new String[querySize];
        String[] queryMemoryScriptPaths = new String[querySize];
        String[] queryDiskScriptPaths = new String[querySize];
        int[] queryPorts = new int[querySize];

        ParserUtils.copyDBOSHostInfoToArray(queryCluster.getOSInspectionHosts()
                , queryHosts, queryUsers, queryPasswords
                , queryPorts, querySids, queryLogPaths
                , queryCPUScriptPaths, queryMemoryScriptPaths
                , queryDiskScriptPaths, querySize);
        
        Sheet426CoreConfig.setInspectedHosts3(queryHosts);
        Sheet426CoreConfig.setPasswords3(queryPasswords);
        Sheet426CoreConfig.setPorts3(queryPorts);
        Sheet426CoreConfig.setUsers3(queryUsers);
        Sheet426CoreConfig.setLogPath3(queryLogPaths);

        AppCluster integrationCluster = connectorParser.getDatabaseInspectionConfig()
                .getCore().getClusterByName(ConnectorParserConfig.getDbInspectionCoreIntegrationHostsTag());

        int integrationSize = integrationCluster.getOSInspectionHosts().size();
        String[] integrationHosts = new String[integrationSize];
        String[] integrationUsers = new String[integrationSize];
        String[] integrationPasswords = new String[integrationSize];
        String[] integrationLogPaths = new String[integrationSize];
        String[] integrationSids = new String[integrationSize];
        String[] integrationCPUScriptPaths = new String[integrationSize];
        String[] integrationMemoryScriptPaths = new String[integrationSize];
        String[] integrationDiskScriptPaths = new String[integrationSize];
        int[] integrationPorts = new int[integrationSize];

        ParserUtils.copyDBOSHostInfoToArray(integrationCluster.getOSInspectionHosts()
                , integrationHosts, integrationUsers, integrationPasswords
                , integrationPorts, integrationSids, integrationLogPaths
                , integrationCPUScriptPaths, integrationMemoryScriptPaths
                , integrationDiskScriptPaths, integrationSize);
        
        Sheet426CoreConfig.setInspectedHosts4(integrationHosts);
        Sheet426CoreConfig.setPasswords4(integrationPasswords);
        Sheet426CoreConfig.setPorts4(integrationPorts);
        Sheet426CoreConfig.setUsers4(integrationUsers);
        Sheet426CoreConfig.setLogPath4(integrationLogPaths);
    }
}
