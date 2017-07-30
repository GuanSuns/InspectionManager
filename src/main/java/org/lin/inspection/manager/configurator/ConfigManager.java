package org.lin.inspection.manager.configurator;

import org.lin.inspection.manager.configurator.connector.DataCollectorConfigurator;
import org.lin.inspection.manager.configurator.database.DBUtilsConfigurator;
import org.lin.inspection.manager.configurator.excel.AutoFillerConfigurator;
import org.lin.inspection.manager.configurator.scheduler.SchedulerConfigurator;

public class ConfigManager {
    private DataCollectorConfigurator dataCollectorConfigurator;
    private DBUtilsConfigurator dbUtilsConfigurator;
    private AutoFillerConfigurator autoFillerConfigurator;
    private SchedulerConfigurator schedulerConfigurator;

    public ConfigManager() throws Exception{
        dataCollectorConfigurator = new DataCollectorConfigurator();
        dbUtilsConfigurator = new DBUtilsConfigurator();
        autoFillerConfigurator = new AutoFillerConfigurator();
        schedulerConfigurator = new SchedulerConfigurator();
    }

    public void configure() throws Exception{
        dataCollectorConfigurator.configure();
        dbUtilsConfigurator.configure();
        autoFillerConfigurator.configure();
        schedulerConfigurator.configure();
    }
}
