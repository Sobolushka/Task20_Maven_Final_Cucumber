package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralPage extends Page {
    public GeneralPage(WebDriver driver){ super(driver);}
    public void Generalpage1()
    {
       driver.get("http://localhost/litecart/en/");//general page

    }
    public void newproductpage() {
        driver.findElement(By.cssSelector("#box-most-popular [class = 'product column shadow hover-light']")).click();
    }
    @FindBy(css = "content span.quantity")
    public WebElement TextBasket;
    public String TextBasket1()
    {return driver.findElement(By.cssSelector(".content span.quantity")).getAttribute("textContent");}
}
