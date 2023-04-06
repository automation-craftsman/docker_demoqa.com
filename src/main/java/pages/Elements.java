package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class Elements {

    private WebDriver driver;

    // Text Box related fields
    private By textbox = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[1]");
    private By name_field = By.xpath("//*[@id=\"userName\"]");
    private By email_field = By.xpath("//*[@id=\"userEmail\"]");
    private By current_address_field = By.xpath("//*[@id=\"currentAddress\"]");
    private By permanent_address_field = By.xpath("//*[@id=\"permanentAddress\"]");
    private By submit_button = By.xpath("//*[@id=\"submit\"]");

    private By output_box_name = By.xpath("//*[@id=\"name\"]");

    // Check Box related fields
    private By check_box = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[1]/div/ul/li[2]/span");
    private By expand_all = By.cssSelector("#tree-node > div > button.rct-option.rct-option-expand-all > svg");


    // Constructor
    public Elements(WebDriver driver){
        this.driver = driver;
    }

    // Text Box related methods
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

    public String verifyTextBoxOutput(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(output_box_name)));

        return driver.findElement(output_box_name).getText();
    }

    // Checkbox related methods
    public void getCheckBox(){
        getElementIntoView(check_box);
        driver.findElement(check_box).click();
    }

    public void expandAll(){
        driver.findElement(expand_all).click();
    }

    public void checkTheBox(By element){
        getElementIntoView(element);
        driver.findElement(element).click();
    }

    public void verifyCheckBoxOutput(By output_container_element, String expected_output){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(output_container_element)));

        String output_text = driver.findElement(output_container_element).getText();

        assertTrue(output_text.contains(expected_output));
    }


    // Private helper methods
    private void getElementIntoView(By element){
        WebElement target = driver.findElement(element);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",target);
    }
}
