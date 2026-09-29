package com.tatf.tests.Login.Pom;

import com.tatf.core.browser.IBrowser;

public class LoginPO {
    private final IBrowser browser;

    private final String linkLogin = "a[href='/adminces/login']";
    private final String inputEmail = "inputEmail";
    private final String inputPassword = "inputPassword";
    private final String btnIniciarSesion = "//button[contains(text(),'Iniciar Sesión')]";

    public LoginPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clickLinkLogin() {
        this.browser.find().css(linkLogin).click();
    }

    public void escribirEmail(String email) {
        this.browser.find().name(inputEmail).write(email);
    }

    public void escribirPassword(String password) {
        this.browser.find().name(inputPassword).write(password);
    }

    public void clickIniciarSesion() {
        this.browser.find().xpath(btnIniciarSesion).click();
    }
}