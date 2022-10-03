package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EleveniaSearchSteps {
    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().setSize(new Dimension(1920,1080));
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("Open website {string}")
    public void open_website(String url) {
        driver.get(url);
    }
    @And("Located on elevenia website")
    public void located_on_elevenia_website() {
        driver.findElement(By.id("mainPopBanner"));
        driver.findElement(By.cssSelector(".btn-close")).click();

    }
    @Then("I search for product terlaris in {string} keyword")
    public void i_search_for_product_terlaris_in_keyword(String searchKeyword) throws InterruptedException {
        driver.findElement(By.id("AKCKwd")).sendKeys(searchKeyword, Keys.RETURN);
        driver.findElement(By.xpath("//a[.='Produk terlaris']")).click();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='prodListType']/ul[1]/li[1]/div[@class='group']")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@class='prodListType']/ul[1]/li[1]/div[@class='group']/a[1]")).click();

    }
    @Then("I add {string} items to my shopping cart")
    public void i_add_items_to_my_shopping_cart(String qtyNumbers) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("optionStock")));
        //driver.findElement(By.name("optionStock")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.name("optionStock")).sendKeys(Keys.BACK_SPACE,qtyNumbers);
        Thread.sleep(100);
        WebElement element = driver.findElement(By.xpath("//a[.='Tambahkan ke Cart']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(2000);
    }
    @Then("I go to cart section")
    public void i_go_to_cart_section() throws InterruptedException {
        //driver.findElement(By.xpath("//a[@href='http://www.elevenia.co.id/cart/CartAction/getCartList.do']")).click();
        WebElement element = driver.findElement(By.xpath("//a[@href='http://www.elevenia.co.id/cart/CartAction/getCartList.do']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".prod"));
    }
    @Then("I modify the courier option")
    public void i_modify_the_courier_option() throws InterruptedException {
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.linkText("Ubah Kurir"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;

        if (element.isDisplayed() && element.isEnabled()){
            executor.executeScript("arguments[0].click();", element);
        }
        //driver.findElement(By.xpath("//a[@name='deliveryChangePopup']")).click();
        driver.findElement(By.cssSelector("strong"));
    }
    @Then("I cancel to modify the courier option")
    public void i_cancel_to_modify_the_courier_option() {

        driver.findElement(By.cssSelector(".btnWGray")).click();
    }
    @Then("I cancel the product on my shopping cart")
    public void i_cancel_the_product_on_my_shopping_cart() {

        driver.findElement(By.xpath("//p[@class='alignL']/a[.='Hapus']")).click();
        /*
        WebElement element = driver.findElement(By.xpath("//p[@class='alignL']/a[.='Hapus']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

         */
        driver.findElement(By.id("chkDelPopY")).click();
        driver.findElement(By.xpath("//strong[.='Tidak ada produk di Shopping Cart.']"));
    }

}
