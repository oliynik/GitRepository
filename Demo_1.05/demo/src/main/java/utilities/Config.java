package utilities;

import java.util.concurrent.TimeUnit;

public class Config {

	public static final String baseUrl = "http://www.i.ua/";

	public static void browserSetUp() {
		Driver.Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.Instance.manage().window().maximize();
	}
}
