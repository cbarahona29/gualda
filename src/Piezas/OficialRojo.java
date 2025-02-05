package proyecto1programacion2;

public class OficialRojo extends Pieza {
    public OficialRojo(int x, int y, String color) {
        super(x, y, color, "src/imagenes/Oficial Rojo.png");
    }

    @Override
    public boolean movimientoValido(int nuevoX, int nuevoY, Pieza[][] tablero) {
        return Math.abs(nuevoX - x) + Math.abs(nuevoY - y) == 1;
    }
}
