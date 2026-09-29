package com.tatf.tests.RegistroTester.Pom;

import com.tatf.core.browser.IBrowser;

public class RegistroTesterPO {
    private final IBrowser browser;

    private final String linkCrearUsuario = "a[href='/adminces/create-user']";
    private final String inputFirstName = "inputFirstName";
    private final String inputLastName = "inputLastName";
    private final String inputEmail = "inputEmail";
    private final String inputCountry = "inputCountry";
    private final String inputPassword = "inputPassword";
    private final String checkboxTesterJunior = "testerJunior";
    private final String btnRegister = "btnRegister";

    public RegistroTesterPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clickLinkCrearUsuario() {
        this.browser.find().css(linkCrearUsuario).click();
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

    public void seleccionarPais(String pais) {
        this.browser.find().name(inputCountry).selectText(pais);
    }

    public void escribirPassword(String password) {
        this.browser.find().name(inputPassword).write(password);
    }

    public void clickTesterJunior() {
        this.browser.find().id(checkboxTesterJunior).click();
    }

    public void clickRegistrar() {
        this.browser.find().id(btnRegister).click();
    }
}