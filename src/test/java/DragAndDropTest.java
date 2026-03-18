import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest {

    @BeforeAll
    static void beforeAll() {

        //Задаём разрешение браузера
        Configuration.browserSize= "2560x1440";

        //Задаём URL
        Configuration.baseUrl = "https://the-internet.herokuapp.com";

        //Пропускаем полную загрузку страницы
        Configuration.pageLoadStrategy = "eager";

        //Оставляем браузер открытым
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void dragAndDropTest() {

        //Открыть страницу
        open("/drag_and_drop");

        //Назначаем элементы
        SelenideElement columnA = $("#column-a");
        SelenideElement columnB = $("#column-b");

        //Проверяем что элементы на своих местах
        $("#column-a header").shouldHave(text("A"));
        $("#column-b header").shouldHave(text("B"));


        //drag and drop
        columnA.dragAndDrop(DragAndDropOptions.to(columnB));

        // Проверка, что элементы поменялись местами
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));


    }
}
