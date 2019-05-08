package com.csg.ksrtc;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

    public class Ksrtc 
    {
	     public WebDriver driver;
		 @BeforeTest
		 public void setUp()
		 {
	  		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/libs/chromedriver");
		    driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		 }
		 @Test
		 public void GetServiceNumbers() throws IOException, InterruptedException 
		 {
	 		InputStream file = Ksrtc.class.getClassLoader().getResourceAsStream("com/csg/ksrtc/ksrtc.properties");
			Properties properties=new Properties();
			properties.load(file);
			String url = properties.getProperty("url");
			String fromAndTo = properties.getProperty("fromandto");
			String departuredateLocation = properties.getProperty("departuredate");
			String desiredDate = properties.getProperty("clickondate");
			String searchdate = properties.getProperty("search");
			String serviceNumber = properties.getProperty("servicenum");
			driver.get(url);
			driver.findElement(By.xpath(fromAndTo)).click();
			driver.findElement(By.name(departuredateLocation)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(desiredDate)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(searchdate)).click();
			Thread.sleep(3000);
			List<WebElement> serviceno=driver.findElements(By.xpath(serviceNumber));
			for(WebElement ele:serviceno)
			{
				String servicenumbers=ele.getText();
				System.out.println(servicenumbers);
			}
		}
		@AfterTest
		public void close()
		{
				driver.close();
		}
}

