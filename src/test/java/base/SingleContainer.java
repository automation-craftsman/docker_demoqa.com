package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SingleContainer {

    public static void main(String[] args) {

        WebDriver driver = WebDriverManager.chromedriver().remoteAddress("http://localhost:4444").create();

        driver.get("https://www.google.com");

        System.out.println("Page Title : " + driver.getTitle());

        By textArea = By.xpath("//textarea[@id=\"APjFqb\"]");

        driver.findElement(textArea).sendKeys("Docker");
        driver.findElement(textArea).submit();

        System.out.println("Page Title : " + driver.getTitle());

        Assert.assertTrue(driver.findElement(textArea).getText().contains("Docker"));

        driver.quit();
    }
}
