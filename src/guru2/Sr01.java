package guru2;

import static org.testng.AssertJUnit.assertEquals;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class Sr01 {
	public WebDriver driver;
	public String baseUrl;
	
	int scc=0;
	@BeforeTest
	public void declaringVariables(){
		System.out.println("This is Guru live project 2");
		
		driver=new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver","/usr/local/bin/geckodriver");
		
		baseUrl="http://live.guru99.com/index.php/";
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	@BeforeMethod
	public void BeforeSr01(){
		
		
		System.out.println("Test case Number1 is going to get executed");
		
	}
	@Test
	public void testSr01() throws Exception{
		String mainTitle=driver.findElement(By.cssSelector("h2")).getText();
		System.out.println(mainTitle);
		driver.findElement(By.linkText("Mobile")).click();
		Select dropdown=new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]")));
		dropdown.selectByVisibleText("Name");
		
			
		
		scc=scc+1;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String png=("/Users/ramadugusanjay/Desktop/"+scc+".png");
		FileUtils.copyFile(scrFile, new File(png));
		
		
		
		
		
		
	}
	@AfterMethod
	public void tearDown(){
		
		System.out.println("Test case Number1 is succesfull");
	}
	@BeforeMethod
	public void BeforeSr02(){
		System.out.println("Test case Number2 is going to get executed");
		
	}
	@Test
	public void testSr02(){
		driver.findElement(By.linkText("Mobile")).click();
		String Price1=driver.findElement(By.cssSelector("#product-price-1 > span")).getText();
		driver.findElement(By.xpath(".//*[@id='product-collection-image-1']")).click();
		String Price2=driver.findElement(By.cssSelector("#product-price-1 > span")).getText();
		try{
			assertEquals(Price1, Price2); 
		}catch(Exception e){
			e.printStackTrace();
			
		}
		System.out.println(Price2);
		System.out.println(Price1);
		
		
		
		
		
		
		
		
	}
	
	@AfterMethod
	public void tearDown2(){
		System.out.println("Test case Number2 is succesfull");
	}
	@BeforeMethod
	public void BeforeSr03(){
		System.out.println("Test case Number3 is going to get executed");
		
	}
	@Test
	public void testSr03(){
		driver.findElement(By.linkText("Mobile")).click();
		driver.findElement(By.cssSelector("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(3) > div > div.actions > button > span > span")).click();
		driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).clear();
		driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).sendKeys("1000");
		driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/button")).click();
		String Error1=driver.findElement(By.cssSelector("body > div > div > div.main-container.col1-layout > div > div > div > ul > li > ul > li > span")).getText();
		System.out.println(Error1);
		driver.findElement(By.cssSelector("#empty_cart_button > span > span")).click();
		String Msg1=driver.findElement(By.cssSelector("body > div > div > div.main-container.col1-layout > div > div > div.page-title > h1")).getText();
		System.out.println(Msg1);
		assertEquals("SHOPPING CART IS EMPTY", Msg1);
	
		
	}

	
	@AfterMethod
	public void tearDown3(){
		System.out.println("Test case Number3 is succesfull");
	}
	
	
	@AfterTest
	public void closingStatements(){
		driver.quit();
		System.out.println("The live project2 has been succesfully tested");
	}

}
