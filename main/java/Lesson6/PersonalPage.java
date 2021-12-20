package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PersonalPage extends BaseView {
    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@class=\"article__discussion\"]")
    private WebElement commentFields;

    public PersonalPage scrollToComments() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class=\"article__discussion\"]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", commentFields);
        return this;
    }
    private final static String COMMENT_INPUT_XPATH_LOCATOR = "//textarea[@placeholder=\"Введите текст комментария\"]";
    @FindBy(xpath=COMMENT_INPUT_XPATH_LOCATOR)
    WebElement commentInput;

    public PersonalPage leaveComment(String comment){
        webDriverWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(COMMENT_INPUT_XPATH_LOCATOR)));
        commentInput.click();
        commentInput.sendKeys(comment);
        
        return this;
    }

}
