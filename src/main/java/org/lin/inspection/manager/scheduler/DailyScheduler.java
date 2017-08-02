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

public class DailyScheduler extends AbstractScheduler{
    @Override
    public void run() {
        try{
            if(getSetFutureCountDown() == null){
                throw new Exception("Uninitialized setFutureCountDown");
            }

            InspectionLogger.info("Daily Inspection waiting for setFutureCountDown");
            getSetFutureCountDown().await();

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
            InspectionLogger.info("Daily Inspection Generating 422 personal Excel");
            Sheet422Generator.generatePersonal();
            System.out.println(df.format(new Date()) + " Filling Excel Sheet 422 Core");
            InspectionLogger.info("Daily Inspection Generating 422 core Excel");
            Sheet422Generator.generateCore();

            System.out.println(df.format(new Date()) + " Filling Excel Sheet 426 Personal");
            InspectionLogger.info("Daily Inspection Generating 426 personal Excel");
            Sheet426Generator.generatePersonal();
            System.out.println(df.format(new Date()) + " Filling Excel Sheet 426 Core");
            InspectionLogger.info("Daily Inspection Generating 426 core Excel");
            Sheet426Generator.generateCore();

            if(getMainSchedulerCountDown() == null){
                throw new Exception("Uninitialized MainSchedulerCountDown");
            }

            InspectionLogger.info("Daily Inspection Waking up main scheduler");
            getMainSchedulerCountDown().countDown();

            if(getFuture() == null){
                throw new Exception("Uninitialized Future");
            }

            InspectionLogger.info("Daily Inspection finishes and kills itself");
            getFuture().cancel(true);

        }catch (Exception e){
            InspectionLogger.error("Fail in Daily Inspection - "
                    + e.toString());
        }
    }
}
