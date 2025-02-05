package proyecto1programacion2;

public class CaballoNegro extends Pieza {
    public CaballoNegro(int x, int y, String color) {
        super(x, y, color, "src/imagenes/Caballo Negro.png");
    }

    @Override
    public boolean movimientoValido(int nuevoX, int nuevoY, Pieza[][] tablero) {
        return Math.abs(nuevoX - x) + Math.abs(nuevoY - y) == 1;
    }
}

