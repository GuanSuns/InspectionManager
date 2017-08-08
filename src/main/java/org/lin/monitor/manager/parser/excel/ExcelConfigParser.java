package org.lin.monitor.manager.parser.excel;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.lin.monitor.manager.config.ExcelParserConfig;
import org.lin.monitor.manager.parser.excel.excel.InnerExcelConfigParser;
import org.lin.monitor.manager.parser.excel.type.InnerCellTypeParser;
import org.lin.monitor.manager.parser.utils.ParserUtils;

public class ExcelConfigParser {
    private Document excelConfigDoc;
    private Element rootElem;
    private InnerCellTypeParser cellTypeParser;
    private InnerExcelConfigParser excelConfigParser;

    public ExcelConfigParser() throws Exception{
        this.cellTypeParser = null;
        this.excelConfigParser = null;
        init();
    }

    private void init() throws Exception{
        SAXBuilder builder= new SAXBuilder();
        excelConfigDoc = builder.build(ExcelParserConfig.getRootDirectory()
                + ExcelParserConfig.getExcelConfigXML());
        rootElem = excelConfigDoc.getRootElement();

        if(rootElem == null){
            throw new Exception("Unexpected XML Config file format: missing root element");
        }
    }

    public InnerCellTypeParser getCellStyle() throws Exception{
        if(cellTypeParser != null) {
            return cellTypeParser;
        }

        cellTypeParser = new InnerCellTypeParser(rootElem);
        return cellTypeParser;
    }

    public InnerExcelConfigParser getExcelConfig() throws Exception{
        if(excelConfigParser != null){
            return excelConfigParser;
        }

        excelConfigParser = new InnerExcelConfigParser(rootElem);
        return excelConfigParser;
    }

    public String getDateFormat() throws Exception{
        return ParserUtils.getStringFromElement(rootElem
                , ExcelParserConfig.getDateFormatTag());
    }

    public String getFileDateFormat() throws Exception{
        return ParserUtils.getStringFromElement(rootElem
                , ExcelParserConfig.getFileDateFormatTag());
    }

    public String getNullValue() throws Exception{
        return ParserUtils.getStringFromElement(rootElem
                , ExcelParserConfig.getNullValueTag());
    }

    public int getDaysRecentInstances() throws Exception{
        return ParserUtils.getIntFromElement(rootElem
                , ExcelParserConfig.getDaysRecentInstancesTag());
    }
}
