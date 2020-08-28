import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class test1 extends baseTest {

@Test
public void firstTest() {
    $(By.linkText("Women")).click();
    $x("//h2[@class='title_block']").shouldBe(Condition.text("Women"));
    System.out.println("Hello world");
}


@Test
public void secondTest() {
    $(By.id("search_query_top")).val("Blouse").pressEnter();
    $x("//img[@title='Blouse']").shouldBe(Condition.visible);
    $(byText("1 result has been found.  ")).should(Condition.exist);
}

@Test
    public void thirdTest() {
    SelenideElement product = $(By.linkText("Faded Short Sleeve T-shirts"));
    product.scrollTo();
    actions().moveToElement(product).perform();
    $x("//a[@class='quick-view']").shouldBe(Condition.visible).click();
    $x("//img[@title='Faded Short Sleeve T-shirts']").shouldBe(Condition.visible);

    List<SelenideElement> iframes = $$("iframe");
    switchTo().frame(iframes.get(1));
    $x("//input[@id='quantity_wanted']").val("2");
    $x("//select[@id='group_1']").selectOptionContainingText("M");
    $(byText("Add to cart")).click();
    $(byText("Proceed to checkout")).click();
    $x("//a[@title='View my shopping cart']").shouldHave(Condition.text("2 Products"));
    sleep(5000);



}
}
