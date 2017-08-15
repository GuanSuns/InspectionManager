package org.lin.monitor.manager.configurator.scheduler;

import excel.filler.config.DailyAppExcelConfig;
import excel.filler.config.DailyDBExcelConfig;
import org.lin.monitor.manager.config.SchedulerConfig;
import org.lin.monitor.manager.parser.scheduler.SchedulerConfigParser;
import org.lin.monitor.manager.utils.Pair;

import java.util.ArrayList;
import java.util.Calendar;

public class SchedulerConfigurator {
    private SchedulerConfigParser schedulerConfigParser;

    public SchedulerConfigurator() throws Exception{
        this.schedulerConfigParser = new SchedulerConfigParser();
    }

    public void configure() throws Exception{
        SchedulerConfig.setRunTimeMM(schedulerConfigParser.getRunTimeMM());
        SchedulerConfig.setRunTimeHH(schedulerConfigParser.getRunTimeHH());
        SchedulerConfig.setTaxLastDayJan(schedulerConfigParser.getLastDayJan());
        SchedulerConfig.setTaxLastDayFeb(schedulerConfigParser.getLastDayFeb());
        SchedulerConfig.setTaxLastDayMar(schedulerConfigParser.getLastDayMar());
        SchedulerConfig.setTaxLastDayApr(schedulerConfigParser.getLastDayApr());
        SchedulerConfig.setTaxLastDayMay(schedulerConfigParser.getLastDayMay());
        SchedulerConfig.setTaxLastDayJun(schedulerConfigParser.getLastDayJun());
        SchedulerConfig.setTaxLastDayJul(schedulerConfigParser.getLastDayJul());
        SchedulerConfig.setTaxLastDayAug(schedulerConfigParser.getLastDayAug());
        SchedulerConfig.setTaxLastDaySep(schedulerConfigParser.getLastDaySep());
        SchedulerConfig.setTaxLastDayOct(schedulerConfigParser.getLastDayOct());
        SchedulerConfig.setTaxLastDayNov(schedulerConfigParser.getLastDayNov());
        SchedulerConfig.setTaxLastDayDec(schedulerConfigParser.getLastDayDec());

        SchedulerConfig.setDailyEveInspectionTime(schedulerConfigParser
                .getDailyEveTaxPeriodTime());
        SchedulerConfig.setDailyLastThreeDayInspectionTime(schedulerConfigParser
                .getDailyLastThreeDayTime());
        SchedulerConfig.setDailyWithinTaxPeriodInspectionTime(schedulerConfigParser
                .getDailyWithinTaxPeriodTime());
        SchedulerConfig.setWeeklyInspectionTime(schedulerConfigParser
                .getWeeklyInspectionTime());
        SchedulerConfig.setMonthlyInspectionTime(schedulerConfigParser
                .getMonthlyInspectionTime());

        setDailyInspectionTime();
    }

    private void setDailyInspectionTime() throws Exception{
        DailyAppExcelConfig.setInspectTimes(timePairArrayToCalendarArray(schedulerConfigParser
                .getDailyWithinTaxPeriodTime()));

        DailyDBExcelConfig.setInspectTimes(timePairArrayToCalendarArray(schedulerConfigParser
                .getDailyWithinTaxPeriodTime()));
    }

    private Calendar[] timePairArrayToCalendarArray(ArrayList<Pair<Integer, Integer>> timePairs){
        Calendar[] calendars = new Calendar[timePairs.size()];
        for(int i=0; i<timePairs.size(); i++){
            calendars[i] = timePairToCalendar(timePairs.get(i));
        }
        return calendars;
    }

    private Calendar timePairToCalendar(Pair<Integer, Integer> timePair){
        Calendar time = Calendar.getInstance();
        time.set(Calendar.HOUR_OF_DAY, timePair.getHour());
        time.set(Calendar.MINUTE, timePair.getMinute());
        return time;
    }
}
