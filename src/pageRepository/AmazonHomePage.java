package pageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends BasePage {

	public AmazonHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchTextBox;
	
	@FindBy(xpath="//*[@type='submit' and @class='nav-input']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//span[contains(text(),'Apple iPhone XR (64GB) - Yellow')]")
	private WebElement iPhoneYellow64GB;

	@FindBy(xpath = "//*[contains(text(),'Apple iPhone XR (64GB) - Yellow')]//ancestor::div[6]//span[@class='a-price-whole']")
	private WebElement priceOfiPhone;

	public void enterSerachText(String inputString) {
		searchTextBox.sendKeys(inputString);
	}

	public void clickOnSearchButton(){
		searchButton.click();
	}
	
	public boolean iPhoneYellow64GBisDisplayed(){
		return iPhoneYellow64GB.isDisplayed();
	}
	
	public String getPriceOfiPhoneYello64GB(){
		return priceOfiPhone.getText();
	}

}
