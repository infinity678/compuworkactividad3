import gestor.GestorDepartamentos;
import gestor.GestorEmpleados;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 🔒 Seguridad básica: contraseña
        final String PASSWORD_ADMIN = "admin123"; // contraseña para administrador
        final String PASSWORD_USER = "user123";   // contraseña para usuario normal

        System.out.print("Ingrese la contraseña para acceder al sistema: ");
        String clave = sc.nextLine();

       boolean esAdmin = false;

        if (clave.equals(PASSWORD_ADMIN)) {
            esAdmin = true;
            System.out.println("✅ Acceso de administrador concedido.");
        } else if (clave.equals(PASSWORD_USER)) {
            System.out.println("✅ Acceso de usuario concedido.");
        } else {
            System.out.println("⚠ Contraseña incorrecta. Saliendo del sistema...");
            sc.close();
            return;
        }

        // 🔹 Inicialización de gestores
        GestorEmpleados gestorEmpleados = new GestorEmpleados(sc);
        GestorDepartamentos gestorDepartamentos = new GestorDepartamentos(sc, gestorEmpleados);

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN ---");
            System.out.println("1. Gestionar Empleados");
            System.out.println("2. Gestionar Departamentos");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> gestorEmpleados.menuEmpleados();
                case 2 -> {
                    // Solo el administrador puede eliminar departamentos
                    if (esAdmin) {
                        gestorDepartamentos.menuDepartamentos();
                    } else {
                        System.out.println("⚠ Solo el administrador puede gestionar departamentos completos.");
                        System.out.println("🔹 Puede listar departamentos y agregar empleados a ellos.");
                        gestorDepartamentos.menuDepartamentosUsuario();
                    }
                }
                case 0 -> System.out.println("👋 Saliendo del sistema...");
                default -> System.out.println("⚠ Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
