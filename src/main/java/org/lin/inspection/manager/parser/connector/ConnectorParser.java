package org.lin.inspection.manager.parser.connector;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.lin.inspection.manager.config.ConnectorParserConfig;

/**
 * Created by guanl on 7/14/2017.
 */
public class ConnectorParser {
    private Document connectorDoc;
    private Element rootElem;
    private InnerConnectorConfigParser connectorConfig;
    private InnerHostsInspectionConfigParser hostsInspectionConfig;

    public ConnectorParser() throws Exception{
        init();
        connectorConfig = null;
        hostsInspectionConfig = null;
    }

    private void init() throws Exception{
        SAXBuilder builder= new SAXBuilder();
        connectorDoc = builder.build(ConnectorParserConfig.getRootDirectory()
                + ConnectorParserConfig.getConnectorConfigXML());
        rootElem = connectorDoc.getRootElement();

        if(rootElem == null){
            throw new Exception("Unexpected XML Config file format: missing root element");
        }
    }

    public InnerConnectorConfigParser getConnectorConfig(){
        if(connectorConfig != null){
            return connectorConfig;
        }else{
            connectorConfig = new InnerConnectorConfigParser(rootElem);
            return connectorConfig;
        }
    }

    public InnerHostsInspectionConfigParser getHostsInspectionConfig(){
        if(hostsInspectionConfig != null){
            return hostsInspectionConfig;
        }else{
            hostsInspectionConfig = new InnerHostsInspectionConfigParser(rootElem);
            return hostsInspectionConfig;
        }
    }

}
