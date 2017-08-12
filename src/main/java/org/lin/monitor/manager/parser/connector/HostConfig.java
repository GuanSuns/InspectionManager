package org.lin.monitor.manager.parser.connector;

import org.jdom.Element;
import org.lin.monitor.manager.config.ConnectorParserConfig;
import org.lin.monitor.manager.parser.utils.ParserUtils;
import org.suns.host.config.AppCluster;
import org.suns.host.config.AppHost;

/**
 * Created by guanl on 7/14/2017.
 */
public class HostConfig {
    private String ip;
    private int port;
    private String user;
    private String password;
    private String sid;
    private String logPath;

    private String scriptCPUPath;
    private String scriptMemoryPath;
    private String scriptDiskPath;

    private AppHost inspectionHost;

    public HostConfig() {
        this.ip = "";
        this.port = 0;
        this.user = "";
        this.password = "";
        this.sid = "";
        this.logPath = "";
        this.scriptCPUPath = "";
        this.scriptMemoryPath = "";
        this.scriptDiskPath = "";
        this.inspectionHost = null;
    }

    public AppHost toAppHost(){
        AppHost appHost = new AppHost();
        appHost.setScriptMemoryPath(scriptMemoryPath);
        appHost.setIp(ip);
        appHost.setPassword(password);
        appHost.setPort(port);
        appHost.setUser(user);
        appHost.setSid(sid);
        appHost.setLogPath(logPath);
        appHost.setScriptCPUPath(scriptCPUPath);
        appHost.setScriptDiskPath(scriptDiskPath);
        appHost.setInspectionHost(inspectionHost);

        return appHost;
    }

    public void copyFromElement(Element hostElem) throws Exception{

        setIp(ParserUtils.getStringFromAttr(hostElem
                , ConnectorParserConfig.getIpAttr()));
        setPassword(ParserUtils.getStringFromAttr(hostElem
                , ConnectorParserConfig.getPasswordAttr()));
        setUser(ParserUtils.getStringFromAttr(hostElem
                , ConnectorParserConfig.getUserAttr()));
        setPort(ParserUtils.getIntFromAttr(hostElem
                , ConnectorParserConfig.getPortAttr()));
    }

    public void copyDbHostFromElement(Element hostElem) throws Exception{
        copyFromElement(hostElem);

        setSid(ParserUtils.getStringFromAttr(hostElem
                , ConnectorParserConfig.getSidAttr()));
    }

    public void copyDbOSHostFromElement(Element hostElem) throws Exception{
        copyFromElement(hostElem);

        setLogPath(ParserUtils.getStringFromAttr(hostElem
                , ConnectorParserConfig.getLogAttr()));
        setScriptCPUPath(ParserUtils.getStringFromAttr(hostElem
                , ConnectorParserConfig.getCpuScriptAttr()));
        setScriptMemoryPath(ParserUtils.getStringFromAttr(hostElem
                , ConnectorParserConfig.getMemoryScriptAttr()));
        setScriptDiskPath(ParserUtils.getStringFromAttr(hostElem
                , ConnectorParserConfig.getDiskScriptAttr()));
    }

    public void copyDailyAppOSHostFromElement(Element hostElem) throws Exception{
        copyFromElement(hostElem);

        setScriptCPUPath(ParserUtils.getStringFromAttr(hostElem
                , ConnectorParserConfig.getCpuScriptAttr()));
        setScriptMemoryPath(ParserUtils.getStringFromAttr(hostElem
                , ConnectorParserConfig.getMemoryScriptAttr()));
    }

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getScriptCPUPath() {
        return scriptCPUPath;
    }

    public void setScriptCPUPath(String scriptCPUPath) {
        this.scriptCPUPath = scriptCPUPath;
    }

    public String getScriptMemoryPath() {
        return scriptMemoryPath;
    }

    public void setScriptMemoryPath(String scriptMemoryPath) {
        this.scriptMemoryPath = scriptMemoryPath;
    }

    public String getScriptDiskPath() {
        return scriptDiskPath;
    }

    public void setScriptDiskPath(String scriptDiskPath) {
        this.scriptDiskPath = scriptDiskPath;
    }

    public AppHost getInspectionHost() {
        return inspectionHost;
    }

    public void setInspectionHost(AppHost inspectionHost) {
        this.inspectionHost = inspectionHost;
    }

    @Override
    public String toString() {
        return "HostConfig{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", sid='" + sid + '\'' +
                ", logPath='" + logPath + '\'' +
                ", scriptCPUPath='" + scriptCPUPath + '\'' +
                ", scriptMemoryPath='" + scriptMemoryPath + '\'' +
                ", scriptDiskPath='" + scriptDiskPath + '\'' +
                '}';
    }
}
