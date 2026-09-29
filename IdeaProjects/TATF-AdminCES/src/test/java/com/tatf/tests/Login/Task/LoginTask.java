package com.tatf.tests.Login.Task;

import com.tatf.core.browser.IBrowser;
import com.tatf.tests.Login.Pom.LoginPO;
import com.tatf.tests.Popup.Task.PopupTask;

public class LoginTask {
    private final IBrowser browser;
    private final LoginPO login;

    public LoginTask(IBrowser browser) {
        this.browser = browser;
        this.login = new LoginPO(browser);
    }

    public void loguearComoAdmin(String email, String password) {
        this.login.clickLinkLogin();
        this.login.escribirEmail(email);
        this.login.escribirPassword(password);
        this.login.clickIniciarSesion();
        new PopupTask(this.browser).confirmarYObtenerMensaje();
    }
}