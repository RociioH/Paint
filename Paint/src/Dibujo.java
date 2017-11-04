
    import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Dibujo extends JPanel {

    private Figura[] figuras;//variable de arreglo firguras

    //variables para cada tipo de firgura
    private static final int LINEAS = 0;
    private static final int OVALOS = 1;
    private static final int RECTANGULOS = 2;

    //varaibles de instancia nuevas 
    private int cuentaFiguras;//cuenta el numero de figuras en el arreglo

    private int tipoFigura;//determina el tipo de figura a dibujar

    private Figura figuraActual;//figura actual que esta dibujando el usuario

    private Paint color1, color2, colorDegradado, colorActual;//color del dibujo actual

    private Stroke trazoActual;

    private boolean figuraRellena;//determina si se va dibujar una figura rellena

    private boolean degradado;//determina si se va dibujar con degradado

    private boolean lineaPunteada;//determina si sedinujara con esilo punteado - - --
    private int longitudDeGuion;

    private JLabel etiquetaEstado;

    private boolean seDibujo;

    private int anchuraLinea;//anchura de linea 

    private int x1, y1, x2, y2;

    //constructor , crea un panel con figuras al azar 
    public Dibujo(JLabel etiqueta) {

        etiquetaEstado = etiqueta;

        figuras = new Figura[100];//incializa arreglo con 100 entradas

        cuentaFiguras = 0;

        tipoFigura = LINEAS;

        figuraActual = null;

        color1 = Color.BLACK;

        this.setBackground(Color.WHITE);

        ManejadorEvents manejador = new ManejadorEvents();

        this.addMouseListener(manejador);
        this.addMouseMotionListener(manejador);

    }//fin del constructor

    @Override//anotacion que asegura que los metodos se sobrescriban con los de la superclase
    //para cada arreglo de figuras , dibuja las figuras individuales
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        //usar  variables cuentaFiguras para deerminar cuantas figuras hay que dibujar
        Graphics2D g2d = (Graphics2D) g;

        //pendiente checar
        for (int f = 0; f < cuentaFiguras; f++) {
            if (figuras[f] != null) {
                figuras[f].Dibujar(g2d);
            }

        }

        if (seDibujo) {
            figuraActual.Dibujar(g2d);
        }

    }//fin del metodo paintComponent

    //clase privada
    private class ManejadorEvents extends MouseAdapter implements MouseMotionListener {

        @Override
        public void mousePressed(MouseEvent e) {

            //dibuja con degradado o sin degradado
            if (degradado) {
                colorActual = new GradientPaint(0, 0, (Color) color1, 50, 50, (Color) color2, true);
            } else {
                colorActual = color1;
            }

       
//			
            //dibuja con linea punteada o normal
            if (lineaPunteada) {
                float[] guiones = {longitudDeGuion};
                trazoActual = new BasicStroke(anchuraLinea, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, guiones, 0);
            } else {
                trazoActual = new BasicStroke(anchuraLinea, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            }

            switch (tipoFigura) {
                case LINEAS:
                    figuraActual = new Linea(e.getX(), e.getY(), e.getX(), e.getY(), colorActual, trazoActual);
                    x1 = e.getX();
                    y1 = e.getY();

                    //cuentaFiguras++;
                    break;
                case OVALOS:
                    figuraActual = new Circulo(e.getX(), e.getY(), e.getX(), e.getY(), colorActual, trazoActual, figuraRellena);
                    x1 = e.getX();
                    y1 = e.getY();

                    //cuentaFiguras++;
                    break;
                case RECTANGULOS:
                    figuraActual = new Cuadrado(e.getX(), e.getY(), e.getX(), e.getY(), colorActual, trazoActual, figuraRellena);
                    x1 = e.getX();
                    y1 = e.getY();

                    //cuentaFiguras++;
                    break;
            }//fin de switch que creador de objetos figura de clases concretas

            seDibujo = true;
     
        }//fin de metodo mousePressed

        @Override
        public void mouseReleased(MouseEvent e) {

            figuraActual.DeterminarX2(e.getX());
            figuraActual.DeterminarY2(e.getY());

            //agrega la figura al arreglo
            figuras[cuentaFiguras++] = figuraActual;

            repaint();

            //establece figura actual a null
            figuraActual = null;

            seDibujo = false;
        }//fin de metodo mouseReleased

        @Override
        public void mouseMoved(MouseEvent e) {
            etiquetaEstado.setText(String.format("Cordenadas X = %d, Y = %d", e.getX(), e.getY()));

        }//fin de metodo mouseMoved

        @Override
        public void mouseDragged(MouseEvent e) {
            //establece el segundo punto de figuraActual con la posicion actual de raton

            figuraActual.DeterminarX2(e.getX());
            figuraActual.DeterminarY2(e.getY());

            etiquetaEstado.setText(String.format("Dragged Cordenadas I(X = %d , Y = %d), F(X = %d, Y = %d)", x1, x2, e.getX(), e.getY()));

            repaint();

        }//fin del metodo mouseDragged

    }//fin de la clase interna ManejadorEventos

    public void establecerTipoFigura(int tF) {
        tipoFigura = tF;
    }

    public void establecerColor1(Color c) {
        color1 = c;
    }

    public void establecerColor2(Color c) {
        color2 = c;
    }

    public void establecerTrazoActual(Stroke s) {
        trazoActual = s;
    }

    public void establecerFiguraRellena(boolean fR) {
        figuraRellena = fR;
    }

    public void establecerDegradado(boolean d) {
        degradado = d;
    }//fin de metodo establecerDegradado

    public void establecerLineaPunteada(boolean l) {
        lineaPunteada = l;
    }

    public void establecerAnchuraLinea(int anchura) {
        anchuraLinea = anchura;
    }

    //borra la ultima figura dibujada
    public void borrarUltimaFigura() {
        --cuentaFiguras;
        if (cuentaFiguras < 0) {
            cuentaFiguras = 0;
            JOptionPane.showMessageDialog(null, "Ya no hay mas figuras por borrar!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        repaint();//acgtualiza la pantalla
    }//fin de metodo borrarUltimaFIgura

    //elimina todas las figuras del dibujo actual
    public void borrarDibujo() {
        cuentaFiguras = 0;
        repaint();//acgtualiza la pantalla
    }

}//fin de la clase PanelDibujo
