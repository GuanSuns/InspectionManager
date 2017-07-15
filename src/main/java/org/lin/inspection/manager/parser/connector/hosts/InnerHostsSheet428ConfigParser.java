package org.lin.inspection.manager.parser.connector.hosts;

import org.jdom.Element;
import org.lin.inspection.manager.config.ConnectorParserConfig;
import org.lin.inspection.manager.parser.connector.HostConfig;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public String getTimeCMD() throws Exception{
        if(hostsInspectionElem == null){
            init();
        }

        Element timeCmdElem = sheet428Elem.getChild(ConnectorParserConfig.getSheet428TimeCmdTag());
        if(timeCmdElem == null){
            throw new Exception("Unexpected XML Config file format: missing Sheet428 getTimeCMD element");
        }
        return timeCmdElem.getText();
    }

    public String getCorrectReport() throws Exception{
        if(hostsInspectionElem == null){
            init();
        }

        Element correctReportElem = sheet428Elem.getChild(ConnectorParserConfig.getSheet428CorrectReportTag());
        if(correctReportElem == null){
            throw new Exception("Unexpected XML Config file format: missing Sheet428 CorrectReport element");
        }
        return correctReportElem.getText();
    }

    public long getTimeDiffTolerance() throws Exception{
        if(hostsInspectionElem == null){
            init();
        }

        Element timeDiffToleranceElem = sheet428Elem.getChild(ConnectorParserConfig.getSheet428DiffToleranceTag());
        if(timeDiffToleranceElem == null){
            throw new Exception("Unexpected XML Config file format: missing Sheet428 TimeDiffTolerance element");
        }

        String strTimeDiff = timeDiffToleranceElem.getText();
        if(strTimeDiff == null || strTimeDiff.equals("")){
            throw new Exception("Unexpected XML Config file format: empty value in Sheet428 TimeDiffTolerance Tag");
        }
        return Long.valueOf(strTimeDiff);
    }

    public Personal getPersonal() throws Exception{
        if(personal != null){
            return personal;
        }

        if(sheet428Elem == null){
            init();
        }

        Element personalElem = sheet428Elem.getChild(ConnectorParserConfig.getSheet428PersonalTag());
        if(personalElem == null){
            throw new Exception("Unexpected XML Config file format: missing Sheet428 personal element");
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

        public ArrayList<HostConfig> getHosts1() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet428PersonalHosts1Tag());
        }

        public ArrayList<HostConfig> getHosts2() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet428PersonalHosts2Tag());
        }

        public ArrayList<HostConfig> getHosts3() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet428PersonalHosts3Tag());
        }

        public ArrayList<HostConfig> getHosts4() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet428PersonalHosts4Tag());
        }

        private ArrayList<HostConfig> getHosts(String strTag) throws Exception{
            if(personalElem == null){
                throw new Exception("Uninitialized core element");
            }

            Element hostsRootElem = personalElem.getChild(strTag);
            if(hostsRootElem == null){
                throw new Exception("Unexpected XML Config file format: missing Sheet428 core " + strTag + " list");
            }

            List hostsElems = hostsRootElem.getChildren(ConnectorParserConfig.getHostTag());
            if(hostsElems == null || hostsElems.isEmpty()){
                throw new Exception("Unexpected XML Config file format: empty Sheet428 core " + strTag);
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

    public Core getCore() throws Exception{
        if(core != null){
            return core;
        }

        if(sheet428Elem == null){
            init();
        }

        Element coreElem = sheet428Elem.getChild(ConnectorParserConfig.getSheet428CoreTag());
        if(coreElem == null){
            throw new Exception("Unexpected XML Config file format: missing Sheet428 core element");
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

        public ArrayList<HostConfig> getHosts1() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet428CoreHosts1Tag());
        }

        public ArrayList<HostConfig> getHosts2() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet428CoreHosts2Tag());
        }

        public ArrayList<HostConfig> getHosts34() throws Exception{
            return getHosts(ConnectorParserConfig.getSheet428CoreHosts34Tag());
        }

        private ArrayList<HostConfig> getHosts(String strTag) throws Exception{
            if(coreElem == null){
                throw new Exception("Uninitialized core element");
            }

            Element hostsRootElem = coreElem.getChild(strTag);
            if(hostsRootElem == null){
                throw new Exception("Unexpected XML Config file format: missing Sheet428 core " + strTag + " list");
            }

            List hostsElems = hostsRootElem.getChildren(ConnectorParserConfig.getHostTag());
            if(hostsElems == null || hostsElems.isEmpty()){
                throw new Exception("Unexpected XML Config file format: empty Sheet428 core " + strTag);
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
