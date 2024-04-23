package pages;

import org.openqa.selenium.JavascriptExecutor;
//LoginPage.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;

	@FindBy(id = "identifierId")
	private WebElement emailInput;

	@FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
	private WebElement passwordInput;

	@FindBy(id = "passwordNext")
	private WebElement passwordNextButton;

	@FindBy(id = "identifierNext")
	private WebElement nextButton;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Methods
	public void enterEmail(String email) throws InterruptedException {
		emailInput.sendKeys(email);
		Thread.sleep(1000);
	}

	public void enterPassword(String password) throws InterruptedException {
		Thread.sleep(1000);
		passwordInput.sendKeys(password);
		boolean isEnabled = (boolean) ((JavascriptExecutor) driver)
				.executeScript("return arguments[0].disabled === false", passwordInput);
		System.out.println("Is password input enabled? " + isEnabled);
		Thread.sleep(1000);
	}

	public void clickNext() throws InterruptedException {
		nextButton.click();
		Thread.sleep(1000);
	}

	public void clickPasswordNext() throws InterruptedException {
		passwordNextButton.click();
		Thread.sleep(2000);
	}
}
