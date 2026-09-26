package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
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
        browser.find().css("input[type='password']").write("Insertar Hash");
        browser.find().css("button[type='submit']").click();
    }

    @AfterAll
    static void afterAll() {
        BrowserFactory.quitBrowser();
    }

    @Test
    void eliminarCuentaTester() {
        String email = "jeniffer@gmail.com";

        // Login
        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
        browser.find().css("a[href='/adminces/login']").click();
        browser.find().name("inputEmail").write("yaniscorrea@gmail.com");
        browser.find().name("inputPassword").write("12345");
        browser.find().xpath("//button[contains(text(),'Iniciar Sesión')]").click();
        browser.wait(".swal2-popup").css();
        browser.find().css(".swal2-confirm").click();

        // Eliminación Tester
        browser.find().css("a[href='/adminces/view-users']").click();
        browser.wait("bodyTable").id();
        browser.find().id(email).click();

       // cierra popup
        browser.wait(".swal2-popup").css();
        browser.find().css(".swal2-confirm").click();

        String tablaUsuarios = browser.find().id("bodyTable").getText();
        IVerify.create().verifyTrue(!tablaUsuarios.contains(email),
                "La cuenta " + email + " debería haber sido eliminada del listado");
    }
}
