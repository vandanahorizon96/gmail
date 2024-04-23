//GmailAutomationTest.java
package testpages;

import pages.LoginPage;
import pages.InboxPage;
import pages.ComposeEmailPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GmailAutomationTest {
	private WebDriver driver;
	private LoginPage loginPage;
	private InboxPage inboxPage;
	private ComposeEmailPage composeEmailPage;

	@BeforeClass
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://mail.google.com");
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		Thread.sleep(1000);
		inboxPage = new InboxPage(driver);
		Thread.sleep(1000);
		composeEmailPage = new ComposeEmailPage(driver);
		Thread.sleep(1000);
	}

	@Test
	public void loginAndComposeEmail() throws InterruptedException {
		loginPage.enterEmail("testingdemo9548@gmail.com");
		loginPage.clickNext();
		loginPage.enterPassword("test@#1748$");
		loginPage.clickPasswordNext();

		Thread.sleep(2000);

		inboxPage.clickCompose();

		// Wait for compose email page to load

		Thread.sleep(2000);

		// Compose email
		composeEmailPage.fillRecipient("akhiljp5352@gmail.com");
		composeEmailPage.fillSubject("Test mail");
		composeEmailPage.fillBody("This is a test mail");
		composeEmailPage.clickSend();
		// Add some wait here as Gmail might take time to load password field
		// Continue with other actions using page objects
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
