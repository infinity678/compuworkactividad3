package modelo;

import java.util.ArrayList;

public class Departamento {
    private String nombre;
    private ArrayList<Empleado> empleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public ArrayList<Empleado> getEmpleados() { return empleados; }

    public void agregarEmpleado(Empleado e) { empleados.add(e); }

    public void eliminarEmpleado(int idEmpleado) {
        empleados.removeIf(e -> e.getId() == idEmpleado);
    }

    // Desempeño promedio de 1 a 10
    public double calcularDesempeno() {
        if (empleados.isEmpty()) return 1;
        int suma = 0;
        for (Empleado e : empleados) {
            suma += e.getDesempeno();
        }
        double promedio = (double) suma / empleados.size();
        return Math.round(promedio * 10.0) / 10.0; // redondea a 1 decimal
    }

    @Override
    public String toString() {
        return "Departamento: " + nombre +
                " | Empleados: " + empleados.size() +
                " | Desempeño: " + calcularDesempeno();
    }
}
