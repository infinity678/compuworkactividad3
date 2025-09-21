package modelo;

public class EmpleadoPermanente extends Empleado {
    private double salario;

    public EmpleadoPermanente(String nombre, int id, double salario, int desempeno) {
        super(nombre, id, desempeno);
        this.salario = salario;
    }

    public double getSalario() { return salario; }

    @Override
    public String toString() {
        return super.toString() + " - Permanente, Salario: " + salario;
    }
}
