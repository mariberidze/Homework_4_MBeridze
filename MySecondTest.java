import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.*;

public class MySecondTest {
    @Test
    public void Mytest_1() {

        //1.საიტი -myhome.ge - იპოთეკური სესხის გამომთვლელი //

        Configuration.browserSize = "1500x800";
        //Configuration.browser = "Firefox";
        open("https://www.myhome.ge/ka/");
        $(byLinkText("იპოთეკა")).click();
        $("#principal").setValue("2000");
        $("#base").setValue("15");
        $(byText("15 წელი")).click();
        $("#months").setValue("3");
        $("#percent").setValue("5");
        $(".amount").click();
        //$(".convert-toggler active").click();
        $("#bank-1").click();
        $(byText("შემდეგი")).shouldBe(Condition.enabled);
        $(byText("აიღე იპოთეკური სესხი ონლაინ")).click();
        sleep(2000);
    }

    @Test
    public void Mytest_2() {

        //2.საიტი -myhome.ge - შესვლა - ავტორიზაცია //

        Configuration.browserSize = "1500x800";
        //Configuration.browser = "Firefox";
        open("https://www.myhome.ge/ka/");
        $(byText("შესვლა")).click();
        $("#Email").setValue("marimari@gmail.com");
        $("#Password").pressEnter();
        $(byName("Password")).setValue("Adfgj").pressEnter();
        $(byText("შესვლა")).click();
        $("#input-error-Password").shouldBe(Condition.visible, Duration.ofMillis(2000));



    }
}