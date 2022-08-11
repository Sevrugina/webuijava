package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

import static java.awt.SystemColor.menu;

public class FitoByTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String FITO_BY_URL = "https://fito.by";

    @BeforeAll
    static  void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void  setupBrowser(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(FITO_BY_URL);
    }
    @Test
            void PutInBasketTest() throws InterruptedException {

        driver.findElement(By.xpath("//a[@href=\"https://fito.by/product-category/beauty/\" and contains(.,'Красота')]/i")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("[class=\"woocommerce-breadcrumb breadcrumbs\"]")));
        driver.findElement(By.xpath("//p[contains(@class,\"name product-title\")]/a[contains(@href,\"https://fito.by/product/10521-alerana-vitaminy-dlya-ukrepleniya-i-rosta-volos-n60/\")]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"product-info summary col-fit col entry-summary product-summary text-left\"]")));

        driver.findElement(By.xpath("//button[@name=\"add-to-cart\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"ttt-pnwc-close\"]")));
        //Thread.sleep(5000);
        Assertions.assertEquals(driver.findElement(By.xpath("//button[@class=\"ttt-pnwc-close\"]")).isDisplayed(), true);
    }

    @Test
    void hoverHealthClickHealthyFoodTest() throws InterruptedException {
        actions.moveToElement(driver.findElement(By.xpath("//a[@href='https://fito.by/product-category/health/' and contains(.,\"Здоровье\")]/i")))
                .build()
                .perform();
        //Thread.sleep(5000);
        SystemColor item;
        Object https;
        driver.findElement(By.xpath("//li[@id=\"menu-item-18544\"]/a")).click();
        Assertions.assertEquals(driver.getCurrentUrl(), "https://fito.by/product-category/health/health-nutrition/");

    }

    @AfterEach
    void quitBrowser(){
        driver.quit();
    }
}
