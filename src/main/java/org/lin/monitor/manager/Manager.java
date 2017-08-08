package org.lin.monitor.manager;

import excel.filler.generator.*;
import org.lin.monitor.manager.configurator.ConfigManager;
import org.lin.monitor.manager.scheduler.MainScheduler;
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
import java.util.concurrent.*;

public class Manager {
    public static void main(String[] args) {
        try{
            ConfigManager configManager = new ConfigManager();
            configManager.configure();

            if(args.length > 0 && args[0].equals("clear")){
                clearAllTable();
            }

            InspectionLogger.turnOnDebug();

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
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void clearAllTable() throws Exception{
        Sheet411Controller.clearAll();
        Sheet421Controller.clearAll();
        Sheet422Controller.clearAll();
        Sheet423Controller.clearAll();
        Sheet424Controller.clearAll();
        Sheet426Controller.clearAll();
        Sheet428Controller.clearAll();
        Sheet429Controller.clearAll();
    }

    private static void inspect() throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm");

        System.out.println(df.format(new Date()) + " Inspecting Sheet 411 Personal");
        Sheet411PersonalCollector sheet411PersonalCollector
                = new Sheet411PersonalCollector();
        sheet411PersonalCollector.inspect();
        System.out.println(df.format(new Date()) + " Inspecting Sheet 411 Core");
        Sheet411CoreCollector sheet411CoreCollector
                = new Sheet411CoreCollector();
        sheet411CoreCollector.inspect();

        System.out.println(df.format(new Date()) + " Inspecting Sheet 421 Personal");
        Sheet421PersonalCollector sheet421PersonalCollector
                = new Sheet421PersonalCollector();
        sheet421PersonalCollector.inspect();
        System.out.println(df.format(new Date()) + " Inspecting Sheet 421 Core");
        Sheet421CoreCollector sheet421CoreCollector
                = new Sheet421CoreCollector();
        sheet421CoreCollector.inspect();

        System.out.println(df.format(new Date()) + " Inspecting Sheet 428 Personal");
        Sheet428CoreCollector sheet428CoreCollector
                = new Sheet428CoreCollector();
        sheet428CoreCollector.inspect();

        System.out.println(df.format(new Date()) + " Inspecting Sheet 428 Core");
        Sheet428PersonalCollector sheet428PersonalCollector
                = new Sheet428PersonalCollector();
        sheet428PersonalCollector.inspect();

        System.out.println(df.format(new Date()) + " Inspecting Sheet 422 Personal");
        Sheet422PersonalCollector sheet422PersonalCollector
                = new Sheet422PersonalCollector();
        sheet422PersonalCollector.inspect();
        System.out.println(df.format(new Date()) + " Inspecting Sheet 422 Core");
        Sheet422CoreCollector sheet422CoreCollector
                = new Sheet422CoreCollector();
        sheet422CoreCollector.inspect();

        System.out.println(df.format(new Date()) + " Inspecting Sheet 423 Personal");
        Sheet423PersonalCollector sheet423PersonalCollector
                = new Sheet423PersonalCollector();
        sheet423PersonalCollector.inspect();
        System.out.println(df.format(new Date()) + " Inspecting Sheet 423 Core");
        Sheet423CoreCollector sheet423CoreCollector
                = new Sheet423CoreCollector();
        sheet423CoreCollector.inspect();

        System.out.println(df.format(new Date()) + " Inspecting Sheet 424 Personal");
        Sheet424PersonalCollector sheet424PersonalCollector
                = new Sheet424PersonalCollector();
        sheet424PersonalCollector.inspect();
        System.out.println(df.format(new Date()) + " Inspecting Sheet 424 Core");
        Sheet424CoreCollector sheet424CoreCollector
                = new Sheet424CoreCollector();
        sheet424CoreCollector.inspect();

        System.out.println(df.format(new Date()) + " Inspecting Sheet 426 Personal");
        Sheet426PersonalCollector sheet426PersonalCollector
                = new Sheet426PersonalCollector();
        sheet426PersonalCollector.inspect();
        System.out.println(df.format(new Date()) + " Inspecting Sheet 426 Core");
        Sheet426CoreCollector sheet426CoreCollector
                = new Sheet426CoreCollector();
        sheet426CoreCollector.inspect();

        System.out.println(df.format(new Date()) + " Inspecting Sheet 429 Personal");
        Sheet429PersonalCollector sheet429PersonalCollector
                = new Sheet429PersonalCollector();
        sheet429PersonalCollector.inspect();
        System.out.println(df.format(new Date()) + " Inspecting Sheet 429 Core");
        Sheet429CoreCollector sheet429CoreCollector
                = new Sheet429CoreCollector();
        sheet429CoreCollector.inspect();


    }

    private static void generateExcel() throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm");

        System.out.println(df.format(new Date()) + " Filling Excel Sheet 411 Personal");
        Sheet411Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " Filling Excel Sheet 411 Core");
        Sheet411Generator.generateCore();

        System.out.println(df.format(new Date()) + " Filling Excel Sheet 421 Personal");
        Sheet421Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " Filling Excel Sheet 421 Core");
        Sheet421Generator.generateCore();

        System.out.println(df.format(new Date()) + " Filling Excel Sheet 422 Personal");
        Sheet422Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " Filling Excel Sheet 422 Core");
        Sheet422Generator.generateCore();

        System.out.println(df.format(new Date()) + " Filling Excel Sheet 423 Personal");
        Sheet423Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " Filling Excel Sheet 423 Core");
        Sheet423Generator.generateCore();

        System.out.println(df.format(new Date()) + " Filling Excel Sheet 424 Personal");
        Sheet424Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " Filling Excel Sheet 424 Core");
        Sheet424Generator.generateCore();

        System.out.println(df.format(new Date()) + " Filling Excel Sheet 426 Personal");
        Sheet426Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " Filling Excel Sheet 426 Core");
        Sheet426Generator.generateCore();

        System.out.println(df.format(new Date()) + " Filling Excel Sheet 428 Personal");
        Sheet428Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " Filling Excel Sheet 428 Core");
        Sheet428Generator.generateCore();

        System.out.println(df.format(new Date()) + " Filling Excel Sheet 429 Personal");
        Sheet429Generator.generatePersonal();
        System.out.println(df.format(new Date()) + " Filling Excel Sheet 429 Core");
        Sheet429Generator.generateCore();

    }
}
