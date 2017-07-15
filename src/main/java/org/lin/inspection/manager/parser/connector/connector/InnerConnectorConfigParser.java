package org.lin.inspection.manager.parser.connector.connector;

import org.jdom.Element;
import org.lin.inspection.manager.config.ConnectorParserConfig;

/**
 * Created by guanl on 7/14/2017.
 */
public class InnerConnectorConfigParser {
    private Element rootElem;
    private Element connectorConfigRoot;

    public InnerConnectorConfigParser(Element rootElem) {
        this.rootElem = rootElem;
        this.connectorConfigRoot = null;
    }

    public InnerConnectorConfigParser() {
        this.rootElem = null;
        this.connectorConfigRoot = null;
    }

    private void initConnectorConfigRoot() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        connectorConfigRoot = rootElem
                .getChild(ConnectorParserConfig.getConnectorConfigRootTag());

        if(connectorConfigRoot == null){
            throw new Exception("Unexpected XML Config file format: missing ConnectorConfig element");
        }
    }

    public int getSessionTimeout() throws Exception{
        if(connectorConfigRoot == null){
            initConnectorConfigRoot();
        }

        Element timeoutElem = connectorConfigRoot.getChild(ConnectorParserConfig.getTimeoutTag());
        if(timeoutElem == null){
            throw new Exception("Unexpected XML Config file format: missing timeout tag in ConnectorConfig");
        }

        String strTimeout = timeoutElem.getText();
        return Integer.valueOf(strTimeout);
    }

    public String getOracleDriver() throws Exception{
        if(connectorConfigRoot == null){
            initConnectorConfigRoot();
        }

        Element oracleElem = connectorConfigRoot.getChild(ConnectorParserConfig.getOracleTag());
        if(oracleElem == null){
            throw new Exception("Unexpected XML Config file format: missing oracle tag in ConnectorConfig");
        }

        Element oracleDriverElem = oracleElem.getChild(ConnectorParserConfig.getOracleDriverTag());
        if(oracleDriverElem == null){
            throw new Exception("Unexpected XML Config file format: missing oracleDriver tag in ConnectorConfig");
        }

        return oracleDriverElem.getText();
    }

    public String getOracleUrl() throws Exception{
        if(connectorConfigRoot == null){
            initConnectorConfigRoot();
        }

        Element oracleElem = connectorConfigRoot.getChild(ConnectorParserConfig.getOracleTag());
        if(oracleElem == null){
            throw new Exception("Unexpected XML Config file format: missing oracle tag in ConnectorConfig");
        }

        Element oracleURLElem = oracleElem.getChild(ConnectorParserConfig.getOracleURLTag());
        if(oracleURLElem == null){
            throw new Exception("Unexpected XML Config file format: missing oracle url tag in ConnectorConfig");
        }

        return oracleURLElem.getText();
    }
}
