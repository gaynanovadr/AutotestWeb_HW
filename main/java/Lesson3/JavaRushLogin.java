package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class JavaRushLogin {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://javarush.ru/");
        driver.manage().timeouts().implicityWait(3,TimeUnit.SECONDS);

        //login into account (maximize the window)
        WebElement headerLogin = driver.findElement(By.id("button_menu_start_learning_unauthorized_user"));
        headerLogin.click();
        driver.findElement(By.id("id_button_jr_welcome_proceeding_to_login")).click();
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("gaynanovadr@mail.ru");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("****");
        driver.findElement(By.id("button_auth_form_sign_in")).click();
        Thread.sleep(7000);

        //opening the course and adding comment
        driver.findElement(By.xpath("//a[@href=\"/quests\"]")).click();
        driver.findElement(By.xpath("//a[@href=\"/quests/lectures\"]")).click();
        
        driver.findElement(By.xpath("//a[@href=\"https://javarush.ru/quests/lectures/questsyntaxpro.level01.lecture01\"]")).click();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(20))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder=\"Введите текст комментария\"]")));

        driver.findElement(By.xpath("//textarea[@placeholder=\"Введите текст комментария\"]")).click();
        driver.findElement(By.xpath("//textarea[@placeholder=\"Введите текст комментария\"]")).sendKeys("It was easy!");
        driver.findElement(By.xpath("//b[text()=\"Отправить\"]")).click();
        
        driver.quit();



    }
}
