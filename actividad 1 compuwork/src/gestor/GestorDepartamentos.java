package gestor;

import modelo.Departamento;
import modelo.Empleado;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorDepartamentos {
    private ArrayList<Departamento> departamentos;
    private Scanner sc;
    private GestorEmpleados gestorEmpleados;

    public GestorDepartamentos(Scanner sc, GestorEmpleados gestorEmpleados) {
        this.sc = sc;
        this.gestorEmpleados = gestorEmpleados;
        this.departamentos = new ArrayList<>();
    }

    // 🔹 Menú completo para administradores
    public void menuDepartamentos() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE DEPARTAMENTOS ---");
            System.out.println("1. Crear Departamento");
            System.out.println("2. Eliminar Departamento");
            System.out.println("3. Listar Departamentos");
            System.out.println("4. Agregar Empleado a Departamento");
            System.out.println("0. Volver al menú principal");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> crearDepartamento();
                case 2 -> eliminarDepartamento();
                case 3 -> listarDepartamentos();
                case 4 -> agregarEmpleadoADepartamento();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("⚠ Opción inválida.");
            }
        } while (opcion != 0);
    }

    // 🔹 Menú limitado para usuarios normales
    public void menuDepartamentosUsuario() {
        int opcion;
        do {
            System.out.println("\n--- DEPARTAMENTOS (Usuario) ---");
            System.out.println("1. Listar Departamentos");
            System.out.println("2. Agregar Empleado a Departamento");
            System.out.println("0. Volver al menú principal");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> listarDepartamentos();
                case 2 -> agregarEmpleadoADepartamento();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("⚠ Opción inválida.");
            }
        } while (opcion != 0);
    }

    // 🔹 Métodos existentes
    private void crearDepartamento() {
        System.out.print("Nombre del Departamento: ");
        String nombre = sc.nextLine();
        departamentos.add(new Departamento(nombre));
        System.out.println("✅ Departamento creado.");
    }

    private void eliminarDepartamento() {
        if (departamentos.isEmpty()) {
            System.out.println("⚠ No hay departamentos para eliminar.");
            return;
        }
        listarDepartamentos();
        System.out.print("Ingrese el número del departamento a eliminar: ");
        int index = sc.nextInt();
        sc.nextLine();

        if (index > 0 && index <= departamentos.size()) {
            departamentos.remove(index - 1);
            System.out.println("🗑 Departamento eliminado.");
        } else {
            System.out.println("⚠ Número inválido.");
        }
    }

    private void listarDepartamentos() {
        System.out.println("\n--- LISTA DE DEPARTAMENTOS ---");
        if (departamentos.isEmpty()) {
            System.out.println("No hay departamentos registrados.");
        } else {
            int i = 1;
            for (Departamento d : departamentos) {
                System.out.println(i++ + ". " + d);
                for (Empleado e : d.getEmpleados()) {
                    System.out.println("   - " + e);
                }
            }
        }
    }

    private void agregarEmpleadoADepartamento() {
        if (departamentos.isEmpty()) {
            System.out.println("⚠ No hay departamentos creados.");
            return;
        }
        if (gestorEmpleados.getEmpleados().isEmpty()) {
            System.out.println("⚠ No hay empleados registrados.");
            return;
        }

        listarDepartamentos();
        System.out.print("Seleccione el número del departamento: ");
        int deptIndex = sc.nextInt();
        sc.nextLine();

        if (deptIndex < 1 || deptIndex > departamentos.size()) {
            System.out.println("⚠ Número inválido.");
            return;
        }

        ArrayList<Empleado> empleados = gestorEmpleados.getEmpleados();
        for (int i = 0; i < empleados.size(); i++) {
            System.out.println((i + 1) + ". " + empleados.get(i).getNombre() +
                    " | Desempeño: " + empleados.get(i).getDesempeno());
        }

        System.out.print("Seleccione el número del empleado: ");
        int empIndex = sc.nextInt();
        sc.nextLine();

        if (empIndex < 1 || empIndex > empleados.size()) {
            System.out.println("⚠ Número inválido.");
            return;
        }

        Departamento dept = departamentos.get(deptIndex - 1);
        Empleado emp = empleados.get(empIndex - 1);
        dept.agregarEmpleado(emp);

        System.out.println("✅ Empleado agregado al departamento " + dept.getNombre());
    }

    // 🔹 👉 Getter que faltaba
    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }
}
