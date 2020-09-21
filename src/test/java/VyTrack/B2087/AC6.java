package VyTrack.B2087;

import com.sun.org.apache.xpath.internal.operations.And;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AC6 {

    WebDriver driver;


    @BeforeMethod

    public void setUpMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/");
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys("user160");
        WebElement passWord = driver.findElement(By.id("prependedInput2"));
        passWord.sendKeys("UserUser123" + Keys.ENTER);
    }
    @Test
    //Given I am on Vehicles Odometer page as a Truck Driver
    public void test1() throws InterruptedException {

        WebElement fleetElement = driver.findElement(By.cssSelector("span[class='title title-level-1']"));
        fleetElement.click();//clicking on Fleet button
        WebElement vehicleOdometer = driver.findElement(By.linkText("Vehicle Odometer"));
        vehicleOdometer.click();//clicking on Vehicle odometer button

        // When I click on Grid settings symbol on the right top of the grid

       WebElement gridSettings = driver.findElement(By.xpath("//a[@title='Grid Settings']"));
        gridSettings.click();//clicking on a grit settings button

        //And select/deselect the properties of the odometer as I want it to be displayed

        List<WebElement> gridSetting = driver.findElements(By.xpath("//*[contains(@id,'column')]"));// list of grid setting buttons

        for (WebElement each : gridSetting) {//clicking on every setting button
            Thread.sleep(500);
            each.click();
        }

        WebElement idColumn=driver.findElement(By.xpath("//span[@class='grid-header-cell__label']"));// header Column

        String ColumnTestExpected="ID";
        String ColumnTextActual = idColumn.getText();

        Assert.assertEquals(ColumnTextActual, ColumnTestExpected);
        gridSettings.click();//clicking on a grit settings button

        WebElement resetButton= driver.findElement(By.linkText("Reset"));
        resetButton.click();// clicking on reset button


    }
}
