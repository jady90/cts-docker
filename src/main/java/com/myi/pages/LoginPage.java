package com.myi.pages;

import com.myi.enums.WaitStrategy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private By txtUsername = By.id("username");
    private By txtPassword = By.id("uapPassword");
    private By btnLogin = By.xpath("//button[normalize-space()='Log in']");

    private void enterUsername(String username){
        sendKeys(txtUsername, WaitStrategy.PRESENT,username, "Username field");
    }
    private void enterPassword(String password){
        sendKeys(txtPassword, WaitStrategy.NONE, password, "Password field");
    }
    private void clickOnLogin(){
        click(btnLogin, WaitStrategy.NONE, "Login button");
    }
    public void login(String username, String password, String otpcode){
        enterUsername(username);
        enterPassword(password);
        clickOnLogin();
        //Complete otp
        new OtpSetupPage().byPassOtp(otpcode);
    }
}
