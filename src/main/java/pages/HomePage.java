package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    private By element_dropdown = By.cssSelector("#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(1) > span > div > div.header-right");
    private By textbox_element = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]");
    private By interactions_dropdown = By.cssSelector("#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(5) > span > div > div.header-right");
    private By dragabble_element = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[5]/div/ul/li[5]/span");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }



    public void clickOnTextBox(){
        driver.findElement(element_dropdown).click();

        driver.findElement(textbox_element).click();
    }

    public void getInteractions(){
        getElementIntoView(interactions_dropdown);

        driver.findElement(interactions_dropdown).click();
    }

    public void clickOnDragabble(){
        getElementIntoView(dragabble_element);
        driver.findElement(dragabble_element).click();
    }


    private void getElementIntoView(By element){
        WebElement target = driver.findElement(element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",target);
    }

}
