package com.ramognee.orangehrms.scripts;

import com.aventstack.extentreports.Status;
import com.ramognee.orangehrms.generic.BaseTestClass;
import com.ramognee.orangehrms.generic.ExcelUtil;
import com.ramognee.orangehrms.generic.WaitStatement;
import com.ramognee.orangehrms.pagewise.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTestClass {

    String expTextForDashboard = "Dashboard";
    String expTextForInvalidCredential = "Invalid credentials";
    String expTextForRequired = "Required";

    LoginPage loginPage;
    ExcelUtil excelUtil;

    @Test
    public void tc01_verifyValidLogin() {
        extentTest.assignAuthor("Sudha");
        loginPage = new LoginPage(driver);
        excelUtil = new ExcelUtil();
        WaitStatement.staticWaitForSeconds(2);
        loginPage.getUsernameTextBox().sendKeys(excelUtil.readDataExcelSheet("src/main/resources/LoginDataSheet.xlsx", 1, 0));
        loginPage.getPasswordTextBox().sendKeys(excelUtil.readDataExcelSheet("src/main/resources/LoginDataSheet.xlsx", 1, 1));
        loginPage.getLoginButton().click();
        driver.switchTo().alert().accept();
        Assert.assertEquals(loginPage.getDashboardTitle().getText(),expTextForDashboard);
        extentTest.log(Status.INFO, "Valid login is verified successfully");
    }

    @Test
    public void tc02_verifyLoginPageWithRightUsernameAndWrongPwd() {
        extentTest.assignAuthor("Sudha");
        loginPage = new LoginPage(driver);
        excelUtil = new ExcelUtil();
        WaitStatement.staticWaitForSeconds(2);
        loginPage.getUsernameTextBox().sendKeys(excelUtil.readDataExcelSheet("src/main/resources/LoginDataSheet.xlsx", 2, 0));
        loginPage.getPasswordTextBox().sendKeys(excelUtil.readDataExcelSheet("src/main/resources/LoginDataSheet.xlsx", 2, 1));
        loginPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getInvalidCredentialToastMessage().getText(),expTextForInvalidCredential);
        extentTest.log(Status.INFO, "Login page with right username and wrong pwd is verified successfully");
    }

    @Test
    public void tc03_verifyLoginPageWithWrongUsernameAndRightPwd() {
        extentTest.assignAuthor("Sudha");
        loginPage = new LoginPage(driver);
        excelUtil = new ExcelUtil();
        WaitStatement.staticWaitForSeconds(2);
        loginPage.getUsernameTextBox().sendKeys(excelUtil.readDataExcelSheet("src/main/resources/LoginDataSheet.xlsx", 3, 0));
        loginPage.getPasswordTextBox().sendKeys(excelUtil.readDataExcelSheet("src/main/resources/LoginDataSheet.xlsx", 3, 1));
        loginPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getInvalidCredentialToastMessage().getText(),expTextForInvalidCredential);
        extentTest.log(Status.INFO, "Login page with wrong username and right pwd is verified successfully");
    }

    @Test
    public void tc04_verifyLoginPageWithBlankCredential() {
        extentTest.assignAuthor("Sudha");
        loginPage = new LoginPage(driver);
        excelUtil = new ExcelUtil();
        WaitStatement.staticWaitForSeconds(2);
        loginPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getTextForBlankPlaceholder().getText(),expTextForRequired);
        extentTest.log(Status.INFO, "Login page with blank credential is verified successfully");
    }
}
