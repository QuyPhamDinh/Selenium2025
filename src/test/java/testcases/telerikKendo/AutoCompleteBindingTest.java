package testcases.telerikKendo;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.AutoCompleteDataBinding;
import pom.Iframe;
import testcases.BaseTelerikKendoTest;
import testcases.DriverManager;

public class AutoCompleteBindingTest extends BaseTelerikKendoTest {


    @Test
        //(retryAnalyzer = Retry.class)
    void testAutoCompleteTextbox() {
        String inputText = "Ar";


        AutoCompleteDataBinding autoCompleteDataBinding = new AutoCompleteDataBinding(DriverManager.getDriver());
        Iframe iframe = new Iframe(DriverManager.getDriver());
        iframe.moveToIFrame();

        autoCompleteDataBinding.typeAutoCompleteTextbox(inputText);
        WebElement itemFocused = autoCompleteDataBinding.getItemFocused();
        Assert.assertTrue(itemFocused.getText().contains(inputText), "Text does not contain the expected substring!");

        String notExistItem = "Br";
        autoCompleteDataBinding.typeAutoCompleteTextbox(notExistItem);
        WebElement noItem = autoCompleteDataBinding.getItemFocused();
        Assert.assertNull(noItem);
    }
}
