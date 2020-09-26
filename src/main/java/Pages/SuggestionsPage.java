package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SuggestionsPage {

	WebDriver driver;

	public SuggestionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div/span[contains(text(),'SPDR')]/../../div[3]/span[1]")
	private WebElement spdrText;

	public String getSpdrText() throws Exception {
		return spdrText.getText();

	}
}
