package org.example.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SuccessAddToBasket extends BasePage {

    public SuccessAddToBasket(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@class=\"ttt-pnwc-close\"]")
    private WebElement successBasket;

    public SuccessAddToBasket checkAddToBasket() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[@class=\"ttt-pnwc-close\"]")));
        Assertions.assertTrue(successBasket.isDisplayed());
        return this;
    }

}
