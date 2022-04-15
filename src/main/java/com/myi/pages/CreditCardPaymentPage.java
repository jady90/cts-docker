package com.myi.pages;

import com.myi.driver.DriverManager;
import com.myi.enums.WaitStrategy;
import org.openqa.selenium.By;

public class CreditCardPaymentPage extends BasePage {

    private By btnEditPaymentDetails = By.cssSelector("button[class*='btn-primary']");
    private By btnBack = btnBack = By.cssSelector("button[class*='btn-secondary']");
    private By txtCardHolderName = By.id("creditCardHolder");
    private By txtCardNbr = By.id("bambora-card-number");
    private By txtExpiryDate = By.id("bambora-expiry");
    private By txtCvv = By.id("bambora-cvv");
    private By chkAuthReq = By.id("termsAndConditions");
    private By btnUpdate = By.cssSelector("button[class*='btn-primary']");
    private By lblChangesSaved = By.cssSelector("[class='alert-title'] strong");

    public CreditCardPaymentPage clickOnEditPaymentDetails(){
        click(btnEditPaymentDetails, WaitStrategy.VISIBLE, "Edit payment details CTA");
        return this;
    }

    public CreditCardPaymentPage enterCardHolderName(String name){
        sendKeys(txtCardHolderName, WaitStrategy.VISIBLE, name, "Card holder name field");
        return this;
    }

    public CreditCardPaymentPage enterCreditCardNbr(String cardNbr){
        goToFrame(txtCardNbr);
        sendKeys(txtCardNbr, WaitStrategy.VISIBLE, cardNbr, "credit card number field");
        DriverManager.getDriver().switchTo().defaultContent();
        return this;
    }

    public CreditCardPaymentPage enterCardExpiryDate(String expiryDate){
        if(goToFrame(txtExpiryDate)){
            sendKeys(txtExpiryDate, WaitStrategy.VISIBLE, expiryDate, "card expiry date field");
        }
        else{
            System.out.println("Not able to switch to Frame");
        }
        DriverManager.getDriver().switchTo().defaultContent();
        return this;
    }

    public CreditCardPaymentPage enterCvv(String cVV){
        goToFrame(txtCvv);
        sendKeys(txtCvv, WaitStrategy.NONE, cVV, "cvv field");
        DriverManager.getDriver().switchTo().defaultContent();
        return this;
    }

    public CreditCardPaymentPage clickOnTermsAndConditions(){
        DriverManager.getDriver().switchTo().defaultContent();
        click(chkAuthReq, WaitStrategy.NONE, "terms nd conditions checkbox");
        return this;
    }

    public BillingConfirmationPage clickOnUpdate(){
        click(btnUpdate, WaitStrategy.NONE, "Update field");
        return new BillingConfirmationPage();
    }

}
