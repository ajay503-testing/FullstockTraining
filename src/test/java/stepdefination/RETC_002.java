package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RETC_002 {
	public WebDriver wd;
	SoftAssert assrt = new SoftAssert();
	//// nav[@id='navigation']

	@Given("navigate to valid given  url")
	public void navigate_to_valid_given_url() throws Exception {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		Thread.sleep(2000);
		// Navigating to URL
		wd.get("http://realty-real-estatem1.upskills.in/");
		//Thread.sleep(2000);
	}

	@When("click on LogIn\\/Register button")
	public void click_on_log_in_register_button() throws Exception {
		wd.navigate().refresh();
		Thread.sleep(200);
		// wd.findElement(By.xpath("//nav[@id='navigation']//a[@class='sign-in']")).click();
		wd.findElement(By.xpath("//a[@href=\"http://realty-real-estatem1.upskills.in/my-profile/\"]")).click();
	}

	@Then("enter valid credentails in email textbox")
	public void enter_valid_credentails_in_email_textbox() {

		wd.findElement(By.xpath("//input[@id='user_login']")).sendKeys("admin");
		String userName = wd.findElement(By.xpath("//input[@id='user_login']")).getAttribute("value");
		if (userName.equalsIgnoreCase("admin")) {
			assrt.assertEquals(true, true);
		} else {
			assrt.assertEquals(true, false);
		}

	}

	@Then("enter valid credentails in password textbox")
	public void enter_valid_credentails_in_password_textbox() {

		wd.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("admin@123");
		String userName = wd.findElement(By.xpath("//input[@id='user_pass']")).getAttribute("value");
		if (userName.equalsIgnoreCase("admin@123")) {
			assrt.assertEquals(true, true);
		} else {
			assrt.assertEquals(true, false);
		}

	}

	@Then("click on sing In Button")
	public void click_on_sing_in_button() {

		wd.findElement(By.xpath("//input[@name='login']")).click();
		
		
		assrt.assertAll();
	}


}
