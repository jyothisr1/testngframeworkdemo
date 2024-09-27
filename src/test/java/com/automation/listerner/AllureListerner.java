package com.automation.listerner;


import com.automation.utils.AllureReportManager;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.ITestResult;

public class AllureListerner extends AllureTestNg {


    public void onTestFailure(ITestResult result) {
        AllureReportManager.attachScreenshot();
        super.onTestFailure(result);
        AllureReportManager.attachScreenshot();
    }
}
