package org.lin.inspection.manager.config;

/**
 * Created by guanl on 7/14/2017.
 */
public class ConnectorParserConfig {
    private static String rootDirectory ="C:\\Users\\guanl\\Desktop\\Test\\";
    private static String connectorConfigXML = "ConnectorConfig.xml";

    private static String hostTag = "host";
    private static String ipAttr = "ip";
    private static String portAttr = "port";
    private static String userAttr = "user";
    private static String passwordAttr = "password";

    //Connector Config
    private static String connectorConfigRootTag = "ConnectorConfig";
    private static String timeoutTag = "sessionTimeout";
    private static String oracleTag = "oracle";
    private static String oracleDriverTag = "driver";
    private static String oracleURLTag = "url";

    //Hosts Inspection
    private static String hostsInspectionTag = "HostsInspection";
    //Hosts Inspection Config Sheet 411
    private static String sheet411Tag = "Sheet411";
    private static String sheet411CoreTag = "Core";
    private static String sheet411CoreRootDirectoryTag = "rootDirectory";
    private static String sheet411CoreSoftwareDirectoryTag = "softwareDirectory";
    private static String sheet411CoreHosts2Tag = "hosts2";
    private static String sheet411CoreHosts3Tag = "hosts3";
    private static String sheet411CoreHosts4Tag = "hosts4";
    private static String sheet411CoreHosts5Tag = "hosts5";
    private static String sheet411CoreHosts6Tag = "hosts6";
    private static String sheet411CoreHosts8Tag = "hosts8";
    private static String sheet411PersonalTag = "Personal";
    private static String sheet411PersonalRootDirectoryTag = "rootDirectory";
    private static String sheet411PersonalSoftwareDirectoryTag = "softwareDirectory";
    private static String sheet411PersonalHosts2Tag = "hosts2";
    private static String sheet411PersonalHosts3Tag = "hosts3";
    private static String sheet411PersonalHosts45Tag = "hosts45";
    
    //Hosts Inspection Config Sheet 421
    private static String sheet421Tag = "Sheet421";
    private static String sheet421CoreTag = "Core";
    private static String sheet421CoreRootDirectoryTag = "rootDirectory";
    private static String sheet421CoreSoftwareDirectoryTag = "softwareDirectory";
    private static String sheet421CoreGgsDirectoryTag = "softwareGgsDirectory";
    private static String sheet421CoreHosts2Tag = "hosts2";
    private static String sheet421CoreHosts35Tag = "hosts35";
    private static String sheet421CoreHosts4Tag = "hosts4";
    private static String sheet421PersonalTag = "Personal";
    private static String sheet421PersonalRootDirectoryTag = "rootDirectory";
    private static String sheet421PersonalSoftwareDirectoryTag = "softwareDirectory";
    private static String sheet421PersonalGgsDirectoryTag = "softwareGgsDirectory";
    private static String sheet421PersonalHosts2Tag = "hosts2";
    private static String sheet421PersonalHosts3Tag = "hosts3";
    private static String sheet421PersonalHosts45Tag = "hosts45";

    public static String getSheet421Tag() {
        return sheet421Tag;
    }

    public static void setSheet421Tag(String sheet421Tag) {
        ConnectorParserConfig.sheet421Tag = sheet421Tag;
    }

    public static String getSheet421CoreTag() {
        return sheet421CoreTag;
    }

    public static void setSheet421CoreTag(String sheet421CoreTag) {
        ConnectorParserConfig.sheet421CoreTag = sheet421CoreTag;
    }

    public static String getSheet421CoreRootDirectoryTag() {
        return sheet421CoreRootDirectoryTag;
    }

    public static void setSheet421CoreRootDirectoryTag(String sheet421CoreRootDirectoryTag) {
        ConnectorParserConfig.sheet421CoreRootDirectoryTag = sheet421CoreRootDirectoryTag;
    }

    public static String getSheet421CoreSoftwareDirectoryTag() {
        return sheet421CoreSoftwareDirectoryTag;
    }

    public static void setSheet421CoreSoftwareDirectoryTag(String sheet421CoreSoftwareDirectoryTag) {
        ConnectorParserConfig.sheet421CoreSoftwareDirectoryTag = sheet421CoreSoftwareDirectoryTag;
    }

    public static String getSheet421CoreGgsDirectoryTag() {
        return sheet421CoreGgsDirectoryTag;
    }

    public static void setSheet421CoreGgsDirectoryTag(String sheet421CoreGgsDirectoryTag) {
        ConnectorParserConfig.sheet421CoreGgsDirectoryTag = sheet421CoreGgsDirectoryTag;
    }

    public static String getSheet421CoreHosts2Tag() {
        return sheet421CoreHosts2Tag;
    }

    public static void setSheet421CoreHosts2Tag(String sheet421CoreHosts2Tag) {
        ConnectorParserConfig.sheet421CoreHosts2Tag = sheet421CoreHosts2Tag;
    }

    public static String getSheet421CoreHosts35Tag() {
        return sheet421CoreHosts35Tag;
    }

    public static void setSheet421CoreHosts35Tag(String sheet421CoreHosts35Tag) {
        ConnectorParserConfig.sheet421CoreHosts35Tag = sheet421CoreHosts35Tag;
    }

    public static String getSheet421CoreHosts4Tag() {
        return sheet421CoreHosts4Tag;
    }

    public static void setSheet421CoreHosts4Tag(String sheet421CoreHosts4Tag) {
        ConnectorParserConfig.sheet421CoreHosts4Tag = sheet421CoreHosts4Tag;
    }

    public static String getSheet421PersonalTag() {
        return sheet421PersonalTag;
    }

    public static void setSheet421PersonalTag(String sheet421PersonalTag) {
        ConnectorParserConfig.sheet421PersonalTag = sheet421PersonalTag;
    }

    public static String getSheet421PersonalRootDirectoryTag() {
        return sheet421PersonalRootDirectoryTag;
    }

    public static void setSheet421PersonalRootDirectoryTag(String sheet421PersonalRootDirectoryTag) {
        ConnectorParserConfig.sheet421PersonalRootDirectoryTag = sheet421PersonalRootDirectoryTag;
    }

    public static String getSheet421PersonalSoftwareDirectoryTag() {
        return sheet421PersonalSoftwareDirectoryTag;
    }

    public static void setSheet421PersonalSoftwareDirectoryTag(String sheet421PersonalSoftwareDirectoryTag) {
        ConnectorParserConfig.sheet421PersonalSoftwareDirectoryTag = sheet421PersonalSoftwareDirectoryTag;
    }

    public static String getSheet421PersonalGgsDirectoryTag() {
        return sheet421PersonalGgsDirectoryTag;
    }

    public static void setSheet421PersonalGgsDirectoryTag(String sheet421PersonalGgsDirectoryTag) {
        ConnectorParserConfig.sheet421PersonalGgsDirectoryTag = sheet421PersonalGgsDirectoryTag;
    }

    public static String getSheet421PersonalHosts2Tag() {
        return sheet421PersonalHosts2Tag;
    }

    public static void setSheet421PersonalHosts2Tag(String sheet421PersonalHosts2Tag) {
        ConnectorParserConfig.sheet421PersonalHosts2Tag = sheet421PersonalHosts2Tag;
    }

    public static String getSheet421PersonalHosts3Tag() {
        return sheet421PersonalHosts3Tag;
    }

    public static void setSheet421PersonalHosts3Tag(String sheet421PersonalHosts3Tag) {
        ConnectorParserConfig.sheet421PersonalHosts3Tag = sheet421PersonalHosts3Tag;
    }

    public static String getSheet421PersonalHosts45Tag() {
        return sheet421PersonalHosts45Tag;
    }

    public static void setSheet421PersonalHosts45Tag(String sheet421PersonalHosts45Tag) {
        ConnectorParserConfig.sheet421PersonalHosts45Tag = sheet421PersonalHosts45Tag;
    }

    public static String getIpAttr() {
        return ipAttr;
    }

    public static void setIpAttr(String ipAttr) {
        ConnectorParserConfig.ipAttr = ipAttr;
    }

    public static String getPortAttr() {
        return portAttr;
    }

    public static void setPortAttr(String portAttr) {
        ConnectorParserConfig.portAttr = portAttr;
    }

    public static String getUserAttr() {
        return userAttr;
    }

    public static void setUserAttr(String userAttr) {
        ConnectorParserConfig.userAttr = userAttr;
    }

    public static String getPasswordAttr() {
        return passwordAttr;
    }

    public static void setPasswordAttr(String passwordAttr) {
        ConnectorParserConfig.passwordAttr = passwordAttr;
    }

    public static String getHostTag() {
        return hostTag;
    }

    public static void setHostTag(String hostTag) {
        ConnectorParserConfig.hostTag = hostTag;
    }

    public static String getRootDirectory() {
        return rootDirectory;
    }

    public static void setRootDirectory(String rootDirectory) {
        ConnectorParserConfig.rootDirectory = rootDirectory;
    }

    public static String getConnectorConfigXML() {
        return connectorConfigXML;
    }

    public static void setConnectorConfigXML(String connectorConfigXML) {
        ConnectorParserConfig.connectorConfigXML = connectorConfigXML;
    }

    public static String getConnectorConfigRootTag() {
        return connectorConfigRootTag;
    }

    public static void setConnectorConfigRootTag(String connectorConfigRootTag) {
        ConnectorParserConfig.connectorConfigRootTag = connectorConfigRootTag;
    }

    public static String getTimeoutTag() {
        return timeoutTag;
    }

    public static void setTimeoutTag(String timeoutTag) {
        ConnectorParserConfig.timeoutTag = timeoutTag;
    }

    public static String getOracleTag() {
        return oracleTag;
    }

    public static void setOracleTag(String oracleTag) {
        ConnectorParserConfig.oracleTag = oracleTag;
    }

    public static String getOracleDriverTag() {
        return oracleDriverTag;
    }

    public static void setOracleDriverTag(String oracleDriverTag) {
        ConnectorParserConfig.oracleDriverTag = oracleDriverTag;
    }

    public static String getOracleURLTag() {
        return oracleURLTag;
    }

    public static void setOracleURLTag(String oracleURLTag) {
        ConnectorParserConfig.oracleURLTag = oracleURLTag;
    }

    public static String getHostsInspectionTag() {
        return hostsInspectionTag;
    }

    public static void setHostsInspectionTag(String hostsInspectionTag) {
        ConnectorParserConfig.hostsInspectionTag = hostsInspectionTag;
    }

    public static String getSheet411Tag() {
        return sheet411Tag;
    }

    public static void setSheet411Tag(String sheet411Tag) {
        ConnectorParserConfig.sheet411Tag = sheet411Tag;
    }

    public static String getSheet411CoreTag() {
        return sheet411CoreTag;
    }

    public static void setSheet411CoreTag(String sheet411CoreTag) {
        ConnectorParserConfig.sheet411CoreTag = sheet411CoreTag;
    }

    public static String getSheet411CoreRootDirectoryTag() {
        return sheet411CoreRootDirectoryTag;
    }

    public static void setSheet411CoreRootDirectoryTag(String sheet411CoreRootDirectoryTag) {
        ConnectorParserConfig.sheet411CoreRootDirectoryTag = sheet411CoreRootDirectoryTag;
    }

    public static String getSheet411CoreSoftwareDirectoryTag() {
        return sheet411CoreSoftwareDirectoryTag;
    }

    public static void setSheet411CoreSoftwareDirectoryTag(String sheet411CoreSoftwareDirectoryTag) {
        ConnectorParserConfig.sheet411CoreSoftwareDirectoryTag = sheet411CoreSoftwareDirectoryTag;
    }

    public static String getSheet411CoreHosts2Tag() {
        return sheet411CoreHosts2Tag;
    }

    public static void setSheet411CoreHosts2Tag(String sheet411CoreHosts2Tag) {
        ConnectorParserConfig.sheet411CoreHosts2Tag = sheet411CoreHosts2Tag;
    }

    public static String getSheet411CoreHosts3Tag() {
        return sheet411CoreHosts3Tag;
    }

    public static void setSheet411CoreHosts3Tag(String sheet411CoreHosts3Tag) {
        ConnectorParserConfig.sheet411CoreHosts3Tag = sheet411CoreHosts3Tag;
    }

    public static String getSheet411CoreHosts4Tag() {
        return sheet411CoreHosts4Tag;
    }

    public static void setSheet411CoreHosts4Tag(String sheet411CoreHosts4Tag) {
        ConnectorParserConfig.sheet411CoreHosts4Tag = sheet411CoreHosts4Tag;
    }

    public static String getSheet411CoreHosts5Tag() {
        return sheet411CoreHosts5Tag;
    }

    public static void setSheet411CoreHosts5Tag(String sheet411CoreHosts5Tag) {
        ConnectorParserConfig.sheet411CoreHosts5Tag = sheet411CoreHosts5Tag;
    }

    public static String getSheet411CoreHosts6Tag() {
        return sheet411CoreHosts6Tag;
    }

    public static void setSheet411CoreHosts6Tag(String sheet411CoreHosts6Tag) {
        ConnectorParserConfig.sheet411CoreHosts6Tag = sheet411CoreHosts6Tag;
    }

    public static String getSheet411CoreHosts8Tag() {
        return sheet411CoreHosts8Tag;
    }

    public static void setSheet411CoreHosts8Tag(String sheet411CoreHosts8Tag) {
        ConnectorParserConfig.sheet411CoreHosts8Tag = sheet411CoreHosts8Tag;
    }

    public static String getSheet411PersonalTag() {
        return sheet411PersonalTag;
    }

    public static void setSheet411PersonalTag(String sheet411PersonalTag) {
        ConnectorParserConfig.sheet411PersonalTag = sheet411PersonalTag;
    }

    public static String getSheet411PersonalRootDirectoryTag() {
        return sheet411PersonalRootDirectoryTag;
    }

    public static void setSheet411PersonalRootDirectoryTag(String sheet411PersonalRootDirectoryTag) {
        ConnectorParserConfig.sheet411PersonalRootDirectoryTag = sheet411PersonalRootDirectoryTag;
    }

    public static String getSheet411PersonalSoftwareDirectoryTag() {
        return sheet411PersonalSoftwareDirectoryTag;
    }

    public static void setSheet411PersonalSoftwareDirectoryTag(String sheet411PersonalSoftwareDirectoryTag) {
        ConnectorParserConfig.sheet411PersonalSoftwareDirectoryTag = sheet411PersonalSoftwareDirectoryTag;
    }

    public static String getSheet411PersonalHosts2Tag() {
        return sheet411PersonalHosts2Tag;
    }

    public static void setSheet411PersonalHosts2Tag(String sheet411PersonalHosts2Tag) {
        ConnectorParserConfig.sheet411PersonalHosts2Tag = sheet411PersonalHosts2Tag;
    }

    public static String getSheet411PersonalHosts3Tag() {
        return sheet411PersonalHosts3Tag;
    }

    public static void setSheet411PersonalHosts3Tag(String sheet411PersonalHosts3Tag) {
        ConnectorParserConfig.sheet411PersonalHosts3Tag = sheet411PersonalHosts3Tag;
    }

    public static String getSheet411PersonalHosts45Tag() {
        return sheet411PersonalHosts45Tag;
    }

    public static void setSheet411PersonalHosts45Tag(String sheet411PersonalHosts45Tag) {
        ConnectorParserConfig.sheet411PersonalHosts45Tag = sheet411PersonalHosts45Tag;
    }
}
