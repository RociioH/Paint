import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;

public abstract class FiguraDelim extends Figura {

	private boolean relleno;
	
	public FiguraDelim (){
		
		this(0, 0, 0, 0, Color.BLACK, new BasicStroke(), false );
	}
	
	public FiguraDelim (int x1, int y1 , int width, int height, Paint miColor, Stroke estilo, boolean r ){
		super(x1, y1, width, height, miColor, estilo);
		relleno = r;
	}
	
	public void establecerRelleno ( boolean r ){
		relleno = r;
	}
	public boolean obtenerRelleno (){
		return relleno;
	}
	
	/*
	 * LEER EL LIBRO PARA VER SI ESTOS VALORES SON CORRECTOS
	 */
	public int obtenerXSupIzq (){
		return Math.min( CoordenadaX1(), CoordenadaX2() );
	}
	public int obtenerYSupIzq (){
		return Math.min( CoordenadaY1(), CoordenadaY2() );
	}
	public int obtenerAnchura (){
		return Math.abs( CoordenadaX1() - CoordenadaX2() );
	}
	public int obtenerAltura (){
		return Math.abs( CoordenadaY1() - CoordenadaY2() );
	}
	
	@Override
	public abstract void Dibujar ( Graphics2D g2d );
		
	
	
	
}
