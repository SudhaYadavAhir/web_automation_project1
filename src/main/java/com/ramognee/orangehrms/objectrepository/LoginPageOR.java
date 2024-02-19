package com.ramognee.orangehrms.objectrepository;

import com.ramognee.orangehrms.locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageOR implements LoginPageLocators {

    public LoginPageOR(WebDriver driver){;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = usernameTextBox)
    protected WebElement elementForUsernameTextBox;
    @FindBy(xpath = passwordTextBox)
    protected WebElement elementForPasswordTextBox;
    @FindBy(xpath = loginButton)
    protected WebElement elementForLoginButton;
    @FindBy(xpath = invalidCredentialToastMessage)
    protected WebElement elementForInvalidCredentialToastMessage;
    @FindBy(xpath = textForBlankPlaceholder)
    protected WebElement elementForTextForBlankPlaceholder;
    @FindBy(xpath = dashboardTitle)
    protected WebElement elementForDashboardTitle;
}
