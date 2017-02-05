package taskfordemo.demo;

import org.openqa.selenium.By;
import utilities.Driver;

public class EmailPage {

	public void setTO(String to) {
		Driver.Instance.findElement(By.id("to")).sendKeys(to);
	}

	public void setSubject(String subject) {
		Driver.Instance.findElement(By.name("subject")).sendKeys(subject);
	}

	public void setBody(String body) {
		Driver.Instance.findElement(By.id("text")).sendKeys(body);
	}

	public void submitButton() {
		Driver.Instance.findElement(By.name("send")).click();
	}
}
