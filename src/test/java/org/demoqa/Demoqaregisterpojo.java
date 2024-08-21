package org.demoqa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Demoqaregisterpojo extends DemoqaBase {
	
	public Demoqaregisterpojo() {
		
	PageFactory.initElements(driver, this);
		
	}
	
	

@FindBy(xpath="//input[@id='firstname']") @CacheLookup private WebElement firstName;
@FindBy(xpath="//input[@id='lastname']") @CacheLookup private WebElement lastName;
@FindBy(xpath="//input[@id='userName']") @CacheLookup private WebElement userName;
@FindBy(xpath="//input[@id='password']") @CacheLookup private WebElement password;
@FindBy(xpath="//button[@id='gotologin']") @CacheLookup private WebElement backToLogin;
@FindBy(xpath="//button[@id='register']") @CacheLookup private WebElement register;
@FindBy(xpath="//div[@class='recaptcha-checkbox-border']") @CacheLookup private WebElement captchachkbox;


public WebElement getFirstName() {
	return firstName;
}
public WebElement getLastName() {
	return lastName;
}
public WebElement getUserName() {
	return userName;
}
public WebElement getPassword() {
	return password;
}
public WebElement getBackToLogin() {
	return backToLogin;
}
public WebElement getRegister() {
	return register;
}
public WebElement getcaptchachkbox() {
	return captchachkbox;
}



	
	
	
	
	

}
