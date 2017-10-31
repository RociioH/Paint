
//La clase Linea dibuja a una linea.
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public class Linea extends Figura{
	
	public Linea (){
		this(0, 0, 0, 0, Color.BLACK, new BasicStroke ());
	}
		
	//constructor 
	public Linea( int x1, int y1, int x2, int y2, Paint color, Stroke estilo ){
		super (x1, y1 , x2 , y2, color, estilo);
		
	}//fin del constructor de Linea
	
		
	//pendiente
	public void Dibujar ( Graphics2D g2D ){
		g2D.setPaint( EstablecerColor() );
		g2D.setStroke( obtenerStroke() );
		g2D.drawLine( CoordenadaX1(), CoordenadaY1(), CoordenadaX2(), CoordenadaY2());
		
	}//fin del metodo Dibujar 	
}//fin de la clase Linea
