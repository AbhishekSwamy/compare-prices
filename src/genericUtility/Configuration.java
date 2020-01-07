package genericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Configuration {

	public String data_filepath = "testData/data.xls";

	public String geckoDriver_path = "drivers/";

	public WebDriver driver;

	public String chromeDriver_path = "drivers/";
	
	public String url;


	@BeforeMethod
	public void precondition() {
		String browserName = Utility.getData(data_filepath, "config", 2, 0);

		if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", geckoDriver_path + "geckodriver.exe");
			driver = new FirefoxDriver();
		}

		if (browserName.equals("CC")) {
			System.setProperty("webdriver.chrome.driver", chromeDriver_path + "chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.close();
	}
}