package com.myi.pages;

import com.myi.enums.WaitStrategy;
import org.openqa.selenium.By;

public class SelectPaymentInfoPage extends BasePage {

    private By btnEditPaymentDetails = By.cssSelector("button[class*='btn-primary']");
    private By btnBack = By.cssSelector("button[class*='btn-secondary']");

    public void clickOnEditPaymentDetails(){
        click(btnEditPaymentDetails, WaitStrategy.VISIBLE, "Edit payment details CTA");

    }

    public void clickOnBack(){
        click(btnBack, WaitStrategy.NONE, "Back CTA");
    }

}
