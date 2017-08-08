package org.lin.monitor.manager.parser.app;

import org.jdom.Element;
import org.lin.monitor.manager.config.DailyAppParserConfig;
import org.lin.monitor.manager.parser.utils.ParserUtils;
import org.suns.host.config.WebLogicServerConfig;

import java.util.ArrayList;

public class DailyAppInspectionCoreParser {
    private Element rootElem;
    private Element coreAppElem;

    public DailyAppInspectionCoreParser(Element rootElem) throws Exception{
        this.rootElem = rootElem;
        init();
    }

    private void init() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized Root Element");
        }

        coreAppElem = rootElem.getChild(DailyAppParserConfig
                .getCoreAppInspectionTag());
        if(coreAppElem == null){
            throw new Exception("unexpected XML Config file format: missing coreAppInspection tag");
        }
    }

    public ArrayList<WebLogicServerConfig> getWebLogicServers() throws Exception{
        if(coreAppElem == null){
            init();
        }
        return ParserUtils.extractWebLogicServersFromRootElem(coreAppElem
                , DailyAppParserConfig.getCoreAppInspectionTag());
    }
}
