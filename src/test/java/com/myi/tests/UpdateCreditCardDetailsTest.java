package com.myi.tests;

import com.myi.annotations.FrameworkAnnotation;
import com.myi.pages.HomePage;
import com.myi.pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class UpdateCreditCardDetailsTest extends BaseTest {

    @FrameworkAnnotation(author = "JD", category = "Regression")
    @Test
    public void updateCcDetailsTest(Map<String, String> map){
        new LoginPage().login(map.get("username"),
                map.get("password"), map.get("otpcode"));

        boolean isSuccess = new HomePage().goToMyBillingPage()
                .clickOnProductTab(map.get("product"))
                .clickOnEditCcDetails()
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
}
