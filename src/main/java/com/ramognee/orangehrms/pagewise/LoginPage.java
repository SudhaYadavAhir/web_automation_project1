package com.ramognee.orangehrms.pagewise;

import com.ramognee.orangehrms.objectrepository.LoginPageOR;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends LoginPageOR {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebElement getUsernameTextBox(){
        return elementForUsernameTextBox;
    }
    public WebElement getPasswordTextBox(){
        return elementForPasswordTextBox;
    }
    public WebElement getLoginButton(){
        return elementForLoginButton;
    }
    public WebElement getInvalidCredentialToastMessage(){
        return elementForInvalidCredentialToastMessage;
    }
    public WebElement getTextForBlankPlaceholder(){
        return elementForTextForBlankPlaceholder;
    }
    public WebElement getDashboardTitle(){
        return elementForDashboardTitle;
    }

}
