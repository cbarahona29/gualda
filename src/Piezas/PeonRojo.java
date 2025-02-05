package proyecto1programacion2;

public class PeonRojo extends Pieza {
    public PeonRojo(int x, int y, String color) {
        super(x, y, color, "src/imagenes/Peon Rojo.png");
    }

    @Override
    public boolean movimientoValido(int nuevoX, int nuevoY, Pieza[][] tablero) {
        return Math.abs(nuevoX - x) + Math.abs(nuevoY - y) == 1;
    }
}
