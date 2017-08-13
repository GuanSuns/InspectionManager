package org.lin.monitor.manager.configurator.excel;

import excel.filler.config.DailyAppExcelConfig;
import excel.filler.config.DailyDBExcelConfig;
import excel.filler.config.ExcelConfig;
import excel.filler.config.POIConfig;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.lin.monitor.manager.parser.excel.ExcelConfigParser;
import org.suns.data.collector.config.daily.AppCoreConfig;
import org.suns.data.collector.config.daily.AppPersonalConfig;
import org.suns.data.collector.config.daily.DBCoreConfig;
import org.suns.data.collector.config.daily.DBPersonalConfig;
import org.suns.host.config.AppCluster;
import org.suns.host.config.WebLogicServer;

import java.util.ArrayList;

public class AutoFillerConfigurator {
    private ExcelConfigParser excelConfigParser;

    public AutoFillerConfigurator() throws Exception{
        this.excelConfigParser = new ExcelConfigParser();
    }

    public void configure() throws Exception{
        POIConfig.RootDirectory = excelConfigParser.getExcelConfig()
                .getRootDirectory();

        POIConfig.MonthlyPersonalFile = excelConfigParser.getExcelConfig()
                .getPersonalMonthlyFile();

        POIConfig.MonthlyCoreFile = excelConfigParser.getExcelConfig()
                .getCoreMonthlyFile();

        POIConfig.DailyCoreFile = excelConfigParser.getExcelConfig()
                .getCoreDailyFile();

        POIConfig.DailyPersonalFile = excelConfigParser.getExcelConfig()
                .getPersonalDailyFile();

        setProvince();
        setSheetNames();
        setDailyInspectionHostsInfo();

        ExcelConfig.daysRecentInstances = excelConfigParser
                .getDaysRecentInstances();

        ExcelConfig.dateFormat = excelConfigParser.getDateFormat();
        ExcelConfig.fileDateFormat = excelConfigParser.getFileDateFormat();
        ExcelConfig.nullValue = excelConfigParser.getNullValue();
        ExcelConfig.cellBorder = excelConfigParser.getCellStyle().isBorder();
        ExcelConfig.centralAlignment = excelConfigParser
                .getCellStyle().isCentralAlignment();
        ExcelConfig.font = excelConfigParser.getCellStyle().getFont();
        ExcelConfig.fontSize = (short)excelConfigParser.getCellStyle()
                .getFontSize();
        ExcelConfig.borderColor = (short)excelConfigParser
                .getCellStyle().getBorderColor();

        int borderStyleIndex = excelConfigParser.getCellStyle().getBorderStyle();
        ExcelConfig.borderStyle = BorderStyle.values()[borderStyleIndex];
    }

    private void setProvince() throws Exception{
        String province = excelConfigParser.getExcelConfig().getProvince();

        ExcelConfig.Sheet411DefaultProvince = province;
        ExcelConfig.Sheet421DefaultProvince = province;
        ExcelConfig.Sheet422DefaultProvince = province;
        ExcelConfig.Sheet423DefaultProvince = province;
        ExcelConfig.Sheet424DefaultProvince = province;
        ExcelConfig.Sheet426DefaultProvince = province;
        ExcelConfig.Sheet428DefaultProvince = province;
        ExcelConfig.Sheet429DefaultProvince = province;
    }

    private void setDailyInspectionHostsInfo() throws Exception{
        //Set Personal Daily App
        ArrayList<AppCluster> personalDailyAppClusters = getClustersFromWebLogicServers(AppPersonalConfig
                .getWebLogicServers());
        String[] personalDailyAppNames = new String[personalDailyAppClusters.size()];
        String[] personalDailyAppPrintedNames = new String[personalDailyAppClusters.size()];
        copyNamesAndPrintedNamesFromClusters(personalDailyAppClusters
                , personalDailyAppNames, personalDailyAppPrintedNames);
        DailyAppExcelConfig.setPersonalInspectClustersNames(personalDailyAppNames);
        DailyAppExcelConfig.setPersonalInspectClustersPrintedNames(personalDailyAppPrintedNames);

        //Set Core Daily App
        ArrayList<AppCluster> coreDailyAppClusters = getClustersFromWebLogicServers(AppCoreConfig
                .getWebLogicServers());
        String[] coreDailyAppNames = new String[coreDailyAppClusters.size()];
        String[] coreDailyAppPrintedNames = new String[coreDailyAppClusters.size()];
        copyNamesAndPrintedNamesFromClusters(coreDailyAppClusters
                , coreDailyAppNames, coreDailyAppPrintedNames);
        DailyAppExcelConfig.setCoreInspectClustersNames(coreDailyAppNames);
        DailyAppExcelConfig.setCoreInspectClustersPrintedNames(coreDailyAppPrintedNames);

        //Set Personal Daily DB
        ArrayList<AppCluster> personalDailyDBClusters = DBPersonalConfig
                .getClusters();
        String[] personalDailyDBNames = new String[personalDailyDBClusters.size()];
        String[] personalDailyDBPrintedNames = new String[personalDailyDBClusters.size()];
        copyNamesAndPrintedNamesFromClusters(personalDailyDBClusters
                , personalDailyDBNames, personalDailyDBPrintedNames);
        DailyDBExcelConfig.setPersonalInspectClustersNames(personalDailyDBNames);
        DailyDBExcelConfig.setPersonalInspectClustersPrintedNames(personalDailyDBPrintedNames);

        //Set Core Daily DB
        ArrayList<AppCluster> coreDailyDBClusters = DBCoreConfig
                .getClusters();
        String[] coreDailyDBNames = new String[coreDailyDBClusters.size()];
        String[] coreDailyDBPrintedNames = new String[coreDailyDBClusters.size()];
        copyNamesAndPrintedNamesFromClusters(coreDailyDBClusters
                , coreDailyDBNames, coreDailyDBPrintedNames);
        DailyDBExcelConfig.setCoreInspectClustersNames(coreDailyDBNames);
        DailyDBExcelConfig.setCoreInspectClustersPrintedNames(coreDailyDBPrintedNames);
    }

    private void setSheetNames() throws Exception{
        ExcelConfig.SheetName411 = excelConfigParser.getExcelConfig()
                .getSheetNames().getSheet411Name();

        ExcelConfig.SheetName421 = excelConfigParser.getExcelConfig()
                .getSheetNames().getSheet421Name();

        ExcelConfig.SheetName422 = excelConfigParser.getExcelConfig()
                .getSheetNames().getSheet422Name();

        ExcelConfig.SheetName423 = excelConfigParser.getExcelConfig()
                .getSheetNames().getSheet423Name();

        ExcelConfig.SheetName424 = excelConfigParser.getExcelConfig()
                .getSheetNames().getSheet424Name();

        ExcelConfig.SheetName426 = excelConfigParser.getExcelConfig()
                .getSheetNames().getSheet426Name();

        ExcelConfig.SheetName428 = excelConfigParser.getExcelConfig()
                .getSheetNames().getSheet428Name();

        ExcelConfig.SheetName429 = excelConfigParser.getExcelConfig()
                .getSheetNames().getSheet429Name();

        DailyAppExcelConfig.setSheetName(excelConfigParser.getExcelConfig()
                .getSheetNames().getSheetDailyApp());

        DailyDBExcelConfig.setSheetName(excelConfigParser.getExcelConfig()
                .getSheetNames().getSheetDailyDB());
    }

    private ArrayList<AppCluster> getClustersFromWebLogicServers(ArrayList<WebLogicServer> servers){
        ArrayList<AppCluster> clusters = new ArrayList<>();
        for(WebLogicServer webLogicServer : servers){
            clusters.addAll(webLogicServer.getClusters());
        }
        return clusters;
    }

    private void copyNamesAndPrintedNamesFromClusters(ArrayList<AppCluster> clusters
            , String[] names, String[] printedNames){
        for(int i=0; i<clusters.size(); i++){
            names[i] = clusters.get(i).getName();
            printedNames[i] = clusters.get(i).getPrintedName();
        }
    }
}
