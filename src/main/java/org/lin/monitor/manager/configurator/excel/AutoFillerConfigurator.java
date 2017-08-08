package org.lin.monitor.manager.configurator.excel;

import excel.filler.config.ExcelConfig;
import excel.filler.config.POIConfig;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.lin.monitor.manager.parser.excel.ExcelConfigParser;

public class AutoFillerConfigurator {
    private ExcelConfigParser excelConfigParser;

    public AutoFillerConfigurator() throws Exception{
        this.excelConfigParser = new ExcelConfigParser();
    }

    public void configure() throws Exception{
        POIConfig.RootDirectory = excelConfigParser.getExcelConfig()
                .getRootDirectory();

        POIConfig.PersonalSystemFile = excelConfigParser.getExcelConfig()
                .getPersonalFile();

        POIConfig.CoreSystemFile = excelConfigParser.getExcelConfig()
                .getCoreFile();

        setProvince();
        setSheetNames();

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
    }
}
