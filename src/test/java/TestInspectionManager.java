import org.junit.Test;
import org.lin.inspection.manager.parser.connector.ConnectorParser;

/**
 * Created by guanl on 7/14/2017.
 */
public class TestInspectionManager {
    @Test
    public void testInspectionManager(){
        try{
            ConnectorParser connectorParser = new ConnectorParser();
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
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
