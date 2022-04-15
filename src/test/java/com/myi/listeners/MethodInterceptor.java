package com.myi.listeners;

import com.myi.constants.FrameworkConstant;
import com.myi.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<Map<String, String>> excelList = ExcelUtils
                .readExcelData(FrameworkConstant.getExcelRunnerSheetName());
        List<IMethodInstance> executableList = new ArrayList<>();
        for(int i=0; i<methods.size(); i++){
            for(int j=0; j<excelList.size(); j++){
                if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(excelList.get(j)
                        .get("testcasename")) && excelList.get(j).get("execute")
                        .equalsIgnoreCase("yes")){
                    executableList.add(methods.get(i));
                }
            }
        }
        return executableList;
    }
}
