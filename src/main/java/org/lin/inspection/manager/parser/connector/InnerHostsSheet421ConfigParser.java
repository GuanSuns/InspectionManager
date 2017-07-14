package org.lin.inspection.manager.parser.connector;

import org.jdom.Element;
import org.lin.inspection.manager.config.ConnectorParserConfig;

/**
 * Created by guanl on 7/14/2017.
 */
public class InnerHostsSheet421ConfigParser {
    private Element sheet421Elem;
    private Element hostsInspectionElem;
    private Core core;
    private Personal personal;

    public InnerHostsSheet421ConfigParser(Element hostsInspectionElem) {
        this.hostsInspectionElem = hostsInspectionElem;
        this.sheet421Elem = null;
        this.core = null;
        this.personal = null;
    }

    public InnerHostsSheet421ConfigParser() {
        this.hostsInspectionElem = null;
        this.sheet421Elem = null;
        this.core = null;
        this.personal = null;
    }

    private void init() throws Exception{
        if(hostsInspectionElem == null){
            throw new Exception("Uninitialized hostsInspection element");
        }

        sheet421Elem = hostsInspectionElem.getChild(ConnectorParserConfig.getSheet421Tag());
        if(sheet421Elem == null){
            throw new Exception("Unexpected XML Config file format: missing Sheet421 element");
        }
    }

    public Core getCore() throws Exception{
        if(core != null){
            return core;
        }

        if(sheet421Elem == null){
            init();
        }

        Element coreElem = sheet421Elem.getChild(ConnectorParserConfig.getSheet421CoreTag());
        if(coreElem == null){
            throw new Exception("Unexpected XML Config file format: missing Sheet421 core element");
        }

        core = new Core(coreElem);
        return core;
    }

    public class Core{
        private Element coreElem;

        public Core(Element coreElem) {
            this.coreElem = coreElem;
        }

        public Core() {
            this.coreElem = null;
        }

        public String getRootDirectory() throws Exception{
            if(coreElem == null){
                throw new Exception("Uninitialized core element");
            }

            Element rootDirectoryElem = coreElem.getChild(ConnectorParserConfig.getSheet421CoreRootDirectoryTag());
            if(rootDirectoryElem == null){
                throw new Exception("Unexpected XML Config file format: missing Sheet421 core root directory element");
            }
            return rootDirectoryElem.getText();
        }

        public String getSoftwareDirectory() throws Exception{
            if(coreElem == null){
                throw new Exception("Uninitialized core element");
            }

            Element softwareDirectoryElem = coreElem.getChild(ConnectorParserConfig.getSheet421CoreSoftwareDirectoryTag());
            if(softwareDirectoryElem == null){
                throw new Exception("Unexpected XML Config file format: missing Sheet421 core software directory element");
            }
            return softwareDirectoryElem.getText();
        }

        public String getGgsDirectory() throws Exception{
            if(coreElem == null){
                throw new Exception("Uninitialized core element");
            }

            Element ggsDirectoryElem = coreElem.getChild(ConnectorParserConfig.getSheet421CoreGgsDirectoryTag());
            if(ggsDirectoryElem == null){
                throw new Exception("Unexpected XML Config file format: missing Sheet421 core GGS directory element");
            }
            return ggsDirectoryElem.getText();
        }
    }

    public class Personal{

    }
}
