package com.CGC-Operational-Panel.stepdefinitions;

import com..utils.ElementUtils;
import org.junit.Assert;
import com..driverfactory.DriverFactory;
import com.CGC-Operational-Panel.pages.LoginScreenPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class LoginScreen extends DriverFactory {
LoginScreenPage loginScreenPage = new LoginScreenPage(driver);
@Given("the user is on the Login Screen")
public void the_user_is_on_the_login_screen() {
loginScreenPage.navigateToLoginScreen();
}
@When("the user launches the application URL")
public void the_user_launches_the_application_url() {
loginScreenPage.launchApplicationURL();
}
@When("the user enters {string} in the Organization field")
public void the_user_enters_organization_in_the_organization_field(String organizationName) {
loginScreenPage.enterOrganization(organizationName);
}
@When("the user enters {string} in the Email field")
public void the_user_enters_email_in_the_email_field(String email) {
loginScreenPage.enterEmail(email);
}
@When("the user enters {string} in the Password field")
public void the_user_enters_password_in_the_password_field(String password) {
loginScreenPage.enterPassword(password);
}
@When("the user clicks the Login button")
public void the_user_clicks_the_login_button() {
loginScreenPage.clickLoginButton();
}
@Then("the system displays the error message {string}")
public void the_system_displays_the_error_message(String errorMessage) {
Assert.assertEquals("Error message mismatch", errorMessage, loginScreenPage.getErrorMessage());
}
@Then("the user remains on the login screen")
public void the_user_remains_on_the_login_screen() {
"User is not on the login screen", loginScreenPage.isLoginScreenDisplayed();
}
@When("the user leaves all fields (Organization, Email, Password) empty")
public void the_user_leaves_all_fields_empty() {
loginScreenPage.leaveFieldsEmpty();
}
@Then("the system displays an error message indicating that all fields are required")
public void the_system_displays_an_error_message_indicating_that_all_fields_are_required() {
"All fields required message not displayed", loginScreenPage.isAllFieldsRequiredMessageDisplayed();
}
@When("the user enters an invalid Email address in the Email field")
public void the_user_enters_an_invalid_email_address_in_the_email_field() {
loginScreenPage.enterInvalidEmail();
}
@When("the user clicks the Send button")
public void the_user_clicks_the_send_button() {
loginScreenPage.clickSendButton();
}
@Then("the system displays an error message indicating the Email is invalid")
public void the_system_displays_an_error_message_indicating_the_email_is_invalid() {
"Email invalid message not displayed", loginScreenPage.isEmailInvalidMessageDisplayed();
}
@Then("the Login button is disabled")
public void the_login_button_is_disabled() {
"Login button is enabled", loginScreenPage.isLoginButtonEnabled();
}
@When("the user enters a maximum length {string} in the Organization field")
public void the_user_enters_maximum_length_organization_in_the_organization_field(String organization) {
loginScreenPage.enterOrganization(organization);
}
@When("the user enters a maximum length {string} in the Email field")
public void the_user_enters_maximum_length_email_in_the_email_field(String email) {
loginScreenPage.enterEmail(email);
}
@When("the user enters a maximum length {string} in the Password field")
public void the_user_enters_maximum_length_password_in_the_password_field(String password) {
loginScreenPage.enterPassword(password);
}
@Then("the system processes the login request without errors")
public void the_system_processes_the_login_request_without_errors() {
"Login request not processed successfully", loginScreenPage.isLoginProcessedSuccessfully();
}
@Then("the user is redirected to the home screen if credentials are valid")
public void the_user_is_redirected_to_the_home_screen_if_credentials_are_valid() {
"User is not redirected to home screen", loginScreenPage.isHomeScreenDisplayed();
}

@Given("I enter {string} in the email field")
public void i_enter_in_the_email_field(String email) {
loginScreenPage.enterEmail(email);
}
@When("I clickElement the login button")
public void i_click_the_login_button() {
loginScreenPage.clickLoginButton();
}
@When("the user enters an invalid password in the password field")
public void the_user_enters_an_invalid_password_in_the_password_field() {
loginScreenPage.enterInvalidPassword();
}
@Given("I leave the email password fields empty")
public void i_leave_the_email_password_fields_empty() {
loginScreenPage.leaveEmailAndPasswordFieldsEmpty();
}
@Given("the user leaves the organization email fields empty")
public void the_user_leaves_the_organization_email_fields_empty() {
loginScreenPage.leaveOrganizationEmailFieldsEmpty();
}
@Then("the system displays the error message we couldn’t find this organisation")
public void the_system_displays_the_error_message_we_couldn_t_find_this_organisation() {
Assert.assertEquals("we couldn’t find this organisation", loginScreenPage.getErrorMessage());
}
@Given("I enter a valid organization name in the organization field")
public void i_enter_a_valid_organization_name_in_the_organization_field() {
loginScreenPage.enterValidOrganizationName();
}
@Given("I enter {string} in the organization field")
public void i_enter_in_the_organization_field(String organization) {
loginScreenPage.enterOrganization(organization);
}
@Given("I enter a maximum length {string} in the password field")
public void i_enter_a_maximum_length_in_the_password_field(String password) {
loginScreenPage.enterPassword(password);
}
@Then("the user remains on the forgot password screen")
public void the_user_remains_on_the_forgot_password_screen() {
loginScreenPage.isOnForgotPasswordScreen();
}
@When("I clickElement the send button")
public void i_click_the_send_button() {
loginScreenPage.clickSendButton();
}
@Then("the login button should be disabled")
public void the_login_button_should_be_disabled() {
loginScreenPage.isLoginButtonDisabled();
}
@Given("the user leaves all fields (organization, email) empty")
public void the_user_leaves_all_fields_organization_email_empty() {
loginScreenPage.leaveAllFieldsEmpty();
}
@Given("I leave the password field empty")
public void i_leave_the_password_field_empty() {
loginScreenPage.leavePasswordFieldEmpty();
}
@Then("the system should display the error message your email or password is invalid")
public void the_system_should_display_the_error_message_your_email_or_password_is_invalid() {
Assert.assertEquals("your email or password is invalid", loginScreenPage.getErrorMessage());
}
@Given("I enter a maximum length {string} in the organization field")
public void i_enter_a_maximum_length_in_the_organization_field(String organization) {
loginScreenPage.enterOrganization(organization);
}
@Given("I leave the organization field empty")
public void i_leave_the_organization_field_empty() {
loginScreenPage.leaveOrganizationFieldEmpty();
}
@Then("the system displays an error message indicating the organization is invalid")
public void the_system_displays_an_error_message_indicating_the_organization_is_invalid() {
Assert.assertEquals("organization is invalid", loginScreenPage.getErrorMessage());
}
@Then("the system displays the error message your email or password is invalid")
public void the_system_displays_the_error_message_your_email_or_password_is_invalid() {
Assert.assertEquals("your email or password is invalid", loginScreenPage.getErrorMessage());
}
@Given("I enter a maximum length {string} in the email field")
public void i_enter_a_maximum_length_in_the_email_field(String email) {
loginScreenPage.enterEmail(email);
}
@Then("the user should remain on the login screen")
public void the_user_should_remain_on_the_login_screen() {
loginScreenPage.isOnLoginScreen();
}
@Given("I enter {string} in the password field")
public void i_enter_in_the_password_field(String password) {
loginScreenPage.enterPassword(password);
}
}