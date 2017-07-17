package org.lin.inspection.manager.parser.connector.df;

import org.jdom.Element;
import org.lin.inspection.manager.config.ConnectorParserConfig;

/**
 * Created by guanl on 7/17/2017.
 */
public class InnerDfFormatConfigParser {
    private Element rootElem;
    private Element dfFormatConfigRoot;

    public InnerDfFormatConfigParser(Element rootElem) {
        this.rootElem = rootElem;
        this.dfFormatConfigRoot = null;
    }

    public InnerDfFormatConfigParser() {
        this.rootElem = null;
        this.dfFormatConfigRoot = null;
    }

    private void initConnectorConfigRoot() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized root element");
        }

        dfFormatConfigRoot = rootElem
                .getChild(ConnectorParserConfig.getDfFormatTag());

        if(dfFormatConfigRoot == null){
            throw new Exception("Unexpected XML Config file format: missing DFFormat element");
        }
    }

    public int getFileSystemColumn() throws Exception{
        if(dfFormatConfigRoot == null){
            initConnectorConfigRoot();
        }

        Element fileSystemColumnElem = dfFormatConfigRoot.getChild(ConnectorParserConfig
                .getDfFileSystemColumnTag());
        if(fileSystemColumnElem == null){
            throw new Exception("Unexpected XML Config file format: missing fileSystemColumn tag");
        }

        String strFileSysColumn = fileSystemColumnElem.getText();
        return Integer.valueOf(strFileSysColumn);
    }

    public int getMountedSysColumn() throws Exception{
        if(dfFormatConfigRoot == null){
            initConnectorConfigRoot();
        }

        Element mountedSysColumnElem = dfFormatConfigRoot.getChild(ConnectorParserConfig
                .getDfMountedSysColumnTag());
        if(mountedSysColumnElem == null){
            throw new Exception("Unexpected XML Config file format: missing mountedSysColumn tag");
        }

        String strMountedSysColumn = mountedSysColumnElem.getText();
        return Integer.valueOf(strMountedSysColumn);
    }

    public int getUsageColumn() throws Exception{
        if(dfFormatConfigRoot == null){
            initConnectorConfigRoot();
        }

        Element usageColumnElem = dfFormatConfigRoot.getChild(ConnectorParserConfig
                .getDfUsageColumn());
        if(usageColumnElem == null){
            throw new Exception("Unexpected XML Config file format: missing usageColumn tag");
        }

        String strUsageColumn = usageColumnElem.getText();
        return Integer.valueOf(strUsageColumn);
    }
}
