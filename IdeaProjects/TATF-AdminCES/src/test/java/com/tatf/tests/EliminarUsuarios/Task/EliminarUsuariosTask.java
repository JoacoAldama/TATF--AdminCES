package com.tatf.tests.EliminarUsuarios.Task;

import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import com.tatf.tests.EliminarUsuarios.Pom.EliminarUsuariosPO;
import com.tatf.tests.Login.Data.LoginData;
import com.tatf.tests.Login.Task.LoginTask;
import com.tatf.tests.Popup.Task.PopupTask;

public class EliminarUsuariosTask {
    private final IBrowser browser;
    private final EliminarUsuariosPO eliminarUsuarios;

    public EliminarUsuariosTask(IBrowser browser) {
        this.browser = browser;
        this.eliminarUsuarios = new EliminarUsuariosPO(browser);
    }

    public void eliminarUsuarioYVerificar(String email) {
        new LoginTask(this.browser).loguearComoAdmin(LoginData.EMAIL_ADMIN, LoginData.PASSWORD_ADMIN);

        this.eliminarUsuarios.clickLinkVerUsuarios();
        this.eliminarUsuarios.esperarTabla();
        this.eliminarUsuarios.clickEliminar(email);
        new PopupTask(this.browser).confirmarYObtenerMensaje();

        String tabla = this.eliminarUsuarios.getTextoTabla();
        IVerify.create().verifyTrue(!tabla.contains(email),
                "La cuenta " + email + " debería haber sido eliminada del listado");
    }
}