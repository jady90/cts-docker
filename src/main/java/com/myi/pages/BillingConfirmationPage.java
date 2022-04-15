package com.myi.pages;

import com.myi.enums.WaitStrategy;
import org.openqa.selenium.By;

public class BillingConfirmationPage extends BasePage {

    private By lblChangesSaved = By.cssSelector("[class='alert-title'] strong");

    public boolean verifyUpdateConfirmation(){
        return isDisplayed(lblChangesSaved, WaitStrategy.VISIBLE, "Saved Changes message");
    }

}
