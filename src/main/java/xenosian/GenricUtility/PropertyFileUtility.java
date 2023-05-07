package xenosian.GenricUtility;
/**
 * @author Ratan
 */
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {

	Properties property;
	/**
	 * below method will Load the property file before utilizing the key and value
	 * @throws Throwable
	 */
	public void loadProperty() throws Throwable {
		FileInputStream fis=new FileInputStream(IFilePath.propertyFile);
		property=new Properties();
		property.load(fis);
	}

	public String getBrowser() {
		return property.getProperty("browser");
		
	}
	public String getURL() {
		return property.getProperty("url");
	}
	public String getUserName() {
		return property.getProperty("username");
	}
	public String getPassword() {
		return property.getProperty("password");
	}
	public int implicitWait() {
		return Integer.parseInt(property.getProperty("implicitwait"));
	}
	public int explicitWait() {
		return Integer.parseInt(property.getProperty("explicitwait"));
	}
	
	public String remote() {
		return property.getProperty("remote");
	}
}
