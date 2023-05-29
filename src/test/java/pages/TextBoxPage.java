package pages;

import base.Base;
import org.openqa.selenium.By;

public class TextBoxPage extends Base {
    private By textboxBtn = By.xpath("//span[normalize-space()=\"Text Box\"]");

    private By tbInputField = By.xpath("//input[@id=\"userName\"]");
    private By tbEmailField = By.xpath("//input[@id=\"userEmail\"]");
    private By tbCAddressField = By.xpath("//textarea[@id=\"currentAddress\"]");
    private By tbPAddressField = By.xpath("//textarea[@id=\"permanentAddress\"]");
    private By tbSubmitBtn = By.xpath("//button[@id=\"submit\"]");

    private By resultNameArea = By.xpath("//p[@id=\"name\"]");

    String cAddress = """
            House : Earth,
            Road : Birth,
            Area : Milky Way
            """;

    String pAddress = """
            House : Jannatul Ferdous,
            Road : Death,
            Area : Cosmos
            """;

    public void openTextBoxes(){
        driver.findElement(textboxBtn).click();
    }

    public void fillInUserData(){
        driver.findElement(tbInputField).sendKeys("Automation-Craftsman");
        driver.findElement(tbEmailField).sendKeys("automationcraftsman@gmail.com");
        driver.findElement(tbCAddressField).sendKeys(cAddress);
        driver.findElement(tbPAddressField).sendKeys(pAddress);
    }

    public void submitUserData(){
        driver.findElement(tbSubmitBtn).click();
    }

    public String getNameFromResult(){

        return driver.findElement(resultNameArea).getText();
    }
}
