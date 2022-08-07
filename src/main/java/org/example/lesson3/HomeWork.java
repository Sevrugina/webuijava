package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


//   Проверка на сайте https://afisha.relax.by/ работы вкладок "Кино",а затем "Фантастика"

public class HomeWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://afisha.relax.by/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//a[@href=\"https://afisha.relax.by/kino/minsk/\" and contains(.,'Кино') ]")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Кино в Минске']")));
        driver.findElement(By.xpath("//a[@href=\"https://afisha.relax.by/kino/minsk/fantastika/\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Фантастика в кино Минска']")));
        Thread.sleep(5000);
        driver.quit();
    }
}
