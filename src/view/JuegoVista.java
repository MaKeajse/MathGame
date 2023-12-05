package view;

import javax.swing.*;

/**
 * Clase que representa la vista del juego matemático.
 * Define la interfaz gráfica con etiquetas, campos de texto y botones.
 */

public class JuegoVista {
	private JFrame frame;
    private JLabel preguntaLabel;
    private JTextField respuestaField;
    private JButton verificarButton;

    public JuegoVista() {
        frame = new JFrame("Juego Matemático");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        preguntaLabel = new JLabel();
        respuestaField = new JTextField();
        verificarButton = new JButton("Verificar");

        frame.add(preguntaLabel);
        frame.add(respuestaField);
        frame.add(verificarButton);
    }
    
    /**
     * Obtiene el marco principal de la interfaz gráfica.
     *
     * @return El marco principal.
     */

    public JFrame getFrame() {
        return frame;
    }
    
    /**
     * Obtiene la etiqueta que muestra la pregunta en la interfaz gráfica.
     *
     * @return La etiqueta de la pregunta.
     */

    public JLabel getPreguntaLabel() {
        return preguntaLabel;
    }
    
    /**
     * Obtiene el campo de texto donde el usuario puede ingresar respuestas.
     *
     * @return El campo de texto de respuesta.
     */

    public JTextField getRespuestaField() {
        return respuestaField;
    }
    
    /**
     * Obtiene el botón que el usuario puede hacer clic para verificar la respuesta.
     *
     * @return El botón de verificación.
     */

    public JButton getVerificarButton() {
        return verificarButton;
    }
}
