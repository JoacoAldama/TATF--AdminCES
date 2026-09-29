package com.tatf.tests.RegistroAdmin.Test;

import com.tatf.tests.Base.BaseTest;
import com.tatf.tests.RegistroAdmin.Task.RegistroAdminTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrearCuentaAdministradorTest extends BaseTest {

    private RegistroAdminTask registroAdmin;

    @BeforeEach
    void configurar() {
        this.registroAdmin = new RegistroAdminTask(browser);
    }

    @Test
    @DisplayName("Crea una cuenta de administrador correctamente")
    void crearCuentaAdministrador() {
        this.registroAdmin.registrarAdminYVerificar("QA", "Automation", "aldamajoaquin@gmail.com", "Prueba123", "Uruguay");
    }
}