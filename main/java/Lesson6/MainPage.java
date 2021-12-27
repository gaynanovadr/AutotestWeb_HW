package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseView{

    public MainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="button_menu_start_learning_unauthorized_user")
    private WebElement headerLoginButton;
    public MainPage clickOnHeaderLoginButton () {
        headerLoginButton.click();
        return this;
    }

}

