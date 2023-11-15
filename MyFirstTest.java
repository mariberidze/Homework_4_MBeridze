import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.*;

public class MyFirstTest {
    @Test
    public void mytest_1() {

        //გახსენით ee.ge - ს ლინკი - ტესტ მეთოდი 1 - დადებითი მნიშვნელობები//

        open("https://www.ee.ge/");
        $(byText("რეგისტრაცია")).click();
        $(byText("რეგისტრაცია")).shouldBe(Condition.visible);
        sleep(2000);
        $("#firstName").setValue("მარიამ");
        $("#firstName").shouldNot(Condition.empty);
        $("#lastName").setValue("ბერიძე");
        $("#firstName").shouldNot(Condition.empty);
        $("#email").setValue("mariberidze@gmail.com");
        $("#email").shouldNot(Condition.empty);
        $("#password").setValue("Aa1234567890");
        $("#password").shouldNot(Condition.empty);
        $("#confirmPassword").setValue("Aa1234567890");
        $("#confirmPassword").shouldNot(Condition.empty);
        $("#singup").shouldNot(Condition.disabled);
        sleep(8000);

    }

    @Test
    public void mytest_2() {

        //გახსენით ee.ge - ს ლინკი - ტესტ მეთოდი 2 - ნეგატიური მნიშვნელობები//

        open("https://www.ee.ge/");
        $(byText("რეგისტრაცია")).click();
        $(byText("რეგისტრაცია")).shouldBe(Condition.visible);
        $("#singup").shouldBe(Condition.disabled);
        sleep(2000);
        $("#firstName").click();
        $("#firstName").shouldBe(Condition.empty);
        $("#lastName").click();
        $(byText("სახელი სავალდებულოა")).shouldBe(Condition.visible);
        $("#lastName").shouldBe(Condition.empty);
        $("#email").click();
        $(byText("გვარი სავალდებულოა")).shouldBe(Condition.visible);
        $("#email").shouldBe(Condition.empty);
        $("#password").pressEnter();
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
        $("#password").shouldBe(Condition.empty);
        $("#confirmPassword").pressEnter();
        $(byText("პაროლი სავალდებულოა.")).shouldBe(Condition.visible);
        $("#confirmPassword").shouldBe(Condition.empty);
        $("#confirmPassword").pressEnter();
        $(byText("რეგისტრაცია")).click();
        $(byText("პაროლის გამეორება სავალდებულოა")).shouldBe(Condition.visible);
        sleep(5000);
        open("https://www.ee.ge/");
        $(byText("რეგისტრაცია")).click();
        $(byText("რეგისტრაცია")).shouldBe(Condition.visible);
        $("#singup").shouldBe(Condition.disabled);
        $("#email").setValue("mariberidzegmail.com");
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
        $("#password").setValue("123");
        $("#confirmPassword").pressEnter();
        $(byText("პაროლი სავალდებულოა.")).shouldBe(Condition.visible);
        $("#confirmPassword").setValue("Tralivali@34567");
        $(byText("პაროლის გამეორება სავალდებულოა")).shouldBe(Condition.visible);
        sleep(3000);

    }

    @Test
    public void mytest_3() {

        //გახსენით ee.ge - ს ლინკი - ტესტ მეთოდი 3 //

        open("https://www.ee.ge/");
        $(".btn-cart").click();
        $(".not_cart_items").shouldBe(Condition.visible);
        $("#search_list").setValue("მტვერსასრუტი").pressEnter();
        $(byXpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/div[2]/a")).pressEnter();
        $(byText("დაამატე კალათში"), 0).click();
        $("#search_list").setValue("ყურსასმენი").pressEnter();
        $(byXpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/div[2]/a")).pressEnter();
        $(byText("დაამატე კალათში"), 0).click();
        $(".btn-cart").click();
        $(byText("კომპიუტერული ტექნიკა")).click();
        $(byText("ნოუთბუქი")).click();
        $(byText("დაამატე კალათში"), 0).click();
        sleep(500);
        $(".btn-cart").click();
        $(".btn-cart").shouldNot(Condition.empty);
        sleep(500);
        $(byText("წაშლა"), 0).click();
        $(".btn-cart").click();
        $(byText("წაშლა"), 1).click();
        $(".btn-cart").click();
        $(byText("წაშლა"), 0).click();
        $(".btn-cart").click();
        sleep(500);
        $(".not_cart_items").shouldBe(Condition.visible);

    }


    @Test
    public void mytest_4() {

        //გახსენით ee.ge - ს ლინკი - ტესტ მეთოდი 4 //

        open("https://www.ee.ge/");
        $(".btn-cart").click();
        $(".not_cart_items").shouldBe(Condition.visible);
        $("#search_list").setValue("მტვერსასრუტი").pressEnter();
        $(byXpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/div[2]/a")).click();
        $(byText("დაამატე კალათში"), 0).click();
        $(".btn-cart").click();
        $(byText("შენახვა")).click();
        $(byText("შენახული ნივთები")).click();
        $(byText("შენახული ნივთები")).shouldNot(Condition.empty);
        $(".btn-cart").click();
        $(".btn-cart").shouldBe(Condition.visible);
        $(byText("შენახული ნივთები")).click();
        $(byXpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/button")).click();
        $(byText("შენახული ნივთები")).shouldBe(Condition.visible);

    }
}
