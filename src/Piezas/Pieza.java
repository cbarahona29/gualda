package proyecto1programacion2;

import javax.swing.*;
import java.awt.*;

public abstract class Pieza {
    protected int x, y;
    protected ImageIcon imagen;
    protected String color; 

    public Pieza(int x, int y, String color, String rutaImagen) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.imagen = new ImageIcon(rutaImagen);
    }

    public abstract boolean movimientoValido(int nuevoX, int nuevoY, Pieza[][] tablero);

    public void dibujar(Graphics g, JPanel panel) {
        g.drawImage(imagen.getImage(), x * 60 + 5, y * 60 + 5, 50, 50, panel);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void setPosicion(int x, int y) { this.x = x; this.y = y; }
}
