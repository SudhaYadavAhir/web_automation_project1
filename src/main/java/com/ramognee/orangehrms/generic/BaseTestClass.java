package com.ramognee.orangehrms.generic;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTestClass {

    public static WebDriver driver;
    public ExtentSparkReporter htmlReporter;
    public static ExtentReports extent ;
    public static ExtentTest extentTest;

    @BeforeTest
    public void LoadReport() {
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "ExtentReportHtml" + File.separator +getClass().getSimpleName()+" "
                +(new SimpleDateFormat("dd-MM-yyyy hh-mm-ss").format(new Date()) + ".html")).viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD, ViewName.TEST, ViewName.CATEGORY, ViewName.AUTHOR}).apply();
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        htmlReporter.config().setDocumentTitle("Ramognee Report");
        htmlReporter.config().setReportName("Ramognee Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @Parameters({"browserName"})
    @BeforeMethod
    public void setUp(String browserName, Method getMethodName) {
        extentTest=extent.createTest(getMethodName.getName());
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if(browserName.equalsIgnoreCase("opera")){
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }else if(browserName.equalsIgnoreCase("microsoft edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WaitStatement.implicitWaitForSec(driver, 60);
        //driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        WaitStatement.staticWaitForSeconds(100);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void postMethod(ITestResult result) {

        try {
            switch (result.getStatus()) {
                case 1:
                    extentTest.log(Status.PASS, "Test: Passed");
                    break;

                case 3:
                    extentTest.log(Status.SKIP, MarkupHelper.createLabel("Test: Skipped", ExtentColor.ORANGE));
                    break;

                case 2:
                    extentTest.log(Status.FAIL, MarkupHelper.createLabel("Exception Name "+ result.getThrowable(), ExtentColor.RED));
                    extentTest.addScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (driver != null) {
            driver.close();
        }
    }

    @AfterTest
    public void tearDown() {
        extent.flush();
    }

}

