package com.automation.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class AllureReportManager {

//    @Attachment(type = "image/png",value = "screenshot")
    public static void attachScreenshot(){
        TakesScreenshot ts=(TakesScreenshot) DriverManager.getDriver();
        byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
//        return screenshot;
        Allure.addAttachment("screenshot",new ByteArrayInputStream(screenshot));

    }

//    @Attachment(type = "text/plain")
    public static void attachLog(String message){
//        return message;
        Allure.addAttachment("Log",message);
    }
}
