package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WeatherPortfolioPage {
	WebDriver driver;
	
	public WeatherPortfolioPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Customize Portfolio')][1]")
	private WebElement customizePortfolioButton;
	
	public void clickCustomizePortfolioButton() throws Exception{
		customizePortfolioButton.click();
	
	}
}
