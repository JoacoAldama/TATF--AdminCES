package com.tatf.tests.EliminarUsuarios.Test;

import com.tatf.tests.Base.BaseTest;
import com.tatf.tests.EliminarUsuarios.Task.EliminarUsuariosTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EliminarCuentaTesterTest extends BaseTest {

    private EliminarUsuariosTask eliminarUsuarios;

    @BeforeEach
    void configurar() {
        this.eliminarUsuarios = new EliminarUsuariosTask(browser);
    }

    @Test
    @DisplayName("Elimina una cuenta de tester existente")
    void eliminarCuentaTester() {
        this.eliminarUsuarios.eliminarUsuarioYVerificar("jeniffer@gmail.com");
    }
}