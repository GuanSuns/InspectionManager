import excel.filler.generator.*;
import org.junit.Test;
import org.lin.inspection.manager.configurator.ConfigManager;
import org.lin.inspection.manager.configurator.connector.DataCollectorConfigurator;
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
import org.suns.data.collector.collectors.sheet426.Sheet426CoreCollector;
import org.suns.data.collector.collectors.sheet426.Sheet426PersonalCollector;
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
            ConfigManager configManager = new ConfigManager();
            configManager.configure();

            SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm");

            System.out.println(df.format(new Date()) + " Inspecting Sheet 411 Personal");
            Sheet411PersonalCollector.inspect();
            System.out.println(df.format(new Date()) + " Inspecting Sheet 411 Core");
            Sheet411CoreCollector.inspect();

            System.out.println(df.format(new Date()) + " Inspecting Sheet 421 Personal");
            Sheet421PersonalCollector.inspect();
            System.out.println(df.format(new Date()) + " Inspecting Sheet 421 Core");
            Sheet421CoreCollector.inspect();

            System.out.println(df.format(new Date()) + " Inspecting Sheet 428 Personal");
            Sheet428PersonalCollector.inspect();
            System.out.println(df.format(new Date()) + " Inspecting Sheet 428 Core");
            Sheet428CoreCollector.inspect();

            System.out.println(df.format(new Date()) + " Inspecting Sheet 422 Personal");
            Sheet422PersonalCollector.inspect();
            System.out.println(df.format(new Date()) + " Inspecting Sheet 422 Core");
            Sheet422CoreCollector.inspect();

            System.out.println(df.format(new Date()) + " Inspecting Sheet 423 Personal");
            Sheet423PersonalCollector.inspect();
            System.out.println(df.format(new Date()) + " Inspecting Sheet 423 Core");
            Sheet423CoreCollector.inspect();

            System.out.println(df.format(new Date()) + " Inspecting Sheet 424 Personal");
            Sheet424PersonalCollector.inspect();
            System.out.println(df.format(new Date()) + " Inspecting Sheet 424 Core");
            Sheet424CoreCollector.inspect();
/*
            System.out.println(df.format(new Date()) + " Inspecting Sheet 426 Personal");
            Sheet426PersonalCollector.inspect();
            System.out.println(df.format(new Date()) + " Inspecting Sheet 426 Core");
            Sheet426CoreCollector.inspect();
*/
            System.out.println(df.format(new Date()) + " Inspecting Sheet 429 Personal");
            Sheet429PersonalCollector.inspect();
            System.out.println(df.format(new Date()) + " Inspecting Sheet 429 Core");
            Sheet429CoreCollector.inspect();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void generateExcel() throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm");
        System.out.println(df.format(new Date()) + " Filling Excel Sheet 411 Personal");
        Sheet411Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " Filling Excel Sheet 411 Core");
        Sheet411Generator.generateCore();

        System.out.println(df.format(new Date()) + " Filling Excel Sheet 421 Personal");
        Sheet421Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " Filling Excel Sheet 421 Core");
        Sheet421Generator.generateCore();

        System.out.println(df.format(new Date()) + " Filling Excel Sheet 422 Personal");
        Sheet422Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " Filling Excel Sheet 422 Core");
        Sheet422Generator.generateCore();

        System.out.println(df.format(new Date()) + " Filling Excel Sheet 423 Personal");
        Sheet423Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " Filling Excel Sheet 423 Core");
        Sheet423Generator.generateCore();

        System.out.println(df.format(new Date()) + " Filling Excel Sheet 424 Personal");
        Sheet424Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " Filling Excel Sheet 424 Core");
        Sheet424Generator.generateCore();

        System.out.println(df.format(new Date()) + " Filling Excel Sheet 426 Personal");
        Sheet426Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " Filling Excel Sheet 426 Core");
        Sheet426Generator.generateCore();

        System.out.println(df.format(new Date()) + " Filling Excel Sheet 428 Personal");
        Sheet428Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " Filling Excel Sheet 428 Core");
        Sheet428Generator.generateCore();

        System.out.println(df.format(new Date()) + " Filling Excel Sheet 429 Personal");
        Sheet429Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " Filling Excel Sheet 429 Core");
        Sheet429Generator.generateCore();
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
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getCore().getQueryHosts());
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getCore().getIntegrationHosts());
            System.out.println(connectorParser.getDatabaseInspectionConfig()
                    .getPersonal().getCoreHosts());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
