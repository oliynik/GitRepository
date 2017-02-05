package taskfordemo.demo;

import org.openqa.selenium.By;
import utilities.Driver;

public class MailBoxPage {

	public String getUser() {
		return Driver.Instance.findElement(By.xpath("//span[@class='sn_menu_title']")).getText();
	}

	public EmailPage newLetter() {
		Driver.Instance.findElement(By.xpath("//p[@class='make_message']//a")).click();
		return new EmailPage();
	}

	public void findLetter(String textForSearch) {
		Driver.Instance.findElement(By.name("text")).sendKeys(textForSearch);
		Driver.Instance.findElement(By.xpath("//span[@class='button l_r do_search']")).click();
	}

	public void openMessage() {
		Driver.Instance.findElement(By.xpath("//span[@class='sbj']")).click();
	}

	public String getLetterSubject() {
		return Driver.Instance.findElement(By.xpath("//div[@class='message_header iua_support clear']//h3")).getText();
	}

	public String checkSending() {
		return Driver.Instance.findElement(By.xpath("//div[@class='block_confirmation']")).getText();
	}
}
