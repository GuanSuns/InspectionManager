package org.lin.monitor.manager.parser.connector.hosts;

import org.jdom.Element;
import org.lin.monitor.manager.config.ConnectorParserConfig;

/**
 * Created by guanl on 7/14/2017.
 */
public class InnerHostsInspectionConfigParser {
    private Element rootElem;
    private Element hostsInspectionRoot;

    private InnerHostsSheet411ConfigParser sheet411Parser;
    private InnerHostsSheet421ConfigParser sheet421Parser;
    private InnerHostsSheet428ConfigParser sheet428Parser;

    public InnerHostsInspectionConfigParser() {
        this.rootElem = null;
        this.hostsInspectionRoot = null;
        this.sheet411Parser = null;
        this.sheet421Parser = null;
        this.sheet428Parser = null;
    }

    public InnerHostsInspectionConfigParser(Element rootElem) {
        this.rootElem = rootElem;
        this.hostsInspectionRoot = null;
        this.sheet411Parser = null;
        this.sheet421Parser = null;
        this.sheet428Parser = null;
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

        sheet411Parser = new InnerHostsSheet411ConfigParser(hostsInspectionRoot);
        return sheet411Parser;
    }

    public InnerHostsSheet421ConfigParser getSheet421Parser() throws Exception{
        if(sheet421Parser != null){
            return sheet421Parser;
        }

        if(hostsInspectionRoot == null){
            initHostsInspectionRoot();
        }

        sheet421Parser = new InnerHostsSheet421ConfigParser(hostsInspectionRoot);
        return sheet421Parser;
    }

    public InnerHostsSheet428ConfigParser getSheet428Parser() throws Exception{
        if(sheet428Parser != null){
            return sheet428Parser;
        }

        if(hostsInspectionRoot == null){
            initHostsInspectionRoot();
        }

        sheet428Parser = new InnerHostsSheet428ConfigParser(hostsInspectionRoot);
        return sheet428Parser;
    }
}
