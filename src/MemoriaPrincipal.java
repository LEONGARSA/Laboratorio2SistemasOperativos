import java.util.ArrayList;
import java.util.List;

public class MemoriaPrincipal {
    private int[] memoria;
    private List<Instruccion> instrucciones;
    private int unidadDeControl;
    private int acumulador;
    private int alu;
    private int pc;
    private int icr;
    private int mar;
    private int mdr;

    public MemoriaPrincipal() {
        memoria = new int[100]; // Asumiendo que la memoria principal tiene 100 posiciones
        instrucciones = new ArrayList<>();
        unidadDeControl = 0;
        alu = 0;
        pc = 0;
        icr = 0;
        mar = 0;
        mdr = 0;
    }

    public void agregarInstruccion(Instruccion instruccion) {
        instrucciones.add(instruccion);
    }

    public void ejecutarInstrucciones() {
        for (Instruccion instruccion : instrucciones) {
            mar = instruccion.getPosicion();
            switch (instruccion.getTipo()) {
                case "LOAD":
                    mdr = memoria[mar];
                    acumulador = mdr;
                    System.out.println("LOAD ejecutado. Acumulador: " + acumulador);
                    break;
                case "ADD":
                    mdr = memoria[mar];
                    alu = acumulador + mdr;
                    acumulador = alu;
                    System.out.println("ADD ejecutado. Acumulador: " + acumulador);
                    break;
                case "STORE":
                    mdr = acumulador;
                    memoria[mar] = mdr;
                    System.out.println("STORE ejecutado. Memoria en posición " + mar + ": " + memoria[mar]);
                    break;
            }
            pc++;
            icr++;
            System.out.println("PC: " + pc + ", ICR: " + icr);
        }
        System.out.println("Valor final que se guardó: " + acumulador);
    }

    public void cargarDato(int valor) {
        acumulador = valor;
        memoria[posicion] = valor;
    }
}
