package proyecto1programacion2;

public class GeneralNegro extends Pieza {
    public GeneralNegro(int x, int y, String color) {
        super(x, y, color, "src/imagenes/General Negro.png");
    }

    @Override
    public boolean movimientoValido(int nuevoX, int nuevoY, Pieza[][] tablero) {
        return Math.abs(nuevoX - x) + Math.abs(nuevoY - y) == 1;
    }
}
