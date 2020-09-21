package VyTrack.B2088;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AC6_Roman {
public static void waitTime (int seconds)  {
try {
    Thread.sleep(seconds * 1000);
}catch (InterruptedException e){}
}

    public static void main(String[] args)  {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa2.vytrack.com/");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.xpath("//input[@name='_username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='_password']"));

        username.sendKeys("user160");
        password.sendKeys("UserUser123" + Keys.ENTER);

        waitTime(4);
        WebElement fleetButton = driver.findElement(By.linkText("Fleet"));
        fleetButton.click();

        waitTime(2);
        WebElement vehicleOdometer = driver.findElement(By.linkText("Vehicle Odometer"));
        vehicleOdometer.click();
        waitTime(4);

        WebElement gridSettings = driver.findElement(By.xpath("//a[@title='Grid Settings']"));
        gridSettings.click();
        waitTime(4);

        WebElement idCheckButton = driver.findElement(By.xpath("//input[@id='column-c596']"));
        idCheckButton.click();
        waitTime(2);

        driver.navigate().refresh();
        waitTime(4);

        WebElement refreshButton = driver.findElement(By.xpath("//a[@title='Reset']"));
        refreshButton.click();
        waitTime(5);

        driver.close();

    }


}
