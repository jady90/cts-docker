package com.myi.tests;

import com.myi.annotations.FrameworkAnnotation;
import com.myi.pages.HomePage;
import com.myi.pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class LoginTest extends BaseTest {

    @FrameworkAnnotation(author = "JD", category = "Regression")
    @Test()
    public void loginTest(Map<String, String> map) {

        new LoginPage().login(map.get("username"),
                map.get("password"), map.get("otpcode"));

        //To verify Home Page is displayed after Login
        HomePage homePage = new HomePage();
        homePage.clickMyPolicies();

        //Verify Title of the page
        String title = homePage.getTitle();
        Assertions.assertThat(title)
                .as(title + " is not as expected").isEqualTo("My Policies");
    }
}
