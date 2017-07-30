package org.lin.inspection.manager;

import excel.filler.generator.*;
import org.lin.inspection.manager.configurator.ConfigManager;
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
import java.text.SimpleDateFormat;
import java.util.Date;

public class Manager {
    public static void main(String[] args) {
        try{
            ConfigManager configManager = new ConfigManager();
            configManager.configure();

            inspect();
            //generateExcel();

        }catch (Exception e){
            e.printStackTrace();
        }
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
/*
        System.out.println(df.format(new Date()) + " Inspecting Sheet 429 Personal");
        Sheet429PersonalCollector sheet429PersonalCollector
                = new Sheet429PersonalCollector();
        sheet429PersonalCollector.inspect();
        System.out.println(df.format(new Date()) + " Inspecting Sheet 429 Core");
        Sheet429CoreCollector sheet429CoreCollector
                = new Sheet429CoreCollector();
        sheet429CoreCollector.inspect();
*/
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
