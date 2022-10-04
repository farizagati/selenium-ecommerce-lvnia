package StepDefinitions;

import PageObjects.BasePO;
import PageObjects.Homepage_PO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;


public class EleveniaSearchSteps extends BasePO {
    private WebDriver driver = getDriver();
    private Homepage_PO Homepage_PO;

    public EleveniaSearchSteps(Homepage_PO Homepage_PO){
        this.Homepage_PO = Homepage_PO;
    }

    @Given("Open website {string}")
    public void open_website(String url) {
        navigateTo_URL(url);
    }
    @And("Located on elevenia website")
    public void located_on_elevenia_website(){
        Homepage_PO.verifyPopupBanner();
        Homepage_PO.clickPopupBanner();
    }
    @Then("I search for product terlaris in {string} keyword")
    public void i_search_for_product_terlaris_in_keyword(String searchKeyword) throws InterruptedException {
        Homepage_PO.fillAndSearchHomepage(searchKeyword);
        Homepage_PO.clickBtnFilterProdukTerlaris();
        Homepage_PO.clickBtnBestSellerItem();
    }
    @Then("I add {string} items to my shopping cart")
    public void i_add_items_to_my_shopping_cart(String qtyNumbers) throws InterruptedException {
        Homepage_PO.fillQtyItem(qtyNumbers);
        Homepage_PO.clickBtnTambahkeCart();
    }
    @Then("I go to cart section")
    public void i_go_to_cart_section() throws InterruptedException {
        Homepage_PO.clickBtnYaLihatCart();
    }
    @Then("I modify the courier option")
    public void i_modify_the_courier_option() throws InterruptedException {
        Homepage_PO.clickBtnUbahKurir();
    }
    @Then("I cancel to modify the courier option")
    public void i_cancel_to_modify_the_courier_option() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:closeLayer()");
    }
    @Then("I cancel the product on my shopping cart")
    public void i_cancel_the_product_on_my_shopping_cart() throws InterruptedException {
        Homepage_PO.clickBtnHapusCartItem();
    }

}
