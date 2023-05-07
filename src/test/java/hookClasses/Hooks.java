package hookClasses;


import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import xenosian.GenricUtility.BaseClass;
import xenosian.GenricUtility.PropertyFileUtility;
import xenosian.GenricUtility.WebDriverUtility;
/**
 * @author Ratan
 */
public class Hooks extends BaseClass{
	BaseClass base;
	
	public Hooks(BaseClass base) {
		this.base=base;
	}
	
	@Before
	public void setUp() throws Throwable {
		base.pUtil=new PropertyFileUtility();
		base.pUtil.loadProperty();
		base.wutil=new WebDriverUtility();
		String browser=base.pUtil.getBrowser();
		String remote=base.pUtil.remote();
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			base.driver=new ChromeDriver();
		}
		base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(base.pUtil.implicitWait()));
		base.driver.get(base.pUtil.getURL());
	}

	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenShot = base.wutil.takeScreenShot(base.driver);
			scenario.attach(screenShot, "image/png", scenario.getName());
		}
		//base.driver.close();	
	}
}
