import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;


public class Magento {
    WebDriver driver;


    @BeforeClass
    public void setup() {
        // Set the path to the ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void createAccount() {
        driver.get("https://magento.softwaretestingboard.com/");
        // Click "Create an Account"
        driver.findElement(By.linkText("Create an Account")).click();
        String randomEmail = EmailGenerator.generateRandomEmail();
        System.out.println("Using Email: " + randomEmail);
        // Fill out account information
        driver.findElement(By.id("firstname")).sendKeys("Ahmed");
        driver.findElement(By.id("lastname")).sendKeys("Sherif");
        driver.findElement(By.id("email_address")).sendKeys(randomEmail);
        driver.findElement(By.id("password")).sendKeys("Test@1234");
        driver.findElement(By.id("password-confirmation")).sendKeys("Test@1234");

        // Submit the form
        driver.findElement(By.cssSelector("button.action.submit.primary")).click();

        //Validate account creation

        WebElement welcomeMessage = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div"));
        Assert.assertTrue(welcomeMessage.isDisplayed(), "The welcome message is not displayed.");
        String expectedMessage = "Thank you for registering with Main Website Store.";
        String actualMessage = welcomeMessage.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage), "The welcome message does not contain the expected text. Actual message: " + actualMessage);
    }

    @Test(priority = 2)
    public void navigateToHotSellersAndCompareProducts() {
        // Navigate to Home page
        WebDriver webdriver = null;
        driver.findElement(By.cssSelector(".logo")).click();
        WebElement hotSellersSection = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[5]/div/div/ol"));

        // Scroll to "Hot Sellers" section
        ((ChromeDriver) driver).executeScript("arguments[0].scrollIntoView(true);", hotSellersSection);
        // Assert that the "Hot Sellers" section is displayed
        assert hotSellersSection.isDisplayed() : "Hot Sellers section is not visible on the page.";
        System.out.println("Successfully navigated to the 'Hot Sellers' section.");
        // Perform mouse hover on the first product

        Actions actions = new Actions(driver);
        WebElement firstProductContainer = driver.findElement(By.xpath("(//li[contains(@class, 'product-item')])[1]"));
        actions.moveToElement(firstProductContainer).perform();
        System.out.println("Mouse hovered over the first product.");
        // Add the first products to the compare list
        WebElement firstProduct = driver.findElement(By.xpath("(//a[@title='Add to Compare'])[1]"));
        firstProduct.click();
        // Wait for the success message
        driver.findElement(By.cssSelector(".message-success"));
        System.out.println("First product added to compare list.");
        // Hover over the second product and add to compare
        WebElement secondProductContainer = driver.findElement(By.xpath("(//li[contains(@class, 'product-item')])[2]"));
        actions.moveToElement(secondProductContainer).perform();
        System.out.println("Mouse hovered over the second product.");
        WebElement secondProduct = driver.findElement(By.xpath("(//a[@title='Add to Compare'])[2]"));
        secondProduct.click();
        // Wait for the success message
        driver.findElement(By.cssSelector(".message-success"));
        System.out.println("Second product added to compare list.");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }

    }
}
