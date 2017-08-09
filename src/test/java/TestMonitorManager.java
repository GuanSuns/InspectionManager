import org.junit.Test;
import org.lin.monitor.manager.config.SchedulerConfig;
import org.lin.monitor.manager.configurator.ConfigManager;
import org.lin.monitor.manager.parser.app.DailyAppInspectionCoreParser;
import org.lin.monitor.manager.parser.connector.ConnectorParser;
import org.lin.monitor.manager.parser.scheduler.SchedulerConfigParser;
import org.suns.data.collector.config.DFFormat;
import org.suns.host.config.AppCluster;
import org.suns.host.config.AppHost;
import org.suns.host.config.WebLogicServer;

import java.util.ArrayList;

/**
 * Created by guanl on 7/14/2017.
 */
public class TestMonitorManager {
    @Test
    public void testInspectionManager(){
        try{
            test_app_parser();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void test_app_parser() throws Exception{
        ConnectorParser connectorParser = new ConnectorParser();

        //System.out.println(connectorParser.getAppInspectionPersonalConfig().getWebLogicServers());
        //System.out.println(connectorParser.getAppInspectionCoreConfig().getWebLogicServers());
        ArrayList<WebLogicServer> webLogicServerConfigs = connectorParser.getAppInspectionCoreConfig().getWebLogicServers();
        for(WebLogicServer webLogicServerConfig : webLogicServerConfigs){
            System.out.println("WebServer Name: " + webLogicServerConfig.getIp()
                    + " , " + webLogicServerConfig.getPort());
            for (AppCluster cluster: webLogicServerConfig.getClusters()){
                System.out.println("  Cluster Name: " + cluster.getName());
                //System.out.println(cluster.getServers());
                for(AppHost host: cluster.getHosts()){
                    System.out.println("    Host Name: " + host.getIp());
                    for(String strServer : host.getServers()){
                        System.out.println("      Server Name: " + strServer);
                    }
                }
            }
        }
    }

    //@Test
    public void test_parser(){
        try{
            ConfigManager configManager = new ConfigManager();
            configManager.configure();

            ConnectorParser connectorParser = new ConnectorParser();
            System.out.println("\nSheet 411");
            System.out.println(connectorParser.getConnectorConfig().getOracleDriver());
            System.out.println(connectorParser.getConnectorConfig().getOracleUrl());
            System.out.println(connectorParser.getConnectorConfig().getSessionTimeout());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet411Parser().getCore().getRootDirectory());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet411Parser().getCore().getSoftwareDirectory());

            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet411Parser().getCore().getHosts2());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet411Parser().getCore().getHosts3());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet411Parser().getCore().getHosts4());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet411Parser().getCore().getHosts5());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet411Parser().getCore().getHosts6());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet411Parser().getCore().getHosts8());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet411Parser().getPersonal().getHosts2());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet411Parser().getPersonal().getHosts3());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet411Parser().getPersonal().getHosts45());

            System.out.println("\nSheet 421");
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet421Parser().getCore().getGgsDirectory());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet421Parser().getCore().getRootDirectory());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet421Parser().getCore().getSoftwareDirectory());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet421Parser().getCore().getHosts2());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet421Parser().getCore().getHosts35());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet421Parser().getCore().getHosts4());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet421Parser().getPersonal().getGgsDirectory());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet421Parser().getPersonal().getRootDirectory());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet421Parser().getPersonal().getSoftwareDirectory());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet421Parser().getPersonal().getHosts2());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet421Parser().getPersonal().getHosts3());

            System.out.println("\nSheet 428");
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet428Parser().getPersonal().getHosts1());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet428Parser().getPersonal().getHosts2());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet428Parser().getPersonal().getHosts3());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet428Parser().getPersonal().getHosts4());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet428Parser().getTimeCMD());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet428Parser().getCorrectReport());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet428Parser().getTimeDiffTolerance());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet428Parser().getCore().getHosts1());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet428Parser().getCore().getHosts2());
            System.out.println(connectorParser.getHostsInspectionConfig()
                    .getSheet428Parser().getCore().getHosts34());

            System.out.println("\nDatabase Inspection");
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getCore().getTaxationHosts());
            System.out.println("OS Inspection Host");
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getCore().getTaxationOSInspectionHosts());
            System.out.println("");
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getCore().getQueryHosts());
            System.out.println("OS Inspection Host");
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getCore().getQueryOSInspectionHosts());
            System.out.println("");
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getCore().getIntegrationHosts());
            System.out.println("OS Inspection Host");
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getCore().getIntegrationOSInspectionHosts());
            System.out.println("");
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getPersonal().getCoreHosts());
            System.out.println("OS Inspection Host");
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getPersonal().getCoreOSInspectionHosts());

            SchedulerConfigParser schedulerConfigParser = new SchedulerConfigParser();
            System.out.println();
            System.out.println(schedulerConfigParser.getRunTimeMM());
            System.out.println(schedulerConfigParser.getRunTimeHH());
            System.out.println(schedulerConfigParser.getLastDayJan());
            System.out.println(schedulerConfigParser.getLastDayFeb());
            System.out.println(schedulerConfigParser.getLastDayMar());
            System.out.println(schedulerConfigParser.getLastDayApr());

            System.out.println();
            System.out.println(DFFormat.getFileSystemColumn(DFFormat.InspectionSysType.AIX));
            System.out.println(DFFormat.getFileSystemColumn(DFFormat.InspectionSysType.LINUX));
            System.out.println(DFFormat.getUsageColumn(DFFormat.InspectionSysType.AIX));
            System.out.println(DFFormat.getUsageColumn(DFFormat.InspectionSysType.LINUX));
            System.out.println(DFFormat.getMountedSysColumn(DFFormat.InspectionSysType.AIX));
            System.out.println(DFFormat.getMountedSysColumn(DFFormat.InspectionSysType.LINUX));

            System.out.println();
            System.out.println(SchedulerConfig.getMonthlyInspectionTime());
            System.out.println(SchedulerConfig.getWeeklyInspectionTime());
            System.out.println(SchedulerConfig.getDailyEveInspectionTime());
            System.out.println(SchedulerConfig.getDailyLastThreeDayInspectionTime());
            System.out.println(SchedulerConfig.getDailyWithinTaxPeriodInspectionTime());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
