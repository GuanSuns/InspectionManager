package org.lin.inspection.manager.parser.connector;

import org.jdom.Element;
import org.lin.inspection.manager.config.ConnectorParserConfig;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by guanl on 7/14/2017.
 */
public class InnerHostsSheet411ConfigParser {
    private Element sheet411Elem;
    private Element hostsInspectionElem;
    private Core core;
    private Personal personal;

    public InnerHostsSheet411ConfigParser(Element hostsInspectionElem) {
        this.hostsInspectionElem = hostsInspectionElem;
        this.sheet411Elem = null;
        this.core = null;
        this.personal = null;
    }

    public InnerHostsSheet411ConfigParser() {
        this.sheet411Elem = null;
        this.hostsInspectionElem = null;
        this.core = null;
        this.personal = null;
    }

    private void init() throws Exception{
        if(hostsInspectionElem == null){
            throw new Exception("Uninitialized hostsInspection element");
        }

        sheet411Elem = hostsInspectionElem.getChild(ConnectorParserConfig.getSheet411Tag());
        if(sheet411Elem == null){
            throw new Exception("Unexpected XML Config file format: missing Sheet411 element");
        }
    }

    public Core getCore() throws Exception{
        if(core != null){
            return core;
        }

        if(sheet411Elem == null){
            init();
        }

        Element coreElem = sheet411Elem.getChild(ConnectorParserConfig.getSheet411CoreTag());
        if(coreElem == null){
            throw new Exception("Unexpected XML Config file format: missing Sheet411 core element");
        }

        core = new Core(coreElem);
        return core;
    }
    
    public Personal getPersonal() throws Exception{
        if(personal != null){
            return personal;
        }

        if(sheet411Elem == null){
            init();
        }

        Element personalElem = sheet411Elem.getChild(ConnectorParserConfig.getSheet411PersonalTag());
        if(personalElem == null){
            throw new Exception("Unexpected XML Config file format: missing Sheet411 personal element");
        }

        personal = new Personal(personalElem);
        return personal;
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

            Element rootDirectoryElem = coreElem.getChild(ConnectorParserConfig.getSheet411CoreRootDirectoryTag());
            if(rootDirectoryElem == null){
                throw new Exception("Unexpected XML Config file format: missing Sheet411 core root directory element");
            }
            return rootDirectoryElem.getText();
        }

        public String getSoftwareDirectory() throws Exception{
            if(coreElem == null){
                throw new Exception("Uninitialized core element");
            }

            Element softwareDirectoryElem = coreElem.getChild(ConnectorParserConfig.getSheet411CoreSoftwareDirectoryTag());
            if(softwareDirectoryElem == null){
                throw new Exception("Unexpected XML Config file format: missing Sheet411 core software directory element");
            }
            return softwareDirectoryElem.getText();
        }

        public ArrayList<HostConfig> getHosts2() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet411CoreHosts2Tag());
        }

        public ArrayList<HostConfig> getHosts3() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet411CoreHosts3Tag());
        }

        public ArrayList<HostConfig> getHosts4() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet411CoreHosts4Tag());
        }

        public ArrayList<HostConfig> getHosts5() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet411CoreHosts5Tag());
        }

        public ArrayList<HostConfig> getHosts6() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet411CoreHosts6Tag());
        }

        public ArrayList<HostConfig> getHosts8() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet411CoreHosts8Tag());
        }

        private ArrayList<HostConfig> getHosts(String strTag) throws Exception{
            if(coreElem == null){
                throw new Exception("Uninitialized core element");
            }

            Element hostsRootElem = coreElem.getChild(strTag);
            if(hostsRootElem == null){
                throw new Exception("Unexpected XML Config file format: missing Sheet411 core " + strTag + " list");
            }

            List hostsElems = hostsRootElem.getChildren(ConnectorParserConfig.getHostTag());
            if(hostsElems == null || hostsElems.isEmpty()){
                throw new Exception("Unexpected XML Config file format: empty Sheet411 core" + strTag);
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

            Element rootDirectoryElem = personalElem.getChild(ConnectorParserConfig.getSheet411PersonalRootDirectoryTag());
            if(rootDirectoryElem == null){
                throw new Exception("Unexpected XML Config file format: missing Sheet411 personal root directory element");
            }
            return rootDirectoryElem.getText();
        }

        public String getSoftwareDirectory() throws Exception{
            if(personalElem == null){
                throw new Exception("Uninitialized personal element");
            }

            Element softwareDirectoryElem = personalElem.getChild(ConnectorParserConfig.getSheet411CoreSoftwareDirectoryTag());
            if(softwareDirectoryElem == null){
                throw new Exception("Unexpected XML Config file format: missing Sheet411 personal software directory element");
            }
            return softwareDirectoryElem.getText();
        }

        public ArrayList<HostConfig> getHosts2() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet411PersonalHosts2Tag());
        }

        public ArrayList<HostConfig> getHosts3() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet411PersonalHosts3Tag());
        }

        public ArrayList<HostConfig> getHosts45() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet411PersonalHosts45Tag());
        }
        
        private ArrayList<HostConfig> getHosts(String strTag) throws Exception{
            if(personalElem == null){
                throw new Exception("Uninitialized personal element");
            }

            Element hostsRootElem = personalElem.getChild(strTag);
            if(hostsRootElem == null){
                throw new Exception("Unexpected XML Config file format: missing Sheet411 personal " + strTag + " list");
            }

            List hostsElems = hostsRootElem.getChildren(ConnectorParserConfig.getHostTag());
            if(hostsElems == null || hostsElems.isEmpty()){
                throw new Exception("Unexpected XML Config file format: empty Sheet411 personal " + strTag);
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
