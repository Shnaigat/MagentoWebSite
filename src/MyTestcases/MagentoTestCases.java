package MyTestcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MagentoTestCases extends Parameters {
	WebDriver driver =new ChromeDriver();
	
	@BeforeTest
	public void MySetUp() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
	
	@Test()
	public void SignUp() {
		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']")).click();
		//OR >> driver.findElement(By.linkText("Create an Account"));
		//OR >> driver.findElement(By.partialLinkText("Create an "));
		
		//find the element
		WebElement FirstName = driver.findElement(By.id("firstname"));
		WebElement LastName = driver.findElement(By.id("lastname"));
		WebElement Email = driver.findElement(By.id("email_address"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement ConfirmPassword = driver.findElement(By.id("password-confirmation"));
		WebElement CreateAccountButton = driver.findElement(By.cssSelector("button[title='Create an Account']"));
		//interact with the element
		FirstName.sendKeys(firstNames[RandIndex]);
		LastName.sendKeys(lastNames[RandIndex]);
		Email.sendKeys(EmailAddres);
		Password.sendKeys(CommonPassword);
		ConfirmPassword.sendKeys(CommonPassword);
		CreateAccountButton.click();
		//actual vs expected
		String welcomMsg = driver.findElement(By.className("message-success")).getText();
		assertEquals(welcomMsg, "Thank you for registering with Main Website Store.");
	}
	
}
