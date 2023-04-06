package pages;

import modules.elements.TextBox;
import modules.forms.PracticeForms;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;
    private By element_dropdown = By.cssSelector("#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(1) > span > div > div.header-right");
    private By text_box_vis = By.xpath("//*[@id=\"item-0\"]/span");
    private By forms_dropdown = By.cssSelector("#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(2) > span > div > div.header-right");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public Elements openElementsMenu(){
        // failsafe to prevent out of scope failures
        getElementIntoView(element_dropdown);

        // Checking if the element menu is open or not
        Boolean elementMenuIsOpen = driver.findElement(text_box_vis).isDisplayed();

        // Opening element menu if not open already
        if(!elementMenuIsOpen){
            driver.findElement(element_dropdown).click();
        }

        return new Elements(driver);
    }

    public PracticeForms openFormsMenu(){
        driver.findElement(forms_dropdown).click();

        return new PracticeForms(driver);
    }

    private void getElementIntoView(By element){
        WebElement target = driver.findElement(element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",target);
    }

}
