package taskfordemo.demo;

import org.openqa.selenium.By;
import utilities.Config;
import utilities.Driver;
import utilities.XmlParser;

public class MainPage {

	private XmlParser input = new XmlParser();

	public MailBoxPage loginAsUser() {
		Driver.Instance.navigate().to(Config.baseUrl);
		Driver.Instance.findElement(By.name("login")).clear();
		Driver.Instance.findElement(By.name("login")).sendKeys(input.parser().get(0));
		Driver.Instance.findElement(By.name("pass")).clear();
		Driver.Instance.findElement(By.name("pass")).sendKeys(input.parser().get(1));
		Driver.Instance.findElement(By.xpath("//input[@tabindex='5']")).click();
		return new MailBoxPage();
	}

	public PasportUaPage loginAsFakeUser() {
		Driver.Instance.navigate().to(Config.baseUrl);
		Driver.Instance.findElement(By.name("login")).clear();
		Driver.Instance.findElement(By.name("login")).sendKeys(input.parser().get(2));
		Driver.Instance.findElement(By.name("pass")).clear();
		Driver.Instance.findElement(By.name("pass")).sendKeys(input.parser().get(3));
		Driver.Instance.findElement(By.xpath("//input[@tabindex='5']")).click();
		return new PasportUaPage();
	}

	public void logout() {
		Driver.Instance.navigate().to(Config.baseUrl);
		Driver.Instance.findElement(By.xpath("//li[@class='right']//a")).click();
	}

}
