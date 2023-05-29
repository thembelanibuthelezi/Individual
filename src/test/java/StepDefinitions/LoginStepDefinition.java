package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
        @Given("User is on DemoWEbShop landing page and login button is visible")
    public void User_is_on_DemoWEbShop_landing_page_and_login_button_is_visible(){
            System.out.println("User_is_on_DemoWEbShop_landing_page_and_login_button_is_visible");

    }

    @When("User login  with <Email Address> and {}")
    public void userLoginWithEmailAddressAnd(String arg0) {
        
    }

    @Then("Home page is populated {string}")
    public void homePageIsPopulated(String arg0) {
    }
}
