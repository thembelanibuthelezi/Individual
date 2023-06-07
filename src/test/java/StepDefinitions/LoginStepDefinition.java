package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.TestContextSetup;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static utils.TestContextSetup.*;

public class LoginStepDefinition {

    TestContextSetup testContextSetup;


    public LoginStepDefinition(TestContextSetup testContextSetup){

        this.testContextSetup = testContextSetup;
    }





    @Given("User is on DemoWEbShop landing page and login button is visible")

    public void User_is_on_DemoWEbShop_landing_page_and_login_button_is_visible() throws InterruptedException {

        driver = TestContextSetup.getDriver();
        driver.get("https://www.duplichecker.com/credit-card-generator.php");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"generateCard\"]")).click();

        Cnum = driver.findElement(By.xpath("//*[@id=\"cards\"]/div[1]/div/div/div/div[4]/div[2]")).getText();
        Hname = driver.findElement(By.xpath("//*[@id=\"cards\"]/div[1]/div/div/div/div[7]/div[2]")).getText();
        Cvv = driver.findElement(By.xpath("//*[@id=\"cards\"]/div[1]/div/div/div/div[10]/span[2]")).getText();
        Exdate = driver.findElement(By.xpath("//*[@id=\"cards\"]/div[1]/div/div/div/div[11]/span[2]")).getText();

        Exyear = Exdate.substring(Exdate.length() -4);
        Exmonth = Exdate.substring(0,2);

        if(Exmonth.contains("/")){
            Exmonth = "0"+ Exdate.substring(0,1);
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println( Exyear + "   " +  Exmonth  );
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);





    }
    @When("User login  with {} and {}")
    public void user_Login_With_And(String arg0, String arg1) throws InterruptedException {
        driver.findElement(By.className("ico-login")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("Email")).sendKeys(arg0);

        driver.findElement(By.id("Password")).sendKeys(arg1);
        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);







    }





    @Given("Searched product is displayed")
    public void searchedProductIsDisplayed() {

        driver = TestContextSetup.getDriver();

        System.out.println("ngikhona");

    }

    @When("User clicks addtocart on the Displayed product")
    public void userClicksAddtocartOnTheDisplayedProduct() throws InterruptedException {


        System.out.println(driver.getTitle() +"new");

        driver.findElement(By.xpath("//input[@class='button-2 product-box-add-to-cart-button']")).click();





    }

    @Then("User open cart")
    public void userOpenCart() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id='topcartlink']")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);





        WebElement dropdown = driver.findElement(By.xpath("//select[@id='CountryId']"));

        Select select = new Select(dropdown);

        select.selectByVisibleText("South Africa");


        driver.findElement(By.xpath("//*[@id='ZipPostalCode']")).sendKeys("4001");
        driver.findElement(By.xpath("//*[@id='termsofservice']")).click();
        driver.findElement(By.xpath("//*[@id='checkout']")).click();

        driver.findElement(By.xpath("//*[@id='billing-buttons-container']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);





        driver.findElement(By.xpath("//input[@class='button-1 new-address-next-step-button']")).click();



        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);







        driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);





        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);





        driver.findElement(By.xpath("//*[@id=\"paymentmethod_2\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);






        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);





        driver.findElement(By.xpath("//*[@id=\"CardholderName\"]")).sendKeys(Hname);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);





        driver.findElement(By.xpath("//*[@id=\"CardNumber\"]")).sendKeys(Cnum);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);









        WebElement yeardrop = driver.findElement(By.xpath("//select[@id='ExpireYear']"));

        Select yselect = new Select(yeardrop);

        yselect.selectByVisibleText(Exyear);

        WebElement monthdrop = driver.findElement(By.xpath("//select[@id='ExpireMonth']"));

        Select mselect = new Select(monthdrop);

        mselect.selectByVisibleText(Exmonth);

        driver.findElement(By.xpath("//*[@id=\"CardCode\"]")).sendKeys(Cvv);

        driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



        String orderconf = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div")).getText();



        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }








}


