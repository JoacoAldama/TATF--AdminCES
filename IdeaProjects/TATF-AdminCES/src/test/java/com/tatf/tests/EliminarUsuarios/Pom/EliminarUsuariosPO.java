package com.tatf.tests.EliminarUsuarios.Pom;

import com.tatf.core.browser.IBrowser;

public class EliminarUsuariosPO {
    private final IBrowser browser;

    private final String linkVerUsuarios = "a[href='/adminces/view-users']";
    private final String tablaUsuarios = "bodyTable";

    public EliminarUsuariosPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clickLinkVerUsuarios() {
        this.browser.find().css(linkVerUsuarios).click();
    }

    public void esperarTabla() {
        this.browser.wait(tablaUsuarios).id();
    }

    public void clickEliminar(String email) {
        this.browser.find().id(email).click();
    }

    public String getTextoTabla() {
        return this.browser.find().id(tablaUsuarios).getText();
    }
}