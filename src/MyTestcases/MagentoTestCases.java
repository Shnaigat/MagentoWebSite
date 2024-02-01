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
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void MySetUp() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test(priority = 1)
	public void SignUp() {
		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']")).click();
		//// OR >> driver.findElement(By.linkText("Create an Account"));
		//// OR >> driver.findElement(By.partialLinkText("Create an "));

		//// find the element
		WebElement FirstName = driver.findElement(By.id("firstname"));
		WebElement LastName = driver.findElement(By.id("lastname"));
		WebElement Email = driver.findElement(By.id("email_address"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement ConfirmPassword = driver.findElement(By.id("password-confirmation"));
		WebElement CreateAccountButton = driver.findElement(By.cssSelector("button[title='Create an Account']"));
		//// interact with the element
		FirstName.sendKeys(firstNames[RandIndex]);
		LastName.sendKeys(lastNames[RandIndex]);
		Email.sendKeys(EmailAddres);
		Password.sendKeys(CommonPassword);
		ConfirmPassword.sendKeys(CommonPassword);
		CreateAccountButton.click();
		//// if we get this Message >> "We can't save the customer."
		// String errorMsg = driver.findElement(By.className("message-error")).getText()
		//// ;
		// if(errorMsg == "We can't save the customer." ) {
		// SignUp();
		// }
		//// actual vs expected
		String welcomMsg = driver.findElement(By.className("message-success")).getText();
		assertEquals(welcomMsg, "Thank you for registering with Main Website Store.");

	}

	@Test(priority = 2)
	public void LogOut() {
		driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");
		String actual = driver.getCurrentUrl();
		System.out.println(actual);
		assertEquals(actual.contains("logoutSuccess"), true);

	}

	@Test(priority = 3)
	public void Login() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys(EmailAddres);
		driver.findElement(By.id("pass")).sendKeys(CommonPassword);
		driver.findElement(By.id("send2")).click();
		//// actual vs expected
		Thread.sleep(2000);
		//String welcomMsg = driver.findElement(By.className("logged-in")).getText(); >>OR>>
		String welcomMsg = driver.findElement(By.cssSelector(".greet.welcome")).getText();
		assertEquals(welcomMsg.contains("Welcome"), true);
	}
	
	
//	@Test(priority = 4)
//	public void NumOfSomeTags() {
//		driver.get("https://magento.softwaretestingboard.com/");
//		WebElement footer = driver.findElement(By.cssSelector(".footer.content"));
//		int NumOfATag = footer.findElements(By.tagName("a")).size();
//		System.out.println(NumOfATag + "Number of a tag");
//		int NumOfH1Tag = driver.findElements(By.tagName("h1")).size();
//		System.out.println(NumOfH1Tag + "Number of h1 tag");
//	}
	
	@Test(priority = 5)
	public void addOneRandomItem() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/");
		WebElement ItemsContainer = driver.findElement(By.cssSelector(".product-items.widget-product-grid"));
		int NumOfItems = ItemsContainer.findElements(By.tagName("li")).size();
		System.out.println(NumOfItems);
		//but i need first 4 items only so i will put 4 instead of NumOfItems
		int RandomItem = rand.nextInt(4);
		ItemsContainer.findElements(By.tagName("li")).get(RandomItem).click();
		
		WebElement sizeContanier = driver.findElement(By.cssSelector(".swatch-attribute.size"));
		int TheSizes = sizeContanier.findElements(By.cssSelector(".swatch-option.text")).size();
		sizeContanier.findElements(By.cssSelector(".swatch-option.text")).get(rand.nextInt(TheSizes)).click();
		
		WebElement colorContanier = driver.findElement(By.cssSelector(".swatch-attribute.color"));
		int Thecolors = colorContanier.findElements(By.cssSelector(".swatch-option.color")).size();
		colorContanier.findElements(By.cssSelector(".swatch-option.color")).get(rand.nextInt(Thecolors)).click();
		
		driver.findElement(By.id("product-addtocart-button")).click();
		Thread.sleep(5000);
		//actual vs expected
		String ActualAddedMsg = driver.findElement(By.className("message-success")).getText();
		assertEquals(ActualAddedMsg.contains("You added"), true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
