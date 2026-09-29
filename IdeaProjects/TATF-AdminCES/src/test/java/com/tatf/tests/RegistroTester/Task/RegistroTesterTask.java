package com.tatf.tests.RegistroTester.Task;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.tests.Login.Data.LoginData;
import com.tatf.tests.Login.Task.LoginTask;
import com.tatf.tests.Popup.Task.PopupTask;
import com.tatf.tests.RegistroTester.Data.RegistroTesterData;
import com.tatf.tests.RegistroTester.Pom.RegistroTesterPO;

public class RegistroTesterTask {
    private final IBrowser browser;
    private final RegistroTesterPO registroTester;

    public RegistroTesterTask(IBrowser browser) {
        this.browser = browser;
        this.registroTester = new RegistroTesterPO(browser);
    }

    public void crearTesterYVerificar(String nombre, String apellido, String email, String password, String pais) {
        new LoginTask(this.browser).loguearComoAdmin(LoginData.EMAIL_ADMIN, LoginData.PASSWORD_ADMIN);

        this.registroTester.clickLinkCrearUsuario();
        this.registroTester.escribirNombre(nombre);
        this.registroTester.escribirApellido(apellido);
        this.registroTester.escribirEmail(email);
        this.registroTester.seleccionarPais(pais);
        this.registroTester.escribirPassword(password);
        this.registroTester.clickTesterJunior();
        this.registroTester.clickRegistrar();

        String mensaje = new PopupTask(this.browser).confirmarYObtenerMensaje();
        IVerify.create().verify(RegistroTesterData.MENSAJE_EXITO, mensaje,
                "No se mostró el mensaje de confirmación de alta de Tester.");
    }
}