package proyecto1programacion2;

public class GeneralRojo extends Pieza {
    public GeneralRojo(int x, int y, String color) {
        super(x, y, color, "src/imagenes/General Rojo.png");
    }

    @Override
    public boolean movimientoValido(int nuevoX, int nuevoY, Pieza[][] tablero) {
        return Math.abs(nuevoX - x) + Math.abs(nuevoY - y) == 1;
    }
}
