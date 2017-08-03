package org.lin.inspection.manager.scheduler;

import excel.filler.generator.*;
import org.suns.data.collector.collectors.sheet422.Sheet422CoreCollector;
import org.suns.data.collector.collectors.sheet422.Sheet422PersonalCollector;
import org.suns.data.collector.collectors.sheet423.Sheet423CoreCollector;
import org.suns.data.collector.collectors.sheet423.Sheet423PersonalCollector;
import org.suns.data.collector.collectors.sheet424.Sheet424CoreCollector;
import org.suns.data.collector.collectors.sheet424.Sheet424PersonalCollector;
import org.suns.data.collector.collectors.sheet426.Sheet426CoreCollector;
import org.suns.data.collector.collectors.sheet426.Sheet426PersonalCollector;
import org.suns.data.collector.collectors.sheet429.Sheet429CoreCollector;
import org.suns.data.collector.collectors.sheet429.Sheet429PersonalCollector;
import org.suns.inspection.logger.InspectionLogger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MonthlyScheduler extends AbstractScheduler{
    @Override
    public void run() {
        try{
            if(getSetFutureCountDown() == null){
                throw new Exception("Uninitialized setFutureCountDown");
            }

            InspectionLogger.info("Monthly Inspection waiting for setFutureCountDown");
            getSetFutureCountDown().await();

            SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm");

            System.out.println(df.format(new Date()) + " Inspecting Sheet 422 Personal");
            InspectionLogger.info("Monthly Inspection begins inspecting 422 personal");
            Sheet422PersonalCollector sheet422PersonalCollector
                    = new Sheet422PersonalCollector();
            sheet422PersonalCollector.inspect();

            System.out.println(df.format(new Date()) + " Inspecting Sheet 422 Core");
            InspectionLogger.info("Monthly Inspection begins inspecting 422 core");
            Sheet422CoreCollector sheet422CoreCollector
                    = new Sheet422CoreCollector();
            sheet422CoreCollector.inspect();

            System.out.println(df.format(new Date()) + " Inspecting Sheet 423 Personal");
            InspectionLogger.info("Monthly Inspection begins inspecting 423 personal");
            Sheet423PersonalCollector sheet423PersonalCollector
                    = new Sheet423PersonalCollector();
            sheet423PersonalCollector.inspect();

            System.out.println(df.format(new Date()) + " Inspecting Sheet 423 Core");
            InspectionLogger.info("Monthly Inspection begins inspecting 423 core");
            Sheet423CoreCollector sheet423CoreCollector
                    = new Sheet423CoreCollector();
            sheet423CoreCollector.inspect();

            System.out.println(df.format(new Date()) + " Inspecting Sheet 424 Personal");
            InspectionLogger.info("Monthly Inspection begins inspecting 424 personal");
            Sheet424PersonalCollector sheet424PersonalCollector
                    = new Sheet424PersonalCollector();
            sheet424PersonalCollector.inspect();

            System.out.println(df.format(new Date()) + " Inspecting Sheet 424 Core");
            InspectionLogger.info("Monthly Inspection begins inspecting 424 core");
            Sheet424CoreCollector sheet424CoreCollector
                    = new Sheet424CoreCollector();
            sheet424CoreCollector.inspect();

            System.out.println(df.format(new Date()) + " Inspecting Sheet 426 Personal");
            InspectionLogger.info("Monthly Inspection begins inspecting 426 personal");
            Sheet426PersonalCollector sheet426PersonalCollector
                    = new Sheet426PersonalCollector();
            sheet426PersonalCollector.inspect();

            System.out.println(df.format(new Date()) + " Inspecting Sheet 426 Core");
            InspectionLogger.info("Monthly Inspection begins inspecting 426 core");
            Sheet426CoreCollector sheet426CoreCollector
                    = new Sheet426CoreCollector();
            sheet426CoreCollector.inspect();

            System.out.println(df.format(new Date()) + " Inspecting Sheet 429 Personal");
            InspectionLogger.info("Monthly Inspection begins inspecting 429 personal");
            Sheet429PersonalCollector sheet429PersonalCollector
                    = new Sheet429PersonalCollector();
            sheet429PersonalCollector.inspect();

            System.out.println(df.format(new Date()) + " Inspecting Sheet 429 Core");
            InspectionLogger.info("Monthly Inspection begins inspecting 429 core");
            Sheet429CoreCollector sheet429CoreCollector
                    = new Sheet429CoreCollector();
            sheet429CoreCollector.inspect();

            System.out.println(df.format(new Date()) + " Filling Excel Sheet 422 Personal");
            InspectionLogger.info("Daily Inspection Generating 422 personal Excel");
            Sheet422Generator.generatePersonal();
            System.out.println(df.format(new Date()) + " Filling Excel Sheet 422 Core");
            InspectionLogger.info("Daily Inspection Generating 422 core Excel");
            Sheet422Generator.generateCore();

            System.out.println(df.format(new Date()) + " Filling Excel Sheet 423 Personal");
            InspectionLogger.info("Daily Inspection Generating 423 personal Excel");
            Sheet423Generator.generatePersonal();
            System.out.println(df.format(new Date()) + " Filling Excel Sheet 423 Core");
            InspectionLogger.info("Daily Inspection Generating 423 core Excel");
            Sheet423Generator.generateCore();

            System.out.println(df.format(new Date()) + " Filling Excel Sheet 424 Personal");
            InspectionLogger.info("Daily Inspection Generating 424 personal Excel");
            Sheet424Generator.generatePersonal();
            System.out.println(df.format(new Date()) + " Filling Excel Sheet 424 Core");
            InspectionLogger.info("Daily Inspection Generating 424 core Excel");
            Sheet424Generator.generateCore();

            System.out.println(df.format(new Date()) + " Filling Excel Sheet 426 Personal");
            InspectionLogger.info("Daily Inspection Generating 426 personal Excel");
            Sheet426Generator.generatePersonal();
            System.out.println(df.format(new Date()) + " Filling Excel Sheet 426 Core");
            InspectionLogger.info("Daily Inspection Generating 426 core Excel");
            Sheet426Generator.generateCore();

            System.out.println(df.format(new Date()) + " Filling Excel Sheet 429 Personal");
            InspectionLogger.info("Daily Inspection Generating 429 personal Excel");
            Sheet429Generator.generatePersonal();
            System.out.println(df.format(new Date()) + " Filling Excel Sheet 429 Core");
            InspectionLogger.info("Daily Inspection Generating 429 core Excel");
            Sheet429Generator.generateCore();

        }catch (Exception e){
            InspectionLogger.error("Fail in Monthly Inspection - "
                    + e.toString());
        }finally {
            if(getMainSchedulerCountDown() == null){
                InspectionLogger.error("Fail in Monthly Inspection " +
                        "- Uninitialized MainSchedulerCountDown");
            }else{
                InspectionLogger.info("Monthly Inspection Waking up " +
                        "main scheduler");
                getMainSchedulerCountDown().countDown();
            }

            if(getFuture() == null){
                InspectionLogger.error("Fail in Monthly Inspection " +
                        "- Uninitialized Future");
            }else{
                InspectionLogger.info("Monthly Inspection finishes and kills itself");
                getFuture().cancel(true);
            }
        }
    }
}
