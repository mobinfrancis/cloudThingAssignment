package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.baseClass;

public class homePage extends baseClass {
	//public static WebDriver driver;
	
	//Locators
	public static By careerLink=By.xpath("a[href='/careers']");
	
	
	
	//Methods
	public static void goToCareerPageAndSearchFor(String JobName)
	{
		//driver.findElement(careerLink).click();
		driver.findElement(By.xpath("a[href='/careers']")).click();
	}

}
