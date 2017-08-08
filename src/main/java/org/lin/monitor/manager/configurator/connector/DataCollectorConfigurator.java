package org.lin.monitor.manager.configurator.connector;

import org.lin.monitor.manager.parser.connector.ConnectorParser;
import org.suns.data.collector.config.DFFormat;
import org.suns.data.collector.config.HostConnectorConfig;
import org.suns.data.collector.config.OracleConnectorConfig;

/**
 * Created by guanl on 7/17/2017.
 */
public class DataCollectorConfigurator {
    private ConnectorParser connectorParser;

    public DataCollectorConfigurator() throws Exception{
        this.connectorParser = new ConnectorParser();
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
        configureDfFormat();
        configureSheet411();
        configureSheet421();
        configureSheet422();
        configureSheet423();
        configureSheet424();
        configureSheet426();
        configureSheet428();
        configureSheet429();

    }

    private void configureDfFormat() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        DFFormat.setFileSystemColumnAIX(connectorParser.getDfFormatConfig()
                .getFileSystemColumn(DFFormat.InspectionSysType.AIX));

        DFFormat.setFileSystemColumnLinux(connectorParser.getDfFormatConfig()
                .getFileSystemColumn(DFFormat.InspectionSysType.LINUX));

        DFFormat.setMountedSysColumnAIX(connectorParser.getDfFormatConfig()
                .getMountedSysColumn(DFFormat.InspectionSysType.AIX));

        DFFormat.setMountedSysColumnLinux(connectorParser.getDfFormatConfig()
                .getMountedSysColumn(DFFormat.InspectionSysType.LINUX));

        DFFormat.setUsageColumnAIX(connectorParser.getDfFormatConfig()
                .getUsageColumn(DFFormat.InspectionSysType.AIX));

        DFFormat.setUsageColumnLinux(connectorParser.getDfFormatConfig()
                .getUsageColumn(DFFormat.InspectionSysType.LINUX));

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

    private void configureSheet422() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        DataCollectorSheet422Configurator sheet422Configurator
                = new DataCollectorSheet422Configurator(connectorParser);

        sheet422Configurator.configureCore();
        sheet422Configurator.configurePersonal();
    }

    private void configureSheet423() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        DataCollectorSheet423Configurator sheet423Configurator
                = new DataCollectorSheet423Configurator(connectorParser);

        sheet423Configurator.configureCore();
        sheet423Configurator.configurePersonal();
    }

    private void configureSheet424() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        DataCollectorSheet424Configurator sheet424Configurator
                = new DataCollectorSheet424Configurator(connectorParser);

        sheet424Configurator.configureCore();
        sheet424Configurator.configurePersonal();
    }

    private void configureSheet426() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        DataCollectorSheet426Configurator sheet426Configurator
                = new DataCollectorSheet426Configurator(connectorParser);

        sheet426Configurator.configureCore();
        sheet426Configurator.configurePersonal();
    }

    private void configureSheet429() throws Exception{
        if(connectorParser == null){
            throw new Exception("Uninitialized connector parser");
        }

        DataCollectorSheet429Configurator sheet429Configurator
                = new DataCollectorSheet429Configurator(connectorParser);

        sheet429Configurator.configureCore();
        sheet429Configurator.configurePersonal();
    }
}
