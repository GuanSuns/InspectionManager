import excel.filler.generator.*;
import org.junit.Test;
import org.lin.inspection.manager.configurator.ConfigManager;
import org.lin.inspection.manager.parser.connector.ConnectorParser;
import org.suns.data.collector.collectors.sheet411.Sheet411CoreCollector;
import org.suns.data.collector.collectors.sheet411.Sheet411PersonalCollector;
import org.suns.data.collector.collectors.sheet421.Sheet421CoreCollector;
import org.suns.data.collector.collectors.sheet421.Sheet421PersonalCollector;
import org.suns.data.collector.collectors.sheet422.Sheet422CoreCollector;
import org.suns.data.collector.collectors.sheet422.Sheet422PersonalCollector;
import org.suns.data.collector.collectors.sheet423.Sheet423CoreCollector;
import org.suns.data.collector.collectors.sheet423.Sheet423PersonalCollector;
import org.suns.data.collector.collectors.sheet424.Sheet424CoreCollector;
import org.suns.data.collector.collectors.sheet424.Sheet424PersonalCollector;
import org.suns.data.collector.collectors.sheet428.Sheet428CoreCollector;
import org.suns.data.collector.collectors.sheet428.Sheet428PersonalCollector;
import org.suns.data.collector.collectors.sheet429.Sheet429CoreCollector;
import org.suns.data.collector.collectors.sheet429.Sheet429PersonalCollector;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by guanl on 7/14/2017.
 */
public class TestInspectionManager {
    @Test
    public void testInspectionManager(){
        try{
            test_parser();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //@Test
    public void test_parser(){
        try{
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
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
