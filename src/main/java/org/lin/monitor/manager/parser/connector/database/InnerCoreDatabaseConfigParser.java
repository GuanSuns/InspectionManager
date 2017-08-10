package org.lin.monitor.manager.parser.connector.database;

import org.jdom.Element;
import org.lin.monitor.manager.config.ConnectorParserConfig;

/**
 * Created by guanl on 7/15/2017.
 */
public class InnerCoreDatabaseConfigParser extends AbstractInnerDBInspectionConfigParser{
    private Element databaseInspectionElem;
    private Element coreElem;

    public InnerCoreDatabaseConfigParser(Element databaseInspectionElem) {
        this.databaseInspectionElem = databaseInspectionElem;
        this.coreElem = null;
    }

    private void init() throws Exception{
        if(databaseInspectionElem == null){
            throw new Exception("Uninitialized databaseInspection Elem");
        }

        coreElem = databaseInspectionElem.getChild(ConnectorParserConfig.getDbInspectionCoreDatabaseTag());
        if(coreElem == null){
            throw new Exception("Unexpected XML Config file format: missing CoreDatabase element");
        }
    }

    @Override
    protected Element getRootElement() throws Exception{
        if(coreElem == null){
            init();
        }
        return coreElem;
    }
}
