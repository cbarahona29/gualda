package proyecto1programacion2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tablero extends JPanel implements ActionListener {
    private static final int TILE_SIZE = 60;
    private static final int ROWS = 9;
    private static final int COLS = 9;
    private Pieza[][] piezas = new Pieza[COLS][ROWS];
    
    boolean turnoJugador1 = true;
    String oponente;
    JFrame frame;
    JButton moverPiezaBtn, retirarseBtn;
    JLabel turnoLabel, jugadorArribaLabel, jugadorAbajoLabel;

    public Tablero(String oponente) {
        this.oponente = oponente;
        this.setPreferredSize(new Dimension(COLS * TILE_SIZE, ROWS * TILE_SIZE));
        
        frame = new JFrame("Xiangqi Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        JPanel panelArriba = new JPanel();
        jugadorArribaLabel = new JLabel(oponente);
        jugadorArribaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panelArriba.add(jugadorArribaLabel);
        
        JPanel panelAbajo = new JPanel();
        jugadorAbajoLabel = new JLabel(Player.getPlayerActivo().getUsuario());
        jugadorAbajoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        JPanel panelBotones = new JPanel();
        moverPiezaBtn = new JButton("Mover Pieza");
        retirarseBtn = new JButton("Retirarse");
        turnoLabel = new JLabel("Turno: " + Player.getPlayerActivo().getUsuario());
        
        moverPiezaBtn.addActionListener(this);
        retirarseBtn.addActionListener(this);
        
        panelBotones.add(moverPiezaBtn);
        panelBotones.add(retirarseBtn);
        panelBotones.add(turnoLabel);
        
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));
        panelInferior.add(jugadorAbajoLabel);
        panelInferior.add(panelBotones);
        
        frame.add(panelArriba, BorderLayout.NORTH);
        frame.add(this, BorderLayout.CENTER);
        frame.add(panelInferior, BorderLayout.SOUTH);
        
        inicializarPiezas();
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void inicializarPiezas() {
     
        piezas[4][0] = new GeneralRojo(4, 0, "");
        piezas[3][0] = new OficialRojo(3, 0, "");
        piezas[5][0] = new OficialRojo(5, 0, "");
        piezas[2][0] = new ElefanteRojo(2, 0, "");
        piezas[6][0] = new ElefanteRojo(6, 0, "");
        piezas[1][0] = new CaballoRojo(1, 0, "");
        piezas[7][0] = new CaballoRojo(7, 0, "");
        piezas[0][0] = new TorreRojo(0, 0, "");
        piezas[8][0] = new TorreRojo(8, 0, "");
        piezas[1][2] = new CanonRojo(1, 2, "");
        piezas[7][2] = new CanonRojo(7, 2, "");
        
      
        for (int i = 0; i < 9; i += 2) {
            piezas[i][3] = new PeonRojo(i, 3, "");
        }

        piezas[4][8] = new GeneralNegro(4, 8, "");
        piezas[3][8] = new OficialNegro(3, 8, "");
        piezas[5][8] = new OficialNegro(5, 8, "");
        piezas[2][8] = new ElefanteNegro(2, 8, "");
        piezas[6][8] = new ElefanteNegro(6, 8, "");
        piezas[1][8] = new CaballoNegro(1, 8, "");
        piezas[7][8] = new CaballoNegro(7, 8, "");
        piezas[0][8] = new TorreNegro(0, 8, "");
        piezas[8][8] = new TorreNegro(8, 8, "");
        piezas[1][6] = new CanonNegro(1, 6, "");
        piezas[7][6] = new CanonNegro(7, 6, "");
        
        // Peones negros
        for (int i = 0; i < 9; i += 2) {
            piezas[i][5] = new PeonNegro(i, 5, "");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == moverPiezaBtn) {
            cambiarTurno();
        } else if (e.getSource() == retirarseBtn) {
            retirarse();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
        drawPiezas(g);
    }

 private void drawBoard(Graphics g) {
    // Dibujar el fondo del tablero
    g.setColor(new Color(233, 149, 65)); // Color marrón claro para el tablero
    g.fillRect(0, 0, getWidth(), getHeight());

    // Dibujar el río (quinta fila)
    g.setColor(new Color(88, 174, 223)); // Color azul claro para el río
    g.fillRect(0, 4 * TILE_SIZE, COLS * TILE_SIZE, TILE_SIZE);

    // Dibujar las líneas de la cuadrícula
    g.setColor(Color.BLACK);
    
    // Líneas verticales
    for (int col = 0; col <= COLS; col++) {
        g.drawLine(col * TILE_SIZE, 0, col * TILE_SIZE, ROWS * TILE_SIZE);
    }

    // Líneas horizontales
    for (int row = 0; row <= ROWS; row++) {
        g.drawLine(0, row * TILE_SIZE, COLS * TILE_SIZE, row * TILE_SIZE);
    }

    // Dibujar las líneas diagonales en los palacios (superior e inferior)

    // Palacio superior
    g.drawLine(3 * TILE_SIZE, 0, 6 * TILE_SIZE, 3 * TILE_SIZE); // Diagonal \
    g.drawLine(6 * TILE_SIZE, 0, 3 * TILE_SIZE, 3 * TILE_SIZE); // Diagonal /

    // Palacio inferior
    g.drawLine(3 * TILE_SIZE, 6 * TILE_SIZE, 6 * TILE_SIZE, 9 * TILE_SIZE); // Diagonal \
    g.drawLine(6 * TILE_SIZE, 6 * TILE_SIZE, 3 * TILE_SIZE, 9 * TILE_SIZE); // Diagonal /
}

    private void drawPiezas(Graphics g) {
        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                if (piezas[i][j] != null) {
                    int x = i * TILE_SIZE + TILE_SIZE/2;
                    int y = j * TILE_SIZE + TILE_SIZE/2;
                    piezas[i][j].dibujar(g,this);
                }
            }
        }
    }

    private void cambiarTurno() {
        turnoJugador1 = !turnoJugador1;
        turnoLabel.setText("Turno: " + (turnoJugador1 ? Player.getPlayerActivo().getUsuario() : oponente));
    }

    private void retirarse() {
        Player jugadorActual = Player.getPlayerActivo();
        Player jugadorOponente = null;
        String mensaje;

        Player[] jugadores = Player.getJugadores();
        for (int i = 0; i < Player.getContadorJugadores(); i++) {
            if (jugadores[i] != null && jugadores[i].getUsuario().equals(oponente)) {
                jugadorOponente = jugadores[i];
                break;
            }
        }

        if (turnoJugador1) {
            if (jugadorOponente != null) {
                jugadorOponente.addPuntos(3);
                mensaje = jugadorActual.getUsuario() + " se ha retirado. " + oponente + " gana 3 puntos.";
            } else {
                mensaje = jugadorActual.getUsuario() + " se ha retirado. No se pudieron asignar puntos al oponente.";
            }
        } else {
            jugadorActual.addPuntos(3);
            mensaje = oponente + " se ha retirado. " + jugadorActual.getUsuario() + " gana 3 puntos.";
        }
        
        JOptionPane.showMessageDialog(this, mensaje);
        new MenuJuego();
        frame.dispose();
    }
}