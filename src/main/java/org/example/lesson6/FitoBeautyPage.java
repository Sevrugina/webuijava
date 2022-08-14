package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FitoBeautyPage extends BasePage {

    public FitoBeautyPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class=\"title-wrapper\" and contains(.,'Витамины')]")
    private WebElement VitaminsAlerana;

    public FitoVitaminsPage clickVitamins() {
        VitaminsAlerana.click();
        return new FitoVitaminsPage(driver);
    }
}