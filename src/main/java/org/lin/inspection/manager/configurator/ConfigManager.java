package org.lin.inspection.manager.configurator;

import org.lin.inspection.manager.configurator.connector.DataCollectorConfigurator;
import org.lin.inspection.manager.configurator.database.DBUtilsConfigurator;
import org.lin.inspection.manager.configurator.excel.AutoFillerConfigurator;

public class ConfigManager {
    private DataCollectorConfigurator dataCollectorConfigurator;
    private DBUtilsConfigurator dbUtilsConfigurator;
    private AutoFillerConfigurator autoFillerConfigurator;

    public ConfigManager() throws Exception{
        dataCollectorConfigurator = new DataCollectorConfigurator();
        dbUtilsConfigurator = new DBUtilsConfigurator();
        autoFillerConfigurator = new AutoFillerConfigurator();
    }

    public void configure() throws Exception{
        dataCollectorConfigurator.configure();
        dbUtilsConfigurator.configure();
        autoFillerConfigurator.configure();
    }
}
