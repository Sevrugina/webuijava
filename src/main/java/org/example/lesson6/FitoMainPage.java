package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FitoMainPage extends BasePage {

    public FitoMainPage(WebDriver driver) {
        super(driver);
    }
@FindBy(xpath = "//a[@class=\"nav-top-link\" and (.=\"Красота\")]/i")
    public WebElement beautyMain;

    public FitoBeautyPage clickBeauty() {
        beautyMain.click();
        return new FitoBeautyPage(driver);
    }

}