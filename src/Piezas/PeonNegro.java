package proyecto1programacion2;

public class PeonNegro extends Pieza {
    public PeonNegro(int x, int y, String color) {
        super(x, y, color, "src/imagenes/Peon Negro.png");
    }

    @Override
    public boolean movimientoValido(int nuevoX, int nuevoY, Pieza[][] tablero) {
        return Math.abs(nuevoX - x) + Math.abs(nuevoY - y) == 1;
    }
}
