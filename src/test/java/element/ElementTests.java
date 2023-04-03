package element;

import base.BaseTests;
import org.testng.annotations.Test;

public class ElementTests extends BaseTests {

    @Test
    public void InteractionsTest(){
        homepage.getInteractions();
        homepage.clickOnDragabble();
    }
}
