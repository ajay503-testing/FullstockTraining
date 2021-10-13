package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RETC_001 {
	public WebDriver wd;
	SoftAssert assrt = new SoftAssert();

	@Given("navigate to valid url")
	public void navigate_to_valid_url() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		Thread.sleep(2000);
		// Navigating to URL
		wd.get("http://realty-real-estatem1.upskills.in/");
		Thread.sleep(2000);

	}

	@When("click on Register button")
	public void click_on_register_button() throws InterruptedException {
		wd.navigate().refresh();
		Thread.sleep(200);
		// wd.findElement(By.xpath("//nav[@id='navigation']//a[@class='sign-in']")).click();
		wd.findElement(By.xpath("//a[@href=\"http://realty-real-estatem1.upskills.in/my-profile/\"]")).click();

	}

	@Then("click on Register tab")
	public void click_on_register_tab() {

		wd.findElement(By.xpath("//a[text()='Register']")).click();

	}

	@Then("enter valid email")
	public void enter_valid_email() {

		wd.findElement(By.xpath("//input[@id='email']")).sendKeys("aj@gmail.com");
		String email = wd.findElement(By.xpath("//input[@id='email']")).getAttribute("value");
		if (email.equalsIgnoreCase("aj@gmail.com")) {
			assrt.assertEquals(true, true);
		} else {
			assrt.assertEquals(true, false);
		}
	}

	@Then("enter valid firstName")
	public void enter_valid_first_name() {
		wd.findElement(By.xpath("//input[@id='first-name']")).sendKeys("ajay");
		String firstName = wd.findElement(By.xpath("//input[@id='first-name']")).getAttribute("value");
		if (firstName.equalsIgnoreCase("ajay")) {
			assrt.assertEquals(true, true);
		} else {
			assrt.assertEquals(true, false);
		}
	}

	@Then("enter valid lastName")
	public void enter_valid_last_name() {
		wd.findElement(By.xpath("//input[@id='last-name']")).sendKeys("kumar");
		String lastName = wd.findElement(By.xpath("//input[@id='last-name']")).getAttribute("value");
		if (lastName.equalsIgnoreCase("kumar")) {
			assrt.assertEquals(true, true);
		} else {
			assrt.assertEquals(true, false);
		}
	}

	@Then("click on register button at the end")
	public void click_on_register_button_at_the_end() {
		wd.findElement(By.xpath("//input[@value='Register']")).click();

		assrt.assertAll();
		wd.close();
	}

}
