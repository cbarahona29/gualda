package proyecto1programacion2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SeleccionJugador extends JFrame implements ActionListener {
    
    JButton salirbtn;
    JButton jugarbtn;  
    JComboBox<String> comboBox;
    JLabel fondo;
    
    public SeleccionJugador() {
        // Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("XIANQI Seleccionar Jugador");
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(177, 37, 7));
        
        ImageIcon backgroundImage = new ImageIcon("src/imagenes/fondo.png");
        this.setSize(backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        fondo = new JLabel(backgroundImage);
        fondo.setBounds(0, 0, 500, 500);
        this.setContentPane(fondo);
        this.setLayout(null);
        
        comboBox = new JComboBox<>();
        comboBox.setBounds(150, 150, 200, 25);
        this.add(comboBox);
        llenarComboBox();

        jugarbtn = new JButton("Jugar");
        jugarbtn.setBounds(200, 200, 110, 25);
        this.add(jugarbtn);
        jugarbtn.addActionListener(this);
        
        salirbtn = new JButton("Salir");
        salirbtn.setBounds(200, 250, 110, 25);
        this.add(salirbtn);
        salirbtn.addActionListener(this);
        
        this.setVisible(true);
    }
    
    private void llenarComboBox() {
        Player[] jugadores = Player.getJugadores();
        Player jugadorActivo = Player.getPlayerActivo();
        for (int i = 0; i < Player.getContadorJugadores(); i++) {
            if (jugadores[i] != null && jugadores[i] != jugadorActivo) {
                comboBox.addItem(jugadores[i].getUsuario());
            }
        }
    }
    
  @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == salirbtn) {
        new MenuJuego();
        this.dispose();
    } else if (e.getSource() == jugarbtn) {
        if (comboBox.getItemCount() == 0) {
            JOptionPane.showMessageDialog(this, "Debe agregar otro jugador antes de jugar.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String selectedPlayer = (String) comboBox.getSelectedItem();
            new Tablero(selectedPlayer); 
            this.dispose();
        }
    }
}

}
