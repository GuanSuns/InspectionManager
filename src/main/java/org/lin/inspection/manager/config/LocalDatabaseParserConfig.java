package org.lin.inspection.manager.config;

public class LocalDatabaseParserConfig {
    private static String rootDirectory ="config\\";//"C:\\Users\\guanl\\Desktop\\Test\\XML File\\";
    private static String localDatabaseConfigXML = "LocalDatabaseConfig.xml";

    private static String databaseTypeTag = "databaseType";
    private static String driverTag = "driver";
    private static String urlTag = "url";

    private static String usernameTag = "username";
    private static String passwordTag = "password";
    private static String defaultNumericNullValueTag = "defaultNumericNullValue";

    public static String getRootDirectory() {
        return rootDirectory;
    }

    public static void setRootDirectory(String rootDirectory) {
        LocalDatabaseParserConfig.rootDirectory = rootDirectory;
    }

    public static String getLocalDatabaseConfigXML() {
        return localDatabaseConfigXML;
    }

    public static void setLocalDatabaseConfigXML(String localDatabaseConfigXML) {
        LocalDatabaseParserConfig.localDatabaseConfigXML = localDatabaseConfigXML;
    }

    public static String getDatabaseTypeTag() {
        return databaseTypeTag;
    }

    public static void setDatabaseTypeTag(String databaseTypeTag) {
        LocalDatabaseParserConfig.databaseTypeTag = databaseTypeTag;
    }

    public static String getDriverTag() {
        return driverTag;
    }

    public static void setDriverTag(String driverTag) {
        LocalDatabaseParserConfig.driverTag = driverTag;
    }

    public static String getUrlTag() {
        return urlTag;
    }

    public static void setUrlTag(String urlTag) {
        LocalDatabaseParserConfig.urlTag = urlTag;
    }

    public static String getUsernameTag() {
        return usernameTag;
    }

    public static void setUsernameTag(String usernameTag) {
        LocalDatabaseParserConfig.usernameTag = usernameTag;
    }

    public static String getPasswordTag() {
        return passwordTag;
    }

    public static void setPasswordTag(String passwordTag) {
        LocalDatabaseParserConfig.passwordTag = passwordTag;
    }

    public static String getDefaultNumericNullValueTag() {
        return defaultNumericNullValueTag;
    }

    public static void setDefaultNumericNullValueTag(String defaultNumericNullValueTag) {
        LocalDatabaseParserConfig.defaultNumericNullValueTag = defaultNumericNullValueTag;
    }
}
