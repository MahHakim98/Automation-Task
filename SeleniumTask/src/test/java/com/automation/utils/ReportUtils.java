package com.automation.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReportUtils {
    private WebDriver driver;

    public ReportUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void captureScreenshot(String testName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot.toPath(), Paths.get("screenshots/" + testName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logTestResult(String testName, boolean status) {
        // Implementation for logging results to a file or console
        System.out.println("Test: " + testName + " | Status: " + (status ? "PASSED" : "FAILED"));
    }
}
