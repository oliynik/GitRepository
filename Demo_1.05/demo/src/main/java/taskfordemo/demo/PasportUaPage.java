package taskfordemo.demo;

import org.openqa.selenium.By;
import utilities.Driver;

public class PasportUaPage {

	public String getPageInfo() {
		return Driver.Instance.findElement(By.xpath("//div[@class='content clear']")).getText();
	}

}
