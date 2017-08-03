package org.lin.inspection.manager.parser.scheduler;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.lin.inspection.manager.config.SchedulerConfig;
import org.lin.inspection.manager.parser.utils.ParserUtils;
import org.lin.inspection.manager.utils.Pair;

import java.util.ArrayList;

public class SchedulerConfigParser {
    private Document SchedulerConfigDoc;
    private Element rootElem;
    private Element dailyInspectionElem;

    public SchedulerConfigParser() throws Exception{
        init();
    }

    private void init() throws Exception{
        SAXBuilder builder= new SAXBuilder();
        SchedulerConfigDoc = builder.build(SchedulerConfig.getRootDirectory()
                + SchedulerConfig.getSchedulerConfigXML());
        rootElem = SchedulerConfigDoc.getRootElement();

        if(rootElem == null){
            throw new Exception("Unexpected XML Config file format: missing root element");
        }
    }

    private void initDailyInspectionElem() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        dailyInspectionElem = rootElem.getChild(SchedulerConfig.getDailyInspectionTag());
        if(dailyInspectionElem == null){
            throw new Exception("Unexpected XML Config file format: missing "
                    + SchedulerConfig.getDailyInspectionTag() + " element");
        }
    }

    public int getRunTimeHH() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        Element runTimeElem = rootElem.getChild(SchedulerConfig.getRunTimeTag());
        if(runTimeElem == null){
            throw new Exception("Unexpected XML Config file format: missing SchedulerRunTime element");
        }

        return ParserUtils.getIntFromAttr(runTimeElem, SchedulerConfig.getHourAttr());
    }
    
    public int getRunTimeMM() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        Element runTimeElem = rootElem.getChild(SchedulerConfig.getRunTimeTag());
        if(runTimeElem == null){
            throw new Exception("Unexpected XML Config file format: missing SchedulerRunTime element");
        }

        return ParserUtils.getIntFromAttr(runTimeElem, SchedulerConfig.getMinuteAttr());
    }
    
    public int getLastDayJan() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }
        
        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getJanTag());
    }

    public int getLastDayFeb() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getFebTag());
    }

    public int getLastDayMar() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getMarTag());
    }

    public int getLastDayApr() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getAprTag());
    }

    public int getLastDayMay() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getMayTag());
    }

    public int getLastDayJun() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getJunTag());
    }

    public int getLastDayJul() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getJulTag());
    }

    public int getLastDayAug() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getAugTag());
    }

    public int getLastDaySep() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getSepTag());
    }

    public int getLastDayOct() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getOctTag());
    }

    public int getLastDayNov() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getNovTag());
    }

    public int getLastDayDec() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getDecTag());
    }

    public ArrayList<Pair<Integer, Integer>> getDailyEveTaxPeriodTime() throws Exception {
        if (dailyInspectionElem == null) {
            initDailyInspectionElem();
        }

        Element eveOfTaxPeriodElem = dailyInspectionElem
                .getChild(SchedulerConfig.getEveOfTaxPeriodTag());
        if (eveOfTaxPeriodElem == null) {
            throw new Exception("Unexpected XML Config file format: missing element "
                    + SchedulerConfig.getEveOfTaxPeriodTag());
        }

        return ParserUtils.extractTimeArrayFromElem(eveOfTaxPeriodElem
                , SchedulerConfig.getTimeTag());
    }

    public ArrayList<Pair<Integer, Integer>> getDailyLastThreeDayTime() throws Exception {
        if (dailyInspectionElem == null) {
            initDailyInspectionElem();
        }

        Element lastThreeDayElem = dailyInspectionElem
                .getChild(SchedulerConfig.getLastThreeDayTag());
        if (lastThreeDayElem == null) {
            throw new Exception("Unexpected XML Config file format: missing element "
                    + SchedulerConfig.getLastThreeDayTag());
        }

        return ParserUtils.extractTimeArrayFromElem(lastThreeDayElem
                , SchedulerConfig.getTimeTag());
    }

    public ArrayList<Pair<Integer, Integer>> getWithinTaxPeriodTime() throws Exception {
        if (dailyInspectionElem == null) {
            initDailyInspectionElem();
        }

        Element withinTaxPeriodElem = dailyInspectionElem
                .getChild(SchedulerConfig.getWithinTaxPeriodTag());
        if (withinTaxPeriodElem == null) {
            throw new Exception("Unexpected XML Config file format: missing element "
                    + SchedulerConfig.getWithinTaxPeriodTag());
        }

        return ParserUtils.extractTimeArrayFromElem(withinTaxPeriodElem
                , SchedulerConfig.getTimeTag());
    }

    public ArrayList<Pair<Integer, Integer>> getWeeklyInspectionTime() throws Exception {
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        Element weeklyInspectionElem = rootElem
                .getChild(SchedulerConfig.getWeeklyInspectionTag());
        if (weeklyInspectionElem == null) {
            throw new Exception("Unexpected XML Config file format: missing element "
                    + SchedulerConfig.getWeeklyInspectionTag());
        }

        return ParserUtils.extractTimeArrayFromElem(weeklyInspectionElem
                , SchedulerConfig.getTimeTag());
    }

    public ArrayList<Pair<Integer, Integer>> getMonthlyInspectionTime() throws Exception {
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        Element monthlyInspectionElem = rootElem
                .getChild(SchedulerConfig.getMonthlyInspectionTag());
        if (monthlyInspectionElem == null) {
            throw new Exception("Unexpected XML Config file format: missing element "
                    + SchedulerConfig.getMonthlyInspectionTag());
        }

        return ParserUtils.extractTimeArrayFromElem(monthlyInspectionElem
                , SchedulerConfig.getTimeTag());
    }
}
