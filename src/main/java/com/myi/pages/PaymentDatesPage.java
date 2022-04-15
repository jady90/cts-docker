package com.myi.pages;

import com.myi.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PaymentDatesPage extends BasePage {

    private By btnNextPaymentDate = By.cssSelector("a[href*='nextPayment']");
    private By btnAllPaymentDates = By.cssSelector("a[href*='allDates']");
    private By txtNextPaymentDate = By.id("nextPaymentDateInput");
    private By iconDateSelectionCalender = By.cssSelector("div[class*='td-icon-bookAppointment']");
    private By daysOfMonth = By.cssSelector("tr[role='row'] td[role='gridcell']");
    private By btnUpdate = By.cssSelector("button[class*='btn-primary']");
    private By dropdownPaymentDate = By.id("newPaymentDateInput");


    public PaymentDatesPage clickOnNextPaymentDate(){
        click(btnNextPaymentDate, WaitStrategy.VISIBLE, "Next Payment Date CTA");
        return this;
    }
    public PaymentDatesPage clickOnDateSelectionCalender(){
        click(iconDateSelectionCalender, WaitStrategy.VISIBLE, "Calender icon");
        return this;
    }
    public PaymentDatesPage selectDate(String dateValue){
        List<WebElement> availableDates = getElementsList(daysOfMonth);
        for(int i=0; i<=availableDates.size(); i++){
            if(availableDates.get(i).getText().equalsIgnoreCase(dateValue)){
                availableDates.get(i).click();
                break;
            }
        }
        return this;
    }
    public PaymentDatesPage clickOnAllFuturePaymentsDate(){
        click(btnAllPaymentDates, WaitStrategy.VISIBLE, "All Future Payments date CTA");
        return this;
    }
    public PaymentDatesPage selectDateFromDropdown(String dayOfMonth){
        selectByValue(dropdownPaymentDate, WaitStrategy.VISIBLE, dayOfMonth, "payment date dropdown");
        return this;
    }
    public BillingConfirmationPage clickOnUpdate(){
        click(btnUpdate, WaitStrategy.CLICKABLE, "Update CTA");
        return new BillingConfirmationPage();
    }
}
