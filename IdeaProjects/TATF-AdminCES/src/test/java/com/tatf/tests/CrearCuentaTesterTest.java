package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.element.Element;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CrearCuentaTesterTest {

    private static IBrowser browser;

    @BeforeAll
    static void beforeAll() {
        browser = BrowserFactory.getBrowser(true);
        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
        browser.find().css("input[type='password']").write("3)ea60e0be3ba12c6ecd%7297868%5c4");
        browser.find().css("button[type='submit']").click();
    }

    @AfterAll
    static void afterAll() {
        BrowserFactory.quitBrowser();
    }

    @Test
    void crearCuentaTester() {
        String email = "tester@gmail.com";
        String password = "Prueba123";

//Login admin
        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
        browser.find().css("a[href='/adminces/login']").click();
        browser.find().name("inputEmail").write("yaniscorrea@gmail.com");
        browser.find().name("inputPassword").write("12345");
        browser.find().xpath("//button[contains(text(),'Iniciar Sesión')]").click();
        browser.wait(".swal2-popup").css();
        browser.find().css(".swal2-confirm").click();

        //Crear cuenta QA
        browser.find().css("a[href='/adminces/create-user']").click();
        browser.find().name("inputFirstName").write("QA");
        browser.find().name("inputLastName").write("Automation");
        browser.find().name("inputEmail").write(email);
        browser.find().name("inputCountry").selectText("Uruguay");
        browser.find().name("inputPassword").write(password);
        browser.find().id("testerJunior").click();
        browser.find().id("btnRegister").click();

       //cierra popup
        browser.wait(".swal2-popup").css();
        Element modal = browser.find().css(".swal2-title");
        String mensajeObtenido = modal.getText();
        browser.find().css(".swal2-confirm").click();

        IVerify.create().verify("Correcto!", mensajeObtenido,
                "No se mostró el mensaje de confirmación de alta de Tester.");

    }
}