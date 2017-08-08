package org.lin.monitor.manager.utils;

import org.lin.monitor.manager.scheduler.AbstractScheduler;
import org.lin.monitor.manager.scheduler.DailyScheduler;
import org.lin.monitor.manager.scheduler.MonthlyScheduler;
import org.lin.monitor.manager.scheduler.WeeklyScheduler;
import org.suns.inspection.logger.InspectionLogger;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerUtils {
    public static CountDownLatch setInspection(ScheduledExecutorService service
            , CountDownLatch setFutureCountDown, SchedulerType schedulerType
            , List<Pair<Integer, Integer>> timePairs) throws Exception{
        if(timePairs == null || schedulerType == null
                || setFutureCountDown == null
                || service == null){
            throw new Exception("Uninitialized Arguments");
        }

        if(timePairs.size() == 0){
            return null;
        }

        Calendar now = Calendar.getInstance();
        CountDownLatch waitForChildCountDown = new CountDownLatch(timePairs.size());

        for(int i=0; i<timePairs.size(); i++){
            Pair<Integer, Integer> timePair = timePairs.get(i);
            Calendar executeTime = Calendar.getInstance();
            executeTime.set(Calendar.HOUR_OF_DAY, timePair.getHour());
            executeTime.set(Calendar.MINUTE, timePair.getMinute());

            AbstractScheduler scheduler = getNewScheduler(schedulerType);
            scheduler.setMainSchedulerCountDown(waitForChildCountDown);
            scheduler.setSetFutureCountDown(setFutureCountDown);

            if(executeTime.after(now)){
                InspectionLogger.info("Inspection scheduler creating "
                        + schedulerType.name() +  " inspection future at "
                        + executeTime.get(Calendar.HOUR_OF_DAY) + " : "
                        + executeTime.get(Calendar.MINUTE));

                Future future = service.scheduleAtFixedRate(scheduler
                        , executeTime.getTimeInMillis() - now.getTimeInMillis()
                        , 6000*1000, TimeUnit.MILLISECONDS);

                InspectionLogger.info(schedulerType.name()
                        + " inspection setting future");
                scheduler.setFuture(future);
            }
        }

        return waitForChildCountDown;
    }

    private static AbstractScheduler getNewScheduler(SchedulerType schedulerType){
        switch (schedulerType){
            case DAILY:
                return new DailyScheduler();
            case WEEKLY:
                return new WeeklyScheduler();
            case MONTHLY:
                return new MonthlyScheduler();
            default:
                return new MonthlyScheduler();
        }
    }
}
