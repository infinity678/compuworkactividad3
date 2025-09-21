package gestor;

import modelo.Empleado;
import modelo.EmpleadoPermanente;
import modelo.EmpleadoTemporal;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorEmpleados {
    private ArrayList<Empleado> empleados;
    private Scanner sc;

    public GestorEmpleados(Scanner sc) {
        this.sc = sc;
        this.empleados = new ArrayList<>();
    }

    public void menuEmpleados() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE EMPLEADOS ---");
            System.out.println("1. Crear Empleado Permanente");
            System.out.println("2. Crear Empleado Temporal");
            System.out.println("3. Listar Empleados");
            System.out.println("0. Volver al menú principal");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> crearEmpleadoPermanente();
                case 2 -> crearEmpleadoTemporal();
                case 3 -> listarEmpleados();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("⚠ Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void crearEmpleadoPermanente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("ID: ");
        int id = sc.nextInt();
        System.out.print("Salario: ");
        double salario = sc.nextDouble();
        System.out.print("Desempeño (0-100): ");
        int desempeno = sc.nextInt();
        sc.nextLine();

        desempeno = normalizarDesempeno(desempeno);
        empleados.add(new EmpleadoPermanente(nombre, id, salario, desempeno));
        System.out.println("✅ Empleado permanente creado con desempeño " + desempeno + "/10.");
    }

    private void crearEmpleadoTemporal() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("ID: ");
        int id = sc.nextInt();
        System.out.print("Duración contrato (meses): ");
        int duracion = sc.nextInt();
        System.out.print("Desempeño (0-100): ");
        int desempeno = sc.nextInt();
        sc.nextLine();

        desempeno = normalizarDesempeno(desempeno);
        empleados.add(new EmpleadoTemporal(nombre, id, duracion, desempeno));
        System.out.println("✅ Empleado temporal creado con desempeño " + desempeno + "/10.");
    }

    private int normalizarDesempeno(int valor) {
        int resultado = valor / 10;
        if (resultado < 1) resultado = 1;
        if (resultado > 10) resultado = 10;
        return resultado;
    }

    public void listarEmpleados() {
        System.out.println("\n--- LISTA DE EMPLEADOS ---");
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado e : empleados) {
                System.out.println(e);
            }
        }
    }

    public ArrayList<Empleado> getEmpleados() { return empleados; }
}
