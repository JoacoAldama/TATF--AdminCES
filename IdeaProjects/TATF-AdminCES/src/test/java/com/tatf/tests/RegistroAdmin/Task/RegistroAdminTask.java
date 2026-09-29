package com.tatf.tests.RegistroAdmin.Task;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.tests.Popup.Task.PopupTask;
import com.tatf.tests.RegistroAdmin.Data.RegistroAdminData;
import com.tatf.tests.RegistroAdmin.Pom.RegistroAdminPO;

public class RegistroAdminTask {
    private final IBrowser browser;
    private final RegistroAdminPO registroAdmin;

    public RegistroAdminTask(IBrowser browser) {
        this.browser = browser;
        this.registroAdmin = new RegistroAdminPO(browser);
    }

    public void registrarAdminYVerificar(String nombre, String apellido, String email, String password, String pais) {
        this.registroAdmin.clickLinkRegistro();
        this.registroAdmin.escribirNombre(nombre);
        this.registroAdmin.escribirApellido(apellido);
        this.registroAdmin.escribirEmail(email);
        this.registroAdmin.escribirPassword(password);
        this.registroAdmin.escribirRepetirPassword(password);
        this.registroAdmin.escribirPais(pais);
        this.registroAdmin.clickTerminos();
        this.registroAdmin.clickRegistrar();

        String mensaje = new PopupTask(this.browser).confirmarYObtenerMensaje();
        IVerify.create().verify(RegistroAdminData.MENSAJE_EXITO, mensaje,
                "No se mostró el mensaje de confirmación de alta Admin.");
    }
}