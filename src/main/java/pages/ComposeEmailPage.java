//// ComposeEmailPage.java
package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComposeEmailPage {
	private WebDriver driver;

	//@FindBy(name = "to")
	@FindBy(css = "input[aria-label='To recipients']")
	private WebElement toInput;

	@FindBy(name = "subjectbox")
	private WebElement subjectInput;

	@FindBy(xpath = "//div[@aria-label='Message Body']")
	private WebElement bodyInput;

//	@FindBy(xpath = "//div[contains(@aria-label, 'Send')]")
//	private WebElement sendButton;
	@FindBy(css = "div[aria-label='Send ‪(Ctrl-Enter)‬']")
	private WebElement sendButton;

	// Constructor
	public ComposeEmailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods
	public void fillRecipient(String recipient) throws InterruptedException {
		// Thread.sleep(1000);
		toInput.sendKeys(recipient);
		Thread.sleep(1000);
	}

	public void fillSubject(String subject) throws InterruptedException {
		// Thread.sleep(1000);
		subjectInput.sendKeys(subject);
		Thread.sleep(1000);
	}

	public void fillBody(String body) throws InterruptedException {
		// Thread.sleep(1000);
		bodyInput.sendKeys(body);
		Thread.sleep(1000);
	}

	public boolean isButtonEnabled() {
		return sendButton.isEnabled();
	}

	public void clickSend() throws InterruptedException {
		if (isButtonEnabled()) {
			System.out.println(isButtonEnabled());
			sendButton.click();
			Thread.sleep(1000);
		} else {
			System.out.println("Send button is disabled.");
		}
	}
//    public void clickSend() throws InterruptedException {
//        sendButton.click();
//        boolean isSendButtonEnabled = isButtonEnabled(sendButton);
//        System.out.println("Is send button enabled? " + isSendButtonEnabled);
//        Thread.sleep(10000);
//    }
}
