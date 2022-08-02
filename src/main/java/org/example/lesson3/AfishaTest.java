package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AfishaTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.afisha.ru/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //хотим ввести название фильма
        driver.findElement(By.xpath("//input[@placeholder='Событие, актер, место']")).sendKeys("Брат");
        //умное ожидание с условием
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));// максимум ждем 5 секунд
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Брат']")));
       // webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[.='Брат']"))));
        //Thread.sleep(5000);
        driver.findElement(By.xpath("//div[.='Брат']")).click();
        Thread.sleep(5000);
        driver.quit();


    }
}
