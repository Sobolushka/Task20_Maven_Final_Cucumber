package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Application {
    private WebDriver driver;
    private WebDriverWait wait;
    private GeneralPage Generalpage;
    private ProductPage productPage;
    private BasketTrashPage basketTrashPage;
    public Application() {
        driver = new ChromeDriver();
        Generalpage = new GeneralPage(driver);
        productPage = new ProductPage(driver);
        basketTrashPage = new BasketTrashPage(driver);
    }
    public void quit(){
        driver.quit();
    }
    public void GeneralPageandNewProduct() throws  InterruptedException
    {
        Generalpage.Generalpage1();
        Generalpage.newproductpage();
    }
    public void GeneralPage1() throws  InterruptedException
    {
        Generalpage.Generalpage1();
    }
    public void ProductPage(int count) throws InterruptedException
    {
        for (int i = 0; i < count; i++) {
            String oldcount = productPage.countItems();
            productPage.AddNewProduct(oldcount);
            Thread.sleep(500);
            //GeneralPageandNewProduct(); //Можно добавить для добавления разных товаров
        }
    }
    public void BasketPage() throws InterruptedException
    {
        basketTrashPage.openbasket();
        basketTrashPage.deleteTrash();
    }
    public String CheckBasket() {
        return (Generalpage.TextBasket1());
    }
}
