package ru.stqa.cucumber;

import PageObject.Application;
import io.cucumber.java8.En;
import org.junit.Assert;

public class Steps  implements En {
    private static Application app = new Application();
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(()-> {app.quit();app = null;}));
    }
    public Steps() {
        When("Go to the shop", () ->{
            app.GeneralPageandNewProduct();
        });
        And("Add {string} product in basket",(String count) ->{
            app.ProductPage(Integer.parseInt(count));
        });
        And("Go to the basket and delete all products", () ->{
            app.BasketPage();
        });

        Then("The basket is empty", () ->{
            app.GeneralPage1();
            String str = app.CheckBasket();
            Assert.assertEquals(app.CheckBasket(),"0");
        });
    }
}
