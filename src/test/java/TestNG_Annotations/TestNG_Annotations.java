package TestNG_Annotations;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class TestNG_Annotations {

        WebDriver driver;

        // @BeforeSuite - This will run before the suite begins
        @BeforeSuite
        public void beforeSuite() {
            System.out.println("Before Suite: Running once before the test suite.");
        }

        // @BeforeTest - This will run before any test is executed
        @BeforeTest
        public void beforeTest() {
            System.out.println("Before Test: Running before any test.");
        }

        // @BeforeClass - This will run before the first test method in the class
        @BeforeClass
        public void beforeClass() {
            System.out.println("Before Class: Running once before the first test method.");
        }

        // @BeforeMethod - This will run before each @Test method
        @BeforeMethod
        public void setup() {
            System.out.println("Before Method: Setting up WebDriver.");
            // Initialize WebDriver
           WebDriver driver = new ChromeDriver();
        }

        // @Test - This is the test method where actual test steps are written
        @Test
        public void testGoogleTitle() {
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com");
            String title = driver.getTitle();
            System.out.println("Title of the page is: " + title);
            // You can add assertions here to validate the title
        }


        // @Test - Another test method
        @Test
        public void testFacebookTitle() {
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.facebook.com");
            String title = driver.getTitle();
            System.out.println("Title of the page is: " + title);
            // You can add assertions here to validate the title
        }

        // @AfterMethod - This will run after each @Test method
        @AfterMethod
        public void tearDown() {
            System.out.println("After Method: Closing the browser.");
           // driver.quit();
        }

        // @AfterClass - This will run after all the test methods in this class
        @AfterClass
        public void afterClass() {
            System.out.println("After Class: All tests in this class have finished.");
        }

        // @AfterTest - This will run after all the tests in the test tag are executed
        @AfterTest
        public void afterTest() {
            System.out.println("After Test: Running after all the tests.");
        }

        // @AfterSuite - This will run after the suite finishes
        @AfterSuite
        public void afterSuite() {
            System.out.println("After Suite: Running once after the test suite.");
        }
    }

