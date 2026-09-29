package com.tatf.tests.Popup.Pom;

import com.tatf.core.browser.IBrowser;

public class PopupPO {
    private final IBrowser browser;

    private final String popup = ".swal2-popup";
    private final String titulo = ".swal2-title";
    private final String botonConfirmar = ".swal2-confirm";

    public PopupPO(IBrowser browser) {
        this.browser = browser;
    }

    public void esperarPopup() {
        this.browser.wait(popup).css();
    }

    public String getMensaje() {
        return this.browser.find().css(titulo).getText();
    }

    public void clickConfirmar() {
        this.browser.find().css(botonConfirmar).click();
    }
}