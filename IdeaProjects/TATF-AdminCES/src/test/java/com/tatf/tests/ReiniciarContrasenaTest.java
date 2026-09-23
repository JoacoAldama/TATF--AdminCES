package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.element.Element;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ReiniciarContrasenaTest {

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
    void reiniciarContrasenaDeUnaCuentaExistente() {
        String email = "yaniscorrea@gmail.com";
        String newPassword = "NuevaPass123";

//Reiniciar contraseña
        browser.find().css("a[href='/adminces/forgot-password']").click();
        browser.find().name("inputEmail").write(email);
        browser.find().name("inputPassword").write(newPassword);
        browser.find().name("inputRepeatPassword").write(newPassword);
        browser.find().id("btnReset").click();
//cierra popup
        browser.wait(".swal2-popup").css();
        Element modal = browser.find().css(".swal2-title");
        String mensajeObtenido = modal.getText();
        browser.find().css(".swal2-confirm").click();

        IVerify.create().verify("Correcto!", mensajeObtenido,
                "No se mostró el mensaje de confirmación de reinicio de contraseña.");
    }
}