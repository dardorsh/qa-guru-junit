package quru.qa;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import quru.qa.data.AuthorAndBook;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BookStoreTests extends TestBase {

    @ValueSource(strings = {"Пушкин", "Лермонтов", "Толстой"})
    @ParameterizedTest(name= "Поиск по фамилии автора {0} должен выдать карточки книг")
    @Tag("BLOCKER")
    void checkSearchResultsAreNotEmpty(String searchQuery) {
        $("[data-testid='search__input']").setValue(searchQuery).pressEnter();
        $$("[data-testid='art__authorName--link']").shouldBe(sizeGreaterThan(0));
    }

    @CsvSource(value = {
            "Пушкин, Капитанская дочка",
            "Лермонтов, Герой нашего времени"
    })
    @ParameterizedTest(name = "В результатах поиска по автору {0} должна быть книга {1}")
    void checkSearchResultsContainExactBook(String searchQuery, String bookName) {
        $("[data-testid='search__input']").setValue(searchQuery).pressEnter();
        $$("[data-testid='art__title']").first().shouldHave(text(bookName));
    }

    @EnumSource(AuthorAndBook.class)
    @ParameterizedTest(name = "В результатах поиска по автору {0} должна быть книга {1}")
    void checkSearchResultContainFullAuthorName(AuthorAndBook data) {
        String searchQuery = data.getAuthor();
        String bookName = data.getBook();

        $("[data-testid='search__input']").setValue(searchQuery).pressEnter();
        $$("[data-testid='art__title']").first().shouldHave(text(bookName));
    }
}
