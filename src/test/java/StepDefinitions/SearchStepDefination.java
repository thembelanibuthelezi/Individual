package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.TestContextSetup;

import java.util.concurrent.TimeUnit;

import static utils.TestContextSetup.driver;

public class SearchStepDefination {






    @Then("Home page is populated and user search for {string}")
    public void homePageIsPopulatedAndUserSearchFor(String arg0) throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id='small-searchterms']")).sendKeys(arg0);
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[3]/form/input[2]")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



    }



}
