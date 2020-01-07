package pageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipKartPage extends BasePage{

	public FlipKartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@title='Search for products, brands and more']")
	private WebElement searchTextBox;
	
	@FindBy(xpath="//*[@type='submit']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//*[contains(@href,'/apple-iphone-xr-yellow-64')]")
	private WebElement iPhoneYellow64GB;

	@FindBy(xpath = "//*[contains(@href,'/apple-iphone-xr-yellow-64-')]//parent::div//div[@class='_1vC4OE _2rQ-NK']")
	private WebElement priceOfiPhone;

	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	private WebElement closeButtonLoginPopUp;
	
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
	
	public void clicktoCloseLoginPopUp(){
		closeButtonLoginPopUp.click();
	}
	
	public boolean loginPopUpIsDisplayed(){
		return closeButtonLoginPopUp.isDisplayed();
	}
	
}
