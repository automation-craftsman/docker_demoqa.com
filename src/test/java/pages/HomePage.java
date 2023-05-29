package pages;

import base.Base;
import org.openqa.selenium.By;

public class HomePage extends Base {

    private By elementsBtn = By.xpath("//h5[normalize-space()=\"Elements\"]");

    public TextBoxPage openElements(){
        driver.findElement(elementsBtn).click();

        return new TextBoxPage();
    }

}
