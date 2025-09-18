package com.rawteananya.ex_05_RA_TestNG_Eaxamples.TestNG_Annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Disable_Google_Notification {

    public static void main(String[] args) {


        // Using the chrome options to avoid the popup of Change Passowrd
        ChromeOptions options = new ChromeOptions();

        // Disable Chrome password manager popup
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notification");

        WebDriver driver = new ChromeDriver();
       // driver.get("https://the-internet.herokuapp.com/login");

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("iphone15" + Keys.ENTER);

        //needed to bypass it manually in selenium

    }
}
