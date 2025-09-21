package modelo;

public abstract class Empleado {
    protected String nombre;
    protected int id;
    protected int desempeno; // valor normalizado 1-10

    public Empleado(String nombre, int id, int desempeno) {
        this.nombre = nombre;
        this.id = id;
        this.desempeno = desempeno;
    }

    public String getNombre() { return nombre; }
    public int getId() { return id; }
    public int getDesempeno() { return desempeno; } // sin ñ

    // Retorna el desempeño como double
    public double calcularDesempeno() {
        return desempeno;
    }

    @Override
    public String toString() {
        return "Empleado: " + nombre + " (ID: " + id + ") | Desempeño: " + calcularDesempeno();
    }
}
