package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.homePage;
import utils.baseClass;


public class applyForJob extends baseClass {
	public WebDriver driver;
	homePage page = new homePage();
	
	
	
	@Test
	public void TC1()
	{
		launchCloudThingPage();	
		homePage.goToCareerPageAndSearchFor("UX Designer");
	}
}
