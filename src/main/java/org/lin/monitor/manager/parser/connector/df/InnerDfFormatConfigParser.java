package org.lin.monitor.manager.parser.connector.df;

import org.jdom.Element;
import org.lin.monitor.manager.config.ConnectorParserConfig;
import org.lin.monitor.manager.parser.utils.ParserUtils;
import org.suns.data.collector.config.DFFormat;

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

    public int getFileSystemColumn(DFFormat.InspectionSysType sysType)
            throws Exception{
        if(dfFormatConfigRoot == null){
            initConnectorConfigRoot();
        }

        Element fileSystemColumnElem = dfFormatConfigRoot.getChild(ConnectorParserConfig
                .getDfFileSystemColumnTag());
        if(fileSystemColumnElem == null){
            throw new Exception("Unexpected XML Config file format: missing fileSystemColumn tag");
        }

        if(sysType.equals(DFFormat.InspectionSysType.LINUX)){
            return ParserUtils.getIntFromAttr(fileSystemColumnElem
                    , ConnectorParserConfig.getLinuxAttr());
        }else{
            return ParserUtils.getIntFromAttr(fileSystemColumnElem
                    , ConnectorParserConfig.getAixAttr());
        }
    }

    public int getMountedSysColumn(DFFormat.InspectionSysType sysType)
            throws Exception{
        if(dfFormatConfigRoot == null){
            initConnectorConfigRoot();
        }

        Element mountedSysColumnElem = dfFormatConfigRoot.getChild(ConnectorParserConfig
                .getDfMountedSysColumnTag());
        if(mountedSysColumnElem == null){
            throw new Exception("Unexpected XML Config file format: missing mountedSysColumn tag");
        }

        if(sysType.equals(DFFormat.InspectionSysType.LINUX)){
            return ParserUtils.getIntFromAttr(mountedSysColumnElem
                    , ConnectorParserConfig.getLinuxAttr());
        }else{
            return ParserUtils.getIntFromAttr(mountedSysColumnElem
                    , ConnectorParserConfig.getAixAttr());
        }
    }

    public int getUsageColumn(DFFormat.InspectionSysType sysType)
            throws Exception{
        if(dfFormatConfigRoot == null){
            initConnectorConfigRoot();
        }

        Element usageColumnElem = dfFormatConfigRoot.getChild(ConnectorParserConfig
                .getDfUsageColumn());
        if(usageColumnElem == null){
            throw new Exception("Unexpected XML Config file format: missing usageColumn tag");
        }

        if(sysType.equals(DFFormat.InspectionSysType.LINUX)){
            return ParserUtils.getIntFromAttr(usageColumnElem
                    , ConnectorParserConfig.getLinuxAttr());
        }else{
            return ParserUtils.getIntFromAttr(usageColumnElem
                    , ConnectorParserConfig.getAixAttr());
        }
    }
}
