package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForPageToLoad() throws Exception {
		int count = 0;
		while (count != 5) {
			Thread.sleep(1000);
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				if (js.executeScript("return document.readyState").toString()
						.equals("complete")) {
					break;
				}

			} catch (Exception e) {
				System.out.println("page didnot appear");
			}
			count++;
		}
	}

}
