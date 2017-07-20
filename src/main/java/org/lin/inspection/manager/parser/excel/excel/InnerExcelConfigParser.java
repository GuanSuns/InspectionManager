package org.lin.inspection.manager.parser.excel.excel;

import org.jdom.Element;
import org.lin.inspection.manager.config.ExcelParserConfig;
import org.lin.inspection.manager.parser.utils.ParserUtils;

public class InnerExcelConfigParser {
    private Element rootElem;
    private Element excelConfigElem;
    private InnerSheetNames sheetNames;

    public InnerExcelConfigParser() {
        this.rootElem = null;
        this.excelConfigElem = null;
        this.sheetNames = null;
    }

    public InnerExcelConfigParser(Element rootElem) throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized rootElem");
        }

        this.rootElem = rootElem;
        this.sheetNames = null;
        init();
    }

    private void init() throws Exception{
        if(rootElem == null){
            throw new Exception("Uninitialized Root Element");
        }

        excelConfigElem = rootElem.getChild(ExcelParserConfig.getExcelConfigTag());
        if(excelConfigElem == null){
            throw new Exception("Unexpected XML Format: missing ExcelConfig element");
        }
    }

    public String getRootDirectory() throws Exception{
        if(excelConfigElem == null){
            init();
        }

        return ParserUtils.getStringFromElement(excelConfigElem
                , ExcelParserConfig.getRootDirectoryTag());
    }

    public String getPersonalFile() throws Exception{
        if(excelConfigElem == null){
            init();
        }
        return ParserUtils.getStringFromElement(excelConfigElem
                , ExcelParserConfig.getPersonalFileTag());
    }

    public String getCoreFile() throws Exception{
        if(excelConfigElem == null){
            init();
        }
        return ParserUtils.getStringFromElement(excelConfigElem
                , ExcelParserConfig.getCoreFileTag());
    }

    public String getProvince() throws Exception{
        if(excelConfigElem == null){
            init();
        }
        return ParserUtils.getStringFromElement(excelConfigElem
                , ExcelParserConfig.getProvinceTag());
    }

    public InnerSheetNames getSheetNames() throws Exception{
        if(sheetNames != null){
            return sheetNames;
        }

        if(excelConfigElem == null){
            init();
        }
        sheetNames = new InnerSheetNames();
        return sheetNames;
    }

    public class InnerSheetNames{
        private Element sheetNamesElem;

        public InnerSheetNames() throws Exception{
            if(excelConfigElem == null){
                throw new Exception("Uninitialized ExcelConfig Elem");
            }
            sheetNamesElem = excelConfigElem.getChild(ExcelParserConfig
                    .getSheetNamesTag());

            if(sheetNamesElem == null){
                throw new Exception("Unexpected XML Format: missing sheetNames element");
            }
        }

        public String getSheet411Name() throws Exception{
            return ParserUtils.getStringFromElement(sheetNamesElem
                    , ExcelParserConfig.getSheet411NameTag());
        }

        public String getSheet421Name() throws Exception{
            return ParserUtils.getStringFromElement(sheetNamesElem
                    , ExcelParserConfig.getSheet421NameTag());
        }

        public String getSheet422Name() throws Exception{
            return ParserUtils.getStringFromElement(sheetNamesElem
                    , ExcelParserConfig.getSheet422NameTag());
        }

        public String getSheet423Name() throws Exception{
            return ParserUtils.getStringFromElement(sheetNamesElem
                    , ExcelParserConfig.getSheet423NameTag());
        }

        public String getSheet424Name() throws Exception{
            return ParserUtils.getStringFromElement(sheetNamesElem
                    , ExcelParserConfig.getSheet424NameTag());
        }

        public String getSheet426Name() throws Exception{
            return ParserUtils.getStringFromElement(sheetNamesElem
                    , ExcelParserConfig.getSheet426NameTag());
        }

        public String getSheet428Name() throws Exception{
            return ParserUtils.getStringFromElement(sheetNamesElem
                    , ExcelParserConfig.getSheet428NameTag());
        }

        public String getSheet429Name() throws Exception{
            return ParserUtils.getStringFromElement(sheetNamesElem
                    , ExcelParserConfig.getSheet429NameTag());
        }
    }
}
