package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferTest {

    @BeforeEach
    void setUpPage() {
        open("http://localhost:9999/");
    }

    @Test
    @Order(1)
    void shouldReplenismentFirstOwnCardFromSecond() {
        int transfer = 1000;
        var loginPage = new LoginPage();
        var infoValidUser = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(infoValidUser);
        var verificationCode = DataHelper.getVerificationCodeFor(infoValidUser);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var balanceCardFirstBefore = dashboardPage.getFirstCardBalance();
        var balanceCardSecondBefore = dashboardPage.getSecondCardBalance();
        var replenishment = dashboardPage.replenishmentFirstCard();
        var numberCardFrom = DataHelper.getNumberSecondCard();
        var numberCardTo = DataHelper.getNumberFirstCard();
        var dashboardPageAfter = replenishment.replenishment(transfer, numberCardFrom, numberCardTo);
        var balanceCardFirstAfter = dashboardPageAfter.getFirstCardBalance();
        var balanceCardSecondAfter = dashboardPageAfter.getSecondCardBalance();
        assertEquals(balanceCardFirstBefore + transfer, balanceCardFirstAfter);
        assertEquals(balanceCardSecondBefore - transfer, balanceCardSecondAfter);
    }

    @Test
    @Order(2)
    void shouldReplenishmentSecondOwnCardFromFirst() {
        int transfer = 1000;
        var loginPage = new LoginPage();
        var infoValidUser = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(infoValidUser);
        var verificationCode = DataHelper.getVerificationCodeFor(infoValidUser);
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var balanceCardFirstBefore = dashboardPage.getFirstCardBalance();
        var balanceCardSecondBefore = dashboardPage.getSecondCardBalance();
        var replenishment = dashboardPage.replenishmentSecondCard();
        var numberCardFrom = DataHelper.getNumberFirstCard();
        var numberCardTo = DataHelper.getNumberSecondCard();
        var dashboardPageAfter = replenishment.replenishment(transfer, numberCardFrom, numberCardTo);
        var balanceCardFirstAfter = dashboardPageAfter.getFirstCardBalance();
        var balanceCardSecondAfter = dashboardPageAfter.getSecondCardBalance();
        assertEquals(balanceCardFirstBefore - transfer, balanceCardFirstAfter);
        assertEquals(balanceCardSecondBefore + transfer, balanceCardSecondAfter);
    }


}
