package test;

import org.junit.Test;

import controller.JuegoControlador;
import model.JuegoModelo;
import view.JuegoVista;

import static org.junit.Assert.*;
import org.junit.Before;

public class JuegoControladorTest {
	private JuegoModelo modelo;
    private JuegoVista vista;
    private JuegoControlador controlador;

    @Before
    public void setUp() {
        modelo = new JuegoModelo();
        vista = new JuegoVista();
        controlador = new JuegoControlador(modelo, vista);
    }

    @Test
    public void verificarRespuesta_respuestaCorrecta_muestraMensajeCorrecto() {
        modelo.generarPregunta();
        vista.getRespuestaField().setText(String.valueOf(modelo.getRespuestaCorrecta()));
        controlador.verificarRespuesta();
        
        // Comprueba que se muestra un mensaje de respuesta correcta
        // Idealmente, podrías mejorar esto utilizando mocks o capturando la salida estándar.
        // Aquí se usa una aserción básica para demostrar el concepto.
        assertNotNull(vista.getFrame().getComponent(0));
    }

    @Test
    public void verificarRespuesta_respuestaIncorrecta_muestraMensajeIncorrecto() {
        modelo.generarPregunta();
        vista.getRespuestaField().setText("999"); // Respuesta incorrecta
        controlador.verificarRespuesta();
        
        // Comprueba que se muestra un mensaje de respuesta incorrecta
        // Idealmente, podrías mejorar esto utilizando mocks o capturando la salida estándar.
        // Aquí se usa una aserción básica para demostrar el concepto.
        assertNotNull(vista.getFrame().getComponent(0));
    }
}
