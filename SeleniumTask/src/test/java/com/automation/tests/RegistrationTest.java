package com.automation.tests;

import com.automation.pageobjects.Registration;
import com.automation.utils.ScreenshotUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest {
    private WebDriver driver;
    private Registration registration;
    private Faker faker;

    @BeforeEach
    public void setUp() {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        registration = new Registration(driver);
        faker = new Faker();
        driver.get("https://codenboxautomationlab.com/registration-form/");
    }

    @Test
    @Description("Testing Registration website")
    @Story("User Registration")
    public void testRegistration() {
        // Generating dynamic data
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String phone = faker.phoneNumber().cellPhone();
        String email = faker.internet().emailAddress();

        // Complete the registration form with generated data
        registration.completeRegistration(firstName, lastName, phone, email, "Selenium Automation", "November");

        String confirmationMessage = registration.getConfirmationMessage();

        // Assert the confirmation message with screenshot on failure
        try {
            assertEquals("Your registration is completed. We will contact with you soon. Thank you !", confirmationMessage);
        } catch (AssertionError e) {
            ScreenshotUtil.captureScreenshot(driver, "registration_failure");
            throw e;
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
