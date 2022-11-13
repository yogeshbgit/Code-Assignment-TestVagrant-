package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Wiki {

	WebDriver driver;
	public Wiki(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By date = By.xpath("//div[text()='Release date']/parent::th/following-sibling::td//li");
	By country = By.xpath("//th[normalize-space()='Country']/following-sibling::td");
	public WebElement getreleasedate() 
	{
		return driver.findElement(date);
	}
	
	public WebElement getcountry()
	{
		return driver.findElement(country);
	}
	
}
