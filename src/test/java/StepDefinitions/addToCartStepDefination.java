package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addToCartStepDefination {
    @Given("User is on Items home page")
    public void User_is_on_Items_home_page(){
        System.out.println("User_is_on_Items_home_page");
    }

    @When("User search for {string}")
    public void userSearchFor(String arg0) {
        
    }

    @Then("User adds product to cart")
    public void userAddsProductToCart() {


    }

    @And("User Goes to shopping cart")
    public void userGoesToShoppingCart() {
    }
}
