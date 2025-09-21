package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartamentoTest {

    private Departamento departamento;

    @BeforeEach
    void setUp() {
        departamento = new Departamento("Recursos Humanos");
    }

    @Test
    void testCrearDepartamento() {
        assertEquals("Recursos Humanos", departamento.getNombre(), "El nombre del departamento debe coincidir");
        assertTrue(departamento.getEmpleados().isEmpty(), "Un nuevo departamento debe iniciar sin empleados");
    }

    @Test
    void testAgregarEmpleado() {
        Empleado e = new EmpleadoPermanente("Carlos", 1, 2000, 8);
        departamento.agregarEmpleado(e);

        assertEquals(1, departamento.getEmpleados().size(), "Debe haber 1 empleado en el departamento");
        assertEquals("Carlos", departamento.getEmpleados().get(0).getNombre(), "El nombre del empleado debe ser Carlos");
    }

    @Test
    void testEliminarEmpleado() {
        Empleado e1 = new EmpleadoPermanente("Ana", 2, 2500, 7);
        Empleado e2 = new EmpleadoTemporal("Luis", 3, 6, 6);
        departamento.agregarEmpleado(e1);
        departamento.agregarEmpleado(e2);

        departamento.eliminarEmpleado(2);

        assertEquals(1, departamento.getEmpleados().size(), "Después de eliminar debe quedar 1 empleado");
        assertEquals(3, departamento.getEmpleados().get(0).getId(), "El empleado restante debe ser Luis");
    }

    @Test
    void testCalcularDesempenoVacio() {
        assertEquals(1, departamento.calcularDesempeno(), "El desempeño de un departamento vacío debe ser 1");
    }

    @Test
    void testCalcularDesempenoConEmpleados() {
        departamento.agregarEmpleado(new EmpleadoPermanente("Ana", 4, 2500, 8));
        departamento.agregarEmpleado(new EmpleadoTemporal("Luis", 5, 12, 6));

        double promedio = departamento.calcularDesempeno();
        assertEquals(7.0, promedio, "El promedio debe ser 7.0");
    }

    @Test
    void testToString() {
        departamento.agregarEmpleado(new EmpleadoPermanente("Carlos", 6, 2200, 9));

        String salida = departamento.toString();
        assertTrue(salida.contains("Departamento: Recursos Humanos"), "toString debe incluir el nombre del departamento");
        assertTrue(salida.contains("Empleados: 1"), "toString debe mostrar la cantidad de empleados");
        assertTrue(salida.contains("Desempeño:"), "toString debe mostrar el desempeño");
    }
}
