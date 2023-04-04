package modules.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextBox {

    private WebDriver driver;

    private By textbox = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]");
    private By name_field = By.xpath("//*[@id=\"userName\"]");
    private By email_field = By.xpath("//*[@id=\"userEmail\"]");
    private By current_address_field = By.xpath("//*[@id=\"currentAddress\"]");
    private By permanent_address_field = By.xpath("//*[@id=\"permanentAddress\"]");
    private By submit_button = By.xpath("//*[@id=\"submit\"]");

    private By output_box_name = By.xpath("//*[@id=\"name\"]");

    public TextBox(WebDriver driver){
        this.driver = driver;
    }

    public void getTextBox(){
        getElementIntoView(textbox);
        driver.findElement(textbox).click();
    }

    public void insertFullName(String full_name){
        driver.findElement(name_field).sendKeys(full_name);
    }

    public void insertEmail(String email){
        driver.findElement(email_field).sendKeys(email);
    }

    public void insertCurrentAddress(String current_address){
        driver.findElement(current_address_field).sendKeys(current_address);
    }

    public void insertPermanentAddress(String permanent_address){
        driver.findElement(permanent_address_field).sendKeys(permanent_address);
    }

    public void submitForm(){
        driver.findElement(submit_button).click();
    }

    public String verifyOutput(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(output_box_name)));

        return driver.findElement(output_box_name).getText();
    }

    private void getElementIntoView(By element){
        WebElement target = driver.findElement(element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",target);
    }
}
