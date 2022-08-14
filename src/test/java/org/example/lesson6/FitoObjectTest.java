package org.example.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FitoObjectTest {
    WebDriver driver;
    @BeforeAll
    static void registerDriverFito() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initDriverFito() {
        driver = new ChromeDriver();
        driver.get("https://fito.by");
    }

    @Test

    void putVitaminsAleranaToBasketTest() throws InterruptedException {
        new FitoMainPage(driver).clickBeauty()
                .clickVitamins()
                .addToBasket()
                .checkAddToBasket();

    }
    @AfterEach
    void killBrowserFito() {
        driver.quit();
    }
}
