package org.lin.inspection.manager.parser.utils;


import org.jdom.Element;

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
}
