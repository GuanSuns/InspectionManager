package org.lin.monitor.manager.config;

/**
 * Created by guanl on 7/14/2017.
 */
public class ConnectorParserConfig {
    private static String rootDirectory ="config\\";
    private static String connectorConfigXML = "ConnectorConfig.xml";

    private static String serverTag = "server";
    private static String hostTag = "host";
    private static String inspectionOSHostTag = "OSInspection";
    private static String ipAttr = "ip";
    private static String portAttr = "port";
    private static String userAttr = "user";
    private static String passwordAttr = "password";
    private static String sidAttr = "sid";
    private static String logAttr = "log";
    private static String nameAttr = "name";
    private static String printedNameAttr = "printedName";
    private static String cpuScriptAttr = "cpuScript";
    private static String memoryScriptAttr = "memoryScript";
    private static String diskScriptAttr = "diskScript";

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

    //Hosts Inspection Config Sheet 428
    private static String sheet428Tag = "Sheet428";
    private static String sheet428TimeServerTag = "timeServer";
    private static String sheet428TimeCmdTag = "getTimeCMD";
    private static String sheet428CorrectReportTag = "correctReport";
    private static String sheet428DiffToleranceTag = "diffTolerance";
    private static String sheet428CoreTag = "Core";
    private static String sheet428CoreHosts1Tag = "hosts1";
    private static String sheet428CoreHosts2Tag = "hosts2";
    private static String sheet428CoreHosts34Tag = "hosts34";
    private static String sheet428PersonalTag = "Personal";
    private static String sheet428PersonalHosts1Tag = "hosts1";
    private static String sheet428PersonalHosts2Tag = "hosts2";
    private static String sheet428PersonalHosts3Tag = "hosts3";
    private static String sheet428PersonalHosts4Tag = "hosts4";

    //Connector Config
    private static String databaseInspectionConfigRootTag = "DatabaseInspection";
    private static String databaseClusterTag = "Hosts";

    //PersonalDatabase Config
    private static String dbInspectionPersonalDatabaseTag = "PersonalDatabase";
    private static String dbInspectionPersonalCoreDatabaseTag = "CoreHosts";

    //CoreDatabase Config
    private static String dbInspectionCoreDatabaseTag = "CoreDatabase";
    private static String dbInspectionCoreTaxationHostsTag = "TaxationHosts";
    private static String dbInspectionCoreIntegrationHostsTag = "IntegrationHosts";
    private static String dbInspectionCoreQueryHostsTag = "QueryHosts";

    //DfFormat Config
    private static String dfFormatTag = "DFFormat";
    private static String dfFileSystemColumnTag = "fileSystemColumn";
    private static String dfMountedSysColumnTag = "mountedSysColumn";
    private static String dfUsageColumn = "usageColumn";
    private static String linuxAttr = "linux";
    private static String aixAttr = "aix";

    public static String getRootDirectory() {
        return rootDirectory;
    }

    public static String getConnectorConfigXML() {
        return connectorConfigXML;
    }

    public static String getServerTag() {
        return serverTag;
    }

    public static String getHostTag() {
        return hostTag;
    }

    public static String getInspectionOSHostTag() {
        return inspectionOSHostTag;
    }

    public static String getIpAttr() {
        return ipAttr;
    }

    public static String getPortAttr() {
        return portAttr;
    }

    public static String getUserAttr() {
        return userAttr;
    }

    public static String getPasswordAttr() {
        return passwordAttr;
    }

    public static String getSidAttr() {
        return sidAttr;
    }

    public static String getLogAttr() {
        return logAttr;
    }

    public static String getNameAttr() {
        return nameAttr;
    }

    public static String getPrintedNameAttr() {
        return printedNameAttr;
    }

    public static String getCpuScriptAttr() {
        return cpuScriptAttr;
    }

    public static String getMemoryScriptAttr() {
        return memoryScriptAttr;
    }

    public static String getDiskScriptAttr() {
        return diskScriptAttr;
    }

    public static String getConnectorConfigRootTag() {
        return connectorConfigRootTag;
    }

    public static String getTimeoutTag() {
        return timeoutTag;
    }

    public static String getOracleTag() {
        return oracleTag;
    }

    public static String getOracleDriverTag() {
        return oracleDriverTag;
    }

    public static String getOracleURLTag() {
        return oracleURLTag;
    }

    public static String getHostsInspectionTag() {
        return hostsInspectionTag;
    }

    public static String getSheet411Tag() {
        return sheet411Tag;
    }

    public static String getSheet411CoreTag() {
        return sheet411CoreTag;
    }

    public static String getSheet411CoreRootDirectoryTag() {
        return sheet411CoreRootDirectoryTag;
    }

    public static String getSheet411CoreSoftwareDirectoryTag() {
        return sheet411CoreSoftwareDirectoryTag;
    }

    public static String getSheet411CoreHosts2Tag() {
        return sheet411CoreHosts2Tag;
    }

    public static String getSheet411CoreHosts3Tag() {
        return sheet411CoreHosts3Tag;
    }

    public static String getSheet411CoreHosts4Tag() {
        return sheet411CoreHosts4Tag;
    }

    public static String getSheet411CoreHosts5Tag() {
        return sheet411CoreHosts5Tag;
    }

    public static String getSheet411CoreHosts6Tag() {
        return sheet411CoreHosts6Tag;
    }

    public static String getSheet411CoreHosts8Tag() {
        return sheet411CoreHosts8Tag;
    }

    public static String getSheet411PersonalTag() {
        return sheet411PersonalTag;
    }

    public static String getSheet411PersonalRootDirectoryTag() {
        return sheet411PersonalRootDirectoryTag;
    }

    public static String getSheet411PersonalSoftwareDirectoryTag() {
        return sheet411PersonalSoftwareDirectoryTag;
    }

    public static String getSheet411PersonalHosts2Tag() {
        return sheet411PersonalHosts2Tag;
    }

    public static String getSheet411PersonalHosts3Tag() {
        return sheet411PersonalHosts3Tag;
    }

    public static String getSheet411PersonalHosts45Tag() {
        return sheet411PersonalHosts45Tag;
    }

    public static String getSheet421Tag() {
        return sheet421Tag;
    }

    public static String getSheet421CoreTag() {
        return sheet421CoreTag;
    }

    public static String getSheet421CoreRootDirectoryTag() {
        return sheet421CoreRootDirectoryTag;
    }

    public static String getSheet421CoreSoftwareDirectoryTag() {
        return sheet421CoreSoftwareDirectoryTag;
    }

    public static String getSheet421CoreGgsDirectoryTag() {
        return sheet421CoreGgsDirectoryTag;
    }

    public static String getSheet421CoreHosts2Tag() {
        return sheet421CoreHosts2Tag;
    }

    public static String getSheet421CoreHosts35Tag() {
        return sheet421CoreHosts35Tag;
    }

    public static String getSheet421CoreHosts4Tag() {
        return sheet421CoreHosts4Tag;
    }

    public static String getSheet421PersonalTag() {
        return sheet421PersonalTag;
    }

    public static String getSheet421PersonalRootDirectoryTag() {
        return sheet421PersonalRootDirectoryTag;
    }

    public static String getSheet421PersonalSoftwareDirectoryTag() {
        return sheet421PersonalSoftwareDirectoryTag;
    }

    public static String getSheet421PersonalGgsDirectoryTag() {
        return sheet421PersonalGgsDirectoryTag;
    }

    public static String getSheet421PersonalHosts2Tag() {
        return sheet421PersonalHosts2Tag;
    }

    public static String getSheet421PersonalHosts3Tag() {
        return sheet421PersonalHosts3Tag;
    }

    public static String getSheet421PersonalHosts45Tag() {
        return sheet421PersonalHosts45Tag;
    }

    public static String getSheet428Tag() {
        return sheet428Tag;
    }

    public static String getSheet428TimeServerTag() {
        return sheet428TimeServerTag;
    }

    public static String getSheet428TimeCmdTag() {
        return sheet428TimeCmdTag;
    }

    public static String getSheet428CorrectReportTag() {
        return sheet428CorrectReportTag;
    }

    public static String getSheet428DiffToleranceTag() {
        return sheet428DiffToleranceTag;
    }

    public static String getSheet428CoreTag() {
        return sheet428CoreTag;
    }

    public static String getSheet428CoreHosts1Tag() {
        return sheet428CoreHosts1Tag;
    }

    public static String getSheet428CoreHosts2Tag() {
        return sheet428CoreHosts2Tag;
    }

    public static String getSheet428CoreHosts34Tag() {
        return sheet428CoreHosts34Tag;
    }

    public static String getSheet428PersonalTag() {
        return sheet428PersonalTag;
    }

    public static String getSheet428PersonalHosts1Tag() {
        return sheet428PersonalHosts1Tag;
    }

    public static String getSheet428PersonalHosts2Tag() {
        return sheet428PersonalHosts2Tag;
    }

    public static String getSheet428PersonalHosts3Tag() {
        return sheet428PersonalHosts3Tag;
    }

    public static String getSheet428PersonalHosts4Tag() {
        return sheet428PersonalHosts4Tag;
    }

    public static String getDatabaseInspectionConfigRootTag() {
        return databaseInspectionConfigRootTag;
    }

    public static String getDatabaseClusterTag() {
        return databaseClusterTag;
    }

    public static String getDbInspectionPersonalDatabaseTag() {
        return dbInspectionPersonalDatabaseTag;
    }

    public static String getDbInspectionPersonalCoreDatabaseTag() {
        return dbInspectionPersonalCoreDatabaseTag;
    }

    public static String getDbInspectionCoreDatabaseTag() {
        return dbInspectionCoreDatabaseTag;
    }

    public static String getDbInspectionCoreTaxationHostsTag() {
        return dbInspectionCoreTaxationHostsTag;
    }

    public static String getDbInspectionCoreIntegrationHostsTag() {
        return dbInspectionCoreIntegrationHostsTag;
    }

    public static String getDbInspectionCoreQueryHostsTag() {
        return dbInspectionCoreQueryHostsTag;
    }

    public static String getDfFormatTag() {
        return dfFormatTag;
    }

    public static String getDfFileSystemColumnTag() {
        return dfFileSystemColumnTag;
    }

    public static String getDfMountedSysColumnTag() {
        return dfMountedSysColumnTag;
    }

    public static String getDfUsageColumn() {
        return dfUsageColumn;
    }

    public static String getLinuxAttr() {
        return linuxAttr;
    }

    public static String getAixAttr() {
        return aixAttr;
    }
}
