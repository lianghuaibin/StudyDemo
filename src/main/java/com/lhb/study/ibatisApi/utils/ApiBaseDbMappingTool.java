package com.lhb.study.ibatisApi.utils;





import com.lhb.plug.dynamicibatis.utils.DbMappingTool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ApiBaseCodeTool代码工具
 *
 * @author lianghuaibin
 * @since 2017/6/9
 */
public class ApiBaseDbMappingTool {

    public static void main(String[] args) {
        DbMappingTool dbMappingTool  = new DbMappingTool();

        String url ="jdbc:mysql://localhost:3306/lhb?user=foo&password=123";

        String templatePath = DbMappingTool.class.getClassLoader().getResource("templates/ibatis_ftl").getPath();
        String tableName = "tbl_user";
        Map<String, Object> extParams = new HashMap<String, Object>();
        extParams.put("packagePath", "com.lhb.study.ibatisApi");
        extParams.put("author", "lianghuaibin");
        extParams.put("jAppName", "reference");
        extParams.put("since", (new SimpleDateFormat("yyyy/MM/dd")).format(new Date()));
        extParams.put("year", (new Date()).getYear());
        String basePath = "D:\\MyProgram\\StudyDemo\\src\\main\\java\\com\\lhb\\study\\ibatisApi";
        Map<String,String> outputPathMap = new HashMap<String,String>();
        outputPathMap.put("${TableName}.java.ftl",basePath + "\\domain\\pojo");
        outputPathMap.put("${TableName}Query.java.ftl",basePath + "\\domain\\query");
//        outputPathMap.put("${TableName}Dao.java.ftl",basePath + "\\dao");
//        outputPathMap.put("${TableName}Service.java.ftl",basePath + "\\service");
//        outputPathMap.put("${TableName}ServiceImpl.java.ftl",basePath + "\\service\\impl");
//        String xmlPath = "D:\\MyProgram\\StudyDemo\\src\\main\\resources";
//        outputPathMap.put("${TABLE_NAME}.xml.ftl",xmlPath + "\\sqlMap");

        String configFilePath = "E:\\output";
        Map<String, String> configFileMap = new HashMap<String, String>();
//        configFileMap.put("jsfConsumerConfigFile.xml.ftl", configFilePath);
//        configFileMap.put("jsfProviderConfigFile.xml.ftl", configFilePath);
//        configFileMap.put("jsfRegistConfig.csv.ftl", configFilePath);
        dbMappingTool.execute(url, templatePath, outputPathMap, configFileMap, tableName, extParams, true);
    }
}
