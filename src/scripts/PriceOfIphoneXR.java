package scripts;

import org.testng.annotations.Test;

import genericUtility.Configuration;
import pageRepository.AmazonHomePage;
import pageRepository.FlipKartPage;

public class PriceOfIphoneXR extends Configuration{

	@Test
	public void getPriceOfIphoneXRYellowFromAmazon(){
		driver.get("https://www.amazon.in/");
		
		AmazonHomePage homePage = new AmazonHomePage(driver);
		homePage.enterSerachText("Apple iPhone XR (64GB)- Yellow");
		homePage.clickOnSearchButton();
		
		if(homePage.iPhoneYellow64GBisDisplayed())
		System.out.println("iPhone XR 64 GB -Yellow is Displayed and the Price in Amazon.in is  "+homePage.getPriceOfiPhoneYello64GB());
		
		else
			System.out.println("iPhone XR 64 GB -Yellow is not displayed");
	}
	
	
	@Test
	public void getPriceOfIphoneXRYellowFromFlipKart(){
		driver.get("https://www.flipkart.com/");
		
		FlipKartPage homePage = new FlipKartPage(driver);
		
		
		try{
			if (homePage.loginPopUpIsDisplayed()) {
				homePage.clicktoCloseLoginPopUp();
			}
		}catch(Exception e){
			System.out.println("Login pop up not is displayed");
		}
		finally {
			homePage.enterSerachText("Apple iPhone XR (64GB)- Yellow");
			homePage.clickOnSearchButton();
			if(homePage.iPhoneYellow64GBisDisplayed())
				System.out.println("iPhone XR 64 GB -Yellow is Displayed and the Price in FlipKart.com is  "+homePage.getPriceOfiPhoneYello64GB());
				
				else
					System.out.println("iPhone XR 64 GB -Yellow is not displayed");
		}
		
		
	}
}
