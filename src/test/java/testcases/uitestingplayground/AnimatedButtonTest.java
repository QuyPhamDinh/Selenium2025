package testcases.uitestingplayground;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.uitestingplayground.AnimationButtonPage;
import testcases.BaseTest;
import testcases.DriverManager;

public class AnimatedButtonTest extends BaseTest {

    @Test
    void testAnimatedButton() {
        AnimationButtonPage animationButtonPage = new AnimationButtonPage(DriverManager.getDriver());
        animationButtonPage.clickStartAnimation();
        animationButtonPage.clickCompletedAnimationButton();
        Assert.assertEquals(animationButtonPage.getStatus(), "Moving Target clicked. It's class name is 'btn btn-primary'");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
