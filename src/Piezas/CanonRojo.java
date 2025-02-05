package proyecto1programacion2;

public class CanonRojo extends Pieza {
    public CanonRojo(int x, int y, String color) {
        super(x, y, color, "src/imagenes/Cañon Rojo.png");
    }

    @Override
    public boolean movimientoValido(int nuevoX, int nuevoY, Pieza[][] tablero) {
        return Math.abs(nuevoX - x) + Math.abs(nuevoY - y) == 1;
    }
}
