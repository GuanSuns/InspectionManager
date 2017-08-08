package org.lin.monitor.manager.config;

import org.lin.monitor.manager.utils.Pair;

import java.util.ArrayList;

public class SchedulerConfig {
    private static int runTimeHH = 0;
    private static int runTimeMM = 5;
    private static int taxLastDayJan = 18;
    private static int taxLastDayFeb = 15;
    private static int taxLastDayMar = 15;
    private static int taxLastDayApr = 19;
    private static int taxLastDayMay = 15;
    private static int taxLastDayJun = 15;
    private static int taxLastDayJul =  17;
    private static int taxLastDayAug = 15;
    private static int taxLastDaySep = 15;
    private static int taxLastDayOct = 23;
    private static int taxLastDayNov = 15;
    private static int taxLastDayDec = 15;

    private static ArrayList<Pair<Integer, Integer>> dailyEveInspectionTime
            = new ArrayList<>(0);
    private static ArrayList<Pair<Integer, Integer>> dailyLastThreeDayInspectionTime
            = new ArrayList<>(0);
    private static ArrayList<Pair<Integer, Integer>> dailyWithinTaxPeriodInspectionTime
            = new ArrayList<>(0);
    private static ArrayList<Pair<Integer, Integer>> weeklyInspectionTime
            = new ArrayList<>(0);
    private static ArrayList<Pair<Integer, Integer>> monthlyInspectionTime
            = new ArrayList<>(0);


    private static String runTimeTag = "SchedulerRunTime";
    private static String rootTag = "SchedulerConfig";
    private static String rootDirectory ="config\\";
    private static String schedulerConfigXML = "SchedulerConfig.xml";

    private static String janTag = "Jan";
    private static String febTag = "Feb";
    private static String marTag = "Mar";
    private static String aprTag = "Apr";
    private static String mayTag = "May";
    private static String junTag = "Jun";
    private static String julTag = "Jul";
    private static String augTag = "Aug";
    private static String sepTag = "Sep";
    private static String octTag = "Oct";
    private static String novTag = "Nov";
    private static String decTag = "Dec";

    private static String dayAttr = "dd";
    private static String hourAttr = "HH";
    private static String minuteAttr = "mm";

    private static String dailyInspectionTag = "DailyInspection";
    private static String eveOfTaxPeriodTag = "EveOfTaxPeriod";
    private static String lastThreeDayTag = "LastThreeDay";
    private static String withinTaxPeriodTag = "WithinTaxPeriod";
    private static String monthlyInspectionTag = "MonthlyInspection";
    private static String weeklyInspectionTag = "WeeklyInspection";
    private static String timeTag = "time";

    public static ArrayList<Pair<Integer, Integer>> getDailyEveInspectionTime() {
        return dailyEveInspectionTime;
    }

    public static void setDailyEveInspectionTime(ArrayList<Pair<Integer, Integer>> dailyEveInspectionTime) {
        SchedulerConfig.dailyEveInspectionTime = dailyEveInspectionTime;
    }

    public static ArrayList<Pair<Integer, Integer>> getDailyLastThreeDayInspectionTime() {
        return dailyLastThreeDayInspectionTime;
    }

    public static void setDailyLastThreeDayInspectionTime(ArrayList<Pair<Integer, Integer>> dailyLastThreeDayInspectionTime) {
        SchedulerConfig.dailyLastThreeDayInspectionTime = dailyLastThreeDayInspectionTime;
    }

    public static ArrayList<Pair<Integer, Integer>> getDailyWithinTaxPeriodInspectionTime() {
        return dailyWithinTaxPeriodInspectionTime;
    }

    public static void setDailyWithinTaxPeriodInspectionTime(ArrayList<Pair<Integer, Integer>> dailyWithinTaxPeriodInspectionTime) {
        SchedulerConfig.dailyWithinTaxPeriodInspectionTime = dailyWithinTaxPeriodInspectionTime;
    }

    public static ArrayList<Pair<Integer, Integer>> getWeeklyInspectionTime() {
        return weeklyInspectionTime;
    }

    public static void setWeeklyInspectionTime(ArrayList<Pair<Integer, Integer>> weeklyInspectionTime) {
        SchedulerConfig.weeklyInspectionTime = weeklyInspectionTime;
    }

    public static ArrayList<Pair<Integer, Integer>> getMonthlyInspectionTime() {
        return monthlyInspectionTime;
    }

    public static void setMonthlyInspectionTime(ArrayList<Pair<Integer, Integer>> monthlyInspectionTime) {
        SchedulerConfig.monthlyInspectionTime = monthlyInspectionTime;
    }

    public static String getDailyInspectionTag() {
        return dailyInspectionTag;
    }

    public static void setDailyInspectionTag(String dailyInspectionTag) {
        SchedulerConfig.dailyInspectionTag = dailyInspectionTag;
    }

    public static String getEveOfTaxPeriodTag() {
        return eveOfTaxPeriodTag;
    }

    public static void setEveOfTaxPeriodTag(String eveOfTaxPeriodTag) {
        SchedulerConfig.eveOfTaxPeriodTag = eveOfTaxPeriodTag;
    }

    public static String getLastThreeDayTag() {
        return lastThreeDayTag;
    }

    public static void setLastThreeDayTag(String lastThreeDayTag) {
        SchedulerConfig.lastThreeDayTag = lastThreeDayTag;
    }

    public static String getWithinTaxPeriodTag() {
        return withinTaxPeriodTag;
    }

    public static void setWithinTaxPeriodTag(String withinTaxPeriodTag) {
        SchedulerConfig.withinTaxPeriodTag = withinTaxPeriodTag;
    }

    public static String getMonthlyInspectionTag() {
        return monthlyInspectionTag;
    }

    public static void setMonthlyInspectionTag(String monthlyInspectionTag) {
        SchedulerConfig.monthlyInspectionTag = monthlyInspectionTag;
    }

    public static String getWeeklyInspectionTag() {
        return weeklyInspectionTag;
    }

    public static void setWeeklyInspectionTag(String weeklyInspectionTag) {
        SchedulerConfig.weeklyInspectionTag = weeklyInspectionTag;
    }

    public static String getTimeTag() {
        return timeTag;
    }

    public static void setTimeTag(String timeTag) {
        SchedulerConfig.timeTag = timeTag;
    }

    public static String getRootDirectory() {
        return rootDirectory;
    }

    public static void setRootDirectory(String rootDirectory) {
        SchedulerConfig.rootDirectory = rootDirectory;
    }

    public static String getSchedulerConfigXML() {
        return schedulerConfigXML;
    }

    public static void setSchedulerConfigXML(String schedulerConfigXML) {
        SchedulerConfig.schedulerConfigXML = schedulerConfigXML;
    }

    public static String getRootTag() {
        return rootTag;
    }

    public static void setRootTag(String rootTag) {
        SchedulerConfig.rootTag = rootTag;
    }

    public static String getRunTimeTag() {
        return runTimeTag;
    }

    public static void setRunTimeTag(String runTimeTag) {
        SchedulerConfig.runTimeTag = runTimeTag;
    }

    public static String getJanTag() {
        return janTag;
    }

    public static void setJanTag(String janTag) {
        SchedulerConfig.janTag = janTag;
    }

    public static String getFebTag() {
        return febTag;
    }

    public static void setFebTag(String febTag) {
        SchedulerConfig.febTag = febTag;
    }

    public static String getMarTag() {
        return marTag;
    }

    public static void setMarTag(String marTag) {
        SchedulerConfig.marTag = marTag;
    }

    public static String getAprTag() {
        return aprTag;
    }

    public static void setAprTag(String aprTag) {
        SchedulerConfig.aprTag = aprTag;
    }

    public static String getMayTag() {
        return mayTag;
    }

    public static void setMayTag(String mayTag) {
        SchedulerConfig.mayTag = mayTag;
    }

    public static String getJunTag() {
        return junTag;
    }

    public static void setJunTag(String junTag) {
        SchedulerConfig.junTag = junTag;
    }

    public static String getJulTag() {
        return julTag;
    }

    public static void setJulTag(String julTag) {
        SchedulerConfig.julTag = julTag;
    }

    public static String getAugTag() {
        return augTag;
    }

    public static void setAugTag(String augTag) {
        SchedulerConfig.augTag = augTag;
    }

    public static String getSepTag() {
        return sepTag;
    }

    public static void setSepTag(String sepTag) {
        SchedulerConfig.sepTag = sepTag;
    }

    public static String getOctTag() {
        return octTag;
    }

    public static void setOctTag(String octTag) {
        SchedulerConfig.octTag = octTag;
    }

    public static String getNovTag() {
        return novTag;
    }

    public static void setNovTag(String novTag) {
        SchedulerConfig.novTag = novTag;
    }

    public static String getDecTag() {
        return decTag;
    }

    public static void setDecTag(String decTag) {
        SchedulerConfig.decTag = decTag;
    }

    public static String getDayAttr() {
        return dayAttr;
    }

    public static void setDayAttr(String dayAttr) {
        SchedulerConfig.dayAttr = dayAttr;
    }

    public static String getHourAttr() {
        return hourAttr;
    }

    public static void setHourAttr(String hourAttr) {
        SchedulerConfig.hourAttr = hourAttr;
    }

    public static String getMinuteAttr() {
        return minuteAttr;
    }

    public static void setMinuteAttr(String minuteAttr) {
        SchedulerConfig.minuteAttr = minuteAttr;
    }

    public static int getRunTimeHH() {
        return runTimeHH;
    }

    public static void setRunTimeHH(int runTimeHH) {
        SchedulerConfig.runTimeHH = runTimeHH;
    }

    public static int getRunTimeMM() {
        return runTimeMM;
    }

    public static void setRunTimeMM(int runTimeMM) {
        SchedulerConfig.runTimeMM = runTimeMM;
    }

    public static int getTaxLastDayJan() {
        return taxLastDayJan;
    }

    public static void setTaxLastDayJan(int taxLastDayJan) {
        SchedulerConfig.taxLastDayJan = taxLastDayJan;
    }

    public static int getTaxLastDayFeb() {
        return taxLastDayFeb;
    }

    public static void setTaxLastDayFeb(int taxLastDayFeb) {
        SchedulerConfig.taxLastDayFeb = taxLastDayFeb;
    }

    public static int getTaxLastDayMar() {
        return taxLastDayMar;
    }

    public static void setTaxLastDayMar(int taxLastDayMar) {
        SchedulerConfig.taxLastDayMar = taxLastDayMar;
    }

    public static int getTaxLastDayApr() {
        return taxLastDayApr;
    }

    public static void setTaxLastDayApr(int taxLastDayApr) {
        SchedulerConfig.taxLastDayApr = taxLastDayApr;
    }

    public static int getTaxLastDayMay() {
        return taxLastDayMay;
    }

    public static void setTaxLastDayMay(int taxLastDayMay) {
        SchedulerConfig.taxLastDayMay = taxLastDayMay;
    }

    public static int getTaxLastDayJun() {
        return taxLastDayJun;
    }

    public static void setTaxLastDayJun(int taxLastDayJun) {
        SchedulerConfig.taxLastDayJun = taxLastDayJun;
    }

    public static int getTaxLastDayJul() {
        return taxLastDayJul;
    }

    public static void setTaxLastDayJul(int taxLastDayJul) {
        SchedulerConfig.taxLastDayJul = taxLastDayJul;
    }

    public static int getTaxLastDayAug() {
        return taxLastDayAug;
    }

    public static void setTaxLastDayAug(int taxLastDayAug) {
        SchedulerConfig.taxLastDayAug = taxLastDayAug;
    }

    public static int getTaxLastDaySep() {
        return taxLastDaySep;
    }

    public static void setTaxLastDaySep(int taxLastDaySep) {
        SchedulerConfig.taxLastDaySep = taxLastDaySep;
    }

    public static int getTaxLastDayOct() {
        return taxLastDayOct;
    }

    public static void setTaxLastDayOct(int taxLastDayOct) {
        SchedulerConfig.taxLastDayOct = taxLastDayOct;
    }

    public static int getTaxLastDayNov() {
        return taxLastDayNov;
    }

    public static void setTaxLastDayNov(int taxLastDayNov) {
        SchedulerConfig.taxLastDayNov = taxLastDayNov;
    }

    public static int getTaxLastDayDec() {
        return taxLastDayDec;
    }

    public static void setTaxLastDayDec(int taxLastDayDec) {
        SchedulerConfig.taxLastDayDec = taxLastDayDec;
    }
}
