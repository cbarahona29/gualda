package proyecto1programacion2;

import javax.swing.*;

public class LogicaGeneral {
    
    public static void mostrarRanking() {
        Player[] jugadoresOrdenados = Player.getJugadores();
        int contadorJugadores = Player.getContadorJugadores();

        if (contadorJugadores == 0) {
            JOptionPane.showMessageDialog(null, "No hay jugadores registrados.");
            return;
        }

     
        Player[] jugadoresCopia = new Player[contadorJugadores];
        System.arraycopy(jugadoresOrdenados, 0, jugadoresCopia, 0, contadorJugadores);

 
        for (int i = 0; i < contadorJugadores - 1; i++) {
            for (int j = 0; j < contadorJugadores - i - 1; j++) {
                if (jugadoresCopia[j].getPuntos() < jugadoresCopia[j + 1].getPuntos()) {
                    Player temp = jugadoresCopia[j];
                    jugadoresCopia[j] = jugadoresCopia[j + 1];
                    jugadoresCopia[j + 1] = temp;
                }
            }
        }

        StringBuilder ranking = new StringBuilder(" Ranking de jugadores:\n");
        for (int i = 0; i < contadorJugadores; i++) {
            ranking.append((i + 1)).append(". ").append(jugadoresCopia[i].getUsuario())
                   .append(" - Puntos: ").append(jugadoresCopia[i].getPuntos()).append("\n");
        }

        JOptionPane.showMessageDialog(null, ranking.toString());
    }

public static void cambiarContrasena() {
    Player playerActivo = Player.getPlayerActivo();

    String contraActual = JOptionPane.showInputDialog(" Ingrese su contraseña actual:");
     if (contraActual == null) {
        return;
    }
    if (contraActual == null || !contraActual.equals(playerActivo.getContra())) {
        JOptionPane.showMessageDialog(null, " Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
       
        return;
    }

    String nuevaContra = JOptionPane.showInputDialog(" Ingrese su nueva contraseña (5 caracteres):");

    if (nuevaContra != null && nuevaContra.length() == 5) {
        playerActivo.setContra(nuevaContra);
        JOptionPane.showMessageDialog(null, " Contraseña cambiada exitosamente.");
        return;
    } else {
        JOptionPane.showMessageDialog(null, " La contraseña debe tener exactamente 5 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
}

public static void eliminarCuenta() {
    Player playerActivo = Player.getPlayerActivo();

    String contraActual = JOptionPane.showInputDialog("Para eliminar la cuenta, ingrese su contraseña:");
    if (contraActual == null) {
        new MiCuenta();
        return; 
    }

    if (!contraActual.equals(playerActivo.getContra())) {
        JOptionPane.showMessageDialog(null, "Contraseña incorrecta. No se eliminó la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar su cuenta?", "Confirmación", JOptionPane.YES_NO_OPTION);

    if (confirmacion == JOptionPane.YES_OPTION) {
        Player.eliminarJugador(playerActivo);
        Player.setPlayerActivo(null);
        JOptionPane.showMessageDialog(null, "Su cuenta ha sido eliminada exitosamente.");
        new Menu(); 
    } else if (confirmacion == JOptionPane.NO_OPTION) {
        JOptionPane.showMessageDialog(null, "Su cuenta no fue eliminada.");
        new MiCuenta(); 
    }
    
  
}

    public static boolean crearJugador(String usuario, String contra) {
    if (usuario.isEmpty() || contra.isEmpty()) {
        JOptionPane.showMessageDialog(null, " Usuario y contraseña no pueden estar vacíos.");
        return false;
    }

    if (contra.length() != 5) {
        JOptionPane.showMessageDialog(null, " La contraseña debe tener exactamente 5 caracteres.");
        return false;
    }

    Player[] jugadores = Player.getJugadores();
    int contadorJugadores = Player.getContadorJugadores();

    for (int i = 0; i < contadorJugadores; i++) {
        if (jugadores[i].getUsuario().equalsIgnoreCase(usuario)) {
            JOptionPane.showMessageDialog(null, " Nombre de usuario ya en uso.");
            return false;
        }
    }

    Player nuevoJugador = new Player(usuario, contra);
    Player.addJugador(nuevoJugador);
    Player.setPlayerActivo(nuevoJugador);

    JOptionPane.showMessageDialog(null, " Jugador registrado exitosamente.");
    new MenuJuego();
    return true;
}

    public static void login(String usuario, String contra) {
        Player[] jugadores = Player.getJugadores();
        int contadorJugadores = Player.getContadorJugadores();

        for (int i = 0; i < contadorJugadores; i++) {
            if (jugadores[i].getUsuario().equalsIgnoreCase(usuario) && jugadores[i].getContra().equals(contra)) {
                Player.setPlayerActivo(jugadores[i]);
                JOptionPane.showMessageDialog(null, " Inicio de sesión exitoso.");
                new MenuJuego();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, " Usuario o contraseña incorrectos.");
        return;
    }
}
