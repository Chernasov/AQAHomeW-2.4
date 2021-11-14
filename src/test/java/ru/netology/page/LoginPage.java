package ru.netology.page;

import ru.netology.data.DataHelper;

public class LoginPage {
    public VerificationPage validLogin(DataHelper.AuthInfo info) {

        return new VerificationPage();
    }
}
