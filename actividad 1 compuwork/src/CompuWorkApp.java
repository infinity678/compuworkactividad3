import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import gestor.GestorDepartamentos;
import gestor.GestorEmpleados;
import modelo.Departamento;
import modelo.Empleado;
import modelo.EmpleadoPermanente;
import modelo.EmpleadoTemporal;

public class CompuWorkApp extends Application {
    private GestorEmpleados gestorEmpleados;
    private GestorDepartamentos gestorDepartamentos;

    @Override
    public void start(Stage primaryStage) {
        gestorEmpleados = new GestorEmpleados(null);
        gestorDepartamentos = new GestorDepartamentos(null, gestorEmpleados);

        // --- Menú principal ---
        Button btnEmpleados = new Button("Gestionar Empleados");
        Button btnDepartamentos = new Button("Gestionar Departamentos");
        Button btnReporte = new Button("Reporte de Desempeño (Departamentos)");

        btnEmpleados.setOnAction(e -> menuEmpleados());
        btnDepartamentos.setOnAction(e -> menuDepartamentos());
        btnReporte.setOnAction(e -> mostrarReporte());

        VBox layout = new VBox(15, btnEmpleados, btnDepartamentos, btnReporte);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CompuWorkApp");
        primaryStage.show();
    }

    // --- Ventana de empleados ---
    private void menuEmpleados() {
        Stage ventana = new Stage();

        Button btnPermanente = new Button("Crear Empleado Permanente");
        Button btnTemporal = new Button("Crear Empleado Temporal");
        Button btnListar = new Button("Listar Empleados");
        Button btnEliminar = new Button("Eliminar Empleado");
        Button btnReporteInd = new Button("Reporte de Empleado");

        btnPermanente.setOnAction(e -> crearEmpleadoPermanente());
        btnTemporal.setOnAction(e -> crearEmpleadoTemporal());
        btnListar.setOnAction(e -> listarEmpleados());
        btnEliminar.setOnAction(e -> eliminarEmpleado());
        btnReporteInd.setOnAction(e -> mostrarReporteEmpleado());

        VBox layout = new VBox(10, btnPermanente, btnTemporal, btnListar, btnEliminar, btnReporteInd);
        layout.setStyle("-fx-padding: 15; -fx-alignment: center;");

        ventana.setScene(new Scene(layout, 350, 300));
        ventana.setTitle("Gestión de Empleados");
        ventana.show();
    }

    // --- Crear Empleado Permanente ---
    private void crearEmpleadoPermanente() {
        Dialog<EmpleadoPermanente> dialog = new Dialog<>();
        dialog.setTitle("Crear Empleado Permanente");
        dialog.setHeaderText("Ingrese los datos del empleado permanente");

        ButtonType guardarButtonType = new ButtonType("Guardar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(guardarButtonType, ButtonType.CANCEL);

        TextField nombreField = new TextField();
        TextField idField = new TextField();
        TextField salarioField = new TextField();
        TextField desempenoField = new TextField();

        VBox contenido = new VBox(10,
                new Label("Nombre:"), nombreField,
                new Label("ID:"), idField,
                new Label("Salario:"), salarioField,
                new Label("Desempeño (1-10):"), desempenoField
        );
        contenido.setStyle("-fx-padding: 10;");
        dialog.getDialogPane().setContent(contenido);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == guardarButtonType) {
                try {
                    String nombre = nombreField.getText().trim();
                    int id = Integer.parseInt(idField.getText().trim());
                    double salario = Double.parseDouble(salarioField.getText().trim());
                    int desempeno = Integer.parseInt(desempenoField.getText().trim());
                    return new EmpleadoPermanente(nombre, id, salario, desempeno);
                } catch (Exception e) {
                    mostrarAlerta("⚠ Error en los datos ingresados.");
                    return null;
                }
            }
            return null;
        });

        dialog.showAndWait().ifPresent(empleado -> {
            gestorEmpleados.getEmpleados().add(empleado);
            mostrarAlerta("Empleado Permanente creado.");
        });
    }

    // --- Crear Empleado Temporal ---
    private void crearEmpleadoTemporal() {
        Dialog<EmpleadoTemporal> dialog = new Dialog<>();
        dialog.setTitle("Crear Empleado Temporal");
        dialog.setHeaderText("Ingrese los datos del empleado temporal");

        ButtonType guardarButtonType = new ButtonType("Guardar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(guardarButtonType, ButtonType.CANCEL);

        TextField nombreField = new TextField();
        TextField idField = new TextField();
        TextField duracionField = new TextField();
        TextField desempenoField = new TextField();

        VBox contenido = new VBox(10,
                new Label("Nombre:"), nombreField,
                new Label("ID:"), idField,
                new Label("Duración contrato (meses):"), duracionField,
                new Label("Desempeño (1-10):"), desempenoField
        );
        contenido.setStyle("-fx-padding: 10;");
        dialog.getDialogPane().setContent(contenido);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == guardarButtonType) {
                try {
                    String nombre = nombreField.getText().trim();
                    int id = Integer.parseInt(idField.getText().trim());
                    int duracion = Integer.parseInt(duracionField.getText().trim());
                    int desempeno = Integer.parseInt(desempenoField.getText().trim());
                    return new EmpleadoTemporal(nombre, id, duracion, desempeno);
                } catch (Exception e) {
                    mostrarAlerta("⚠ Error en los datos ingresados.");
                    return null;
                }
            }
            return null;
        });

        dialog.showAndWait().ifPresent(empleado -> {
            gestorEmpleados.getEmpleados().add(empleado);
            mostrarAlerta("Empleado Temporal creado.");
        });
    }

    private void listarEmpleados() {
        StringBuilder sb = new StringBuilder("--- Lista de Empleados ---\n");
        if (gestorEmpleados.getEmpleados().isEmpty()) {
            sb.append("No hay empleados registrados.");
        } else {
            for (Empleado e : gestorEmpleados.getEmpleados()) {
                sb.append(e).append("\n");
            }
        }
        mostrarAlerta(sb.toString());
    }

    private void eliminarEmpleado() {
        if (gestorEmpleados.getEmpleados().isEmpty()) {
            mostrarAlerta("⚠ No hay empleados para eliminar.");
            return;
        }
        ChoiceDialog<Empleado> dialog = new ChoiceDialog<>(
                gestorEmpleados.getEmpleados().get(0),
                gestorEmpleados.getEmpleados()
        );
        dialog.setTitle("Eliminar Empleado");
        dialog.setHeaderText("Seleccione un empleado para eliminar");
        dialog.showAndWait().ifPresent(emp -> {
            gestorEmpleados.getEmpleados().remove(emp);
            mostrarAlerta("Empleado eliminado correctamente.");
        });
    }

    private void mostrarReporteEmpleado() {
        if (gestorEmpleados.getEmpleados().isEmpty()) {
            mostrarAlerta("⚠ No hay empleados registrados.");
            return;
        }
        ChoiceDialog<Empleado> dialog = new ChoiceDialog<>(
                gestorEmpleados.getEmpleados().get(0),
                gestorEmpleados.getEmpleados()
        );
        dialog.setTitle("Reporte de Empleado");
        dialog.setHeaderText("Seleccione un empleado para ver su reporte");
        dialog.showAndWait().ifPresent(emp -> {
            String reporte = "=== Reporte Individual ===\n"
                    + "Nombre: " + emp.getNombre() + "\n"
                    + "ID: " + emp.getId() + "\n"
                    + "Desempeño: " + emp.getDesempeno();
            mostrarAlerta(reporte);
        });
    }

    // --- Ventana de departamentos ---
    private void menuDepartamentos() {
        Stage ventana = new Stage();

        Button btnCrear = new Button("Crear Departamento");
        Button btnListar = new Button("Listar Departamentos");
        Button btnEliminar = new Button("Eliminar Departamento");
        Button btnAsignar = new Button("Asignar Empleado a Departamento");

        btnCrear.setOnAction(e -> crearDepartamento());
        btnListar.setOnAction(e -> listarDepartamentos());
        btnEliminar.setOnAction(e -> eliminarDepartamento());
        btnAsignar.setOnAction(e -> asignarEmpleadoADepartamento());

        VBox layout = new VBox(10, btnCrear, btnListar, btnEliminar, btnAsignar);
        layout.setStyle("-fx-padding: 15; -fx-alignment: center;");

        ventana.setScene(new Scene(layout, 350, 250));
        ventana.setTitle("Gestión de Departamentos");
        ventana.show();
    }

    private void crearDepartamento() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("Crear Departamento");
        dialog.setContentText("Nombre del departamento: ");
        dialog.showAndWait().ifPresent(nombre -> {
            gestorDepartamentos.getDepartamentos().add(new Departamento(nombre));
            mostrarAlerta("Departamento creado.");
        });
    }

    private void listarDepartamentos() {
        StringBuilder sb = new StringBuilder("--- Lista de Departamentos ---\n");
        if (gestorDepartamentos.getDepartamentos().isEmpty()) {
            sb.append("No hay departamentos registrados.");
        } else {
            for (Departamento d : gestorDepartamentos.getDepartamentos()) {
                sb.append(d).append("\n");
            }
        }
        mostrarAlerta(sb.toString());
    }

    private void eliminarDepartamento() {
        if (gestorDepartamentos.getDepartamentos().isEmpty()) {
            mostrarAlerta("⚠ No hay departamentos para eliminar.");
            return;
        }
        ChoiceDialog<Departamento> dialog = new ChoiceDialog<>(
                gestorDepartamentos.getDepartamentos().get(0),
                gestorDepartamentos.getDepartamentos()
        );
        dialog.setTitle("Eliminar Departamento");
        dialog.setHeaderText("Seleccione un departamento para eliminar");
        dialog.showAndWait().ifPresent(dept -> {
            gestorDepartamentos.getDepartamentos().remove(dept);
            mostrarAlerta("Departamento eliminado correctamente.");
        });
    }

    private void asignarEmpleadoADepartamento() {
        if (gestorDepartamentos.getDepartamentos().isEmpty()) {
            mostrarAlerta("⚠ No hay departamentos.");
            return;
        }
        if (gestorEmpleados.getEmpleados().isEmpty()) {
            mostrarAlerta("⚠ No hay empleados.");
            return;
        }
        ChoiceDialog<Departamento> deptDialog = new ChoiceDialog<>(
                gestorDepartamentos.getDepartamentos().get(0),
                gestorDepartamentos.getDepartamentos()
        );
        deptDialog.setHeaderText("Asignar Empleado");
        deptDialog.setContentText("Seleccione un departamento:");
        deptDialog.showAndWait().ifPresent(dept -> {
            ChoiceDialog<Empleado> empDialog = new ChoiceDialog<>(
                    gestorEmpleados.getEmpleados().get(0),
                    gestorEmpleados.getEmpleados()
            );
            empDialog.setHeaderText("Asignar Empleado");
            empDialog.setContentText("Seleccione un empleado:");
            empDialog.showAndWait().ifPresent(emp -> {
                dept.agregarEmpleado(emp);
                mostrarAlerta("Empleado asignado a " + dept.getNombre());
            });
        });
    }

    // --- Reporte general de desempeño ---
    private void mostrarReporte() {
        StringBuilder sb = new StringBuilder("--- Reporte de Desempeño ---\n");
        if (gestorDepartamentos.getDepartamentos().isEmpty()) {
            sb.append("No hay departamentos registrados.");
        } else {
            for (Departamento d : gestorDepartamentos.getDepartamentos()) {
                sb.append(d).append("\n");
            }
        }
        mostrarAlerta(sb.toString());
    }

    // --- Utilidad para mostrar mensajes ---
    private void mostrarAlerta(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
