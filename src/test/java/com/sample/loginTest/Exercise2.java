package com.sample.loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/*
 Q: Implement a mehotds named LoginTest() for the following scenario:
  Step1: You will navigate to some web page that has a 'SIGN IN' link, click on it.
  Step2: It opens a new tab to sign in,navigate to the new tab.
  Step3: Enter the username and password and hit next
  Step4: you wil be signed in and shown an image on successful signin

*/
public class Exercise2
{
    WebDriver driver;
    @BeforeTest
    void setUpMethod()
    {
        System.setProperty("webdriver.chrome.driver","/Users/lee/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @AfterTest()
    void tearDown()
    {
        driver.quit();
    }


    @Test
    void signIn()
    {
        driver.get("https://artsandculture.google.com/");
        driver.findElement(By.linkText("Sign in")).click();

        Set<String> tabs = driver.getWindowHandles();
        for(String tab: tabs)
        {
            driver.switchTo().window(tab);
            if(driver.getTitle().equals("Sign in - Google Accounts"))
            {
                break;
            }
        }

        driver.findElement(By.id("identifierId")).sendKeys("regressionjun25");
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        driver.findElement(By.name("password")).sendKeys("Coimbatore123");
        driver.findElement(By.xpath("//span[text()='Next']")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Profile']/div/div"))));
        Assert.assertTrue(driver.findElement(By.xpath("//a[@title='Profile']/div/div")).isDisplayed());


    }
}
