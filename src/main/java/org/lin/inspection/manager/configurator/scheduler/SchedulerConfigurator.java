package org.lin.inspection.manager.configurator.scheduler;

import org.lin.inspection.manager.config.SchedulerConfig;
import org.lin.inspection.manager.parser.scheduler.SchedulerConfigParser;

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
    }
}