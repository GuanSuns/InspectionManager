package org.lin.monitor.manager.parser.excel.type;

import org.jdom.Element;
import org.lin.monitor.manager.config.ExcelParserConfig;
import org.lin.monitor.manager.parser.utils.ParserUtils;

public class InnerCellTypeParser {
    private Element rootElem;
    private Element cellTypeConfigElem;

    public InnerCellTypeParser() {
        this.rootElem = null;
        this.cellTypeConfigElem = null;
    }

    public InnerCellTypeParser(Element rootElem) throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized rootElem");
        }

        this.rootElem = rootElem;
        init();
    }

    private void init() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized Root Element");
        }

        cellTypeConfigElem = rootElem.getChild(ExcelParserConfig.getCellStyleTag());
        if(cellTypeConfigElem == null){
            throw new Exception("Unexpected XML Format: missing cellStyleConfig element");
        }
    }

    public boolean isBorder() throws Exception{
        if(cellTypeConfigElem == null){
            init();
        }

        String strBorder =  ParserUtils.getStringFromElement(cellTypeConfigElem
                , ExcelParserConfig.getBorderTag());

        return strBorder.equals("true");
    }

    public boolean isCentralAlignment() throws Exception{
        if(cellTypeConfigElem == null){
            init();
        }

        String strCentral =  ParserUtils.getStringFromElement(cellTypeConfigElem
                , ExcelParserConfig.getCentralAlignmentTag());

        return strCentral.equals("true");
    }

    public int getBorderStyle() throws Exception{
        if(cellTypeConfigElem == null){
            init();
        }
        return ParserUtils.getIntFromElement(cellTypeConfigElem
                , ExcelParserConfig.getBorderStyleTag());
    }

    public int getBorderColor() throws Exception{
        if(cellTypeConfigElem == null){
            init();
        }
        return ParserUtils.getIntFromElement(cellTypeConfigElem
                , ExcelParserConfig.getBorderColorTag());
    }

    public String getFont() throws Exception{
        if(cellTypeConfigElem == null){
            init();
        }
        return ParserUtils.getStringFromElement(cellTypeConfigElem
                , ExcelParserConfig.getFontTag());
    }

    public int getFontSize() throws Exception{
        if(cellTypeConfigElem == null){
            init();
        }
        return ParserUtils.getIntFromElement(cellTypeConfigElem
                , ExcelParserConfig.getFontSizeTag());
    }
}
