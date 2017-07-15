package org.lin.inspection.manager.parser.connector;

import org.jdom.Element;
import org.lin.inspection.manager.config.ConnectorParserConfig;

/**
 * Created by guanl on 7/15/2017.
 */
public class InnerHostsSheet428ConfigParser {
    private Element sheet428Elem;
    private Element hostsInspectionElem;
    private Core core;
    private Personal personal;

    public InnerHostsSheet428ConfigParser(Element hostsInspectionElem) {
        this.hostsInspectionElem = hostsInspectionElem;
        this.sheet428Elem = null;
        this.core = null;
        this.personal = null;
    }

    public InnerHostsSheet428ConfigParser() {
        this.sheet428Elem = null;
        this.hostsInspectionElem = null;
        this.core = null;
        this.personal = null;
    }

    private void init() throws Exception{
        if(hostsInspectionElem == null){
            throw new Exception("Uninitialized hostsInspection element");
        }

        sheet428Elem = hostsInspectionElem.getChild(ConnectorParserConfig.getSheet428Tag());
        if(sheet428Elem == null){
            throw new Exception("Unexpected XML Config file format: missing Sheet428 element");
        }
    }
    
    public class Personal{
        
    }
    
    public class Core{
        
    }
}
