package modelo;

public class EmpleadoTemporal extends Empleado {
    private int duracionContrato; // meses

    public EmpleadoTemporal(String nombre, int id, int duracionContrato, int desempeno) {
        super(nombre, id, desempeno);
        this.duracionContrato = duracionContrato;
    }

    public int getDuracionContrato() { return duracionContrato; }

    @Override
    public String toString() {
        return super.toString() + " - Temporal, Contrato: " + duracionContrato + " meses";
    }
}
