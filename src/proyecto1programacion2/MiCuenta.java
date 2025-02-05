package proyecto1programacion2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiCuenta extends JFrame implements ActionListener {
     JButton cambiarContraBtn, eliminarCuentaBtn, regresarBtn;
     JLabel usuarioLabel, puntosLabel, fechaLabel;
     Player jugadorActual;
    JLabel fondo;

    public MiCuenta() {
        // Obtener el jugador activo una vez
        jugadorActual = Player.getPlayerActivo();

        this.setTitle("Mi Cuenta");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(177, 37, 7));
        
        ImageIcon backgroundImage = new ImageIcon("src/imagenes/fondo.png");
        this.setSize(backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        fondo = new JLabel(backgroundImage);
        fondo.setBounds(0, 0, 500, 500);
        this.setContentPane(fondo);
        this.setLayout(null);
        
        // Botones
        cambiarContraBtn = new JButton("Cambiar Contraseña");
        cambiarContraBtn.setBounds(50, 120, 200, 30);
        cambiarContraBtn.addActionListener(this);
        this.add(cambiarContraBtn);

        eliminarCuentaBtn = new JButton("Eliminar Cuenta");
        eliminarCuentaBtn.setBounds(50, 160, 200, 30);
        eliminarCuentaBtn.addActionListener(this);
        this.add(eliminarCuentaBtn);

        regresarBtn = new JButton("Regresar");
        regresarBtn.setBounds(50, 200, 200, 30);
        regresarBtn.addActionListener(this);
        this.add(regresarBtn);

        // Labels
        usuarioLabel = new JLabel();
        usuarioLabel.setBounds(50, 20, 300, 30);
        usuarioLabel.setForeground(Color.black);
        this.add(usuarioLabel);

        puntosLabel = new JLabel();
        puntosLabel.setBounds(50, 50, 300, 30);
        puntosLabel.setForeground(Color.black);
        this.add(puntosLabel);

        fechaLabel = new JLabel();
        fechaLabel.setBounds(50, 80, 300, 30);
        fechaLabel.setForeground(Color.black);
        this.add(fechaLabel);

        actualizarDatos();
        this.setVisible(true);
    }

    private void actualizarDatos() {
        if (jugadorActual != null) {
            usuarioLabel.setText("Usuario: " + jugadorActual.getUsuario());
            puntosLabel.setText("Puntos: " + jugadorActual.getPuntos());
            fechaLabel.setText("Fecha de creación: " + jugadorActual.getFechaCreacion());
        } else {
            usuarioLabel.setText("Usuario: No activo");
            puntosLabel.setText("Puntos: N/A");
            fechaLabel.setText("Fecha de creación: N/A");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cambiarContraBtn) {
            LogicaGeneral.cambiarContrasena();
            actualizarDatos();
        } else if (e.getSource() == eliminarCuentaBtn) {
            LogicaGeneral.eliminarCuenta();
            this.dispose(); 
        } else if (e.getSource() == regresarBtn) {
            new MenuJuego();
            this.dispose();
        }
    }

}
