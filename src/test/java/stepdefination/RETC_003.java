package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RETC_003 {

	public WebDriver wd;
	SoftAssert assrt = new SoftAssert();

	@Given("navigate to valid url_RETC_{int}")
	public void navigate_to_valid_url_retc(Integer int1) throws Exception {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		Thread.sleep(2000);
		// Navigating to URL
		wd.get("http://realty-real-estatem1.upskills.in/");
		//Thread.sleep(2000);

	}

	@When("click on Register button__RETC_{int}")
	public void click_on_register_button__retc(Integer int1) throws InterruptedException {
		wd.navigate().refresh();
		Thread.sleep(200);
		// wd.findElement(By.xpath("//nav[@id='navigation']//a[@class='sign-in']")).click();
		wd.findElement(By.xpath("//a[@href=\"http://realty-real-estatem1.upskills.in/my-profile/\"]")).click();
	}

	@Then("click on Lost your password__RETC_{int}")
	public void click_on_lost_your_password__retc(Integer int1) throws Exception {
		Thread.sleep(2000);
		wd.findElement(By.xpath("//a[text()=' Lost Your Password?']")).click();
	}

	@Then("validate message__RETC_{int}")
	public void validate_message__retc(Integer int1) {

		wd.findElement(By.xpath("//input[@id='user_login']")).sendKeys("manzoor@gmail.com");

		wd.findElement(By.xpath("//input[@value='Reset Password']")).click();

		String actual = wd.findElement(By.xpath("//p[contains(text(),'The email could not be sent.')]")).getText();

		if (actual.contains("The email could not be sent")) {
			assrt.assertEquals(true, true);
		} else {
			assrt.assertEquals(true, false);
		}
		assrt.assertAll();
		wd.close();
	}



}
