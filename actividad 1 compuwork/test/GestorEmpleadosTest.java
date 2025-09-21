package gestor;

import modelo.Empleado;
import modelo.EmpleadoPermanente;
import modelo.EmpleadoTemporal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GestorEmpleadosTest {

    private GestorEmpleados gestor;

    @BeforeEach
    void setUp() {
        gestor = new GestorEmpleados(new Scanner(System.in));
    }

    @Test
    void testAgregarEmpleadoPermanente() {
        Empleado e = new EmpleadoPermanente("Ana", 101, 2500.0, 8);
        gestor.getEmpleados().add(e);

        assertEquals(1, gestor.getEmpleados().size(), "Debe haber 1 empleado agregado");
        assertTrue(gestor.getEmpleados().get(0) instanceof EmpleadoPermanente, "El empleado debe ser permanente");
        assertEquals("Ana", gestor.getEmpleados().get(0).getNombre(), "El nombre debe coincidir");
    }

    @Test
    void testAgregarEmpleadoTemporal() {
        Empleado e = new EmpleadoTemporal("Luis", 102, 6, 7);
        gestor.getEmpleados().add(e);

        assertEquals(1, gestor.getEmpleados().size(), "Debe haber 1 empleado agregado");
        assertTrue(gestor.getEmpleados().get(0) instanceof EmpleadoTemporal, "El empleado debe ser temporal");
        assertEquals(102, gestor.getEmpleados().get(0).getId(), "El ID debe coincidir");
    }

    @Test
    void testNormalizarDesempeno() {
        // Vamos a usar reflexión porque normalizarDesempeno es privado
        try {
            var metodo = GestorEmpleados.class.getDeclaredMethod("normalizarDesempeno", int.class);
            metodo.setAccessible(true);

            int bajo = (int) metodo.invoke(gestor, 5);   // debería ser 1
            int medio = (int) metodo.invoke(gestor, 75); // debería ser 7
            int alto = (int) metodo.invoke(gestor, 120); // debería ser 10

            assertEquals(1, bajo);
            assertEquals(7, medio);
            assertEquals(10, alto);
        } catch (Exception e) {
            fail("No se pudo probar normalizarDesempeno: " + e.getMessage());
        }
    }
}
