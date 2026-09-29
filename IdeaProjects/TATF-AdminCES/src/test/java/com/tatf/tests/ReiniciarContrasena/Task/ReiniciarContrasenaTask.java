package com.tatf.tests.ReiniciarContrasena.Task;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.tests.Popup.Task.PopupTask;
import com.tatf.tests.ReiniciarContrasena.Data.ReiniciarContrasenaData;
import com.tatf.tests.ReiniciarContrasena.Pom.ReiniciarContrasenaPO;

public class ReiniciarContrasenaTask {
    private final IBrowser browser;
    private final ReiniciarContrasenaPO reiniciarContrasena;

    public ReiniciarContrasenaTask(IBrowser browser) {
        this.browser = browser;
        this.reiniciarContrasena = new ReiniciarContrasenaPO(browser);
    }

    public void reiniciarContrasenaYVerificar(String email, String nuevaPassword) {
        this.reiniciarContrasena.clickLinkOlvidoPassword();
        this.reiniciarContrasena.escribirEmail(email);
        this.reiniciarContrasena.escribirPassword(nuevaPassword);
        this.reiniciarContrasena.escribirRepetirPassword(nuevaPassword);
        this.reiniciarContrasena.clickReset();

        String mensaje = new PopupTask(this.browser).confirmarYObtenerMensaje();
        IVerify.create().verify(ReiniciarContrasenaData.MENSAJE_EXITO, mensaje,
                "No se mostró el mensaje de confirmación de reinicio de contraseña.");
    }
}