package xenosian.GenricUtility;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	/**
	 * Use this method for entering the value
	 * @param element
	 * @param text
	 */
	public void sendValues(WebElement element,String text) {
		element.sendKeys(text);
	}
	/**
	 * Use this method for mouse hover action on element
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element) {

		Actions ac=new Actions(driver);
		ac.moveToElement(element).perform();;
	}
	/**
	 * Use this method for mouse hover action on element
	 * @param driver
	 * @param element
	 */
	public void scrollWindow(WebDriver driver,WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		int yOffset=element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+yOffset+")",element);
	}
	/**
	 * If element is not intractable using selenium click call this method
	 * @param driver
	 * @param element
	 */
	public void jsClick(WebDriver driver,WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
	}
	/**
	 * Select the drop down based on index
	 * @param element
	 * @param index
	 */
	public void dropDownByIndex(WebElement element,int index) {
		Select sl=new Select(element);
		sl.selectByIndex(index);
	}
	/**
	 * Select dropdown based on visible text
	 * @param element
	 * @param visibleText
	 */
	public void dropDownByVisibleText(WebElement element,String visibleText) {
		Select sl=new Select(element);
		sl.selectByVisibleText(visibleText);
	}
	/**
	 * To accept alert popup
	 * @param driver
	 */
	public void acceptAlertPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * To dismiss alert popup
	 * @param driver
	 */
	public void dissmissAlertpopup(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * Takes screenshot in byte format
	 * @param driver
	 * @param screenshotName
	 * @return byte stream of screenshot
	 */
	public byte[] takeScreenShot(WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		return ts.getScreenshotAs(OutputType.BYTES);
	}
	/**
	 * Switch to the tab or new window opened by parent window 
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToWindow(WebDriver driver,String partialTitle) {
		Set<String> ids=driver.getWindowHandles();
		for (String str : ids) {
			driver.switchTo().window(str);
			String title=driver.getTitle();
			if (title.contains(partialTitle)) {
				break;
			}
		}
	}


}
