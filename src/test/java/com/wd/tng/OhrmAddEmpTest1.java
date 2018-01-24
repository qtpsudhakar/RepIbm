package com.wd.tng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OhrmAddEmpTest1 {
	public WebDriver driver;

	@BeforeClass
	public void openApplication() {
		
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\chromedriver.exe");		// get driver
		driver = new ChromeDriver();

		// specify page load timeout
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		// specify findelement timeout
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// maximize the browser
		driver.manage().window().maximize();

		// navigate to application
		driver.get("http://opensource.demo.orangehrmlive.com/");
	}

	@Test
	public void login() {
		// enter text on user name
		driver.findElement(By.id("txtUsername")).sendKeys("admin");

		// enter text on password
		driver.findElement(By.id("txtPassword")).sendKeys("admin");

		// click on login button
		driver.findElement(By.id("btnLogin")).click();
	}

	@Test(dependsOnMethods = "login")
	public void AddEmployee() {
		// click on PIM
		driver.findElement(By.linkText("PIM")).click();

		// click on add employee
		driver.findElement(By.partialLinkText("Add Emp")).click();

		// enter data in first name
		driver.findElement(By.id("firstName")).sendKeys("selenium");

		// enter data in last name
		driver.findElement(By.id("lastName")).sendKeys("hq");

		// click on save
		driver.findElement(By.xpath("//input[@value='Save']")).click();

	}

	@AfterClass
	public void closeApplication() {
		driver.quit();
	}

}
