package model;

import java.util.Random;

/**
 * Clase que representa el modelo del juego matemático.
 * Genera preguntas de suma aleatorias y almacena la respuesta correcta.
 */

public class JuegoModelo {
	public int num1;
    public int num2;
    public String arit;
    private int operador;
    private float respuestaCorrecta;
    
    /**
     * Genera una nueva pregunta de suma aleatoria y almacena los números y la respuesta correcta.
     */

    public void generarPregunta() {
        Random rand = new Random();
        num1 = rand.nextInt(10);
        num2 = rand.nextInt(10);
        
        operador = rand.nextInt(3);
        
        switch(operador) {
        case 0:
        	arit = " + ";
        	respuestaCorrecta = num1 + num2;
        	break;
        case 1:
        	arit = " - ";
        	respuestaCorrecta = num1 - num2;
        	break;
        case 2:
        	arit = " * ";
        	respuestaCorrecta = num1 * num2;
        case 3:
        	arit = " / ";
        	if (num2>0) {
        		respuestaCorrecta = Math.round(num1 / num2);
        	}else {
        		break;
        	}
        	
        	break;        	
        
        }
        
    }
    
    /**
     * Obtiene la respuesta correcta de la última pregunta generada.
     *
     * @return La respuesta correcta de la pregunta.
     */

    public float getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
    
}
