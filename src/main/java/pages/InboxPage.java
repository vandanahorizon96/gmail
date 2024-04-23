//// InboxPage.java
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='T-I T-I-KE L3']")
    private WebElement composeButton;

    // Constructor
    public InboxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods
    public void clickCompose() throws InterruptedException {
        composeButton.click();
        Thread.sleep(2000);
    }
}
