package element;

import base.BaseTests;
import modules.elements.CheckBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CheckBoxTests extends BaseTests {

    public WebDriver driver;

    private By angular_check_box = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(1) > ol > li:nth-child(2) > span > label > span.rct-checkbox > svg");
    private By output_container = By.cssSelector("#result > span.text-success");

    @Test
    public void checkBoxSelectionTest(){
        var checkBox = homepage.openElementsMenu();

        checkBox.getCheckBox();
        checkBox.expandAll();
        checkBox.checkTheBox(angular_check_box);

        checkBox.verifyCheckBoxOutput(output_container, "angular");

    }
}
