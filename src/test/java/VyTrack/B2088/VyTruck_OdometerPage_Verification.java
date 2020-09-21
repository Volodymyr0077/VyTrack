package com.cybertek.tests.Practice5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VyTruck_OdometerPage_Verification {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // this is just a step to maximize the webBrowser
        driver.manage().window().maximize();
        // go to "https://qa2.vytrack.com/user/login"
        driver.get("https://qa2.vytrack.com/user/login");
        // find the element of username and password
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys("user160");
        Thread.sleep(3000);
        WebElement passWord = driver.findElement(By.id("prependedInput2"));
        passWord.sendKeys("UserUser123" + Keys.ENTER);
        Thread.sleep(3000);
        // Clicks on Fleet module
        WebElement fleetElement = driver.findElement(By.cssSelector("span[class='title title-level-1']"));
        fleetElement.click();
        Thread.sleep(3000);
        WebElement vehicleOdometerElement = driver.findElement(By.xpath("//span[.='Vehicle Odometer']"));
        vehicleOdometerElement.click();
        // gets the "create vehicle odometer element and clicks on it"
        //  WebElement createVehicleOdometerElement = driver.findElement(By.xpath("//a.='Create Vehicle Odometer'"));
        // driver.findElement(By.xpath("//a[@class ='btn main-group btn-primary pull-right ']")).click();
        // driver.findElement(By.xpath("//a[@title ='Create Vehicle Odometer']")).click();
        Thread.sleep(4000);
        WebElement createVehicleOdometerElement=  driver.findElement(By.xpath("//a[@title ='Create Vehicle Odometer']"));
        createVehicleOdometerElement.click();
        Thread.sleep(4000);

        WebElement createOdometerValue = driver.findElement(By.xpath("//input[@name=\'custom_entity_type[OdometerValue]\']"));
        createOdometerValue.sendKeys("1");
        Thread.sleep(3000);

        WebElement createDriver = driver.findElement(By.xpath("//input[@name=\'custom_entity_type[Driver]\']"));
        createDriver.sendKeys("Agit AY");
        Thread.sleep(2000);

        WebElement clickSaveAndClose = driver.findElement(By.xpath("//button[@class='btn btn-success action-button' ]"));
        clickSaveAndClose.click();

        if(createDriver.isDisplayed()){
            System.out.println("Odomoter is created. Verification PASSED!");
        }else{
            System.out.println("Odomoter is NOT created.Verification FAILED!");
        }

    }
}

/* AC#2 - Given I am on Vehicles Odometers page as a truck driver
When I click create Vehicle Odometer button at the top right
And click add&save
Then I should be able to see new Vehicle Odometer on the grid.*/