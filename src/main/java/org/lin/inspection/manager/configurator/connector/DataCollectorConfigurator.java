package org.lin.inspection.manager.configurator.connector;

import org.lin.inspection.manager.parser.connector.ConnectorParser;
import org.lin.inspection.manager.parser.connector.HostConfig;
import org.suns.data.collector.config.HostConnectorConfig;
import org.suns.data.collector.config.OracleConnectorConfig;
import org.suns.data.collector.config.sheet411.Sheet411PersonalConfig;

import java.util.ArrayList;

/**
 * Created by guanl on 7/17/2017.
 */
public class DataCollectorConfigurator {
    private ConnectorParser connectorParser;

    public DataCollectorConfigurator(ConnectorParser connectorParser) {
        this.connectorParser = connectorParser;
    }

    public DataCollectorConfigurator() {
        this.connectorParser = null;
    }

    public ConnectorParser getConnectorParser() {
        return connectorParser;
    }

    public void setConnectorParser(ConnectorParser connectorParser) {
        this.connectorParser = connectorParser;
    }

    public void configure() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        configureOracleConnector();
        configureSheet411();
        configureSheet421();
        configureSheet428();
    }

    private void configureOracleConnector() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        String oracleDriver = connectorParser.getConnectorConfig().getOracleDriver();
        OracleConnectorConfig.setDriver(oracleDriver);

        String oracleURL = connectorParser.getConnectorConfig().getOracleUrl();
        OracleConnectorConfig.setUrl(oracleURL);

        int oracleTimeout = connectorParser.getConnectorConfig().getSessionTimeout();
        HostConnectorConfig.setSessionTimeout(oracleTimeout);
    }

    private void configureSheet411() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        DataCollectorSheet411Configurator sheet411Configurator
                = new DataCollectorSheet411Configurator(connectorParser);

        sheet411Configurator.configureCore();
        sheet411Configurator.configurePersonal();
    }

    private void configureSheet421() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        DataCollectorSheet421Configurator sheet421Configurator
                = new DataCollectorSheet421Configurator(connectorParser);

        sheet421Configurator.configureCore();
        sheet421Configurator.configurePersonal();
    }

    private void configureSheet428() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        DataCollectorSheet428Configurator sheet428Configurator
                = new DataCollectorSheet428Configurator(connectorParser);

        sheet428Configurator.configureCore();
        sheet428Configurator.configurePersonal();
    }
}
