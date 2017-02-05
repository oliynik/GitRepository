package taskfordemo.demo;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.Config;
import utilities.Driver;
import utilities.LetterBuilder;

public class BaseTests {

	@BeforeTest
	public void setUp() {
		Driver.Initialize("chrome");
		Config.browserSetUp();
	}

	@AfterTest
	public void close() {
		Driver.close();
	}

	@Test(priority = 1)
	public void logInOutTest() {
		MainPage mainPage = new MainPage();
		MailBoxPage mailBox = mainPage.loginAsUser();
		AssertJUnit.assertTrue(mailBox.getUser().contains("userfordemo@i.ua"));
		mainPage.logout();
	}

	@Test(priority = 2)
	public void FailedLogInTest() {
		MainPage mainPage = new MainPage();
		PasportUaPage mailBox = mainPage.loginAsFakeUser();
		AssertJUnit.assertTrue(mailBox.getPageInfo().contains("Невірний логін або пароль"));
	}

	@Test(priority = 3)
	public void InboxTest() {
		MainPage mainPage = new MainPage();
		MailBoxPage mailBox = mainPage.loginAsUser();
		mailBox.findLetter("Ласкаво просимо на I.UA!");
		mailBox.openMessage();
		AssertJUnit.assertTrue(mailBox.getLetterSubject().contains("Ласкаво просимо на I.UA!"));
		mainPage.logout();
	}

	@Test(priority = 4)
	public void SendMessageTest() {
		MainPage mainPage = new MainPage();
		MailBoxPage mailBox = mainPage.loginAsUser();
		mailBox.newLetter();
		EmailPage letter = new LetterBuilder().setTO("userfordemo@i.ua").setSubject("Hello!")
				.setBody("Banana banana na na").build();
		letter.submitButton();
		AssertJUnit.assertTrue(mailBox.checkSending().contains("Лист успішно відправлено адресатам"));
		mainPage.logout();
	}

}
