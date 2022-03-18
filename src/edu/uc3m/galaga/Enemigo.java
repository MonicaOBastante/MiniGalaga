package edu.uc3m.galaga;

import edu.uc3m.galaga.Constante;
import edu.uc3m.game.GameBoardGUI;

public class Enemigo {// dependiendo de como se llame tendra unas caracteristicas u otras.
	private Constante cte = new Constante();
	private int vida;
	private int puntos;
	private Posicion coordenadas;
	private int identificador;// entre 100 y 200;
	private String tipo = "vacio";// Zako, goei, comandante galaga
	private String imagen;
	private GameBoardGUI gui;
	// crear una variable que controle la rotacion

	public Enemigo() {

	}

	public Enemigo(String tipo, int nombre, int x, int y, GameBoardGUI gui) {
		this.gui = gui;
		// Rellenar datos especificos de cada tipo
		tipo.toLowerCase();
		switch (tipo) {
		case "zako":
			vida = 1;
			puntos = 100;
			this.tipo = tipo;
			imagen = "enemy3G0.png";
			break;
		case "goei":
			vida = 1;
			puntos = 250;
			imagen = "enemy2G0.png";
			this.tipo = tipo;
			break;
		case "comandante galaga":
			vida = 2;
			puntos = 500;
			this.tipo = tipo;
			imagen = "enemy1G0.png";
			break;
		default:
			vida = 1;
			puntos = 100;
			this.tipo = tipo;
			imagen = "enemy3G0.png";
			break;
		}
		// Coordenadas

		if ((x <= cte.getxMax() && x >= cte.getMin()) && (y <= cte.getyMax() && y >= cte.getMin())) {
			coordenadas = new Posicion(x, y);
		} else {
			coordenadas = new Posicion(cte.getxMax(), cte.getyMax());
		}
		setIdentificador(nombre);

	}

	// GETTERS
	public int getVida() {
		return vida;
	}

	public int getPuntos() {
		return puntos;
	}

	public Posicion getCoordenadas() {
		return coordenadas;
	}

	public int getIdentificador() {
		return identificador;
	}

	public String getTipo() {
		return tipo;
	}

	public String getImagen() {
		return imagen;
	}

	// SETTERS
	public void setVida(int vida) {
		this.vida = vida;
	}

	public void setPuntos(int puntosVencer) {
		this.puntos = puntosVencer;
	}

	public void setCoordenadas(Posicion coordenadas) {
		int x = coordenadas.getX();
		int y = coordenadas.getY();
		// Coordenadas

		// x
		if (x <= cte.getxMax() && x >= cte.getMin()) {
			coordenadas.setX(x);
		} else {
			coordenadas.setX(170);
		}
		// y
		if (y <= cte.getyMax() && x >= 0) {
			coordenadas.setY(y);
		} else {
			coordenadas.setY(220);
		}
	}

	public void setIdentificador(int nombre) {
		if (nombre <= 1000 && nombre >= 100) {
			identificador = nombre;
		} else {// por si me equivoco para no repetir
			identificador = (int) (Math.random() * 2000 + 200);
		}
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	// METODOS ESPECIALES
	// cambiar su imagen norte
	public void alternarImagen(String tipo) {
		tipo.toLowerCase();
		switch (tipo) {
		case "zako":
			if (imagen.equals("enemy3G0.png")) {
				imagen = "enemy3G1.png";
			} else {
				imagen = "enemy3G0.png";
			}
			break;
		case "goei":
			if (imagen.equals("enemy2G0.png")) {
				imagen = "enemy2G1.png";
			} else {
				imagen = "enemy2G0.png";
			}
			break;
		case "comandante galaga":
			if (imagen.equals("enemy1G0.png")) {
				imagen = "enemy1G1.png";
			} else { if(vida==2)
				imagen = "enemy1G0.png";
			}
			
			if (imagen.equals("enemy9G0.png"))  {
				imagen = "enemy9G1.png";
			} else {
				if (imagen.equals("enemy9G1.png")) {
					imagen = "enemy9G0.png";
				}
				break;
			}
			gui.gb_setSpriteImage(identificador, imagen);
		}
	}

	// Crear el sprite
	public void crearSprite() {
		gui.gb_addSprite(identificador, imagen, true);
		gui.gb_setSpriteVisible(identificador, true);
		gui.gb_moveSpriteCoord(identificador, coordenadas.getX(), coordenadas.getY());
	}

	public void destruido() {
		setTipo("vacio");
		setImagen("empty.png");
		gui.gb_setSpriteImage(getIdentificador(), getImagen());
		gui.gb_println("El enemigo "+tipo+" ha sido eliminido.");
		gui.gb_println("Has ganado "+puntos);
	}

}
