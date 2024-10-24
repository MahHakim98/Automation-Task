package com.automation.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Registration {
    private WebDriver driver;
    private WebDriverWait wait;

    // Here We Locating elements
    @FindBy(id = "nf-field-17")
    private WebElement firstNameInput;

    @FindBy(id = "nf-field-18")
    private WebElement lastNameInput;

    @FindBy(id = "nf-field-20")
    private WebElement phoneInput;

    @FindBy(id = "nf-field-19")
    private WebElement emailInput;

    @FindBy(id = "nf-field-22")
    private WebElement selectCourseDropdown;

    @FindBy(id = "nf-field-24")
    private WebElement selectMonthDropdown;

    @FindBy(id = "nf-label-class-field-23-1")
    private WebElement radioButton;

    @FindBy(id = "nf-field-15")
    private WebElement submitButton;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/main/article/div/div[1]/div/div[1]/p\n")
    private WebElement confirmationMessage;

    // Driver and Wait
    public Registration(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // Scroll into view method
    private void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Inputs area
    public void enterFirstName(String firstname) {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput));
        firstNameInput.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        lastNameInput.sendKeys(lastname);
    }

    public void enterPhone(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void selectCourse(String course) {
        selectCourseDropdown.sendKeys(course);
    }

    public void selectMonth(String month) {
        selectMonthDropdown.sendKeys(month);
    }

    public void selectRadioButton() {
        scrollToElement(radioButton);
        if (!radioButton.isSelected()) {
            radioButton.click();
        }
    }

    public void clickSignup() {
        scrollToElement(submitButton); // Scroll to the submit button
        submitButton.click();
    }

    // Assert Actual
    public String getConfirmationMessage() {
        wait.until(ExpectedConditions.visibilityOf(confirmationMessage));
        return confirmationMessage.getText(); // Getting text
    }

    // Complete methods
    public void completeRegistration(String firstname, String lastname, String phone, String email, String course, String month) {
        enterFirstName(firstname);
        enterLastName(lastname);
        enterPhone(phone);
        enterEmail(email);
        selectCourse(course);
        selectMonth(month);
        selectRadioButton();
        clickSignup();
    }
}
