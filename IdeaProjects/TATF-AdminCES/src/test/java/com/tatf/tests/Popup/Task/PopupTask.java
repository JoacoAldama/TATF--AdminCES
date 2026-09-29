package com.tatf.tests.Popup.Task;

import com.tatf.core.browser.IBrowser;
import com.tatf.tests.Popup.Pom.PopupPO;

public class PopupTask {
    private final PopupPO popup;

    public PopupTask(IBrowser browser) {
        this.popup = new PopupPO(browser);
    }

    public String confirmarYObtenerMensaje() {
        this.popup.esperarPopup();
        String mensaje = this.popup.getMensaje();
        this.popup.clickConfirmar();
        return mensaje;
    }
}