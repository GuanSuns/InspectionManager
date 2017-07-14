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
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
