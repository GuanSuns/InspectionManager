package org.lin.monitor.manager.config;

public class DailyAppParserConfig {
    private static String PersonalAppInspectionTag = "PersonalAppInspection";
    private static String CoreAppInspectionTag = "CoreAppInspection";

    private static String webLogicServerTag = "WebLogicServer";
    private static String clusterTag = "cluster";
    private static String hostTag = "host";

    public static String getPersonalAppInspectionTag() {
        return PersonalAppInspectionTag;
    }

    public static void setPersonalAppInspectionTag(String personalAppInspectionTag) {
        PersonalAppInspectionTag = personalAppInspectionTag;
    }

    public static String getCoreAppInspectionTag() {
        return CoreAppInspectionTag;
    }

    public static void setCoreAppInspectionTag(String coreAppInspectionTag) {
        CoreAppInspectionTag = coreAppInspectionTag;
    }

    public static String getWebLogicServerTag() {
        return webLogicServerTag;
    }

    public static void setWebLogicServerTag(String webLogicServerTag) {
        DailyAppParserConfig.webLogicServerTag = webLogicServerTag;
    }

    public static String getClusterTag() {
        return clusterTag;
    }

    public static void setClusterTag(String clusterTag) {
        DailyAppParserConfig.clusterTag = clusterTag;
    }

    public static String getHostTag() {
        return hostTag;
    }

    public static void setHostTag(String hostTag) {
        DailyAppParserConfig.hostTag = hostTag;
    }
}
