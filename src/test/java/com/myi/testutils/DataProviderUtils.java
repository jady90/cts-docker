package com.myi.testutils;

import com.myi.constants.FrameworkConstant;
import com.myi.utils.ExcelUtils;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataProviderUtils {
    List<Map<String, String>> excelDataList = new ArrayList<>();
    @DataProvider()
    public Object[] getData(Method method){
        if(excelDataList.isEmpty()){
            excelDataList = ExcelUtils.readExcelData(FrameworkConstant.getExcelDataSheetName());
        }
        List<Map<String, String>> testDataList = new ArrayList<>();
        for(int i=0; i<excelDataList.size(); i++){
            if(method.getName().equalsIgnoreCase(excelDataList.get(i).get("testcasename"))
                     && excelDataList.get(i).get("execute").equalsIgnoreCase("yes")){
                testDataList.add(excelDataList.get(i));
            }
        }
        return testDataList.toArray();
    }

}
