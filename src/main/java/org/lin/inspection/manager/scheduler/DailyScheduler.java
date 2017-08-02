package org.lin.inspection.manager.scheduler;

import excel.filler.generator.Sheet422Generator;
import excel.filler.generator.Sheet426Generator;
import org.suns.data.collector.collectors.sheet422.Sheet422CoreCollector;
import org.suns.data.collector.collectors.sheet422.Sheet422PersonalCollector;
import org.suns.data.collector.collectors.sheet426.Sheet426CoreCollector;
import org.suns.data.collector.collectors.sheet426.Sheet426PersonalCollector;
import org.suns.inspection.logger.InspectionLogger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

public class DailyScheduler implements Runnable{
    private Future future;
    private CountDownLatch setFutureCountDown;
    private CountDownLatch mainSchedulerCountDown;

    public void setFuture(Future future) {
        this.future = future;
    }

    public void setSetFutureCountDown(CountDownLatch setFutureCountDown) {
        this.setFutureCountDown = setFutureCountDown;
    }

    public void setMainSchedulerCountDown(CountDownLatch mainSchedulerCountDown) {
        this.mainSchedulerCountDown = mainSchedulerCountDown;
    }

    @Override
    public void run() {
        try{
            InspectionLogger.info("Daily Inspection waiting for setFutureCountDown");
            setFutureCountDown.await();

            SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm");

            System.out.println(df.format(new Date()) + " Inspecting Sheet 422 Personal");
            InspectionLogger.info("Daily Inspection begins inspecting 422 personal");
            Sheet422PersonalCollector sheet422PersonalCollector
                    = new Sheet422PersonalCollector();
            sheet422PersonalCollector.inspect();

            System.out.println(df.format(new Date()) + " Inspecting Sheet 422 Core");
            InspectionLogger.info("Daily Inspection begins inspecting 422 core");
            Sheet422CoreCollector sheet422CoreCollector
                    = new Sheet422CoreCollector();
            sheet422CoreCollector.inspect();

            System.out.println(df.format(new Date()) + " Inspecting Sheet 426 Personal");
            InspectionLogger.info("Daily Inspection begins inspecting 426 Personal");
            Sheet426PersonalCollector sheet426PersonalCollector
                    = new Sheet426PersonalCollector();
            sheet426PersonalCollector.inspect();

            System.out.println(df.format(new Date()) + " Inspecting Sheet 426 Core");
            InspectionLogger.info("Daily Inspection begins inspecting 426 core");
            Sheet426CoreCollector sheet426CoreCollector
                    = new Sheet426CoreCollector();
            sheet426CoreCollector.inspect();

            System.out.println(df.format(new Date()) + " Filling Excel Sheet 422 Personal");
            InspectionLogger.info("Daily Inspection Generating 422 core Excel");
            Sheet422Generator.generatePersonal();
            System.out.println(df.format(new Date()) + " Filling Excel Sheet 422 Core");
            Sheet422Generator.generateCore();

            System.out.println(df.format(new Date()) + " Filling Excel Sheet 426 Personal");
            InspectionLogger.info("Daily Inspection Generating 426 core Excel");
            Sheet426Generator.generatePersonal();
            System.out.println(df.format(new Date()) + " Filling Excel Sheet 426 Core");
            Sheet426Generator.generateCore();

            InspectionLogger.info("Daily Inspection Waking up main scheduler");
            mainSchedulerCountDown.countDown();
            InspectionLogger.info("Daily Inspection finishes");
            future.cancel(true);

        }catch (Exception e){
            InspectionLogger.error("Fail in Daily Inspection - "
                    + e.toString());
        }
    }
}
