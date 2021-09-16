package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Tag("selenide_android")
public class BrowserStackAndroidSelenideTests extends TestBase {

    @Test
    @DisplayName("Search Selenide in Wikipedia")
    void searchSelenideTest() {
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("Selenide");
        });
        step("Tap on first link in search results", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/view_list_card_header")).click());

        step("Check that article for Selenide chemical compound was found", () ->
                $(MobileBy.AccessibilityId("hydrogen selenide")).shouldBe(Condition.visible));
    }

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchBrowserstackTest() {
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("BrowserStack");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }
}
