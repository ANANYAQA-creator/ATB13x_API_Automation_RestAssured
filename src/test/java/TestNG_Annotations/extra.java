package TestNG_Annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class extra {

    public static void main(String[] args) {

        // Using the chrome options to avoid the popup of Change Passowrd
        ChromeOptions options = new ChromeOptions();

        // Disable Chrome password manager popup
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notification");

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }
}
