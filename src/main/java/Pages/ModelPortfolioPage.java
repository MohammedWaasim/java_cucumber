package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ModelPortfolioPage {

	WebDriver driver;

	public ModelPortfolioPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "btn-explore79")
	private WebElement allWeatherStrategyExploreButton;

	public void clickAllWeatherStrategyExploreButton() throws Exception {
		allWeatherStrategyExploreButton.click();

	}
}
