package Coding_Assignment_TestVagrant;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import PageObject.IMDB;
import Resource.Base;
import io.github.bonigarcia.wdm.WebDriverManager;


public class IMDB_Test extends Base {

	public  WebDriver driver;
	public String Date,Month,Year,Country;
	@Test(priority=1)
	public void ValidateIMDB() throws IOException
	{
	   WebDriverManager.chromedriver().setup();
		 driver = initilazier();
		 driver.get("https://www.imdb.com/title/tt9389998/?ref_=nv_sr_srsg_0");
		 driver.manage().window().maximize();
		 IMDB imdb = new IMDB(driver);
		 String ReleaseDate = imdb.getreleasedate().getText().split("\\(")[0];
		   Date = ReleaseDate.split(" ")[1].split(",")[0];
		   Month = ReleaseDate.split(" ")[0];
		   Year = ReleaseDate.split(", ")[1].trim();
		  Country=imdb.getcountry().getText();
		  scrolltillelement(driver,imdb.getreleasedate());
		 System.out.println("Release Date : "+ReleaseDate);
		 System.out.println("Country of Origin : "+Country);

	}
@AfterTest
public void TearDown()
{
	driver.close();
}


	
}
