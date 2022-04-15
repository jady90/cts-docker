package com.myi.tests;

import com.myi.annotations.FrameworkAnnotation;
import com.myi.pages.HomePage;
import com.myi.pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class EnrollToCreditCardAndPadTest extends BaseTest {

    @FrameworkAnnotation(author = "JD", category = "Regression")
    @Test(priority = 1)
    public void enrollToCcTest(Map<String, String> map){
        new LoginPage().login(map.get("username"),
                map.get("password"), map.get("otpcode"));

        boolean isSuccess = new HomePage().goToMyBillingPage()
                .clickOnProductTab(map.get("product"))
                .ClickOnEnrollToCc()
                .clickOnEditPaymentDetails()
                .enterCardHolderName(map.get("cardholdername"))
                .enterCreditCardNbr(map.get("ccnumber"))
                .enterCardExpiryDate(map.get("expirydate"))
                .enterCvv(map.get("cvv"))
                .clickOnTermsAndConditions()
                .clickOnUpdate()
                .verifyUpdateConfirmation();
        Assertions.assertThat(isSuccess)
                .as("Billing update failed").isEqualTo(true);
    }

    @FrameworkAnnotation(author = "JD", category = "Regression")
    @Test(priority = 2)
    public void EnrollToPad(Map<String, String> map){
        new LoginPage().login(map.get("username"),
                map.get("password"), map.get("otpcode"));

        boolean isSuccess = new HomePage().goToMyBillingPage()
                .clickOnProductTab(map.get("product"))
                .clickOnEnrollToPad()
                .clickOnEditPaymentDetails()
                .enterAccountHolderName(map.get("bankaccholdername"))
                .enterTransitNbr(map.get("transitumber"))
                .enterFinInstNbr(map.get("fininstnumber"))
                .enterBankAccountNbr(map.get("bankaccnumber"))
                .clickOnTermsAndConditions()
                .clickOnUpdate()
                .verifyUpdateConfirmation();
        Assertions.assertThat(isSuccess)
                .as("Billing update failed").isEqualTo(true);
    }
}
