package org.lin.monitor.manager.parser.utils;


import org.jdom.Element;
import org.lin.monitor.manager.config.SchedulerConfig;
import org.lin.monitor.manager.utils.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParserUtils {
    public static String getStringFromElement(Element rootElem
            , String tag) throws Exception{
        if(rootElem == null || tag == null || tag.equals("")){
            throw new Exception("Uninitialized argument");
        }

        Element childElem = rootElem.getChild(tag);
        if(childElem == null){
            throw new Exception("Unexpected XML Format: missing " + tag + " element");
        }

        return childElem.getText();
    }

    public static String getStringFromAttr(Element rootElem
            , String tag) throws Exception{
        if(rootElem == null || tag == null || tag.equals("")){
            throw new Exception("Uninitialized argument");
        }

        String result = rootElem.getAttributeValue(tag);
        if(result == null){
            throw new Exception("Unexpected XML Format: missing " + tag + " attribute");
        }

        return result;
    }

    public static int getIntFromElement(Element rootElem
            , String tag) throws Exception{
        if(rootElem == null || tag == null || tag.equals("")){
            throw new Exception("Uninitialized argument");
        }

        Element childElem = rootElem.getChild(tag);
        if(childElem == null){
            throw new Exception("Unexpected XML Format: missing " + tag + " element");
        }

        return Integer.valueOf(childElem.getText());
    }

    public static int getIntFromAttr(Element rootElem
            , String tag) throws Exception{
        if(rootElem == null || tag == null || tag.equals("")){
            throw new Exception("Uninitialized argument");
        }

        String result = rootElem.getAttributeValue(tag);
        if(result == null || result.equals("")){
            throw new Exception("Unexpected XML Format: missing " + tag + " attribute");
        }

        return Integer.valueOf(result);
    }

    public static ArrayList<Pair<Integer, Integer>> extractTimeArrayFromElem(Element rootElem
            , String tag) throws Exception{
        if(rootElem == null || tag == null || tag.equals("")){
            throw new Exception("Uninitialized argument");
        }

        List timeElems = rootElem.getChildren(tag);
        if(timeElems == null || timeElems.isEmpty()){
            throw new Exception("Unexpected XML Config file format: empty element");
        }

        ArrayList<Pair<Integer, Integer>> timePairs = new ArrayList<>();
        for (Iterator it = timeElems.iterator(); it.hasNext();) {
            Element timeElem = (Element)it.next();
            int hour = getIntFromAttr(timeElem, SchedulerConfig.getHourAttr());
            int minute = getIntFromAttr(timeElem, SchedulerConfig.getMinuteAttr());
            Pair<Integer, Integer> timePair = new Pair<>(hour,minute);
            timePairs.add(timePair);
        }
        return timePairs;
    }
}
