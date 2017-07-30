package org.lin.inspection.manager.parser.scheduler;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.lin.inspection.manager.config.SchedulerConfig;
import org.lin.inspection.manager.parser.utils.ParserUtils;

public class SchedulerConfigParser {
    private Document SchedulerConfigDoc;
    private Element rootElem;

    public SchedulerConfigParser() throws Exception{
        init();
    }

    private void init() throws Exception{
        SAXBuilder builder= new SAXBuilder();
        SchedulerConfigDoc = builder.build(SchedulerConfig.getRootDirectory()
                + SchedulerConfig.getSchedulerConfigXML());
        rootElem = SchedulerConfigDoc.getRootElement();

        if(rootElem == null){
            throw new Exception("Unexpected XML Config file format: missing root element");
        }
    }

    public int getRunTimeHH() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        Element runTimeElem = rootElem.getChild(SchedulerConfig.getRunTimeTag());
        if(runTimeElem == null){
            throw new Exception("Unexpected XML Config file format: missing SchedulerRunTime element");
        }

        return ParserUtils.getIntFromAttr(runTimeElem, SchedulerConfig.getHourAttr());
    }
    
    public int getRunTimeMM() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        Element runTimeElem = rootElem.getChild(SchedulerConfig.getRunTimeTag());
        if(runTimeElem == null){
            throw new Exception("Unexpected XML Config file format: missing SchedulerRunTime element");
        }

        return ParserUtils.getIntFromAttr(runTimeElem, SchedulerConfig.getMinuteAttr());
    }
    
    public int getLastDayJan() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }
        
        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getJanTag());
    }

    public int getLastDayFeb() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getFebTag());
    }

    public int getLastDayMar() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getMarTag());
    }

    public int getLastDayApr() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getAprTag());
    }

    public int getLastDayMay() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getMayTag());
    }

    public int getLastDayJun() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getJunTag());
    }

    public int getLastDayJul() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getJulTag());
    }

    public int getLastDayAug() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getAugTag());
    }

    public int getLastDaySep() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getSepTag());
    }

    public int getLastDayOct() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getOctTag());
    }

    public int getLastDayNov() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getNovTag());
    }

    public int getLastDayDec() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        return ParserUtils.getIntFromElement(rootElem, SchedulerConfig.getDecTag());
    }
    
}
