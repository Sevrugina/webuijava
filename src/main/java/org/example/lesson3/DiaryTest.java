package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class DiaryTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
     //   driver.get("https://diary.ru/user/login");//можно сразу страницу авторизации https://diary.ru/user/login
        // создали переменную loginform типа WebElement тк драйвер возвращает этот тип
        // Ctrl+мышка на findElement видим WebDriver класс и что возвращает
    //    WebElement loginForm = driver.findElement(By.id("loginform-username"));
        //обращаемся к переменной loginForm, жмем (.) и см какие методы есть у этой переменной
    //    loginForm.sendKeys("allasevr");//передаем текст к-рый хотим напечатать в окне-логин
        //можно сразу обраиться к WebElement без записи в перем loginForm
    //    driver.findElement(By.id("loginform-password")).sendKeys("123456");
        // теперь капча, она грузится с гугла это видно по iframe-веб стр внутри веб стр
        // драйвер, переключись в iframe! и найди элемент капча с текстом @title='reCAPTCHA'driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        //теперь мы внутри капчи ищем элемент, где нужно поставить галочку и кликаем на него
    //    driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        // надо нажать на кнопку "войти", но перед этим выйти из iframe,переключиться назад
    //    driver.switchTo().parentFrame();
        //ищем локатор для кнопки "войти"
    //    driver.findElement(By.id("login_btn")).click();

        //Закомментировали всю авторизацию, чтобы попробовать авторизоваться с помощью куки

        driver.get("https://diary.ru");

        //нужно создать куку
        Cookie cookie = new Cookie("_identity_","5d1acfc8e8be7dd4e8dd6afd05a52614774dc95acacedeaa919cc7893f8effc3a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3570658%2C%225DvZq_M5XhHMfPUh0-i39LoT6tXlfaBp%22%2C2592000%5D%22%3B%7D");

        // передаем куку драйверу
        driver.manage().addCookie(cookie);
        //перезагружаем страницу
        driver.navigate().refresh();
        // для удаления куки driver.manage().getCookieNamed("_identity_");

        // хотим кликнуть на элемент "Новая запись", строим локатор по Id
        driver.findElement(By.id("writeThisDiary")).click();
        // чтобы номера тестов генерировались рандомно и добавлялись к слову test
        //иначе любая проверка добавляла бы новую запись с одинаковым словом test
        String postTile = "test" + new Random().nextInt(1000);
        driver.findElement(By.id("postTitle")).sendKeys(postTile);
        //ищем локатор для окна создания новой записи, опять frame
        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.id("tinymce")).sendKeys("не имей сто рублей ,а имей сто друзей");
        driver.switchTo().parentFrame();
        // локатор для кнопки "опубликовать"
        driver.findElement(By.id("rewrite")).click();
        //хотим найти локатор,чтобы перейти в тот пост (новая запись),которую мы создали
        //имя поста подставили в локатор
        //driver.findElement(By.xpath(String.format("//a[text()='%s']",postTile))).click();
        List<WebElement> postTitles = driver.findElements(By.xpath("//a[@class='title']"));
        postTitles.stream().filter(p -> p.getText().equals(postTile)).findFirst().get().click();
        Thread.sleep(5000);



        String a = ""; // пустая строка для останова
        driver.quit();

    }
}
