package com.ramognee.orangehrms.locators;

public interface LoginPageLocators {

    String usernameTextBox = "//input[@placeholder='Username']";
    String passwordTextBox = "//input[@placeholder='Password']";
    String loginButton = "//button[text()=' Login ']";
    String invalidCredentialToastMessage = "//p[text()='Invalid credentials']";
    String textForBlankPlaceholder = "//span[text()='Required']";
    String dashboardTitle = "//h6[text()='Dashboard']";
}
