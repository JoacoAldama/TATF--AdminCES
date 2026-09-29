package com.tatf.tests.RegistroAdmin.Pom;

import com.tatf.core.browser.IBrowser;

public class RegistroAdminPO {
    private final IBrowser browser;

    private final String linkRegistro = "a[href='/adminces/register']";
    private final String inputFirstName = "inputFirstName";
    private final String inputLastName = "inputLastName";
    private final String inputEmail = "inputEmail";
    private final String inputPassword = "inputPassword";
    private final String inputRepeatPassword = "inputRepeatPassword";
    private final String inputCountry = "inputCountry";
    private final String checkboxTerminos = "#formAccount > div:nth-child(4)";
    private final String btnRegister = "btnRegister";

    public RegistroAdminPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clickLinkRegistro() {
        this.browser.find().css(linkRegistro).click();
    }

    public void escribirNombre(String nombre) {
        this.browser.find().name(inputFirstName).write(nombre);
    }

    public void escribirApellido(String apellido) {
        this.browser.find().name(inputLastName).write(apellido);
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

    public void escribirPais(String pais) {
        this.browser.find().name(inputCountry).write(pais);
    }

    public void clickTerminos() {
        this.browser.find().css(checkboxTerminos).click();
    }

    public void clickRegistrar() {
        this.browser.find().id(btnRegister).click();
    }
}