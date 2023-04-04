package element;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class TextBoxTests extends BaseTests {

    String name = "Abeer Ahmed";
    String email = "opensecret@gmail.com";
    String current_addres = """
            House: 20-A,
            Road: 09,
            Banasree, Rampura, Dhaka.
            """;
    String permanet_address = """
            House: Jannah (Inshallah),
            Road: Any rood will be fine,
            After Life, Cosmos.
            """;

    @Test
    public void textBoxDataEntryTest(){
        var textBox = homepage.openElementsMenu();

        textBox.getTextBox();
        textBox.insertFullName(name);
        textBox.insertEmail(email);
        textBox.insertCurrentAddress(current_addres);
        textBox.insertPermanentAddress(permanet_address);

        textBox.submitForm();

        String returned_name = textBox.verifyOutput();

        assertTrue(returned_name.contains(name));

    }
}
