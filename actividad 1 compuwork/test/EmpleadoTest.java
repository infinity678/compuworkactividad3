package modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    // 🔹 Clase anónima para poder probar la abstracta
    static class EmpleadoStub extends Empleado {
        public EmpleadoStub(String nombre, int id, int desempeno) {
            super(nombre, id, desempeno);
        }
    }

    @Test
    void testCrearEmpleado() {
        Empleado e = new EmpleadoStub("Juan", 1, 7);

        assertEquals("Juan", e.getNombre(), "El nombre debe ser Juan");
        assertEquals(1, e.getId(), "El ID debe ser 1");
        assertEquals(7, e.getDesempeno(), "El desempeño debe ser 7");
    }

    @Test
    void testCalcularDesempeno() {
        Empleado e = new EmpleadoStub("Ana", 2, 9);

        assertEquals(9.0, e.calcularDesempeno(), "El desempeño calculado debe ser 9.0");
    }

    @Test
    void testToString() {
        Empleado e = new EmpleadoStub("Luis", 3, 6);

        String salida = e.toString();
        assertTrue(salida.contains("Empleado: Luis"), "toString debe contener el nombre");
        assertTrue(salida.contains("ID: 3"), "toString debe contener el ID");
        assertTrue(salida.contains("Desempeño: 6.0") || salida.contains("Desempeño: 6"),
                "toString debe mostrar el desempeño");
    }
}
