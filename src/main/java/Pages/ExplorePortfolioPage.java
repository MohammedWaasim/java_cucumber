package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplorePortfolioPage {
	WebDriver driver;

	public ExplorePortfolioPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Customise')]")
	private WebElement customiseButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Reset')]")
	private WebElement resetButton;

	@FindBy(how = How.XPATH, using = "//input[@data-isin='SPY']")
	private WebElement spdrSlider;

	@FindBy(how = How.XPATH, using = "//input[@data-isin='SPY']/../../div[1]")
	private WebElement spdrAllocation;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Rebalance')]")
	private WebElement rebalanceButton;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Invest Now')]")
	private WebElement investNowButton;

	public void clickCustomiseButton() throws Exception {
		customiseButton.click();
	}

	public void waitUntilResetButtonDisplayed() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(resetButton));
	}

	public void clickRebalanceButton() throws Exception {
		rebalanceButton.click();
	}

	public void clickInvestNowButton() throws Exception {
		investNowButton.click();
	}

	public void clickResetButton() throws Exception {
		customiseButton.click();
	}

	public void clickSlider() throws Exception {
		spdrSlider.click();
	}

	public String getSpdrAllocation() throws Exception {
		return spdrAllocation.getText();
	}

	public void clickRequiredKey(String keyName) throws Exception {
		if (keyName.contains("rightKey")) {
			this.driver.switchTo().activeElement().sendKeys(Keys.ARROW_RIGHT);
		} else if (keyName.contains("leftKey")) {
			driver.switchTo().activeElement().sendKeys(Keys.ARROW_LEFT);
		}
	}

}
