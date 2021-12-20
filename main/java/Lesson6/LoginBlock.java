package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginBlock extends BaseView{

    public LoginBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="id_button_jr_welcome_proceeding_to_login")
    private WebElement welcomeToLoginButton;
    public LoginBlock clickOnWelcomeLoginButton () {
        welcomeToLoginButton.click();
        return this;
    }
    private final static String LOGIN_INPUT_XPATH_LOCATOR = "//input[@name=\"email\"]";
    @FindBy(xpath=LOGIN_INPUT_XPATH_LOCATOR)
    private WebElement loginInput;

    public LoginBlock fillLoginInput (String login) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGIN_INPUT_XPATH_LOCATOR)));
        loginInput.sendKeys(login);
        return this;
    }
    @FindBy(xpath="//input[@name=\"password\"]")
    private WebElement passwordInput;
    public LoginBlock fillPasswordInput (String pass) {
        passwordInput.sendKeys(pass);
        return this;
    }
    private final static String SUBMIT_LOGIN_ID_LOCATOR = "button_auth_form_sign_in";
    @FindBy(id=SUBMIT_LOGIN_ID_LOCATOR)
    private WebElement submitLoginButton;

    public PersonalPage submitLoginButton(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SUBMIT_LOGIN_ID_LOCATOR)));
        submitLoginButton.click();
        return new PersonalPage(driver);
    }


}
