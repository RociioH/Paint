
//La clase Linea representa a una linea.
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public class Linea extends Figura{
	
	public Linea (){
		this(0, 0, 0, 0, Color.BLACK, new BasicStroke ());
	}
		
	//constructor con valores de entrada
	public Linea( int x1, int y1, int x2, int y2, Paint color, Stroke estilo ){
		super (x1, y1 , x2 , y2, color, estilo);
		
	}//fin del constructor de Linea
	
		
	//pendiente
	public void dibujar ( Graphics2D g ){
		g.setPaint( obtenerColor() );
		g.setStroke( obtenerStroke() );
		g.drawLine( obtenerX1(), obtenerY1(), obtenerX2(), obtenerY2());
		
	}//fin del metodo dibujar 
	
}//fin de la clase Linea
