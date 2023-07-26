package com.Test.SD;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.Test.ConfigFileReader.ConfigFileReader;
import com.Test.Utils.Utils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SD_AmazonAutomationFlow {
	public Properties properties = new Properties();
	public static ConfigFileReader configfilereader= new ConfigFileReader();
	public Utils utils = new Utils();
	public static WebDriver driver;
	

	@Given("User provide appropriate config to the system")
	public void user_provide_appropriate_config_to_the_system() {
		WebDriverManager.chromedriver().setup();

	}

	@When("User launch the browser")
	public void user_launch_the_browser() {
		driver = new ChromeDriver();

	}

	@When("User put the valid instance")
	public void user_put_the_valid_instance() throws Throwable {
		driver.get(configfilereader.url());
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement signInHover = driver.findElement(By.xpath("//span[@class=\"nav-line-2 \"]"));
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(signInHover).perform();
		Thread.sleep(3000);

		WebElement signInButton = driver.findElement(By.xpath("(//span[text()='Sign in'])[1]"));
		signInButton.click();

	}

	@When("User put the valid credentials")
	public void user_put_the_valid_credentials() {
		WebElement signInTextbox = driver.findElement(By.xpath("//input[@name=\"email\"]"));
		signInTextbox.sendKeys(configfilereader.username());
		WebElement continueButton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
		continueButton.click();
		WebElement passwordTextbox = driver.findElement(By.xpath("//input[@type=\"password\"]"));
		passwordTextbox.sendKeys(configfilereader.password());

	}

	@When("User hit login button")
	public void user_hit_login_button() {
		WebElement signInSubmitButton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
		signInSubmitButton.click();

	}

	@Then("User confirm that User reach to homepage or not")
	public void user_confirm_that_user_reach_to_homepage_or_not() {
		String actualTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String expectedTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);

	}

	@When("User click on Best Sellers button")
	public void user_click_on_best_sellers_button() {

		driver.findElement(By.xpath("(//a[text() ='Best Sellers'])[1]")).click();
	}

	@When("User click on the first product appeared")
	public void user_click_on_the_first_product_appeared() {

		WebElement firstItem = driver
				.findElement(By.xpath("(//div[@class='p13n-sc-truncate-desktop-type2  p13n-sc-truncated'])[1]"));
		firstItem.click();
	}

	@When("User add that product to cart")
	public void user_add_that_product_to_cart() {
		WebElement addToCart = driver.findElement(By.xpath("//input[@title=\"Add to Shopping Cart\"]"));
		addToCart.click();
	}

	@When("User click on proceed to buy button")
	public void user_click_on_proceed_to_buy_button() {
		WebElement checkout = driver.findElement(By.xpath("//input[@value=\"Proceed to checkout\"]"));
		checkout.click();
	}

	@Then("User should land on checkout page")
	public void user_should_land_on_checkout_page() {
		WebElement validateCheckoutPage = driver.findElement(By.xpath("//span[text()='Order Total:']"));
		String orderTotalGetText = validateCheckoutPage.getText();
//		Assert.assertEquals(orderTotalGetText, "Order Total:");
		Assert.assertEquals(orderTotalGetText, "Order Total:");
	}

	@Then("User should click on back navigation button")
	public void user_should_click_on_back_navigation_button() {
		driver.navigate().back();
	}

	@When("User click on Amazon logo")
	public void user_click_on_amazon_logo() {
		WebElement homeButton = driver.findElement(By.xpath("//a[@id=\"nav-logo-sprites\"]"));
		homeButton.click();
	}

	@When("User click on All button")
	public void user_click_on_all_button() throws InterruptedException {
		WebElement all = driver.findElement(By.xpath("//i[@class=\"hm-icon nav-sprite\"]"));
		all.click();
		Thread.sleep(2000);
	}

	@When("User click on Mobiles, Computers")
	public void user_click_on_mobiles_computers() {
		WebElement mobiles = driver.findElement(By.xpath("//div[text()='Mobiles, Computers']"));
		mobiles.click();
	}

	@When("User click on Tablets")
	public void user_click_on_tablets() {
		WebElement tablets = driver.findElement(By.xpath("//a[text()='Tablets']"));
		tablets.click();
	}

	@When("User click on blue color")
	public void user_click_on_blue_color() {
		WebElement color = driver.findElement(By.xpath("(//div[@class='colorsprite aok-float-left'])[18]"));
		color.click();
	}

	@When("User click on the product")
	public void user_click_on_the_product() {
		WebElement product = driver.findElement(By.xpath("//h2[contains(text(),size)]"));
		product.click();
	}

	@Then("User should land on new window with that product details")
	public void user_should_land_on_new_window_with_that_product_details() throws InterruptedException {
		Utils.WindowHandleByArray(driver, 1);
	}

	@Then("User should be able add product to cart")
	public void user_should_be_able_add_product_to_cart() {
		WebElement addToCartTablet = driver.findElement(By.xpath("//input[@id=\"add-to-cart-button\"]"));
		addToCartTablet.click();
	}

	@Then("User should be able to select parent window and click on audio button")
	public void user_should_be_able_to_select_parent_window_and_click_on_audio_button() {
		Utils.WindowHandleByArray(driver, 0);
		WebElement audio = driver.findElement(By.xpath("(//span[@class=\"nav-a-content\"])[5]"));
		audio.click();
	}

}
