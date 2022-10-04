package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage_PO extends BasePO{

    private @FindBy(id = "mainPopBanner")
    WebElement popUpHomepage;
    private @FindBy(css = ".btn-close")
    WebElement btnClosePopup;
    private @FindBy(id = "AKCKwd")
    WebElement searchFieldHomepage;
    private @FindBy(xpath = "//a[.='Produk terlaris']")
    WebElement btnFilterProdukTerlaris;
    private @FindBy(xpath = "//ul[@class='prodListType']/ul[1]/li[1]/div[@class='group']/a[1]")
    WebElement btnBestSellerItem;
    private @FindBy(name = "optionStock")
    WebElement txtFieldQtyItem;
    private @FindBy(xpath = "//a[.='Tambahkan ke Cart']")
    WebElement btnTambahkeCart;


    public Homepage_PO(){
        super();
    }

    public void verifyPopupBanner(){
        verifyElementPresent(popUpHomepage);
    }

    public void clickPopupBanner(){
        waitForWebElementAndClick(btnClosePopup);
    }
    public void fillAndSearchHomepage(String searchKeyword){
        sendKeys(searchFieldHomepage, searchKeyword);
        sendKeys(searchFieldHomepage, String.valueOf(Keys.RETURN));
    }
    public void clickBtnFilterProdukTerlaris(){
        waitForWebElementAndClick(btnFilterProdukTerlaris);
    }
    public void clickBtnBestSellerItem() throws InterruptedException {
        Thread.sleep(1000);
        waitForWebElementAndClick(btnBestSellerItem);
    }
    public void fillQtyItem(String qtyNumbers){
        sendKeys(txtFieldQtyItem, String.valueOf(Keys.BACK_SPACE));
        sendKeys(txtFieldQtyItem, qtyNumbers);
    }
    public void clickBtnTambahkeCart() throws InterruptedException {
        Thread.sleep(2000);
        waitForWebElementAndClick(btnTambahkeCart);
    }


}
