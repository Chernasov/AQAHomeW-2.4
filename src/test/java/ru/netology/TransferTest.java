package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class TransferTest {

    @BeforeEach
    void setUpPage() {
        open("http://localhost:9999/");
//        user = new DataGenerator();
    }

    @Test
    void shouldTransferMoneyBetweenOwnCards() {
        var loginPage = new LoginPage();
        var infoValidUser = DataHelper.getAuthInfo();

    }
}