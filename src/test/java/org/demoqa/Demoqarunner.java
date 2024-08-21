package org.demoqa;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import org.junit.*;
public class Demoqarunner extends DemoqaBase {
	
	
	
	@BeforeClass
	public static void bfrClass() {
		launchBrowser();
		maximizeWindow();
		Wait();
	}

	@Test
	public void tc1() {

		openwebpage("https://demoqa.com/register");

		Demoqaregisterpojo reg = new Demoqaregisterpojo();

		passTheValues(reg.getFirstName(), "Senthil");
		passTheValues(reg.getLastName(), "Amuthan");

		passTheValues(reg.getUserName(), "senthil1234");

		passTheValues(reg.getPassword(), "password1234");

		WebElement getcaptchachkbox = driver.findElement(By.xpath("//iframe[@title=\"reCAPTCHA\"]"));

		driver.switchTo().frame(getcaptchachkbox);

		WebElement checkbox = reg.getcaptchachkbox();
		moveTheCursor(checkbox);
		actionClick(checkbox);

		WebElement register = reg.getRegister();
		moveTheCursor(register);
		actionClick(register);

	}

@AfterClass()
public static void aftrClass() {
	
	closeBrowser();
	
	
}
	
	
}
