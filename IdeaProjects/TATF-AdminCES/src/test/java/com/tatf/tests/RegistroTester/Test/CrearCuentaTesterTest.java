package com.tatf.tests.RegistroTester.Test;

import com.tatf.tests.Base.BaseTest;
import com.tatf.tests.RegistroTester.Task.RegistroTesterTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrearCuentaTesterTest extends BaseTest {

    private RegistroTesterTask registroTester;

    @BeforeEach
    void configurar() {
        this.registroTester = new RegistroTesterTask(browser);
    }

    @Test
    @DisplayName("Crea una cuenta de tester correctamente")
    void crearCuentaTester() {
        this.registroTester.crearTesterYVerificar("QA", "Automation", "tester@gmail.com", "Prueba123", "Uruguay");
    }
}