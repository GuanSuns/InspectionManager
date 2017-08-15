package org.lin.monitor.manager;

import com.jcraft.jsch.HASH;
import excel.filler.generator.*;
import org.lin.monitor.manager.configurator.ConfigManager;
import org.lin.monitor.manager.scheduler.MainScheduler;
import org.suns.data.collector.collectors.daily.app.DailyAppCoreCollector;
import org.suns.data.collector.collectors.daily.app.DailyAppPersonalCollector;
import org.suns.data.collector.collectors.daily.database.DailyDBCoreCollector;
import org.suns.data.collector.collectors.daily.database.DailyDBPersonalCollector;
import org.suns.data.collector.collectors.sheet411.Sheet411CoreCollector;
import org.suns.data.collector.collectors.sheet411.Sheet411PersonalCollector;
import org.suns.data.collector.collectors.sheet421.Sheet421CoreCollector;
import org.suns.data.collector.collectors.sheet421.Sheet421PersonalCollector;
import org.suns.data.collector.collectors.sheet422.Sheet422CoreCollector;
import org.suns.data.collector.collectors.sheet422.Sheet422PersonalCollector;
import org.suns.data.collector.collectors.sheet423.Sheet423CoreCollector;
import org.suns.data.collector.collectors.sheet423.Sheet423PersonalCollector;
import org.suns.data.collector.collectors.sheet424.Sheet424CoreCollector;
import org.suns.data.collector.collectors.sheet424.Sheet424PersonalCollector;
import org.suns.data.collector.collectors.sheet426.Sheet426CoreCollector;
import org.suns.data.collector.collectors.sheet426.Sheet426PersonalCollector;
import org.suns.data.collector.collectors.sheet428.Sheet428CoreCollector;
import org.suns.data.collector.collectors.sheet428.Sheet428PersonalCollector;
import org.suns.data.collector.collectors.sheet429.Sheet429CoreCollector;
import org.suns.data.collector.collectors.sheet429.Sheet429PersonalCollector;
import org.suns.database.utils.controller.*;
import org.suns.inspection.logger.InspectionLogger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.*;

public class Manager {
    public static void main(String[] args) {
        try{
            ConfigManager configManager = new ConfigManager();
            configManager.configure();

            HashSet<String> argsSet = getArgsSet(args);
            if(argsSet.contains("clearAll")){
                clearAllTable();
                return;
            }

            if(argsSet.contains("debug")){
                InspectionLogger.turnOnDebug();
            }else{
                InspectionLogger.turnOffDebug();
            }

            if(argsSet.contains("daily")){
                inspectDaily();
                generateDailyExcel();
                return;
            }

            if(argsSet.contains("monthly")){
                inspectMonthly();
                generateExcelMonthly();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static HashSet<String> getArgsSet(String[] args){
        HashSet<String> argsSet = new HashSet<>();
        for(String arg: args){
            argsSet.add(arg);
        }
        return argsSet;
    }

    private static void clearAllTable() throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm");

        System.out.println("\n" + df.format(new Date())
                + " 正在清空记录数据库");

        Sheet411Controller.clearAll();
        Sheet421Controller.clearAll();
        Sheet422Controller.clearAll();
        Sheet423Controller.clearAll();
        Sheet424Controller.clearAll();
        Sheet426Controller.clearAll();
        Sheet428Controller.clearAll();
        Sheet429Controller.clearAll();
        DailyDBController.clearAll();
        DailyAppController.clearAll();
    }

    private static void inspectDaily() throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm");

        System.out.println("\n" + df.format(new Date())
                + " 核心征管系统应用检查-日巡检");
        DailyAppCoreCollector dailyAppCoreCollector = new DailyAppCoreCollector();
        dailyAppCoreCollector.inspect();

        System.out.println(df.format(new Date())
                + " 个人税收系统应用检查-日巡检");
        DailyAppPersonalCollector dailyAppPersonalCollector = new DailyAppPersonalCollector();
        dailyAppPersonalCollector.inspect();

        System.out.println(df.format(new Date())
                + " 核心征管系统数据库检查-日巡检");
        DailyDBCoreCollector dailyDBCoreCollector = new DailyDBCoreCollector();
        dailyDBCoreCollector.inspect();

        System.out.println(df.format(new Date())
                + " 个人税收系统数据库检查-日巡检");
        DailyDBPersonalCollector dailyDBPersonalCollector = new DailyDBPersonalCollector();
        dailyDBPersonalCollector.inspect();
    }

    private static void generateDailyExcel() throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm");

        System.out.println("\n" + df.format(new Date())
                + " 填写Excel表格: 个人税收系统应用检查日表");
        DailyAppExcelGenerator.generatePersonal();
        System.out.println(df.format(new Date())
                + " 填写Excel表格: 核心征管系统应用检查日表");
        DailyAppExcelGenerator.generateCore();

        System.out.println(df.format(new Date())
                + " 填写Excel表格: 个人税收系统数据库检查日表");
        DailyDBExcelGenerator.generatePersonal();
        System.out.println(df.format(new Date())
                + " 填写Excel表格: 核心征管系统数据库检查日表");
        DailyDBExcelGenerator.generateCore();
    }


    private static void inspectMonthly() throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm");

        System.out.println("\n" + df.format(new Date())
                + " 个人税收系统月巡检: 4.1.1 应用OS文件系统使用率检查");
        Sheet411PersonalCollector sheet411PersonalCollector
                = new Sheet411PersonalCollector();
        sheet411PersonalCollector.inspect();
        System.out.println(df.format(new Date())
                + " 核心征管系统月巡检: 4.1.1 应用OS文件系统使用率检查");
        Sheet411CoreCollector sheet411CoreCollector
                = new Sheet411CoreCollector();
        sheet411CoreCollector.inspect();

        System.out.println(df.format(new Date())
                + " 个人税收系统月巡检: 4.2.1 数据库OS文件系统目录使用率检查");
        Sheet421PersonalCollector sheet421PersonalCollector
                = new Sheet421PersonalCollector();
        sheet421PersonalCollector.inspect();
        System.out.println(df.format(new Date())
                + " 核心征管系统月巡检: 4.2.1 数据库OS文件系统目录使用率检查");
        Sheet421CoreCollector sheet421CoreCollector
                = new Sheet421CoreCollector();
        sheet421CoreCollector.inspect();

        System.out.println(df.format(new Date())
                + " 个人税收系统月巡检: 4.2.2 表空间使用率检查");
        Sheet422PersonalCollector sheet422PersonalCollector
                = new Sheet422PersonalCollector();
        sheet422PersonalCollector.inspect();
        System.out.println(df.format(new Date())
                + " 核心征管系统月巡检: 4.2.2 表空间使用率检查");
        Sheet422CoreCollector sheet422CoreCollector
                = new Sheet422CoreCollector();
        sheet422CoreCollector.inspect();

        System.out.println(df.format(new Date())
                + " 个人税收系统月巡检: 4.2.3 ASM共享磁盘检查");
        Sheet423PersonalCollector sheet423PersonalCollector
                = new Sheet423PersonalCollector();
        sheet423PersonalCollector.inspect();
        System.out.println(df.format(new Date())
                + " 核心征管系统月巡检: 4.2.3 ASM共享磁盘检查");
        Sheet423CoreCollector sheet423CoreCollector
                = new Sheet423CoreCollector();
        sheet423CoreCollector.inspect();

        System.out.println(df.format(new Date())
                + " 个人税收系统月巡检: 4.2.4 统计信息收集检查");
        Sheet424PersonalCollector sheet424PersonalCollector
                = new Sheet424PersonalCollector();
        sheet424PersonalCollector.inspect();
        System.out.println(df.format(new Date())
                + " 核心征管系统月巡检: 4.2.4 统计信息收集检查");
        Sheet424CoreCollector sheet424CoreCollector
                = new Sheet424CoreCollector();
        sheet424CoreCollector.inspect();

        System.out.println(df.format(new Date())
                + " 个人税收系统月巡检: 4.2.6 alert日志检查");
        Sheet426PersonalCollector sheet426PersonalCollector
                = new Sheet426PersonalCollector();
        sheet426PersonalCollector.inspect();
        System.out.println(df.format(new Date())
                + " 核心征管系统月巡检: 4.2.6 alert日志检查");
        Sheet426CoreCollector sheet426CoreCollector
                = new Sheet426CoreCollector();
        sheet426CoreCollector.inspect();

        System.out.println(df.format(new Date())
                + " 个人税收系统月巡检: 4.2.8 时钟同步检查");
        Sheet428PersonalCollector sheet428PersonalCollector
                = new Sheet428PersonalCollector();
        sheet428PersonalCollector.inspect();

        System.out.println(df.format(new Date())
                + " 核心征管系统月巡检: 4.2.8 时钟同步检查");
        Sheet428CoreCollector sheet428CoreCollector
                = new Sheet428CoreCollector();
        sheet428CoreCollector.inspect();

    }



    private static void generateExcelMonthly() throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm");

        System.out.println("\n" + df.format(new Date())
                + " 填写个税Excel表格: 4.1.1 应用OS文件系统使用率检查");
        Sheet411Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " 填写核心Excel表格: 4.1.1 应用OS文件系统使用率检查");
        Sheet411Generator.generateCore();

        System.out.println(df.format(new Date()) + " 填写个税Excel表格: 4.2.1 数据库OS文件系统目录使用率检查");
        Sheet421Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " 填写核心Excel表格: 4.2.1 数据库OS文件系统目录使用率检查");
        Sheet421Generator.generateCore();

        System.out.println(df.format(new Date()) + " 填写个税Excel表格: 4.2.2 表空间使用率检查");
        Sheet422Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " 填写核心Excel表格: 4.2.2 表空间使用率检查");
        Sheet422Generator.generateCore();

        System.out.println(df.format(new Date()) + " 填写个税Excel表格: 4.2.3 ASM共享磁盘检查");
        Sheet423Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " 填写核心Excel表格: 4.2.3 ASM共享磁盘检查");
        Sheet423Generator.generateCore();

        System.out.println(df.format(new Date()) + " 填写个税Excel表格: 4.2.4 统计信息收集检查");
        Sheet424Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " 填写核心Excel表格: 4.2.4 统计信息收集检查");
        Sheet424Generator.generateCore();

        System.out.println(df.format(new Date()) + " 填写个税Excel表格: 4.2.6 alert日志检查");
        Sheet426Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " 填写核心Excel表格: 4.2.6 alert日志检查");
        Sheet426Generator.generateCore();

        System.out.println(df.format(new Date()) + " 填写个税Excel表格: 4.2.8 时钟同步检查");
        Sheet428Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " 填写核心Excel表格: 4.2.8 时钟同步检查");
        Sheet428Generator.generateCore();
    }

    private static void run_scheduler() throws Exception{
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        final CountDownLatch waitCountDown = new CountDownLatch(1);
        final CountDownLatch setFutureCountDown = new CountDownLatch(1);
        Calendar now = Calendar.getInstance();
        Calendar executeTime = Calendar.getInstance();
        executeTime.set(Calendar.HOUR_OF_DAY, 11);
        executeTime.set(Calendar.MINUTE, 05);

        MainScheduler mainScheduler = new MainScheduler();
        mainScheduler.setMainSchedulerCountDown(waitCountDown);
        mainScheduler.setSetFutureCountDown(setFutureCountDown);

        InspectionLogger.info("Manager evokes main scheduler");
        Future future = service.scheduleAtFixedRate(mainScheduler
                , executeTime.getTimeInMillis() - now.getTimeInMillis()
                , 10*60*1000, TimeUnit.MILLISECONDS);

        mainScheduler.setFuture(future);
        setFutureCountDown.countDown();

        InspectionLogger.info("Manager waits for main scheduler");
        waitCountDown.await();
        InspectionLogger.info("Manager finishes waiting for main scheduler and shutdowns service");
        service.shutdownNow();
    }
}
