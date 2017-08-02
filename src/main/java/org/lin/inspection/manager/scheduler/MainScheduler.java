package org.lin.inspection.manager.scheduler;

import org.apache.poi.ss.formula.functions.Count;
import org.lin.inspection.manager.config.SchedulerConfig;
import org.suns.inspection.logger.InspectionLogger;

import java.util.Calendar;
import java.util.concurrent.*;

public class MainScheduler implements Runnable{
    @Override
    public void run() {
        try{
            ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
            CountDownLatch dailyWaitCountDown = inspectDaily(service);


            if(dailyWaitCountDown != null){
                dailyWaitCountDown.await();
            }
        }catch (Exception e){
            InspectionLogger.error("Error In Main Scheduler - "
                    + e.toString());
        }

    }

    private CountDownLatch inspectWeekly(ScheduledExecutorService service){
        try{

        }catch (Exception e){

        }
        return null;
    }

    private CountDownLatch inspectDaily(ScheduledExecutorService service){
        try{
            CountDownLatch waitForChildCountDown = null;
            final CountDownLatch setFutureCountDown = new CountDownLatch(1);
            Calendar now = Calendar.getInstance();
            if(isOneDayBeforeTaxPeriod(now)){
                waitForChildCountDown = new CountDownLatch(1);
                Calendar executeTime = Calendar.getInstance();
                executeTime.set(Calendar.HOUR_OF_DAY, 22);
                executeTime.set(Calendar.MINUTE, 0);

                DailyScheduler dailyScheduler = new DailyScheduler();
                dailyScheduler.setMainSchedulerCountDown(waitForChildCountDown);
                dailyScheduler.setSetFutureCountDown(setFutureCountDown);
                if(executeTime.after(now)){
                    InspectionLogger.info("Daily Inspection creating daily inspection future");
                    Future future = service.scheduleAtFixedRate(dailyScheduler
                            , executeTime.getTimeInMillis() - now.getTimeInMillis()
                            , 600*1000, TimeUnit.MILLISECONDS);

                    dailyScheduler.setFuture(future);
                    InspectionLogger.info("Daily Inspection counting down future countDown");
                    setFutureCountDown.countDown();
                }
            }else if(isInLastThreeDay(now)){
                waitForChildCountDown = new CountDownLatch(3);

                Calendar executeTime = Calendar.getInstance();
                executeTime.set(Calendar.HOUR_OF_DAY, 8);
                executeTime.set(Calendar.MINUTE, 0);

                DailyScheduler dailyScheduler1 = new DailyScheduler();
                dailyScheduler1.setMainSchedulerCountDown(waitForChildCountDown);
                dailyScheduler1.setSetFutureCountDown(setFutureCountDown);
                if(executeTime.after(now)){
                    InspectionLogger.info("Daily Inspection creating daily inspection future");
                    Future future = service.scheduleAtFixedRate(dailyScheduler1
                            , executeTime.getTimeInMillis() - now.getTimeInMillis()
                            , 600*1000, TimeUnit.MILLISECONDS);

                    dailyScheduler1.setFuture(future);
                }

                executeTime.set(Calendar.HOUR_OF_DAY, 11);
                executeTime.set(Calendar.MINUTE, 0);

                DailyScheduler dailyScheduler2 = new DailyScheduler();
                dailyScheduler2.setMainSchedulerCountDown(waitForChildCountDown);
                dailyScheduler2.setSetFutureCountDown(setFutureCountDown);
                if(executeTime.after(now)){
                    InspectionLogger.info("Daily Inspection creating daily inspection future");
                    Future future = service.scheduleAtFixedRate(dailyScheduler2
                            , executeTime.getTimeInMillis() - now.getTimeInMillis()
                            , 600*1000, TimeUnit.MILLISECONDS);

                    dailyScheduler2.setFuture(future);
                }

                executeTime.set(Calendar.HOUR_OF_DAY, 17);
                executeTime.set(Calendar.MINUTE, 0);

                DailyScheduler dailyScheduler3 = new DailyScheduler();
                dailyScheduler3.setMainSchedulerCountDown(waitForChildCountDown);
                dailyScheduler3.setSetFutureCountDown(setFutureCountDown);
                if(executeTime.after(now)){
                    InspectionLogger.info("Daily Inspection creating daily inspection future");
                    Future future = service.scheduleAtFixedRate(dailyScheduler3
                            , executeTime.getTimeInMillis() - now.getTimeInMillis()
                            , 600*1000, TimeUnit.MILLISECONDS);

                    dailyScheduler3.setFuture(future);
                }

                InspectionLogger.info("Daily Inspection counting down future countDown");
                setFutureCountDown.countDown();
            }else if(isInTaxPeriod(now)){
                waitForChildCountDown = new CountDownLatch(3);

                Calendar executeTime = Calendar.getInstance();
                executeTime.set(Calendar.HOUR_OF_DAY, 6);
                executeTime.set(Calendar.MINUTE, 30);

                DailyScheduler dailyScheduler1 = new DailyScheduler();
                dailyScheduler1.setMainSchedulerCountDown(waitForChildCountDown);
                dailyScheduler1.setSetFutureCountDown(setFutureCountDown);
                if(executeTime.after(now)){
                    InspectionLogger.info("Daily Inspection creating daily inspection future");
                    Future future = service.scheduleAtFixedRate(dailyScheduler1
                            , executeTime.getTimeInMillis() - now.getTimeInMillis()
                            , 600*1000, TimeUnit.MILLISECONDS);

                    dailyScheduler1.setFuture(future);
                }

                executeTime.set(Calendar.HOUR_OF_DAY, 11);
                executeTime.set(Calendar.MINUTE, 0);

                DailyScheduler dailyScheduler2 = new DailyScheduler();
                dailyScheduler2.setMainSchedulerCountDown(waitForChildCountDown);
                dailyScheduler2.setSetFutureCountDown(setFutureCountDown);
                if(executeTime.after(now)){
                    InspectionLogger.info("Daily Inspection creating daily inspection future");
                    Future future = service.scheduleAtFixedRate(dailyScheduler2
                            , executeTime.getTimeInMillis() - now.getTimeInMillis()
                            , 600*1000, TimeUnit.MILLISECONDS);

                    dailyScheduler2.setFuture(future);
                }

                executeTime.set(Calendar.HOUR_OF_DAY, 22);
                executeTime.set(Calendar.MINUTE, 0);

                DailyScheduler dailyScheduler3 = new DailyScheduler();
                dailyScheduler3.setMainSchedulerCountDown(waitForChildCountDown);
                dailyScheduler3.setSetFutureCountDown(setFutureCountDown);
                if(executeTime.after(now)){
                    InspectionLogger.info("Daily Inspection creating daily inspection future");
                    Future future = service.scheduleAtFixedRate(dailyScheduler3
                            , executeTime.getTimeInMillis() - now.getTimeInMillis()
                            , 600*1000, TimeUnit.MILLISECONDS);

                    dailyScheduler3.setFuture(future);
                }

                InspectionLogger.info("Daily Inspection counting down future countDown");
                setFutureCountDown.countDown();
            }

            return waitForChildCountDown;

        }catch (Exception e){
            InspectionLogger.error("Error in daily inspection - "
                    + e.toString());
            return null;
        }
    }

    private static boolean isInTaxPeriod(Calendar now){
        int day = now.get(Calendar.DAY_OF_MONTH);
        int lastDay = getLastTaxDay(now);
        return day <= lastDay;
    }

    private static boolean isInLastThreeDay(Calendar now){
        int day = now.get(Calendar.DAY_OF_MONTH);
        int lastDay = getLastTaxDay(now);
        return (day <= lastDay && day >= lastDay-2);
    }

    private static boolean isOneDayBeforeTaxPeriod(Calendar now){
        return isLastDayOfMonth(now);
    }

    private static boolean isLastDayOfMonth(Calendar now){
        int day = now.get(Calendar.DAY_OF_MONTH);
        int month = now.get(Calendar.MONTH);
        switch (month){
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return day == 31;
            case 1:
            case 3:
            case 5:
            case 8:
            case 10:
                return day == 30;
        }

        return false;
    }

    private static int getLastTaxDay(Calendar now) {
        int month = now.get(Calendar.MONTH);
        switch (month){
            case 0:
                return SchedulerConfig.getTaxLastDayJan();
            case 1:
                return SchedulerConfig.getTaxLastDayFeb();
            case 2:
                return SchedulerConfig.getTaxLastDayMar();
            case 3:
                return SchedulerConfig.getTaxLastDayApr();
            case 4:
                return SchedulerConfig.getTaxLastDayMay();
            case 5:
                return SchedulerConfig.getTaxLastDayJun();
            case 6:
                return SchedulerConfig.getTaxLastDayJul();
            case 7:
                return SchedulerConfig.getTaxLastDayAug();
            case 8:
                return SchedulerConfig.getTaxLastDaySep();
            case 9:
                return SchedulerConfig.getTaxLastDayOct();
            case 10:
                return SchedulerConfig.getTaxLastDayNov();
            case 11:
                return SchedulerConfig.getTaxLastDayDec();
            default:
                return 1;
        }
    }
}
