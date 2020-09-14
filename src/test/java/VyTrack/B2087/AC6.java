package VyTrack.B2087;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
    }
    @Test
    public void VtTrackTest1() throws InterruptedException {
        driver.get("https://qa2.vytrack.com/");
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys("user160");
        WebElement passWord = driver.findElement(By.id("prependedInput2"));
        passWord.sendKeys("UserUser123" + Keys.ENTER);


        WebElement fleetElement = driver.findElement(By.cssSelector("span[class='title title-level-1']"));
        fleetElement.click();//clicking on Fleet button
        WebElement vehicleOdometer=driver.findElement(By.linkText("Vehicle Odometer"));
        vehicleOdometer.click();//clicking on Vehicle odometer button
        WebElement gridSettings=driver.findElement(By.xpath("//a[@title='Grid Settings']"));
        gridSettings.click();//clicking on a grit settings button

      List<WebElement>gridSetting= driver.findElements(By.xpath("//*[contains(@id,'column')]"));// list of grid setting buttons

      for(WebElement each:gridSetting){//clicking on every setting button
          Thread.sleep(500);
            each.click();
        }
      driver.close();


    }




}
