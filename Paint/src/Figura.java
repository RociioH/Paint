

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public abstract class Figura {
  private Stroke stroke;
    private int x1;//cordenada x del primer punto
    private int y1;//cordenada y del primer punto
    private int x2;//cordenada x del segundo punto 
    private int y2;//cordenada y del segundo punto 
    private Paint color;//color

//a) Un constructor sin argumentos que establezca todas las coordenadas de la figura en 0 , y el color en Color.BLACK.
    public Figura() {

        this(0, 0, 0, 0, Color.BLACK, new BasicStroke());
    }

//b) Un constructor que inicialice las coordenadas y el color con los valores de los argumentos suministrados.
    public Figura(int x1, int y1, int x2, int y2, Paint color, Stroke estilo) {
        DeterminarX1(x1);
        DeterminarY1(y1);
        DeterminarX2(x2);
        DeterminarY2(y2);
        establecerColor(color);
        stroke = estilo;
    }
//c) Métodos establecer para las coordenadas individuales y el color, que permiten al programador establecer cualquier pieza de datos de manera independiente, para una figura en la jerarquía.
    public void DeterminarX1(int x1) {
        if (x1 >= 0) {
            this.x1 = x1;
        } else {
            this.x1 = 0;
        }
    }
//d) Métodos obtener para las coordenadas individuales y el color, que permiten al programador obtener cualquier pieza de datos de manera independiente, para una figura en la jerarquía.
    public int obtenerX1() {
        return x1;
    }

    void DeterminarX2(int x2) {
        if (x2 >= 0) {
            this.x2 = x2;
        } else {
            this.x2 = 0;
        }
    }

    public int obtenerX2() {
        return x2;
    }

    public void DeterminarY1(int y1) {
        if (y1 >= 0) {
            this.y1 = y1;
        } else {
            this.y1 = 0;
        }
    }

    public int obtenerY1() {
        return y1;
    }

    public void DeterminarY2(int y2) {
        if (y2 >= 0) {
            this.y2 = y2;
        } else {
            this.y2 = 0;
        }
    }

    public int obtenerY2() {
        return y2;
    }

    public void establecerColor(Paint colores) {
        color = colores;
    }

    public Paint obtenerColor() {
        return color;
    }

    public void establecerStroke(Stroke estilo) {
        this.stroke = estilo;
    }

    public Stroke obtenerStroke() {
        return stroke;
    }
//e) El método abstract public abstract void dibujar (Graphics g); que se llamará desde el método paintComponent del programa para dibujar una figura en la pantalla.

    public abstract void dibujar(Graphics2D g);
}