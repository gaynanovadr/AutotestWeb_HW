package Lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaRashTest {
    WebDriver driver;
    MainPage mainPage;
    LoginBlock loginBlock;
    private final static String JAVARUSH_BASE_URL = "https://javarush.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        mainPage = new MainPage(driver);
        loginBlock = new LoginBlock(driver);

        //webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //actions = new Actions(driver);
        driver.get(JAVARUSH_BASE_URL);
        driver.manage().window().maximize();
    }
    @Test
    void writeCommentOnLectures(){
        new MainPage(driver).clickOnHeaderLoginButton();

        new LoginBlock(driver)
                .clickOnWelcomeLoginButton()
                .fillLoginInput("gaynanovadr@mail.ru")
                .fillPasswordInput("40Rem5060")
                .submitLoginButton();
    }

    @AfterEach
    void tearDown() {
        driver.quit();

    }
}
