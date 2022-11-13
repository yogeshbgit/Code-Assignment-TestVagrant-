package Coding_Assignment_TestVagrant;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import PageObject.Wiki;
import Resource.Base;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Wiki_Test extends Base {
public  WebDriver driver;

	
	@Test(priority=1)
	public void ValidateWIKI() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		IMDB_Test it = new IMDB_Test();
		it.ValidateIMDB();
		it.TearDown();
		driver = initilazier();
		 driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		 driver.manage().window().maximize();
		 Wiki wiki = new Wiki(driver);
		 String ReleaseDate = wiki.getreleasedate().getText();
		 String date = ReleaseDate.split(" ")[0];
			String month = ReleaseDate.split(" ")[1];
			String year = ReleaseDate.split(" ")[2];
		 String Country=wiki.getcountry().getText();
		 scrolltillelement(driver,wiki.getreleasedate());
		 System.out.println("Release Date : "+ReleaseDate);
		 System.out.println("Country of Origin : "+Country);
		 Assert.assertEquals(it.Country,Country);
		 Assert.assertEquals(it.Date, date);
			Assert.assertEquals(it.Month, month);
			Assert.assertEquals(it.Year, year);
			
      
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
}
