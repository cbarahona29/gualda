package proyecto1programacion2;

public class ElefanteRojo extends Pieza {
    public ElefanteRojo(int x, int y, String color) {
        super(x, y, color, "src/imagenes/Elefante Rojo.png");
    }

    @Override
    public boolean movimientoValido(int nuevoX, int nuevoY, Pieza[][] tablero) {
        return Math.abs(nuevoX - x) + Math.abs(nuevoY - y) == 1;
    }
}
