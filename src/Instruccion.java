import java.util.ArrayList;
import java.util.List;

public class Instruccion {
     private String tipo;
     private int posicion;

     public Instruccion(String tipo, int posicion) {
          this.tipo = tipo;
          this.posicion = posicion;
     }

     public String getTipo() {
          return tipo;
     }

     public int getPosicion() {
          return posicion;
     }
}