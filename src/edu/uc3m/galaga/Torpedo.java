package edu.uc3m.galaga;

import edu.uc3m.game.GameBoardGUI;
public class Torpedo {
	private boolean isAmigo;// torpedo aliado o alienigena
	private Posicion coordenadas = new Posicion();
	private String imagen;
	private int identificador = 0;
	private  GameBoardGUI gui;

	public Torpedo(Boolean amigo, Posicion coordenadasLanzador, int id, GameBoardGUI gui) {
		isAmigo = amigo;
		this.gui=gui;
		if (isAmigo) {
			imagen = "torpedo100.png";
			coordenadas.setX(coordenadasLanzador.getX());
			coordenadas.setY(coordenadasLanzador.getY() - 10);
		} else {
			imagen = "torpedo200.png";
			coordenadas.setX(coordenadasLanzador.getX());
			coordenadas.setY(coordenadasLanzador.getY() + 10);
		}
		identificador = id;
	}

	// GETTERS
	public boolean isAmigo() {
		return isAmigo;
	}

	public Posicion getCoordenadas() {
		return coordenadas;
	}

	public String getImagen() {
		return imagen;
	}

	public int getIdentificador() {
		return identificador;
	}

	// SETTERS
	public void setCoordenadas(int altura) {
		coordenadas.setY(altura);
	}
	public void setIdentificador(int identificador) {
		this.identificador=identificador;
	}

	// METODOS
	public void moverTorpedo() {
		if (isAmigo) {
			coordenadas.setY(coordenadas.getY() - 1);
			gui.gb_moveSpriteCoord(identificador, coordenadas.getX(), coordenadas.getY());
		} else {
			coordenadas.setY(coordenadas.getY() + 1);
			gui.gb_moveSpriteCoord(identificador, coordenadas.getX(), coordenadas.getY());
		}
		if(coordenadas.getY()<-5 ||coordenadas.getY()>225) {
			identificador=identificador*-1;
		}
	}
	public void colisionado() {
		gui.gb_setSpriteImage(identificador, "empty.png");
		setIdentificador(identificador * -1);
	}


}
