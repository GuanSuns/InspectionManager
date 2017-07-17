package org.lin.inspection.manager.parser.connector;

import org.jdom.Element;
import org.lin.inspection.manager.config.ConnectorParserConfig;

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

    public void copyFromElement(Element hostElem) throws Exception{
        String ip = hostElem.getAttributeValue(ConnectorParserConfig.getIpAttr());
        if(ip == null || ip.equals("")){
            throw new Exception("Missing attribute ip");
        }

        String user = hostElem.getAttributeValue(ConnectorParserConfig.getUserAttr());
        if(user == null || user.equals("")){
            throw new Exception("Missing attribute user");
        }

        String password = hostElem.getAttributeValue(ConnectorParserConfig.getPasswordAttr());
        if(password == null || password.equals("")){
            throw new Exception("Missing attribute password");
        }

        String port = hostElem.getAttributeValue(ConnectorParserConfig.getPortAttr());
        if(port == null || port.equals("")){
            throw new Exception("Missing attribute port");
        }

        setIp(ip);
        setPassword(password);
        setUser(user);
        setPort(Integer.valueOf(port));
    }

    public void copyDbHostFromElement(Element hostElem) throws Exception{
        copyFromElement(hostElem);

        String sid = hostElem.getAttributeValue(ConnectorParserConfig.getSidAttr());
        if(sid == null || sid.equals("")){
            throw new Exception("Missing attribute sid");
        }

        String logPath = hostElem.getAttributeValue(ConnectorParserConfig.getLogAttr());
        if(logPath == null || logPath.equals("")){
            throw new Exception("Missing attribute log");
        }

        setLogPath(logPath);
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

    @Override
    public String toString() {
        return "HostConfig{" +
                "ip='" + ip +
                ", port=" + port +
                ", user='" + user +
                ", password='" + password +
                '}';
    }
}
