package com.tatf.tests.ReiniciarContrasena.Test;

import com.tatf.tests.Base.BaseTest;
import com.tatf.tests.ReiniciarContrasena.Task.ReiniciarContrasenaTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReiniciarContrasenaTest extends BaseTest {

    private ReiniciarContrasenaTask reiniciarContrasena;

    @BeforeEach
    void configurar() {
        this.reiniciarContrasena = new ReiniciarContrasenaTask(browser);
    }

    @Test
    @DisplayName("Reinicia la contraseña de una cuenta existente")
    void reiniciarContrasenaDeUnaCuentaExistente() {
        this.reiniciarContrasena.reiniciarContrasenaYVerificar("yaniscorrea@gmail.com", "NuevaPass123");
    }
}