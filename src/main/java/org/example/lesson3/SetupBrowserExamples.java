package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupBrowserExamples {
    public static void main(String[] args) throws InterruptedException {
        // Будем настраивать браузер Хром

        WebDriverManager.chromedriver().setup();

        //Сайт с настройками Хром браузера https://peter.sh/experiments/chromium-command-line-switches/
        //  Создаем обьект chromOptions в который будем добавлять аргументы для настроек

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--disable-notifications"); // запретить браузеру показывать всплывающие нотификации

        //Заходим на страницу как Google-бот (прикидываемся роботом)
        //для робота простая страница без стилей как в 50-е годы
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)");


        //запуск драйвера без визуальной составляющей, чтобы тратить меньше ресурсов,работа мышкой не мешает автотестам
        // на удаленном стенде CI/CD только с этим аргументом
        chromeOptions.addArguments("--headless");//без головы, те без интерфейса, мы его не увидим


        // запуск драйвера

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("http://google.com");
        Thread.sleep(5000);
        driver.quit();

    }
}
