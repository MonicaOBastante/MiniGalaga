package edu.uc3m.galaga;
import edu.uc3m.galaga.Constante;
public class Posicion {
	private Constante cte=new Constante();
	private int x=0;
	private int y=200;
	
	public Posicion() {
		
	}
	
	public Posicion(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		if (x <= cte.getxMax() && x >= cte.getMin()) {
			this.x=x;
		} 
		
	}
	public void setY(int y) {
		//if (y<=cte.getyMax() && y >= cte.getMin()) {
			this.y=y;
		//} 
	}
	
}
