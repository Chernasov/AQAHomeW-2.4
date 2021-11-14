package ru.netology.page;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class ReplenishmentPage {
    private SelenideElement amount = $("[data-test-id='amount'] input");
    private SelenideElement from = $("[data-test-id='from'] input");
    private SelenideElement buttonReplenishment = $("[data-test-id='action-transfer']");

    public ReplenishmentPage() {
        amount.shouldBe(visible);
    }

    public DashboardPage replenishment(String transfer, DataHelper.CardInfo number) {
        amount.setValue(transfer);
        from.setValue(number.getNumber());
        buttonReplenishment.click();
        return new DashboardPage();
    }
}
