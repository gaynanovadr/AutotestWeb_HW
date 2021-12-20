package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class PersonalPage extends BaseView {
    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    private final static String COMMENT_AREA_XPATH_LOCATOR = "//div[@class=\"article__discussion\"]";
    @FindBy(xpath=COMMENT_AREA_XPATH_LOCATOR)
    private WebElement commentAreas;

    public PersonalPage scrollToComments() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(COMMENT_AREA_XPATH_LOCATOR)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",commentAreas);
        return this;
    }
    private final static String COMMENT_INPUT_XPATH_LOCATOR = "//textarea[@placeholder=\"Введите текст комментария\"]";
    @FindBy(xpath=COMMENT_INPUT_XPATH_LOCATOR)
    private WebElement commentInput;

    public PersonalPage leaveComment(String comment){
        webDriverWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(COMMENT_INPUT_XPATH_LOCATOR)));
        commentInput.click();
        commentInput.sendKeys(comment);
        return this;
    }
    @FindBy(xpath="//button[@class=\"ng-star-inserted button button--success button--sm-wide\"]")
    private WebElement submitComment;

    public PersonalPage submitComment() {
        submitComment.click();
        return this;
    }
    private final static String COMMENT_DISPLAYED_XPATH_LOCATOR = "//div[text()=\" (1)\"]";
    @FindBy (xpath=COMMENT_DISPLAYED_XPATH_LOCATOR)
    private WebElement commentIsDisplayedElement;

    public PersonalPage checkCommentIsDisplayed (){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(COMMENT_DISPLAYED_XPATH_LOCATOR)));
        assertThat(driver.findElement(By.xpath(COMMENT_DISPLAYED_XPATH_LOCATOR)), isDisplayed());
        return this;
    }
}
