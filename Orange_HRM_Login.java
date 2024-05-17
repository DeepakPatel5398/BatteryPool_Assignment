package batterypool_Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Orange_HRM_Login {
WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	}
	
	@Test(enabled = true, priority = 1)
	public void Valid_Login() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}
	
	@Test(enabled = true, priority = 2)
	public void Invalid_Username() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Username' and @name='username']")).sendKeys("Deepak");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Password' and @type='password']")).sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=' Login ' and @type='submit']")).click();
	}
	
	@Test(enabled = true, priority = 3)
	public void Invalid_Password() throws InterruptedException {
		driver.findElement(By.xpath("(//input[@placeholder='Username'])[1]")).sendKeys("Admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("Deepak#123");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.oxd-button")).click();
	}
	
	@Test(enabled = true, priority = 4)
	public void Empty_UP() throws InterruptedException{
		driver.findElement(By.xpath("//input[@placeholder='Username']"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Password']"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}
	
	@Test(enabled = true, priority = 5)
	public void Case_Sensitivity() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='username' and @placeholder='Username']")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Admin123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}
	
	@Test(enabled = true, priority = 6)
	public void Forgot_Password() {
		driver.findElement(By.xpath("//p[text()='Forgot your password? ']")).click();
	}
	
	@AfterMethod
	public void teradown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

}
