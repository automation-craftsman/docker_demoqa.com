package pages;

import modules.elements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    private By element_dropdown = By.cssSelector("#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(1) > span > div > div.header-right");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public TextBox openElementsMenu(){
        driver.findElement(element_dropdown).click();
        driver.findElement(element_dropdown).click();

        return new TextBox(driver);
    }

    private void getElementIntoView(By element){
        WebElement target = driver.findElement(element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",target);
    }

}
