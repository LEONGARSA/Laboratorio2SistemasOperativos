import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        MemoriaPrincipal memoriaPrincipal = new MemoriaPrincipal();
        try {
            Scanner scanner = new Scanner(new File("Documento de texto.txt"));
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(" ");
                if (partes.length == 2) {
                    String tipo = partes[0];
                    int posicion = Integer.parseInt(partes[1]);
                    if (tipo.equals("LOAD") || tipo.equals("ADD") || tipo.equals("STORE")) {
                        memoriaPrincipal.agregarInstruccion(new Instruccion(tipo, posicion));
                    } else {
                        System.out.println("Instrucción no válida: " + tipo);
                    }
                } else if (partes.length == 1) {
                    int valor = Integer.parseInt(partes[0]);
                    memoriaPrincipal.cargarDato(valor);
                } else {
                    System.out.println("Línea no válida: " + linea);
                }
            }
            memoriaPrincipal.ejecutarInstrucciones();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        }

    }
}