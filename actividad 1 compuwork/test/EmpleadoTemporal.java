package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTemporalTest {

    @Test
    void testCrearEmpleadoTemporal() {
        EmpleadoTemporal emp = new EmpleadoTemporal("Ana", 201, 6, 7);

        assertEquals("Ana", emp.getNombre(), "El nombre debe ser Ana");
        assertEquals(201, emp.getId(), "El ID debe ser 201");
        assertEquals(6, emp.getDuracionContrato(), "La duración del contrato debe ser 6 meses");
        assertEquals(7, emp.getDesempeno(), "El desempeño debe ser 7");
    }

    @Test
    void testToString() {
        EmpleadoTemporal emp = new EmpleadoTemporal("Pedro", 202, 12, 9);

        String salida = emp.toString();
        assertTrue(salida.contains("Empleado: Pedro"), "Debe mostrar el nombre en toString");
        assertTrue(salida.contains("ID: 202"), "Debe mostrar el ID en toString");
        assertTrue(salida.contains("Desempeño: 9"), "Debe mostrar el desempeño en toString");
        assertTrue(salida.contains("Temporal"), "Debe indicar que es temporal");
        assertTrue(salida.contains("Contrato: 12 meses"), "Debe mostrar la duración del contrato en toString");
    }
}
