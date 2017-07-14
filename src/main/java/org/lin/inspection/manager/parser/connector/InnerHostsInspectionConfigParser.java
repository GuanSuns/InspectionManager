package org.lin.inspection.manager.parser.connector;

import org.jdom.Element;
import org.lin.inspection.manager.config.ConnectorParserConfig;

/**
 * Created by guanl on 7/14/2017.
 */
public class InnerHostsInspectionConfigParser {
    private Element rootElem;
    private Element hostsInspectionRoot;

    private InnerHostsSheet411ConfigParser sheet411Parser;

    public InnerHostsInspectionConfigParser() {
        this.rootElem = null;
        this.hostsInspectionRoot = null;
        this.sheet411Parser = null;
    }

    public InnerHostsInspectionConfigParser(Element rootElem) {
        this.rootElem = rootElem;
        this.hostsInspectionRoot = null;
        this.sheet411Parser = null;
    }

    private void initHostsInspectionRoot() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        hostsInspectionRoot = rootElem
                .getChild(ConnectorParserConfig.getHostsInspectionTag());

        if(hostsInspectionRoot == null){
            throw new Exception("Unexpected XML Config file format: missing HostsInspection element");
        }
    }

    public InnerHostsSheet411ConfigParser getSheet411Parser() throws Exception{
        if(sheet411Parser != null){
            return sheet411Parser;
        }

        if(hostsInspectionRoot == null){
            initHostsInspectionRoot();
        }

        Element sheet411Elem = hostsInspectionRoot.getChild(ConnectorParserConfig.getSheet411Tag());
        if(sheet411Elem == null){
            throw new Exception("Unexpected XML Config file format: missing Sheet411 tag in HostsInspection");
        }

        sheet411Parser = new InnerHostsSheet411ConfigParser(sheet411Elem);
        return sheet411Parser;
    }


}
