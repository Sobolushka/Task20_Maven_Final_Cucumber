package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;


public class ProductPage extends Page {
    public ProductPage(
            WebDriver driver){ super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "quantity")
    public WebElement quantity;

    @FindBy(css = "option")
    public List<WebElement> option;

    @FindBy(name = "add_cart_product")
    public WebElement add;

    public String countItems()
    {
       return quantity.getAttribute("textContent");//страница товара
    }

    public WebElement SpecialPropProduct()
    {
        if (option.size() > 0){
            Select size = new Select(driver.findElement(By.cssSelector("[name='options[Size]']")));
            size.selectByValue("Small");
        }
        return add;
    }

    public void AddNewProduct(String oldcount)
    {
        wait.until(elementToBeClickable(SpecialPropProduct()));
        add.click();
       // wait.until(not(ExpectedConditions.attributeToBe(By.cssSelector("#cart .quantity"), "textContent", oldcount)));
    }

   // public By TextBasket() {return By.xpath("//span [contains(@class, 'quantity')]");}

}
