package ru.netology.page;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class ReplenishmentPage {
    private SelenideElement amount = $("[data-test-id='amount'] input");
    private SelenideElement from = $("[data-test-id='from'] input");
    private SelenideElement to = $("[data-test-id='to'] input");
    private SelenideElement buttonReplenishment = $("[data-test-id='action-transfer']");

    public ReplenishmentPage() {
        amount.shouldBe(visible);
    }

    public DashboardPage replenishment(int transfer, DataHelper.CardInfo numberFrom, DataHelper.CardInfo numberTo) {
        amount.setValue(String.valueOf(transfer));
        from.setValue(numberFrom.getNumber());
        to.shouldHave(attributeMatching("value", ".*" + last4number(numberTo.getNumber())));
        buttonReplenishment.click();
        return new DashboardPage();
    }

    private String last4number(String text) {
        val value = text.substring(15);
        return value;
    }
}
