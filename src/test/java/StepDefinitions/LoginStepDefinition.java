package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestContextSetup;

import java.time.Duration;

public class LoginStepDefinition {

    public  String Cnum;
    public  String Hname;
    public  String Exdate;

    public  String Exmonth;

    public  String Exyear;

    public  String Cvv;
   ChromeDriver driver;


    @Given("User is on DemoWEbShop landing page and login button is visible")
    public void User_is_on_DemoWEbShop_landing_page_and_login_button_is_visible() throws InterruptedException {
        //System.setProperty("web-driver.chrome.driver", "src/test/java/chromedriver_linux64");
        driver = new ChromeDriver();

        driver.get("https://www.duplichecker.com/credit-card-generator.php");
        Thread.sleep(2000);



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

        System.out.println( Exyear + "   " +  Exmonth  );

        driver.get("https://demowebshop.tricentis.com");
        Thread.sleep(2000);

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

        Thread.sleep(2000);


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



        driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")).click();

        Thread.sleep(2000);


        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"paymentmethod_2\"]")).click();
        Thread.sleep(2000);


        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"CardholderName\"]")).sendKeys(Hname);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"CardNumber\"]")).sendKeys(Cnum);
        Thread.sleep(2000);





        WebElement yeardrop = driver.findElement(By.xpath("//select[@id='ExpireYear']"));

        Select yselect = new Select(yeardrop);

        yselect.selectByVisibleText(Exyear);

        WebElement monthdrop = driver.findElement(By.xpath("//select[@id='ExpireMonth']"));

        Select mselect = new Select(monthdrop);

        mselect.selectByVisibleText(Exmonth);

        driver.findElement(By.xpath("//*[@id=\"CardCode\"]")).sendKeys(Cvv);

        driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click();

        Thread.sleep(2000);

        String orderconf =   driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div")).getText();

        System.out.println(orderconf);

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



    private static void wait(ChromeDriver driver){
        JavascriptExecutor jsEx = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> jsEx.executeScript("return document.readyState").equals("complete"));
    }

}


