package com.gb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class JavaRushTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String url = "https://javarush.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    void openCourseAndLectures() throws InterruptedException { //open lectures
        login();

        driver.findElement(By.xpath("//a[@href=\"/quests\" and @class=\"sidebar-nav-link\"]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href=\"/quests/lectures\"]")));
        driver.findElement(By.xpath("//a[@href=\"/quests/lectures\"]")).click();

        assertThat(driver.getCurrentUrl(), containsString("lectures"));
    }

    @Test
    void writeCommentOnLectures() throws InterruptedException {
        login();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class=\"article__discussion\"]")));
        //Thread.sleep(4000);
        WebElement commentField = driver.findElement(By.xpath("//div[@class=\"article__discussion\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", commentField);

        webDriverWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//textarea[@placeholder=\"Введите текст комментария\"]")));
        driver.findElement(By.xpath("//textarea[@placeholder=\"Введите текст комментария\"]")).click();
        driver.findElement(By.xpath("//textarea[@placeholder=\"Введите текст комментария\"]")).sendKeys("It was easy!");
        driver.findElement(By.xpath("//button[@class=\"ng-star-inserted button button--success button--sm-wide\"]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()=\" (1)\"]")));
        Assertions.assertEquals(driver.findElement(By.xpath("//div[text()=\" (1)\"]")).isDisplayed(), true);
        assertThat(driver.findElement(By.xpath("//div[text()=\" (1)\"]")), isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    void login() throws InterruptedException {
        WebElement headerLogin = driver.findElement(By.id("button_menu_start_learning_unauthorized_user"));
        headerLogin.click();
        driver.findElement(By.id("id_button_jr_welcome_proceeding_to_login")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"email\"]")));
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("gaynanovadr@mail.ru");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("40Rem5060");
        driver.findElement(By.id("button_auth_form_sign_in")).click();
        Thread.sleep(5000);
    }


}
