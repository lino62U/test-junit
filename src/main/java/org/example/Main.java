package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        //Set up web driver (chrome, firefox,...)
        //System.setProperty("webdriver.gecko.driver", "C:\\...\\Selenium\\Selenium WebDriver\\Java\\Libs\\geckodriver-v0.23.0-win32\\geckodriver.exe");

        WebDriver driver = new ChromeDriver();
        //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch website
        driver.navigate().to("http://www.calculator.net/");

        //Maximize the browser
        driver.manage().window().maximize();

        // Click on Math Calculators
        driver.findElement(By.xpath("//*[@id=\"homelistwrap\"]/div[3]/div[2]/a")).click();

        // Click on Percent Calculators
        driver.findElement(By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td/div[3]/a")).click();

        // Enter value 10 in the first number of the percent Calculator
        driver.findElement(By.id("cpar1")).sendKeys("10");

        // Enter value 50 in the second number of the percent Calculator
        driver.findElement(By.id("cpar2")).sendKeys("50");

        // Click Calculate Button
        driver.findElement(By.xpath("//*[@id=\"content\"]/form[1]/table/tbody/tr[2]/td/input[2]")).click();


        // Get the Result Text based on its xpath
        String result = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b")).getText();


        // Print a Log In message to the screen
        System.out.println(" The Result is " + result);

        //Close the Browser.
        driver.close();

    }
}