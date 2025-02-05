package proyecto1programacion2;

import java.time.LocalDate;

public class Player {
    private String usuario;
    private String contra;
    private int puntos;
    private LocalDate fechaCreacion;


    private static Player[] jugadores = new Player[100];
    private static int contadorJugadores = 0;
    private static Player playerActivo = null;

    public Player(String usuario, String contra) {
        this.usuario = usuario;
        this.contra = contra;
        this.puntos = 0;
        this.fechaCreacion = LocalDate.now();
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }


    public static Player[] getJugadores() {
        return jugadores;
    }

    public static int getContadorJugadores() {
        return contadorJugadores;
    }

    public static Player getPlayerActivo() {
        return playerActivo;
    }

    public static void setPlayerActivo(Player player) {
        if (player != null) {
         
        } else {
          
        }
        playerActivo = player;
    }

    public static void addJugador(Player player) {
        if (contadorJugadores < jugadores.length) {
            jugadores[contadorJugadores] = player;
            contadorJugadores++;
        }
    }

    public static void eliminarJugador(Player player) {
        for (int i = 0; i < contadorJugadores; i++) {
            if (jugadores[i] == player) {
                for (int j = i; j < contadorJugadores - 1; j++) {
                    jugadores[j] = jugadores[j + 1];
                }
                jugadores[contadorJugadores - 1] = null;
                contadorJugadores--;
                return;
            }
        }
    }

    // Getters y Setters
    public String getUsuario() {
        return usuario;
    }

    public String getContra() {
        return contra;
    }

    public int getPuntos() {
        return puntos;
    }

    public void addPuntos(int puntos) {
        this.puntos += puntos;
    }

    public void setContra(String nuevaContra) {
        this.contra = nuevaContra;
    }
}
