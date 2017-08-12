package org.lin.monitor.manager.configurator.connector;

import org.lin.monitor.manager.parser.connector.ConnectorParser;
import org.suns.data.collector.config.daily.AppCoreConfig;
import org.suns.data.collector.config.daily.AppPersonalConfig;

public class DataCollectorDailyAppConfigurator {
    private ConnectorParser connectorParser;

    public DataCollectorDailyAppConfigurator(ConnectorParser connectorParser) {
        this.connectorParser = connectorParser;
    }

    public void configurePersonal() throws Exception {
        if (connectorParser == null) {
            throw new Exception("Uninitialized connector parser");
        }

        AppPersonalConfig.setWebLogicServers(connectorParser
                .getAppInspectionPersonalConfig().getWebLogicServers());
    }

    public void configureCore() throws Exception{
        if (connectorParser == null) {
            throw new Exception("Uninitialized connector parser");
        }

        AppCoreConfig.setWebLogicServers(connectorParser
                .getAppInspectionCoreConfig().getWebLogicServers());
    }
}
