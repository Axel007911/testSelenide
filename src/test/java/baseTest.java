import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;

public class baseTest {
    String mvn_site = "https://mvnrepository.com";
    String test_url = "http://automationpractice.com/";

    public void titleAssertion() {
        Assert.assertEquals(title(), "Maven Repository: Search/Browse/Explore");


    }

    @BeforeMethod
    public void start() {
        System.out.println("Test starts");
        Configuration.startMaximized = true;
        open(test_url);

    }

    @AfterMethod
    public void finish() {
        System.out.println("Test finished");
        clearBrowserCookies();
        closeWindow();

    }

}
