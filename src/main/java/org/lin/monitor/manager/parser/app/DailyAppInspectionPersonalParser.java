package org.lin.monitor.manager.parser.app;

import org.jdom.Element;
import org.lin.monitor.manager.config.DailyAppParserConfig;
import org.lin.monitor.manager.parser.utils.ParserUtils;
import org.suns.host.config.WebLogicServer;

import java.util.ArrayList;

public class DailyAppInspectionPersonalParser {
    private Element rootElem;
    private Element personalAppElem;

    public DailyAppInspectionPersonalParser(Element rootElem) throws Exception{
        this.rootElem = rootElem;
        init();
    }

    private void init() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized Root Element");
        }

        personalAppElem = rootElem.getChild(DailyAppParserConfig
                .getPersonalAppInspectionTag());
        if(personalAppElem == null){
            throw new Exception("unexpected XML Config file format: missing personalAppInspection tag");
        }
    }

    public ArrayList<WebLogicServer> getWebLogicServers() throws Exception{
        if(personalAppElem == null){
            init();
        }
        return ParserUtils.extractWebLogicServersFromRootElem(personalAppElem
                , DailyAppParserConfig.getPersonalAppInspectionTag());
    }
}
