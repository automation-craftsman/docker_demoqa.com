package tests;

import base.Base;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TextBoxPage;

public class T001_TextBoxTest extends Base {

    HomePage homePage = new HomePage();

    @Test(priority = 0, description = "Text Box Elements Test")
    @Description("Test all text box fields by inserting data")
    @Epic("EP01 : Check Text Boxes")
    @Story("ST01 : All text boxes should be able to take user inputs")
    @Severity(SeverityLevel.CRITICAL)
    public void testTextBoxElements(){
        TextBoxPage textBoxPage = homePage.openElements();
        textBoxPage.openTextBoxes();
        textBoxPage.fillInUserData();
        textBoxPage.submitUserData();
        Assert.assertTrue(textBoxPage.getNameFromResult().contains("Automation-Craftsman"));
    }
}
