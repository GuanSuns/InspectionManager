package org.lin.inspection.manager.parser.connector.hosts;

import org.jdom.Element;
import org.lin.inspection.manager.config.ConnectorParserConfig;
import org.lin.inspection.manager.parser.connector.HostConfig;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

        public ArrayList<HostConfig> getHosts2() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet421CoreHosts2Tag());
        }

        public ArrayList<HostConfig> getHosts35() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet421CoreHosts35Tag());
        }

        public ArrayList<HostConfig> getHosts4() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet421CoreHosts4Tag());
        }

        private ArrayList<HostConfig> getHosts(String strTag) throws Exception{
            if(coreElem == null){
                throw new Exception("Uninitialized core element");
            }

            Element hostsRootElem = coreElem.getChild(strTag);
            if(hostsRootElem == null){
                throw new Exception("Unexpected XML Config file format: missing Sheet421 core " + strTag + " list");
            }

            List hostsElems = hostsRootElem.getChildren(ConnectorParserConfig.getHostTag());
            if(hostsElems == null || hostsElems.isEmpty()){
                throw new Exception("Unexpected XML Config file format: empty Sheet421 core " + strTag);
            }

            ArrayList<HostConfig> hosts = new ArrayList<HostConfig>();
            for (Iterator it = hostsElems.iterator(); it.hasNext();) {
                Element hostElem = (Element)it.next();
                HostConfig host = new HostConfig();
                host.copyFromElement(hostElem);
                hosts.add(host);
            }
            return hosts;
        }
    }

    public Personal getPersonal() throws Exception{
        if(personal != null){
            return personal;
        }

        if(sheet421Elem == null){
            init();
        }

        Element personalElem = sheet421Elem.getChild(ConnectorParserConfig.getSheet421PersonalTag());
        if(personalElem == null){
            throw new Exception("Unexpected XML Config file format: missing Sheet421 personal element");
        }

        personal = new Personal(personalElem);
        return personal;
    }

    public class Personal{
        private Element personalElem;

        public Personal(Element personalElem) {
            this.personalElem = personalElem;
        }

        public Personal() {
            this.personalElem = null;
        }

        public String getRootDirectory() throws Exception{
            if(personalElem == null){
                throw new Exception("Uninitialized personal element");
            }

            Element rootDirectoryElem = personalElem.getChild(ConnectorParserConfig.getSheet421PersonalRootDirectoryTag());
            if(rootDirectoryElem == null){
                throw new Exception("Unexpected XML Config file format: missing Sheet421 personal root directory element");
            }
            return rootDirectoryElem.getText();
        }

        public String getSoftwareDirectory() throws Exception{
            if(personalElem == null){
                throw new Exception("Uninitialized personal element");
            }

            Element softwareDirectoryElem = personalElem.getChild(ConnectorParserConfig.getSheet421PersonalSoftwareDirectoryTag());
            if(softwareDirectoryElem == null){
                throw new Exception("Unexpected XML Config file format: missing Sheet421 personal software directory element");
            }
            return softwareDirectoryElem.getText();
        }

        public String getGgsDirectory() throws Exception{
            if(personalElem == null){
                throw new Exception("Uninitialized personal element");
            }

            Element ggsDirectoryElem = personalElem.getChild(ConnectorParserConfig.getSheet421PersonalGgsDirectoryTag());
            if(ggsDirectoryElem == null){
                throw new Exception("Unexpected XML Config file format: missing Sheet421 personal GGS directory element");
            }
            return ggsDirectoryElem.getText();
        }

        public ArrayList<HostConfig> getHosts2() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet421PersonalHosts2Tag());
        }

        public ArrayList<HostConfig> getHosts3() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet421PersonalHosts3Tag());
        }

        private ArrayList<HostConfig> getHosts(String strTag) throws Exception{
            if(personalElem == null){
                throw new Exception("Uninitialized personal element");
            }

            Element hostsRootElem = personalElem.getChild(strTag);
            if(hostsRootElem == null){
                throw new Exception("Unexpected XML Config file format: missing Sheet421 personal " + strTag + " list");
            }

            List hostsElems = hostsRootElem.getChildren(ConnectorParserConfig.getHostTag());
            if(hostsElems == null || hostsElems.isEmpty()){
                throw new Exception("Unexpected XML Config file format: empty Sheet421 personal " + strTag);
            }

            ArrayList<HostConfig> hosts = new ArrayList<HostConfig>();
            for (Iterator it = hostsElems.iterator(); it.hasNext();) {
                Element hostElem = (Element)it.next();
                HostConfig host = new HostConfig();
                host.copyFromElement(hostElem);
                hosts.add(host);
            }
            return hosts;
        }
    }
}
