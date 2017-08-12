import org.junit.Test;
import org.lin.monitor.manager.config.ConnectorParserConfig;
import org.lin.monitor.manager.config.SchedulerConfig;
import org.lin.monitor.manager.configurator.ConfigManager;
import org.lin.monitor.manager.parser.app.DailyAppInspectionCoreParser;
import org.lin.monitor.manager.parser.connector.ConnectorParser;
import org.lin.monitor.manager.parser.scheduler.SchedulerConfigParser;
import org.suns.data.collector.config.DFFormat;
import org.suns.data.collector.config.daily.AppCoreConfig;
import org.suns.data.collector.config.daily.AppPersonalConfig;
import org.suns.data.collector.config.daily.DBCoreConfig;
import org.suns.data.collector.config.daily.DBPersonalConfig;
import org.suns.data.collector.config.sheet411.Sheet411CoreConfig;
import org.suns.data.collector.config.sheet411.Sheet411PersonalConfig;
import org.suns.data.collector.config.sheet421.Sheet421CoreConfig;
import org.suns.data.collector.config.sheet421.Sheet421PersonalConfig;
import org.suns.data.collector.config.sheet422.Sheet422CoreConfig;
import org.suns.data.collector.config.sheet422.Sheet422PersonalConfig;
import org.suns.data.collector.config.sheet423.Sheet423CoreConfig;
import org.suns.data.collector.config.sheet423.Sheet423PersonalConfig;
import org.suns.data.collector.config.sheet424.Sheet424CoreConfig;
import org.suns.data.collector.config.sheet424.Sheet424PersonalConfig;
import org.suns.data.collector.config.sheet426.Sheet426CoreConfig;
import org.suns.data.collector.config.sheet426.Sheet426PersonalConfig;
import org.suns.data.collector.config.sheet428.Sheet428CoreConfig;
import org.suns.data.collector.config.sheet428.Sheet428PersonalConfig;
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
            test_config_result();

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

            System.out.println("\nTaxation Database Inspection - " + connectorParser.getDatabaseInspectionConfig()
                    .getCore().getClusterByName(ConnectorParserConfig
                            .getDbInspectionCoreTaxationHostsTag()).getPrintedName());
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getCore().getClusterByName(ConnectorParserConfig
                            .getDbInspectionCoreTaxationHostsTag()).getHosts());
            System.out.println("Taxation OS Inspection Host");
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getCore().getClusterByName(ConnectorParserConfig
                            .getDbInspectionCoreTaxationHostsTag()).getOSInspectionHosts());
            System.out.println("\nQuery DB Inspection");
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getCore().getClusterByName(ConnectorParserConfig
                            .getDbInspectionCoreQueryHostsTag()).getHosts());
            System.out.println("Query OS Inspection Host");
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getCore().getClusterByName(ConnectorParserConfig
                            .getDbInspectionCoreQueryHostsTag()).getOSInspectionHosts());
            System.out.println("\nIntegration DB Inspection");
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getCore().getClusterByName(ConnectorParserConfig
                            .getDbInspectionCoreIntegrationHostsTag()).getHosts());
            System.out.println("Integration OS Inspection Host");
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getCore().getClusterByName(ConnectorParserConfig
                            .getDbInspectionCoreIntegrationHostsTag()).getOSInspectionHosts());
            System.out.println("");
            System.out.println("\nCore DB Inspection");
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getPersonal().getClusterByName(ConnectorParserConfig
                            .getDbInspectionPersonalCoreDatabaseTag()).getHosts());
            System.out.println("Core OS Inspection Host");
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getPersonal().getClusterByName(ConnectorParserConfig
                            .getDbInspectionPersonalCoreDatabaseTag()).getOSInspectionHosts());

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

    public void test_config_result(){
        try {
            ConfigManager configManager = new ConfigManager();
            configManager.configure();

            System.out.println("\nDaily Personal App Inspection");
            printWebLogicServers(AppPersonalConfig.getWebLogicServers());

            System.out.println("\nDaily Core App Inspection");
            printWebLogicServers(AppCoreConfig.getWebLogicServers());

            System.out.println("\nDaily Personal DB Inspection");
            printDailyDBClusters(DBPersonalConfig.getClusters());

            System.out.println("\nDaily Core DB Inspection");
            printDailyDBClusters(DBCoreConfig.getClusters());

            System.out.println("\nSheet 411 Personal");
            printStringArray(Sheet411PersonalConfig.getInspectedHosts2());
            printStringArray(Sheet411PersonalConfig.getPasswords2());
            printStringArray(Sheet411PersonalConfig.getUsers2());
            printIntArray(Sheet411PersonalConfig.getPorts2());
            System.out.println();
            printStringArray(Sheet411PersonalConfig.getInspectedHosts3());
            printStringArray(Sheet411PersonalConfig.getPasswords3());
            printStringArray(Sheet411PersonalConfig.getUsers3());
            printIntArray(Sheet411PersonalConfig.getPorts3());
            System.out.println();
            printStringArray(Sheet411PersonalConfig.getInspectedHosts45());
            printStringArray(Sheet411PersonalConfig.getPasswords45());
            printStringArray(Sheet411PersonalConfig.getUsers45());
            printIntArray(Sheet411PersonalConfig.getPorts45());
            System.out.println();

            System.out.println("\nSheet 411 Core");
            printStringArray(Sheet411CoreConfig.getInspectedHosts2());
            printStringArray(Sheet411CoreConfig.getPasswords2());
            printStringArray(Sheet411CoreConfig.getUsers2());
            printIntArray(Sheet411CoreConfig.getPorts2());
            System.out.println();
            printStringArray(Sheet411CoreConfig.getInspectedHosts3());
            printStringArray(Sheet411CoreConfig.getPasswords3());
            printStringArray(Sheet411CoreConfig.getUsers3());
            printIntArray(Sheet411CoreConfig.getPorts3());
            System.out.println();
            printStringArray(Sheet411CoreConfig.getInspectedHosts4());
            printStringArray(Sheet411CoreConfig.getPasswords4());
            printStringArray(Sheet411CoreConfig.getUsers4());
            printIntArray(Sheet411CoreConfig.getPorts4());
            System.out.println();
            printStringArray(Sheet411CoreConfig.getInspectedHosts5());
            printStringArray(Sheet411CoreConfig.getPasswords5());
            printStringArray(Sheet411CoreConfig.getUsers5());
            printIntArray(Sheet411CoreConfig.getPorts5());
            System.out.println();
            printStringArray(Sheet411CoreConfig.getInspectedHosts6());
            printStringArray(Sheet411CoreConfig.getPasswords6());
            printStringArray(Sheet411CoreConfig.getUsers6());
            printIntArray(Sheet411CoreConfig.getPorts6());
            System.out.println();
            printStringArray(Sheet411CoreConfig.getInspectedHosts8());
            printStringArray(Sheet411CoreConfig.getPasswords8());
            printStringArray(Sheet411CoreConfig.getUsers8());
            printIntArray(Sheet411CoreConfig.getPorts8());
            System.out.println();

            System.out.println("\nSheet 421 Personal");
            printStringArray(Sheet421PersonalConfig.getInspectedHosts2());
            printStringArray(Sheet421PersonalConfig.getPasswords2());
            printStringArray(Sheet421PersonalConfig.getUsers2());
            printIntArray(Sheet421PersonalConfig.getPorts2());
            System.out.println();
            printStringArray(Sheet421PersonalConfig.getInspectedHosts3());
            printStringArray(Sheet421PersonalConfig.getPasswords3());
            printStringArray(Sheet421PersonalConfig.getUsers3());
            printIntArray(Sheet421PersonalConfig.getPorts3());
            System.out.println();

            System.out.println("\nSheet 421 Core");
            printStringArray(Sheet421CoreConfig.getInspectedHosts2());
            printStringArray(Sheet421CoreConfig.getPasswords2());
            printStringArray(Sheet421CoreConfig.getUsers2());
            printIntArray(Sheet421CoreConfig.getPorts2());
            System.out.println();
            printStringArray(Sheet421CoreConfig.getInspectedHosts35());
            printStringArray(Sheet421CoreConfig.getPasswords35());
            printStringArray(Sheet421CoreConfig.getUsers35());
            printIntArray(Sheet421CoreConfig.getPorts35());
            System.out.println();
            printStringArray(Sheet421CoreConfig.getInspectedHosts4());
            printStringArray(Sheet421CoreConfig.getPasswords4());
            printStringArray(Sheet421CoreConfig.getUsers4());
            printIntArray(Sheet421CoreConfig.getPorts4());
            System.out.println();

            System.out.println("\nSheet 422 Personal");
            printStringArray(Sheet422PersonalConfig.getInspectedHosts());
            printStringArray(Sheet422PersonalConfig.getSid());
            printStringArray(Sheet422PersonalConfig.getPasswords());
            printStringArray(Sheet422PersonalConfig.getUsers());
            printIntArray(Sheet422PersonalConfig.getPorts());
            System.out.println();

            System.out.println("\nSheet 422 Core");
            printStringArray(Sheet422CoreConfig.getInspectedHosts2());
            printStringArray(Sheet422CoreConfig.getSid2());
            printStringArray(Sheet422CoreConfig.getPasswords2());
            printStringArray(Sheet422CoreConfig.getUsers2());
            printIntArray(Sheet422CoreConfig.getPorts2());
            System.out.println();
            printStringArray(Sheet422CoreConfig.getInspectedHosts3());
            printStringArray(Sheet422CoreConfig.getSid3());
            printStringArray(Sheet422CoreConfig.getPasswords3());
            printStringArray(Sheet422CoreConfig.getUsers3());
            printIntArray(Sheet422CoreConfig.getPorts3());
            System.out.println();
            printStringArray(Sheet422CoreConfig.getInspectedHosts4());
            printStringArray(Sheet422CoreConfig.getSid4());
            printStringArray(Sheet422CoreConfig.getPasswords4());
            printStringArray(Sheet422CoreConfig.getUsers4());
            printIntArray(Sheet422CoreConfig.getPorts4());
            System.out.println();

            System.out.println("\nSheet 423 Personal");
            printStringArray(Sheet423PersonalConfig.getInspectedHosts());
            printStringArray(Sheet423PersonalConfig.getSid());
            printStringArray(Sheet423PersonalConfig.getPasswords());
            printStringArray(Sheet423PersonalConfig.getUsers());
            printIntArray(Sheet423PersonalConfig.getPorts());
            System.out.println();

            System.out.println("\nSheet 423 Core");
            printStringArray(Sheet423CoreConfig.getInspectedHosts2());
            printStringArray(Sheet423CoreConfig.getSid2());
            printStringArray(Sheet423CoreConfig.getPasswords2());
            printStringArray(Sheet423CoreConfig.getUsers2());
            printIntArray(Sheet423CoreConfig.getPorts2());
            System.out.println();
            printStringArray(Sheet423CoreConfig.getInspectedHosts3());
            printStringArray(Sheet423CoreConfig.getSid3());
            printStringArray(Sheet423CoreConfig.getPasswords3());
            printStringArray(Sheet423CoreConfig.getUsers3());
            printIntArray(Sheet423CoreConfig.getPorts3());
            System.out.println();
            printStringArray(Sheet423CoreConfig.getInspectedHosts4());
            printStringArray(Sheet423CoreConfig.getSid4());
            printStringArray(Sheet423CoreConfig.getPasswords4());
            printStringArray(Sheet423CoreConfig.getUsers4());
            printIntArray(Sheet423CoreConfig.getPorts4());
            System.out.println();

            System.out.println("\nSheet 424 Personal");
            printStringArray(Sheet424PersonalConfig.getInspectedHosts());
            printStringArray(Sheet424PersonalConfig.getSid());
            printStringArray(Sheet424PersonalConfig.getPasswords());
            printStringArray(Sheet424PersonalConfig.getUsers());
            printIntArray(Sheet424PersonalConfig.getPorts());
            System.out.println();

            System.out.println("\nSheet 424 Core");
            printStringArray(Sheet424CoreConfig.getInspectedHosts2());
            printStringArray(Sheet424CoreConfig.getSid2());
            printStringArray(Sheet424CoreConfig.getPasswords2());
            printStringArray(Sheet424CoreConfig.getUsers2());
            printIntArray(Sheet424CoreConfig.getPorts2());
            System.out.println();
            printStringArray(Sheet424CoreConfig.getInspectedHosts3());
            printStringArray(Sheet424CoreConfig.getSid3());
            printStringArray(Sheet424CoreConfig.getPasswords3());
            printStringArray(Sheet424CoreConfig.getUsers3());
            printIntArray(Sheet424CoreConfig.getPorts3());
            System.out.println();
            printStringArray(Sheet424CoreConfig.getInspectedHosts4());
            printStringArray(Sheet424CoreConfig.getSid4());
            printStringArray(Sheet424CoreConfig.getPasswords4());
            printStringArray(Sheet424CoreConfig.getUsers4());
            printIntArray(Sheet424CoreConfig.getPorts4());
            System.out.println();

            System.out.println("\nSheet 426 Personal");
            printStringArray(Sheet426PersonalConfig.getInspectedHosts2());
            printStringArray(Sheet426PersonalConfig.getPasswords2());
            printStringArray(Sheet426PersonalConfig.getUsers2());
            printStringArray(Sheet426PersonalConfig.getLogPath2());
            printIntArray(Sheet426PersonalConfig.getPorts2());
            System.out.println();

            System.out.println("\nSheet 426 Core");
            printStringArray(Sheet426CoreConfig.getInspectedHosts2());
            printStringArray(Sheet426CoreConfig.getLogPath2());
            printStringArray(Sheet426CoreConfig.getPasswords2());
            printStringArray(Sheet426CoreConfig.getUsers2());
            printIntArray(Sheet426CoreConfig.getPorts2());
            System.out.println();
            printStringArray(Sheet426CoreConfig.getInspectedHosts3());
            printStringArray(Sheet426CoreConfig.getLogPath3());
            printStringArray(Sheet426CoreConfig.getPasswords3());
            printStringArray(Sheet426CoreConfig.getUsers3());
            printIntArray(Sheet426CoreConfig.getPorts3());
            System.out.println();
            printStringArray(Sheet426CoreConfig.getInspectedHosts4());
            printStringArray(Sheet426CoreConfig.getLogPath4());
            printStringArray(Sheet426CoreConfig.getPasswords4());
            printStringArray(Sheet426CoreConfig.getUsers4());
            printIntArray(Sheet426CoreConfig.getPorts4());
            System.out.println();

            System.out.println("\nSheet 428 Personal");
            printStringArray(Sheet428PersonalConfig.getInspectedHosts2());
            printStringArray(Sheet428PersonalConfig.getPasswords2());
            printStringArray(Sheet428PersonalConfig.getUsers2());
            printIntArray(Sheet428PersonalConfig.getPorts2());
            System.out.println();
            printStringArray(Sheet428PersonalConfig.getInspectedHosts3());
            printStringArray(Sheet428PersonalConfig.getPasswords3());
            printStringArray(Sheet428PersonalConfig.getUsers3());
            printIntArray(Sheet428PersonalConfig.getPorts3());
            System.out.println();
            printStringArray(Sheet428PersonalConfig.getInspectedHosts4());
            printStringArray(Sheet428PersonalConfig.getPasswords4());
            printStringArray(Sheet428PersonalConfig.getUsers4());
            printIntArray(Sheet428PersonalConfig.getPorts4());
            System.out.println();

            System.out.println("\nSheet 428 Core");
            printStringArray(Sheet428CoreConfig.getInspectedHosts2());
            printStringArray(Sheet428CoreConfig.getPasswords2());
            printStringArray(Sheet428CoreConfig.getUsers2());
            printIntArray(Sheet428CoreConfig.getPorts2());
            System.out.println();
            printStringArray(Sheet428CoreConfig.getInspectedHosts1());
            printStringArray(Sheet428CoreConfig.getPasswords1());
            printStringArray(Sheet428CoreConfig.getUsers1());
            printIntArray(Sheet428CoreConfig.getPorts1());
            System.out.println();
            printStringArray(Sheet428CoreConfig.getInspectedHosts34());
            printStringArray(Sheet428CoreConfig.getPasswords34());
            printStringArray(Sheet428CoreConfig.getUsers34());
            printIntArray(Sheet428CoreConfig.getPorts34());
            System.out.println();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void printStringArray(String[] strings){
        System.out.print("[ ");
        for(int i=0; i<strings.length; i++){
            if(i == 0){
                System.out.print("\'" + strings[i] + "\'");
            }else {
                System.out.print(", \'" + strings[i] + "\'");
            }
        }
        System.out.print(" ] ");
    }

    private void printIntArray(int[] ints){
        System.out.print("[ ");
        for(int i=0; i<ints.length; i++){
            if(i == 0){
                System.out.print("\'" + ints[i] + "\'");
            }else {
                System.out.print(", \'" + ints[i] + "\'");
            }
        }
        System.out.print(" ] ");
    }

    private void printWebLogicServers(ArrayList<WebLogicServer> webLogicServers){
        for(WebLogicServer webLogicServer : webLogicServers){
            System.out.println("WebLogic Server: " + webLogicServer.getIp()
                    + ", " + webLogicServer.getPort()
                    + ", " + webLogicServer.getUser()
                    + ", " + webLogicServer.getPassword());

            ArrayList<AppCluster> clusters = webLogicServer.getClusters();
            for(AppCluster cluster : clusters){
                System.out.println("--cluster name: " + cluster.getName()
                        + ", printedName: " + cluster.getPrintedName());

                ArrayList<AppHost> hosts = cluster.getHosts();
                for(AppHost appHost : hosts){
                    printDailyAppHost(appHost);
                }
            }
        }
    }

    private void printDailyDBClusters(ArrayList<AppCluster> clusters){
        for(AppCluster cluster : clusters){
            System.out.println("--cluster name: " + cluster.getName()
                    + ", printedName: " + cluster.getPrintedName());

            ArrayList<AppHost> hosts = cluster.getHosts();
            for(AppHost appHost : hosts){
                printDailyDBHost(appHost);
            }
        }
    }

    private void printDailyAppHost(AppHost host){
        System.out.println("----host: " + host.getIp()
                + ", " + host.getPort()
                + ", " + host.getUser()
                + ", " + host.getPassword()
                + ", " + host.getScriptMemoryPath()
                + ", " + host.getScriptCPUPath());

        for(String server : host.getServers()){
            System.out.println("------server: " + server);
        }
    }

    private void printDailyDBHost(AppHost host){
        System.out.println("----host: " + host.getIp()
                + ", " + host.getPort()
                + ", " + host.getSid()
                + ", " + host.getUser()
                + ", " + host.getPassword()
                );

        AppHost osInspectionHost = host.getInspectionHost();
        System.out.println("------DB OS Inspection host: "
                + osInspectionHost.getIp()
                + ", " + osInspectionHost.getPort()
                + ", " + osInspectionHost.getUser()
                + ", " + osInspectionHost.getPassword()
                + ", " + osInspectionHost.getScriptMemoryPath()
                + ", " + osInspectionHost.getScriptDiskPath()
                + ", " + osInspectionHost.getLogPath()
                + ", " + osInspectionHost.getScriptCPUPath());
    }
}
