package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IMDB {
	WebDriver driver;
	public IMDB(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By date = By.xpath("//li[@data-testid='title-details-releasedate']//li//a");
	By country = By.xpath("//li[@data-testid='title-details-origin']//li//a");
	
	public WebElement getreleasedate() 
	{
		return driver.findElement(date);
	}
	
	public WebElement getcountry()
	{
		return driver.findElement(country);
	}
}
