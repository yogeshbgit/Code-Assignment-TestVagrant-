package Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	public Properties pro;
	public WebDriver initilazier() throws IOException
	{
		pro = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\Coding_Assignment_TestVagrant\\src\\main\\java\\Resource\\data.properties");
		pro.load(file);
		String browsername = pro.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:/YOGI/Softwares/Testing/Firefox Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public String getScreenshotPath(String methodname,WebDriver driver) throws IOException
	{
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     String  destinationfile = System.getProperty("user.dir")+"\\ExtentReports\\"+methodname+".png";
	     FileUtils.copyFile(scrFile, new File(destinationfile));
	     
		 return destinationfile;
	}
	
	public void scrolltillelement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
}