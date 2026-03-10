package com.backend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utils.ElementUtils;
import org.junit.Assert;

public class LoginScreenPage {
    private WebDriver driver;
    private ElementUtils elementUtils;

    @FindBy(id = "organizationField")
    private WebElement organizationField;

    @FindBy(id = "emailField")
    private WebElement emailField;

    @FindBy(id = "passwordField")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    @FindBy(id = "sendButton")
    private WebElement sendButton;

    @FindBy(id = "errorMessage")
    private WebElement errorMessage;

    @FindBy(id = "loginScreen")
    private WebElement loginScreen;

    @FindBy(id = "allFieldsRequiredMessage")
    private WebElement allFieldsRequiredMessage;

    public LoginScreenPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginScreen() {
        driver.get("http://localhost");
    }

    public void launchApplicationURL() {
        driver.get("http://localhost");
    }

    public void enterOrganization(String organizationName) {
        try {
            elementUtils.clearAndSendKeys(organizationField, organizationName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterEmail(String email) {
        try {
            elementUtils.clearAndSendKeys(emailField, email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterPassword(String password) {
        try {
            elementUtils.clearAndSendKeys(passwordField, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickLoginButton() {
        try {
            elementUtils.clickElement(loginButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getErrorMessage() {
        try {
            return elementUtils.getElementText(errorMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isLoginScreenDisplayed() {
        try {
            return elementUtils.isElementDisplayed(loginScreen);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void leaveFieldsEmpty() {
        try {
            elementUtils.clearElement(organizationField);
            elementUtils.clearElement(emailField);
            elementUtils.clearElement(passwordField);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isAllFieldsRequiredMessageDisplayed() {
        try {
            return elementUtils.isElementDisplayed(allFieldsRequiredMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void enterInvalidEmail() {
        try {
            elementUtils.clearAndSendKeys(emailField, "invalidEmail");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickSendButton() {
        try {
            elementUtils.clickElement(sendButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isEmailInvalidMessageDisplayed() {
        // Implement logic to check for email invalid message
        return false; // Placeholder return
    }

    public boolean isLoginButtonEnabled() {
        // Implement logic to check if login button is enabled
        return false; // Placeholder return
    }

    public boolean isLoginProcessedSuccessfully() {
        // Implement logic to check login processing success
        return false; // Placeholder return
    }

    public boolean isHomeScreenDisplayed() {
        // Implement logic to check home screen display
        return false; // Placeholder return
    }

    public void leaveEmailAndPasswordFieldsEmpty() {
        try {
            elementUtils.clearElement(emailField);
            elementUtils.clearElement(passwordField);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void leaveOrganizationEmailFieldsEmpty() {
        try {
            elementUtils.clearElement(organizationField);
            elementUtils.clearElement(emailField);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isOnForgotPasswordScreen() {
        // Implement logic to check if on forgot password screen
        return false; // Placeholder return
    }

    public boolean isLoginButtonDisabled() {
        // Implement logic to check if login button is disabled
        return false; // Placeholder return
    }

    public void leaveAllFieldsEmpty() {
        leaveFieldsEmpty();
    }

    public void leavePasswordFieldEmpty() {
        try {
            elementUtils.clearElement(passwordField);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isOnLoginScreen() {
        return isLoginScreenDisplayed();
    }

    public void enterValidOrganizationName() {
        try {
            elementUtils.clearAndSendKeys(organizationField, "ValidOrganization");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void leaveOrganizationFieldEmpty() {
        try {
            elementUtils.clearAndSendKeys(organizationField, ""); // Clear and leave empty
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterInvalidPassword(String password) {
        try {
            elementUtils.clearAndSendKeys(passwordField, password); // Enter invalid password
            elementUtils.clickElement(loginButton); // Click login button
            String actualMessage = elementUtils.getElementText(errorMessage);
            String expectedMessage = "Invalid password"; // Example expected message
            Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}