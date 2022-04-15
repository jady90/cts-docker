package com.myi.pages;

import com.myi.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class MyBillingPage extends BasePage {

    private By tabAuto = By.xpath("//span[contains(@class, 'td-icon-car')]/parent::a");
    private By tabHome = By.xpath("//span[contains(@class, 'td-icon-home')]/parent::a");
    private By btnEditPaymentDates = By.cssSelector("a[href*='modifyPaymentDate']");
    private By btnEnrollToCc = By.cssSelector("a[href*='changeToCc']");
    private By btnEditPadDetails = By.cssSelector("a[href*='updatePad']");
    private By btnEnrollToPad = By.cssSelector("a[href*='changeToPad']");
    private By btnEditCcDetails = By.cssSelector("a[href*='updateCc']");


    public MyBillingPage clickOnProductTab(String productType){
        if(productType.equalsIgnoreCase("auto")){
            click(tabAuto, WaitStrategy.VISIBLE, "Auto tab");
        }
        else if(productType.equalsIgnoreCase("home")){
            click(tabHome, WaitStrategy.VISIBLE, "Home tab");
        }
        return this;
    }
    public PaymentDatesPage clickOnEditPaymentsDate(){
        click(btnEditPaymentDates, WaitStrategy.VISIBLE, "Edit Payment Dates");
        return new PaymentDatesPage();
    }
    public CreditCardPaymentPage ClickOnEnrollToCc(){
        click(btnEnrollToCc, WaitStrategy.CLICKABLE, "Enroll to Credit Card");
        return new CreditCardPaymentPage();
    }
    public PadPaymentPage clickOnEditPadDetails(){
        click(btnEditPadDetails, WaitStrategy.VISIBLE, "Edit PAD Details");
        return new PadPaymentPage();
    }
    public PadPaymentPage clickOnEnrollToPad(){
        click(btnEnrollToPad, WaitStrategy.VISIBLE, "Enroll to PAD");
        return new PadPaymentPage();
    }
    public CreditCardPaymentPage clickOnEditCcDetails(){
        click(btnEditCcDetails, WaitStrategy.VISIBLE, "Edit Credit Card Details");
        return new CreditCardPaymentPage();
    }

}
