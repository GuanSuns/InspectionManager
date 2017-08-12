package org.lin.monitor.manager.configurator.connector;

import org.lin.monitor.manager.parser.connector.ConnectorParser;
import org.suns.data.collector.config.daily.DBCoreConfig;
import org.suns.data.collector.config.daily.DBPersonalConfig;

public class DataCollectorDailyDBConfigurator {
    private ConnectorParser connectorParser;

    public DataCollectorDailyDBConfigurator(ConnectorParser connectorParser) {
        this.connectorParser = connectorParser;
    }

    public void configurePersonal() throws Exception {
        if (connectorParser == null) {
            throw new Exception("Uninitialized connector parser");
        }

        DBPersonalConfig.setClusters(connectorParser
                .getDatabaseInspectionConfig().getPersonal().getClustersList());
    }

    public void configureCore() throws Exception{
        if (connectorParser == null) {
            throw new Exception("Uninitialized connector parser");
        }

        DBCoreConfig.setClusters(connectorParser
                .getDatabaseInspectionConfig().getCore().getClustersList());
    }
}
