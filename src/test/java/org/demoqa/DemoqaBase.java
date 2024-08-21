package org.demoqa;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DemoqaBase {
	
	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static Alert at;
	public static JavascriptExecutor js;
	public static Select s;
	
	
	
	public static void launchBrowser() {
		driver = new ChromeDriver();
		}
	
	public static void maximizeWindow() {
		driver.manage().window().maximize();
		}
	
	
	public static void openwebpage(String URL) {
		driver.get(URL);
		}
	
	
	public static String pageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		return title;
		}

	public static void closepage() {
		driver.close();
		}
	
	
	public static void closeBrowser() {
		driver.quit();
		}
	
	
	public static void scnsht(String filename) throws IOException {
		
		TakesScreenshot s= (TakesScreenshot)driver;
		
		File src = s.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\Eclipse\\Adactin\\scnshots\\" +filename+ ".png");
		FileUtils.copyFile(src, des);
		
	}
	
		public static void clickButton(WebElement ref) {
		ref.click();
		}
		
		public static void passTheValues(WebElement ref,String val) {
		ref.sendKeys(val);
		}
		
		public static void moveTheCursor(WebElement target) {
		a=new Actions(driver);
		a.moveToElement(target).perform();
		}
		
		public static void actionClick(WebElement target) {
		a=new Actions(driver);
		a.click().perform();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		public static void dragAndDrop(WebElement from,WebElement to) {
		a=new Actions(driver);
		a.dragAndDrop(from, to).perform();
		}
		
		public static void doubleClick(WebElement ref) {
		a=new Actions(driver);
		a.doubleClick(ref).perform();
		}
		
		public static void rightClick(WebElement tar) {
		a=new Actions(driver);
		a.contextClick(tar).perform();
		}
		
		public static void copy() throws AWTException {
			r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_C);
		}
		
		public static void paste() throws AWTException {
			r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
		}
		
		public static void down() throws AWTException {
			r=new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		public static void enter() throws AWTException {
			r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		public static void tab() throws AWTException {
			r=new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		}
		public static void handlingAlertAccept() {
			at=driver.switchTo().alert();
			at.accept();
		}
		public static void handlingAlertDismiss() {
		at=driver.switchTo().alert();
		at.dismiss();
		}
	
		public static void Wait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		}
		public static void frame(WebElement f) {
		driver.switchTo().frame(f);
		}
		public static void parentFrame() {
		driver.switchTo().parentFrame();
		}
		public static void outOfAllFrame() {
		driver.switchTo().defaultContent();
		}
		public static void isDisplay(WebElement d) {
		boolean displayed = d.isDisplayed();
		System.out.println(displayed);
		}
		public static void isEnable(WebElement e) {
		boolean enabled = e.isEnabled();
		System.out.println(enabled);
		}
		public static void isSelect(WebElement s){
		boolean selected = s.isSelected();
		System.out.println(selected);
		}
		public static void setValueJavaScript(WebElement name,String val) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','val')",name );
		}
		public static void clickJavaScript(WebElement clk) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", clk);
		}
		public static void returnvaluejs(WebElement rtn) {
		js=(JavascriptExecutor)driver;
		Object executeScript = js.executeScript("return arguments[0].getAttribute('value')", 
		rtn);
		System.out.println(executeScript);
		}
		public static void scrollDownjs(WebElement sd) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", sd);
		}
		public static void refresh() {
		driver.navigate().refresh();
		}
		public static void back() {
		driver.navigate().back();
		}
		public static void forward() {
		driver.navigate().forward();
		}
		public static void windowHandle() {
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		}
		public static void winHandles() throws InterruptedException {
			String parent=driver.getWindowHandle();
			System.out.println(parent);
			Thread.sleep(3000);
			Set<String> child = driver.getWindowHandles();
			System.out.println(child);
			
			for (String each : child) 
			{
			if(parent!=each) {
			driver.switchTo().window(each);
			}
			}
		}
		
		
		
		public static void windowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		}
		public static void switchWindow(String each) {
		driver.switchTo().window(each);
		}

	

}
