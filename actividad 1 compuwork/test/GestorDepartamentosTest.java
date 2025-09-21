package gestor;

import modelo.Departamento;
import modelo.Empleado;
import modelo.EmpleadoPermanente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GestorDepartamentosTest {

    private GestorDepartamentos gestor;

    @BeforeEach
    void setUp() {
        // Creamos un GestorDepartamentos con un GestorEmpleados vacío
        gestor = new GestorDepartamentos(new Scanner(System.in), new GestorEmpleados(new Scanner(System.in)));
    }

    @Test
    void testCrearDepartamento() {
        Departamento d = new Departamento("Ventas");
        gestor.getDepartamentos().add(d);

        assertEquals(1, gestor.getDepartamentos().size(), "Debe haber 1 departamento creado");
        assertEquals("Ventas", gestor.getDepartamentos().get(0).getNombre(), "El nombre del departamento debe ser 'Ventas'");
    }

    @Test
    void testAgregarEmpleadoADepartamento() {
        Departamento d = new Departamento("TI");
        gestor.getDepartamentos().add(d);

        // 👇 Aquí el ID ahora es un int (antes lo puse como String)
        Empleado e = new EmpleadoPermanente("Juan", 1, 2000, 90);
        d.agregarEmpleado(e);

        assertEquals(1, d.getEmpleados().size(), "El departamento TI debe tener 1 empleado");
        assertEquals("Juan", d.getEmpleados().get(0).getNombre(), "El empleado agregado debe llamarse Juan");
    }
}
