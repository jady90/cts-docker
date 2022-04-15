package com.myi.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.myi.enums.WaitStrategy;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class OtpSetupPage extends BasePage{

    private By dialogBoxOtp = By.xpath("//mat-dialog-container[@id='mat-dialog-0']");
    private By btnTextMe = By.cssSelector("div[class='cdk-global-overlay-wrapper'] div:nth-child(2) div:nth-child(1) button:nth-child(1)");
    private By btnCallMe = By.xpath("//button[normalize-space()='Call me']");
    private By txtOtpCode = By.id("code");
    private By btnEnter = By.xpath("//button[normalize-space()='Enter']");

    public void byPassOtp(String otpCode){
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        if(getListSize(btnTextMe) >0){
            click(btnTextMe, WaitStrategy.PRESENT, "Text Me button");
            sendKeys(txtOtpCode, WaitStrategy.VISIBLE, otpCode, "Otp Code field");
            click(btnEnter, WaitStrategy.NONE, "Enter button");
        }
    }


}
