package org.lin.inspection.manager.scheduler;

import org.lin.inspection.manager.config.SchedulerConfig;
import org.lin.inspection.manager.utils.SchedulerType;
import org.lin.inspection.manager.utils.SchedulerUtils;
import org.suns.inspection.logger.InspectionLogger;

import java.util.Calendar;
import java.util.concurrent.*;

public class MainScheduler extends AbstractScheduler{
    @Override
    public void run() {
        try{
            if(getSetFutureCountDown() == null){
                throw new Exception("Uninitialized setFutureCountDown");
            }

            InspectionLogger.info("Main Scheduler waiting for setFutureCountDown");
            getSetFutureCountDown().await();

            ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
            CountDownLatch dailyWaitCountDown = inspectDaily(service);
            CountDownLatch weeklyWaitCountDown = inspectWeekly(service);
            CountDownLatch monthlyWaitCountDown = inspectMonthly(service);

            if(dailyWaitCountDown != null){
                InspectionLogger.info("Main scheduler waits for daily inspection");
                //dailyWaitCountDown.await();
                InspectionLogger.info("Main scheduler finishes waiting for daily inspection");
            }
            if(weeklyWaitCountDown != null){
                InspectionLogger.info("Main scheduler waits for weekly inspection");
                //weeklyWaitCountDown.await();
                InspectionLogger.info("Main scheduler finishes waiting for weekly inspection");
            }
            if(monthlyWaitCountDown != null){
                InspectionLogger.info("Main scheduler waits for monthly inspection");
                //monthlyWaitCountDown.await();
                InspectionLogger.info("Main scheduler finishes waiting for monthly inspection");
            }

            if(getMainSchedulerCountDown() == null){
                throw new Exception("Uninitialized MainSchedulerCountDown");
            }

            InspectionLogger.info("Main scheduler waking up manager");
            getMainSchedulerCountDown().countDown();

            if(getFuture() == null){
                throw new Exception("Uninitialized Future");
            }

            InspectionLogger.info("Main Scheduler finishes and kills itself");
            getFuture().cancel(true);

        }catch (Exception e){
            InspectionLogger.error("Error In Main Scheduler - "
                    + e.toString());
        }

    }

    private CountDownLatch inspectMonthly(ScheduledExecutorService service){
        try{
            CountDownLatch waitForChildCountDown = null;
            final CountDownLatch setFutureCountDown = new CountDownLatch(1);

            Calendar now = Calendar.getInstance();

            if(isLastDayOfMonth(now)){
                waitForChildCountDown = SchedulerUtils.setInspection(service
                        , setFutureCountDown, SchedulerType.MONTHLY
                        , SchedulerConfig.getMonthlyInspectionTime());

                InspectionLogger.info("Monthly Inspection " +
                        "counting down future countDown");
                setFutureCountDown.countDown();
            }

            return waitForChildCountDown;

        }catch (Exception e){
            InspectionLogger.error("Error in monthly inspection - "
                    + e.toString());
            return null;
        }
    }

    private CountDownLatch inspectWeekly(ScheduledExecutorService service){
        try{
            CountDownLatch waitForChildCountDown = null;
            final CountDownLatch setFutureCountDown = new CountDownLatch(1);

            Calendar now = Calendar.getInstance();

            if(isSunday(now)){
                waitForChildCountDown = SchedulerUtils.setInspection(service
                        , setFutureCountDown, SchedulerType.WEEKLY
                        , SchedulerConfig.getWeeklyInspectionTime());

                InspectionLogger.info("Weekly Inspection " +
                        "counting down future countDown");
                setFutureCountDown.countDown();
            }

            return waitForChildCountDown;

        }catch (Exception e){
            InspectionLogger.error("Error in weekly inspection - "
                    + e.toString());
            return null;
        }
    }

    private CountDownLatch inspectDaily(ScheduledExecutorService service){
        try{
            CountDownLatch waitForChildCountDown = null;
            final CountDownLatch setFutureCountDown = new CountDownLatch(1);

            Calendar now = Calendar.getInstance();

            if(isOneDayBeforeTaxPeriod(now)){
                waitForChildCountDown = SchedulerUtils.setInspection(service
                        , setFutureCountDown, SchedulerType.DAILY
                        , SchedulerConfig.getDailyEveInspectionTime());

                InspectionLogger.info("Daily (One day before Tax Period) " +
                        "Inspection counting down future countDown");
                setFutureCountDown.countDown();

            }else if(isInLastThreeDay(now)){
                waitForChildCountDown = SchedulerUtils.setInspection(service
                        , setFutureCountDown, SchedulerType.DAILY
                        , SchedulerConfig.getDailyLastThreeDayInspectionTime());

                InspectionLogger.info("Daily (Last three day) Inspection " +
                        "counting down future countDown");
                setFutureCountDown.countDown();

            }else if(isInTaxPeriod(now)){
                waitForChildCountDown = SchedulerUtils.setInspection(service
                        , setFutureCountDown, SchedulerType.DAILY
                        , SchedulerConfig.getDailyWithinTaxPeriodInspectionTime());

                InspectionLogger.info("Daily (In Common Tax Period) Inspection " +
                        "counting down future countDown");
                setFutureCountDown.countDown();
            }

            return waitForChildCountDown;

        }catch (Exception e){
            InspectionLogger.error("Error in daily inspection - "
                    + e.toString());
            return null;
        }
    }

    private static boolean isSunday(Calendar now){
        int dayOfWeek = now.get(Calendar.DAY_OF_WEEK) - 1;
        return dayOfWeek == 0;
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
