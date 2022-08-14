package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FitoVitaminsPage extends BasePage {


    public FitoVitaminsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@value='41081']")
    private WebElement ButtonBasket;

    public SuccessAddToBasket addToBasket() {
        ButtonBasket.click();
        return new SuccessAddToBasket(driver);
    }
}
