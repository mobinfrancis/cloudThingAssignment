package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.homePage;
import utils.baseClass;


public class applyForJob extends baseClass {
	public WebDriver driver;
	homePage page = new homePage();
	
	
	//Driver Initialization and App Launch
	@Test(priority=1)
	public void launchApp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cloudthing.com/");
		

	}
	
	//Searching for Job
	@Test(priority=2)
	public void searchJob() throws InterruptedException
	{
		JavascriptExecutor je= (JavascriptExecutor) driver;
		WebElement careersLink=driver.findElement(By.xpath("//a[@href='/careers']"));
		je.executeScript("arguments[0].scrollIntoView(true);", careersLink);
		Thread.sleep(4000);
		careersLink.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://cloudthing.com/careers/","[FAIL] Not Navigated to CloudThing Careers Page");
		WebElement jobSearch=driver.findElement(By.id("pos-search"));
		je.executeScript("arguments[0].scrollIntoView(true);", jobSearch);
		jobSearch.sendKeys("UX Researcher");
		WebElement uxResearcherResult=driver.findElement(By.xpath("//a[contains(@href,'/ux-researcher')]"));
		je.executeScript("arguments[0].scrollIntoView(true);", uxResearcherResult);
		//uxResearcherResult.click();
		je.executeScript("arguments[0].click();", uxResearcherResult);
		Assert.assertEquals(driver.getCurrentUrl(), "https://cloudthing.com/careers/ux-researcher/","[FAIL] Failed to Navigate to UX Researcher Page");
		
		
	
	}
	//Applying for UX Researcher
	@Test(priority=3)
	public void applyForJobToUX() throws InterruptedException
	{
		JavascriptExecutor je= (JavascriptExecutor) driver;
		Thread.sleep(5000);		
		WebElement name = driver.findElement(By.xpath("//input[@name='your-name']"));
		//je.executeScript("arguments[0].scrollIntoView(true);", name);
		name.sendKeys("Mobin");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("mobinfrancis@live.com");
		driver.findElement(By.xpath("//input[@name='tel']")).sendKeys("7259895413");
		driver.findElement(By.name("message")).sendKeys("This is being done with Automated test - for Assignment Purpose of QA Engineer");
		driver.findElement(By.name("cv")).sendKeys("D:\\Resume_Mobin Francis.pdf");
		WebElement submitBtn=driver.findElement(By.xpath("//button[@type='submit']"));
		je.executeScript("arguments[0].click();", submitBtn);
		//submitBtn.click();
		Thread.sleep(3000);
		WebElement successMsg=driver.findElement(By.xpath("//div[contains(text(),'Thank you for your message')]"));
		je.executeScript("arguments[0].scrollIntoView(true);", successMsg);
		if(successMsg.isDisplayed())
		{
			System.out.println("[PASS] Success Message Recieved:" +successMsg.getText() );
		}
		else
		{
			Assert.fail("[FAIL] Success Message Not Recieved!");
		}
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
