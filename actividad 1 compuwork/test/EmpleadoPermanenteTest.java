package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmpleadoPermanenteTest {

    @Test
    void testCrearEmpleadoPermanente() {
        EmpleadoPermanente emp = new EmpleadoPermanente("Carlos", 101, 2500.0, 8);

        assertEquals("Carlos", emp.getNombre(), "El nombre debe ser Carlos");
        assertEquals(101, emp.getId(), "El ID debe ser 101");
        assertEquals(8, emp.getDesempeno(), "El desempeño debe ser 8");
        assertEquals(2500.0, emp.getSalario(), "El salario debe ser 2500.0");
    }

    @Test
    void testToString() {
        EmpleadoPermanente emp = new EmpleadoPermanente("Lucía", 102, 3200.0, 9);

        String salida = emp.toString();
        assertTrue(salida.contains("Empleado: Lucía"), "Debe mostrar el nombre en toString");
        assertTrue(salida.contains("ID: 102"), "Debe mostrar el ID en toString");
        assertTrue(salida.contains("Desempeño: 9"), "Debe mostrar el desempeño en toString");
        assertTrue(salida.contains("Permanente"), "Debe indicar que es permanente");
        assertTrue(salida.contains("Salario: 3200.0"), "Debe mostrar el salario en toString");
    }
}
