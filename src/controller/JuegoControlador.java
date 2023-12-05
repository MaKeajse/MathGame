package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.JuegoModelo;
import view.JuegoVista;

import javax.swing.Timer;

/**
 * Clase que representa el controlador del juego matemático.
 * Maneja la interacción entre el modelo y la vista.
 */

public class JuegoControlador {
	private JuegoModelo model;
    private JuegoVista view;
    Timer timer;
    int tiempoRestante;
  

    public JuegoControlador(JuegoModelo model, JuegoVista view) {
        this.model = model;
        this.view = view;       
        

        view.getVerificarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarRespuesta();
            }
        });
        
     // Configurar el temporizador para contar hacia abajo cada segundo
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decrementarTiempo();
            }
        });
        timer.start();
     
    }
    
    private void decrementarTiempo() {
        tiempoRestante = view.getTiempoRestante();
        if (tiempoRestante > 0) {
            view.setTiempoRestante(tiempoRestante - 1);
        } else {
            // Si el tiempo se agota, puedes manejarlo de la manera que desees
            JOptionPane.showMessageDialog(view.getFrame(), "¡Tiempo agotado! La respuesta correcta era " + model.getRespuestaCorrecta(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
            iniciarJuego(); // Reiniciar el juego
        }
    }
    
    /**
     * Inicia el juego generando la primera pregunta y actualizando la vista.
     */

    public void iniciarJuego() {
        model.generarPregunta();
        actualizarVista();
        view.reiniciarTiempo();        
        
    }
    
    /**
     * Verifica la respuesta ingresada por el usuario y muestra un mensaje.
     */

    public void verificarRespuesta() {
        try {
            int respuestaUsuario = Integer.parseInt(view.getRespuestaField().getText());
            model.incrementarIntentos();
            if (respuestaUsuario == model.getRespuestaCorrecta()) {
                JOptionPane.showMessageDialog(view.getFrame(), "¡Correcto! Buena respuesta. \n\nIntento: " + model.getIntentos(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                model.incrementarPuntos();
                view.actualizarPuntos(model.getPuntos());
            } else {
                JOptionPane.showMessageDialog(view.getFrame(), "Incorrecto. La respuesta correcta es " + model.getRespuestaCorrecta() + "\n\nIntento: " + model.getIntentos(), "Resultado", JOptionPane.ERROR_MESSAGE);
                model.descontarPuntos();
                view.actualizarPuntos(model.getPuntos());
            }
   
            iniciarJuego();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view.getFrame(), "Ingresa un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Actualiza la vista con una nueva pregunta generada por el modelo.
     */

    private void actualizarVista() {
        view.getPreguntaLabel().setText("¿Cuánto es " + model.num1 + model.arit + model.num2 + "?");
        view.getRespuestaField().setText(""); // Limpiar el campo de respuesta
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JuegoModelo modelo = new JuegoModelo();
                JuegoVista vista = new JuegoVista();
                JuegoControlador controlador = new JuegoControlador(modelo, vista);

                vista.getFrame().setVisible(true);
                controlador.iniciarJuego();
            }
        });
    }
}
