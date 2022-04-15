package com.myi.pages;

import com.myi.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class PadPaymentPage extends BasePage {

    private By btnEditPaymentDetails = By.cssSelector("button[class*='btn-primary']");
    private By btnBack = By.cssSelector("button[class*='btn-secondary']");
    private By txtPadHolderName = By.id("bankAccountHolderName");
    private By txtTransitNbr = By.id("transitNumber");
    private By txtFinInstNbr = By.id("institutionNumber");
    private By txtBankAccNbr = By.id("bankAccountNumber");
    private By chkAuthReq = By.id("authorizedRequest");
    private By btnUpdate = By.cssSelector("button[class*='btn-primary']");
    private By lblChangesSaved = By.cssSelector("[class='alert-title'] strong");

    public PadPaymentPage clickOnEditPaymentDetails(){
        click(btnEditPaymentDetails, WaitStrategy.VISIBLE, "Edit Payment details CTA");
        return this;
    }
    public PadPaymentPage enterAccountHolderName(String name){
        clearValueFromTextField(txtPadHolderName, WaitStrategy.VISIBLE);
        sendKeys(txtPadHolderName, WaitStrategy.VISIBLE, name, "account holder name field");
        return this;
    }
    public PadPaymentPage enterTransitNbr(String transitNbr){
        sendKeys(txtTransitNbr, WaitStrategy.NONE, transitNbr, "transit number field");
        return this;
    }
    public PadPaymentPage enterFinInstNbr(String finInstNbr){
        sendKeys(txtFinInstNbr, WaitStrategy.NONE, finInstNbr, "financial inst. number field");
        return this;
    }
    public PadPaymentPage enterBankAccountNbr(String bankAccountNbr){
        clearValueFromTextField(txtBankAccNbr, WaitStrategy.NONE);
        sendKeys(txtBankAccNbr, WaitStrategy.NONE, bankAccountNbr, "bank account number field");
        return this;
    }
    public PadPaymentPage clickOnTermsAndConditions(){
        click(chkAuthReq, WaitStrategy.NONE, "terms and conditions");
        return this;
    }
    public BillingConfirmationPage clickOnUpdate(){
        click(btnUpdate, WaitStrategy.NONE, "Update CTA");
        return new BillingConfirmationPage();
    }
}
