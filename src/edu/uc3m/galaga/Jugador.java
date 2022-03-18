package edu.uc3m.galaga;

import edu.uc3m.game.GameBoardGUI;
import edu.uc3m.galaga.Constante;

public class Jugador {
	private Constante cte = new Constante();
	private int identificador = 40;
	private Posicion coordenadas = new Posicion(80, 210);
	private int puntos = 0;
	private int vidaTotal = 3;
	private int vidaActual = 3;
	private int disparosRealizados = 0;
	private int aciertos = 0;
	private Torpedo[] disparos = new Torpedo[200];
	private GameBoardGUI gui;

	public Jugador(GameBoardGUI gui) {
		this.gui = gui;
		for (int ii = 0; ii < disparos.length; ii++) {
			disparos[ii] = new Torpedo(true, coordenadas, (-700+ii), gui);
		}
		gui.gb_addSprite(identificador, "player.png", true);
		gui.gb_setSpriteVisible(identificador, true);
		gui.gb_moveSpriteCoord(identificador, coordenadas.getX(), coordenadas.getY());
	}

	// GETTERS
	public int getIdentificador() {
		return identificador;
	}

	public Posicion getCoordenadas() {
		return coordenadas;
	}

	public int getPuntos() {
		return puntos;
	}

	public int getVidaTotal() {
		return vidaTotal;
	}

	public int getVidaActual() {
		return vidaActual;
	}

	public int getDisparosRealizados() {
		return disparosRealizados;
	}

	public int getAciertos() {
		return aciertos;
	}

	public Torpedo[] getDisparos() {
		return disparos;
	}

	// SETTERS
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public void setCoordenadas(Posicion coordenadas) {
		this.coordenadas = coordenadas;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public void setVidaTotal(int vidaTotal) {
		this.vidaTotal = vidaTotal;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}

	public void setDisparosRealizados(int disparosRealizados) {
		this.disparosRealizados = disparosRealizados;
	}

	public void setAciertos(int aciertos) {
		this.aciertos = aciertos;
	}

	// METODOS ESPECIFICOS QUE FUNCIONAN
	public void moverJugador(String comando) {
		if (coordenadas.getX() < cte.getxMax() && coordenadas.getX() > cte.getMin()) {
			switch (comando) {
			case "left":
				coordenadas.setX((coordenadas.getX() - 3));
				break;
			case "right":
				coordenadas.setX((coordenadas.getX() + 3));
				break;
			}
		} else {
			if (coordenadas.getX() >= cte.getxMax()) {
				switch (comando) {
				case "left":
					coordenadas.setX((coordenadas.getX() - 3));
					break;
				}
			} else {
				if (coordenadas.getX() <= cte.getMin()) {
					switch (comando) {
					case "right":
						coordenadas.setX((coordenadas.getX() + 3));
						break;
					}
				}
			}
		}
		gui.gb_moveSpriteCoord(identificador, coordenadas.getX(), coordenadas.getY());
	}

	// METODOS ESPECIFICOS EN PRUEBA
	public void disparar(int identificador) {
		// Buscar sitio donde guardar el torpedo
		boolean buscando = true;
		int contador = 0;
		do {
			if (disparos[contador].getIdentificador() <= 0) {
				buscando = false;
				disparos[contador] = new Torpedo(true, coordenadas, identificador, gui);
				gui.gb_addSprite(disparos[contador].getIdentificador(), disparos[contador].getImagen(), true);
				gui.gb_setSpriteVisible(disparos[contador].getIdentificador(), true);
				gui.gb_moveSpriteCoord(disparos[contador].getIdentificador(),
						disparos[contador].getCoordenadas().getX(), disparos[contador].getCoordenadas().getY());

			} else {
				contador++;
			}
		} while (buscando && contador<disparos.length);

	}

	public void moverTorpedos() {
		for (int ii = 0; ii < disparos.length; ii++) {
			if (disparos[ii].getIdentificador() > 0) {
				disparos[ii].moverTorpedo();
			}
		}
	}
/* Al final no hacia falta usarlo
	public boolean isTorpedos() {
		boolean hay = false;
		int contador = 0;
		do {
			if (disparos[contador].getIdentificador() > 0) {
				hay = true;
			} else {
				contador++;
			}
		} while (!hay && contador < disparos.length);
		return hay;
	}
	*/
}
