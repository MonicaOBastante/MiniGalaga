package edu.uc3m.galaga;

//CLASE EN FASE, A LO MEJOR LA ELIMINO
//Estaria bien que todos guardasen la interfaz para tener metodos propios que actuen en ella. 
//Asi reaccionan con ella y me ahorro lineas de codigo en el metodo principal
import edu.uc3m.game.GameBoardGUI;
import edu.uc3m.galaga.Constante;
public class Nivel {
	private Enemigo[][] enjambre = new Enemigo[4][10];
	private int numero;
	private GameBoardGUI gui;
	private Constante cte=new Constante();

	public Nivel(int nivel, GameBoardGUI gui) {
		this.gui = gui;
		if (nivel > 0 && nivel < 4) {
			this.numero = nivel;
		}
		switch (numero) {
		case 1:
			// Enjambre NIVEL1
			for (int ii = 0; ii < enjambre[0].length; ii++) {
				if (ii != 4 && ii != 5) {
					enjambre[0][ii] = new Enemigo();
				}
			}
			for (int ii = 0; ii < enjambre[1].length; ii++) {
				if (ii == 1 || ii == 4 || ii == 5 || ii == 8) {
					enjambre[1][ii] = new Enemigo();
				}
			}
			enjambre[2][0] = new Enemigo();
			enjambre[2][9] = new Enemigo();
			for (int ii = 0; ii < enjambre[3].length; ii++) {
				if (ii == 0 || ii == 1 || ii == 8 || ii == 9) {
					enjambre[3][ii] = new Enemigo();
				}
			}

			// Sustituir por clase enjambre. Cada enjambre tiene un nivel, asi que
			// dependiendo del nivel crea uno u otro enjambre
			// Los espacios rellenos del enjambre
			enjambre[0][4] = new Enemigo("comandante galaga", 100, 75, 10, this.gui);
			enjambre[0][5] = new Enemigo("comandante galaga", 101, 85, 10, this.gui);
			enjambre[1][0] = new Enemigo("goei", 102, 35, 20, this.gui);
			enjambre[1][2] = new Enemigo("goei", 103, 55, 20, this.gui);
			enjambre[1][3] = new Enemigo("goei", 104, 65, 20, this.gui);
			enjambre[1][6] = new Enemigo("goei", 105, 95, 20, this.gui);
			enjambre[1][7] = new Enemigo("goei", 106, 105, 20, this.gui);
			enjambre[1][9] = new Enemigo("goei", 107, 125, 20, this.gui);
			enjambre[2][1] = new Enemigo("zako", 108, 45, 30, this.gui);
			enjambre[2][2] = new Enemigo("zako", 109, 55, 30, this.gui);
			enjambre[2][3] = new Enemigo("zako", 110, 65, 30, this.gui);
			enjambre[2][4] = new Enemigo("zako", 111, 75, 30, this.gui);
			enjambre[2][5] = new Enemigo("zako", 112, 85, 30, this.gui);
			enjambre[2][6] = new Enemigo("zako", 113, 95, 30, this.gui);
			enjambre[2][7] = new Enemigo("zako", 114, 105, 30, this.gui);
			enjambre[2][8] = new Enemigo("zako", 115, 115, 30, this.gui);
			enjambre[3][2] = new Enemigo("zako", 116, 55, 40, this.gui);
			enjambre[3][3] = new Enemigo("zako", 117, 65, 40, this.gui);
			enjambre[3][4] = new Enemigo("zako", 118, 75, 40, this.gui);
			enjambre[3][5] = new Enemigo("zako", 119, 85, 40, this.gui);
			enjambre[3][6] = new Enemigo("zako", 120, 95, 40, this.gui);
			enjambre[3][7] = new Enemigo("zako", 121, 105, 40, this.gui);
			break;
		case 2:
			// Enjambre NIVEL2
			for (int ii = 0; ii < enjambre[0].length; ii++) {
				if (ii != 2 && ii != 3 && ii != 6 && ii != 7) {
					enjambre[0][ii] = new Enemigo();
				} else {
					enjambre[0][ii] = new Enemigo("comandante galaga", (200 + ii), (55 + (ii - 2) * 10), 10, this.gui);
				}
			}

			for (int ii = 0; ii < enjambre[1].length; ii++) {
				enjambre[1][ii] = new Enemigo("goei", (224 + ii), (35 + ii * 10), 20, this.gui);
			}
			for (int ii = 0; ii < enjambre[2].length; ii++) {
				enjambre[2][ii] = new Enemigo("zako", (234 + ii), (35 + ii * 10), 30, this.gui);
			}
			for (int ii = 0; ii < enjambre[3].length; ii++) {
				enjambre[3][ii] = new Enemigo("zako", (244 + ii), (35 + ii * 10), 40, this.gui);
			}
			break;
		case 3:
			// Enjambre NIVEL3
			for (int ii = 0; ii < enjambre[0].length; ii++) {
				if (ii != 1 && ii != 4 && ii != 5 && ii != 8) {
					enjambre[0][ii] = new Enemigo("comandante galaga", (260 + ii), (35 + ii * 10), 10, this.gui);
				} else {
					enjambre[0][ii] = new Enemigo();
				}
			}
			for (int ii = 0; ii < enjambre[1].length; ii++) {
				enjambre[1][ii] = new Enemigo("goei", (306 + ii), (35 + ii * 10), 20, this.gui);
			}
			for (int ii = 0; ii < enjambre[2].length; ii++) {
				if (ii != 1 && ii != 4 && ii != 5 && ii != 8) {
					enjambre[2][ii] = new Enemigo("zako", (280 + ii), (35 + ii * 10), 30, this.gui);
				} else {
					enjambre[2][ii] = new Enemigo();
				}
			}
			for (int ii = 0; ii < enjambre[3].length; ii++) {
				enjambre[3][ii] = new Enemigo("zako", (316 + ii), (35 + ii * 10), 40, this.gui);
			}
			break;
		}

	}

	public Enemigo[][] getEnjambre() {
		return enjambre;
	}

	public int getNivel() {
		return numero;
	}

	public void setNivel(int nivel) {
		this.numero = nivel;
	}

	// METODOS
	public void alternarImagenEnjambre() {
		for (int ii = 0; ii < enjambre.length; ii++) {
			for (int jj = 0; jj < enjambre[ii].length; jj++) {
				if (!enjambre[ii][jj].getTipo().equals("vacio")) {
					// tener las imagenes altenernadas entre si para dar mayor sensacion de
					// movimiento
					if (jj % 2 == 0) {
						enjambre[ii][jj].alternarImagen(enjambre[ii][jj].getTipo());
					}

				}
			}
		}
	}

	// Cambiar coordenadas al enjambre
	public void moverEnjambre(String direccion) {

		if (direccion.equals("izquierda")) {
			for (int ii = 0; ii < enjambre.length; ii++) {
				for (int jj = 0; jj < enjambre[ii].length; jj++) {
					if (!enjambre[ii][jj].getTipo().equals("vacio")) {
						enjambre[ii][jj].getCoordenadas().setX((enjambre[ii][jj].getCoordenadas().getX() - 1));
						if ((enjambre[ii][jj].getCoordenadas().getX() % 10) == 0) {
							enjambre[ii][jj].alternarImagen(enjambre[ii][jj].getTipo());
							gui.gb_setSpriteImage(enjambre[ii][jj].getIdentificador(), enjambre[ii][jj].getImagen());
						}
					}
				}
			}
		}
		if (direccion.equals("derecha")) {
			for (int ii = 0; ii < enjambre.length; ii++) {
				for (int jj = 0; jj < enjambre[ii].length; jj++) {
					if (!enjambre[ii][jj].getTipo().equals("vacio")) {
						enjambre[ii][jj].getCoordenadas().setX((enjambre[ii][jj].getCoordenadas().getX() + 1));
						if ((enjambre[ii][jj].getCoordenadas().getX() % 10) == 0) {
							enjambre[ii][jj].alternarImagen(enjambre[ii][jj].getTipo());
							gui.gb_setSpriteImage(enjambre[ii][jj].getIdentificador(), enjambre[ii][jj].getImagen());
						}
					}
				}
			}
		}
		if (direccion.equals("abajo")) {
			for (int ii = 0; ii < enjambre.length; ii++) {
				for (int jj = 0; jj < enjambre[ii].length; jj++) {
					if (!enjambre[ii][jj].getTipo().equals("vacio")) {
						enjambre[ii][jj].getCoordenadas().setY((enjambre[ii][jj].getCoordenadas().getY() + 1));
					}
				}
			}
		}
		if (direccion.equals("arriba")) {
			for (int ii = 0; ii < enjambre.length; ii++) {
				for (int jj = 0; jj < enjambre[ii].length; jj++) {
					if (!enjambre[ii][jj].getTipo().equals("vacio")) {
						enjambre[ii][jj].getCoordenadas().setY((enjambre[ii][jj].getCoordenadas().getY() - 1));
					}
				}
			}
		}
		imprimirEnjambre();
	}

	// Generar enjambre en pantalla
	public void imprimirEnjambre() {
		for (int ii = 0; ii < enjambre.length; ii++) {
			for (int jj = 0; jj < enjambre[ii].length; jj++) {
				if (!enjambre[ii][jj].getTipo().equals("vacio")) {
					gui.gb_moveSpriteCoord(enjambre[ii][jj].getIdentificador(),
							enjambre[ii][jj].getCoordenadas().getX(), enjambre[ii][jj].getCoordenadas().getY());
				}
			}
		}
	}

	// Crear todo el enjambre
	public void enjambreVisible() {
		for (int ii = 0; ii < enjambre.length; ii++) {
			for (int jj = 0; jj < enjambre[ii].length; jj++) {
				if (!enjambre[ii][jj].getTipo().equals("vacio")) {
					enjambre[ii][jj].crearSprite();
				}
			}
		}
	}

	// Colision. Las casillas coinciden
	public void destruir(Jugador usuario) {
		for (int ii = 0; ii < enjambre.length; ii++) {
			for (int jj = 0; jj < enjambre[ii].length; jj++) {
				if (!enjambre[ii][jj].getTipo().equals("vacio")) {
					for (int kk = 0; kk < usuario.getDisparos().length; kk++) {
						if (usuario.getDisparos()[kk].getIdentificador() > 0) {
							
								if(enjambre[ii][jj].getTipo().equals("comandante galaga") && enjambre[ii][jj].getVida()==2 ) {
									if (enjambre[ii][jj].getCoordenadas().getX()/cte.getMin()+15 == usuario.getDisparos()[kk].getCoordenadas().getX()/cte.getMin()+15
											&& enjambre[ii][jj].getCoordenadas().getY()/cte.getMin()+15 == usuario.getDisparos()[kk].getCoordenadas()
													.getY()/cte.getMin()+15) {
									enjambre[ii][jj].setImagen("enemy9G0.png");
									enjambre[ii][jj].setVida(1);
									usuario.getDisparos()[kk].colisionado(); 
									}
								}else {
									if (enjambre[ii][jj].getCoordenadas().getX()/cte.getMin() == usuario.getDisparos()[kk].getCoordenadas().getX()/cte.getMin()
											&& enjambre[ii][jj].getCoordenadas().getY()/cte.getMin() == usuario.getDisparos()[kk].getCoordenadas()
													.getY()/cte.getMin()) {
								enjambre[ii][jj].destruido();
								usuario.getDisparos()[kk].colisionado(); 
								usuario.setAciertos(usuario.getAciertos()+1);
								usuario.setPuntos(usuario.getPuntos()+enjambre[ii][jj].getPuntos());
									}
								}
							}
						}
					}
				}
			
		}
	}
}
