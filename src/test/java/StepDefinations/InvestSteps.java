package StepDefinations;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.BasePage;
import Pages.ExplorePortfolioPage;
import Pages.ModelPortfolioPage;
import Pages.SuggestionsPage;
import Pages.WeatherPortfolioPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InvestSteps {

	WebDriver driver;
	BasePage basePage = new BasePage(driver);

	@Given("^I launch beta version of model-portfolio$")
	public void i_launch_beta_version_of_model_portfolio() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("------------os-------------");
		String ostype=System.getProperty("os.name");
		System.out.println(ostype);
		switch (ostype) {
			    case "Windows": 
					System.setProperty("webdriver.chrome.driver",
					"C:\\driver\\chromedriver.exe");
			    break;
			    case "Mac OS X": 
				System.setProperty("webdriver.chrome.driver",
				"/Users/mohammedwaasim/Documents/workspace_python/drivers/chromedriver");
			    break;
		}
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://beta.weinvest.net/model-portfolio");
		basePage.waitForPageToLoad();
		ModelPortfolioPage modelPortfolio = new ModelPortfolioPage(driver);
		modelPortfolio.clickAllWeatherStrategyExploreButton();

	}

	@And("^I navigate to Explore Portfolio screen$")
	public void i_navigate_to_Explore_Portfolio_screen() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		basePage.waitForPageToLoad();
		WeatherPortfolioPage weatherPortfolio = new WeatherPortfolioPage(driver);
		weatherPortfolio.clickCustomizePortfolioButton();

	}

	@When("^I change the SPDR slider to \"([^\"]*)\" percent and click on 'Rebalance'$")
	public void i_change_the_SPDR_slider_to_percent_and_click_on_Rebalance(
			String allocation) throws Throwable {
		// basePage.waitForPageToLoad();
		ExplorePortfolioPage explorePortfolio = new ExplorePortfolioPage(driver);
		explorePortfolio.clickCustomiseButton();
		explorePortfolio.waitUntilResetButtonDisplayed();
		explorePortfolio.clickSlider();
		for (int i = 0; i < 80; i++) {
			if (explorePortfolio.getSpdrAllocation().contains(allocation)) {
				break;
			} else if (Integer.parseInt(explorePortfolio.getSpdrAllocation()
					.substring(0, 2)) < Integer.parseInt(allocation)) {
				explorePortfolio.clickRequiredKey("rightKey");
			} else if (Integer.parseInt(explorePortfolio.getSpdrAllocation()
					.substring(0, 2)) > Integer.parseInt(allocation)) {
				explorePortfolio.clickRequiredKey("leftKey");
			}
		}
		explorePortfolio.clickRebalanceButton();
		explorePortfolio.clickInvestNowButton();
	}

	@Then("^I verify SPDR is set to \"([^\"]*)\" percent on suggestions screen$")
	public void i_verify_SPDR_is_set_to_percent_on_suggestions_screen(
			String spdrPercentage) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		basePage.waitForPageToLoad();
		SuggestionsPage suggession = new SuggestionsPage(driver);
		Assert.assertEquals(suggession.getSpdrText(), spdrPercentage);

	}

	@After()
	public void afterStep(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			scenario.embed(((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.BYTES), "image/png");
			scenario.write("Scenario Failed at Verification, Please see the Screenshot embeded in the Report");
		} else {
			scenario.write("Test Case Passed Successfully");
		}
		driver.close();
	}

}
