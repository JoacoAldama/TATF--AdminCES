package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.element.Element;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CrearCuentaAdministradorTest {

    private static IBrowser browser;

    @BeforeAll
    static void beforeAll() {
        browser = BrowserFactory.getBrowser(true);
        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
        browser.find().css("input[type='password']").write("Insertar HASH");
        browser.find().css("button[type='submit']").click();
    }

    @AfterAll
    static void afterAll() {
        BrowserFactory.quitBrowser();
    }

    @Test
    void crearCuentaAdministrador() {
        String email = "aldamajoaquin@gmail.com";
        String password = "Prueba123";

//Registro Admin
        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
        browser.find().css("a[href='/adminces/register']").click();
        browser.find().name("inputFirstName").write("QA");
        browser.find().name("inputLastName").write("Automation");
        browser.find().name("inputEmail").write(email);
        browser.find().name("inputPassword").write(password);
        browser.find().name("inputRepeatPassword").write(password);
        browser.find().name("inputCountry").write("Uruguay");
        browser.find().css("#formAccount > div:nth-child(4)").click();
        browser.find().id("btnRegister").click();

        //cierra popup
        browser.wait(".swal2-popup").css();
        Element modal = browser.find().css(".swal2-title");
        String mensajeObtenido = modal.getText();
        browser.find().css(".swal2-confirm").click();

        IVerify.create().verify("Correcto!", mensajeObtenido,
                "No se mostró el mensaje de confirmación de alta Admin.");

    }
}
