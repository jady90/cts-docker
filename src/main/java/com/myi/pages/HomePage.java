package com.myi.pages;

import com.myi.enums.WaitStrategy;
import org.openqa.selenium.By;

public class HomePage extends BasePage{

    private By lblMypolicies = By.xpath("//a[normalize-space()='Manage Policies']");
    private By lnkMyBilling = By.xpath("//a[normalize-space()='My Billing']");
    private By linkDownloadPinkCard = By.cssSelector("div[class='policy-links'] a[href*='PinkCard']");

    public MyBillingPage goToMyBillingPage(){
        click(lnkMyBilling, WaitStrategy.PRESENT, "My Billing link");
        return new MyBillingPage();
    }

    public void clickMyPolicies(){
        click(lblMypolicies, WaitStrategy.VISIBLE, "Manage Policies link");
    }

}
