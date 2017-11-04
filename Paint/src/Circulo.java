import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public class Circulo extends FiguraDelim{
		
	//constructor sin parametros
	public Circulo (){
		this(0, 0, 0, 0, Color.BLACK, new BasicStroke (), false);
	}//fin del constructor sin parametros
		
	//constructor con parametros
	public Circulo ( int x1, int y1, int width, int height, Paint miColor, Stroke estilo , boolean r ){
		super( x1, y1, width, height, miColor, estilo,  r);
		
	}//fin del constructor
		
	
	//implementacion del metodo dibujar
	@Override
	public void Dibujar ( Graphics2D g ){
		g.setPaint( EstablecerColor() );
		g.setStroke( obtenerStroke() );
		
		if ( obtenerRelleno() == true )
			g.fillOval( obtenerXSupIzq(), obtenerYSupIzq(), obtenerAnchura(), obtenerAltura() );
		else
			g.drawOval( obtenerXSupIzq(), obtenerYSupIzq(), obtenerAnchura(), obtenerAltura() );
				
	}//fin del metodo dibujar 

	

}//fin de la clase Circulo
