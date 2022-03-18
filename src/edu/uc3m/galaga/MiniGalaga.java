package edu.uc3m.galaga;

import edu.uc3m.game.GameBoardGUI;
public class MiniGalaga {
	private static boolean exit = false;
	
	public static void main(String[] args) throws InterruptedException {
		//CREAR TABLERO
		GameBoardGUI gui = new GameBoardGUI(17, 22);
		gui.gb_println("Hola Mundo!");// imprimir algo en el cuadrado pequenio (consola)
		// pintar pantalla de negro
		gui.setVisible(true);// para que se vea el tablero
		for (int i = 0; i < 17; i++) {
			for (int j = 0; j < 22; j++) {
				gui.gb_setSquareColor(i, j, 0, 0, 0);
			}
		}
		

		// Ejemplo crear sprite
		gui.gb_addSprite(500, "enemy900.png", true);
		gui.gb_setSpriteVisible(500, true);
		gui.gb_moveSprite(500, 8, 14);

		
		
		
		// CREAR JUGADOR
		Jugador usuario = new Jugador(gui);
	
		
		//Imprimir habilidades del jugador
		gui.gb_setValueHealthCurrent(usuario.getVidaActual());
		gui.gb_setValueHealthMax(usuario.getVidaTotal());
		gui.gb_setTextAbility1("Disparos");
		gui.gb_setTextAbility2("Aciertos");
		gui.gb_setValueAbility1(usuario.getDisparosRealizados());
		gui.gb_setValueAbility2(usuario.getAciertos());
		gui.gb_setTextPointsDown("Puntos");
		gui.gb_setTextPointsUp("Velocidad");
		gui.gb_setPortraitPlayer("portrait.png");
		
		
		
		// CREAR ENJAMBRES
		Nivel nivel1=new Nivel(1,gui);
		Nivel nivel2=new Nivel(2,gui);
		Nivel nivel3=new Nivel(3, gui);
		nivel1.enjambreVisible();
		nivel1.alternarImagenEnjambre();
		
		
		//Variables control movimiento
		int contador = 0;
		int contador2 = -1;
		int contador3=500;
		String direccion="nada";
		String comando;
		//   boolean isTorpedo=false; 
	 	//para que vaya siempre a la derecha y vuelve a empezar, le sumo 1 a la posiciony hago modulo del maximo (asi va hacia al derecha y vuelve a empezar
		//JUEGO
		while (!exit) { 
			comando=gui.gb_getLastAction();
			// Mover jugador
			usuario.moverJugador(comando);
			

			// Mover enjambre
			if (contador < 30) {
				direccion="izquierda";
				contador++;
			
			} else {
				direccion="nada";
				contador2=0;
				
			}
			
			if((contador%200)<100 && contador2>=0) {
				direccion="derecha";
				contador++;
			}else if((contador%170)>100 && contador2>=0) {
				direccion="izquierda";
			contador++;
				
			}else if(contador2>=0){
				contador=30;
				direccion="abajo";
				nivel1.moverEnjambre(direccion);
			}
			if((contador%170)==100 && contador2>=0) {
				direccion="abajo";
				nivel1.moverEnjambre(direccion);
				contador++;
			}
			nivel1.moverEnjambre(direccion);
			
			//Disparar
			if(comando.equals("space")) {
			usuario.disparar(contador3);
			usuario.setDisparosRealizados(usuario.getDisparosRealizados()+1);
			//isTorpedo=true;
			}
			
			//Ver si no hay torpedos en pantalla
			
			//isTorpedo=usuario.isTorpedos();
			//if(isTorpedo) {
				usuario.moverTorpedos();
			//}
//			
//			
//			//Por consola la ultima accion
//			if(!comando.isEmpty()) {//No esta vacio
//				System.out.println(comando);
//			}
			nivel1.destruir(usuario);

			contador3++;
			gui.gb_setValueHealthCurrent(usuario.getVidaActual());
			gui.gb_setValuePointsDown(usuario.getPuntos());
			gui.gb_setValueAbility1(usuario.getDisparosRealizados());
			gui.gb_setValueAbility2(usuario.getAciertos());
			Thread.sleep(1000 / 60);// esperar

		}
	}

}
