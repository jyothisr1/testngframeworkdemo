package com.automation.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    private ExtentReports extent;
    public static ExtentTest test;
    private static ExtentSparkReporter sparkReporter;

    @BeforeMethod
    public void setUp(){

        String reportPath=System.getProperty("user.dir")+"\\reports\\extentReport.html";
        sparkReporter =new ExtentSparkReporter(reportPath);
        sparkReporter.config().setTheme(Theme.DARK);

        extent=new ExtentReports();
        test=extent.createTest("verify user can login");
        test.info("navigating to another page");

        DriverManager.createDriver();
        ConfigReader.initConfig();
        loginPage=new LoginPage();
        homePage =new HomePage();
    }

    @AfterMethod
    public void cleanUp(){
        extent.attachReporter(sparkReporter);
        extent.flush();
        DriverManager.getDriver().quit();
    }

    public String screenshot() throws IOException {
        TakesScreenshot ts=(TakesScreenshot) DriverManager.getDriver();
        File file=ts.getScreenshotAs(OutputType.FILE);
        String filePath="src/test/resources"+"/screenshot.png";
        FileUtils.copyFile(file,new File(filePath));
        return System.getProperty("user.dir")+"/"+filePath;
    }
}
