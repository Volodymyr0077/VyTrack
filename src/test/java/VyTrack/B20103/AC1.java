package VyTrack.B20103;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AC1 {
    WebDriver driver;

    @BeforeMethod

    public void setUpMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
    }
    @Test
    public void loginTestAC1() throws InterruptedException {
        driver.get("https://qa2.vytrack.com/");
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys("user160");
        WebElement passWord = driver.findElement(By.id("prependedInput2"));
        passWord.sendKeys("UserUser123" + Keys.ENTER);
        String expectedTitle="Dashboard";
        Thread.sleep(1000);
        String actualTitle=driver.getTitle();
        Assert.assertTrue(expectedTitle.equals(actualTitle) );

    }
}
