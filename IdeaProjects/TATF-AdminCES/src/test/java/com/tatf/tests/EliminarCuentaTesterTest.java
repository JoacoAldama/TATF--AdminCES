package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.element.Element;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class EliminarCuentaTesterTest {

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
    void eliminarCuentaTester() {
        String email = "tester.qa." + Long.toString(System.currentTimeMillis(), 36) + "@miempresa.com";
        String password = "Prueba123";

        // Login
        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
        browser.find().css("a[href='/adminces/login']").click();
        browser.find().name("inputEmail").write("yaniscorrea@gmail.com");
        browser.find().name("inputPassword").write("12345");
        browser.find().xpath("//button[contains(text(),'Iniciar Sesión')]").click();
        browser.wait(".swal2-popup").css();
        browser.find().css(".swal2-confirm").click();

        // Eliminacion Tester
        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/view-users");
        browser.find().id(email).click();

        String tablaUsuarios = browser.find().id("bodyTable").getText();
        IVerify.create().verifyTrue(!tablaUsuarios.contains(email),
                "La cuenta " + email + " debería haber sido eliminada del listado");
    }
}
