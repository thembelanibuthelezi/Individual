package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utils.TestContextSetup;

public class LoginStepDefinition {

   ChromeDriver driver;


    @Given("User is on DemoWEbShop landing page and login button is visible")
    public void User_is_on_DemoWEbShop_landing_page_and_login_button_is_visible(){
        //System.setProperty("web-driver.chrome.driver", "src/test/java/chromedriver_linux64");
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");


    }
    @When("User login  with {} and {}")
    public void user_Login_With_And(String arg0, String arg1) throws InterruptedException {
       driver.findElement(By.className("ico-login")).click();
       driver.findElement(By.id("Email")).sendKeys(arg0);

       driver.findElement(By.id("Password")).sendKeys(arg1);
       driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();

        Thread.sleep(2000);


    }



    @Then("Home page is populated and user search for {string}")
    public void homePageIsPopulatedAndUserSearchFor(String arg0) throws InterruptedException {

        driver.findElement(By.xpath("//*[@id='small-searchterms']")).sendKeys(arg0);
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[3]/form/input[2]")).click();

        driver.findElement(By.xpath("//input[@class='button-2 product-box-add-to-cart-button']")).click();

        driver.findElement(By.xpath("//*[@id='topcartlink']")).click();



        WebElement dropdown = driver.findElement(By.xpath("//select[@id='CountryId']"));

        Select select = new Select(dropdown);

        select.selectByVisibleText("South Africa");


        driver.findElement(By.xpath("//*[@id='ZipPostalCode']")).sendKeys("4001");
        driver.findElement(By.xpath("//*[@id='termsofservice']")).click();
        driver.findElement(By.xpath("//*[@id='checkout']")).click();

        driver.findElement(By.xpath("//*[@id='billing-buttons-container']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@class='button-1 new-address-next-step-button']")).click();

        Thread.sleep(2000);
        Thread.sleep(2000);


        driver.findElement(By.xpath("//input[@class='button-1 new-address-next-step-button']")).click();
        driver.findElement(By.xpath("//input[@class='button-1 new-address-next-step-button']")).click();



    }

    @Given("Searched product is displayed")
    public void searchedProductIsDisplayed() {

        //System.out.println(driver.getTitle());
    }

    @When("User clicks addtocart on the Displayed product")
    public void userClicksAddtocartOnTheDisplayedProduct() throws InterruptedException {

        System.out.println("ngikhona");

    }

    @Then("User open cart")
    public void userOpenCart() {


        //driver.findElement(By.xpath("//input[@class='button-2 product-box-add-to-cart-button']")).click();


    }
}


