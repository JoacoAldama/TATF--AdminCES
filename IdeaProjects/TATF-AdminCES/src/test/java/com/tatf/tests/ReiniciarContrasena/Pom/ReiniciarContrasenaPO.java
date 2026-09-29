package com.tatf.tests.ReiniciarContrasena.Pom;

import com.tatf.core.browser.IBrowser;

public class ReiniciarContrasenaPO {
    private final IBrowser browser;

    private final String linkOlvidoPassword = "a[href='/adminces/forgot-password']";
    private final String inputEmail = "inputEmail";
    private final String inputPassword = "inputPassword";
    private final String inputRepeatPassword = "inputRepeatPassword";
    private final String btnReset = "btnReset";

    public ReiniciarContrasenaPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clickLinkOlvidoPassword() {
        this.browser.find().css(linkOlvidoPassword).click();
    }

    public void escribirEmail(String email) {
        this.browser.find().name(inputEmail).write(email);
    }

    public void escribirPassword(String password) {
        this.browser.find().name(inputPassword).write(password);
    }

    public void escribirRepetirPassword(String password) {
        this.browser.find().name(inputRepeatPassword).write(password);
    }

    public void clickReset() {
        this.browser.find().id(btnReset).click();
    }
}