package proyecto1programacion2;

public class TorreRojo extends Pieza {
    public TorreRojo(int x, int y, String color) {
        super(x, y, color, "src/imagenes/Torre Roja.png");
    }

    @Override
    public boolean movimientoValido(int nuevoX, int nuevoY, Pieza[][] tablero) {
        return Math.abs(nuevoX - x) + Math.abs(nuevoY - y) == 1;
    }
}
