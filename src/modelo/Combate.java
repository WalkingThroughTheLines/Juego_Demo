package modelo;

public class Combate {
	/**
	 * @author WTTL
	 * @version 1.0
	 */
	public static void iniciarCombate() {
		int prob = (int) Math.floor(Math.random() * 101);
		if (prob <= 50) {

		} else if (prob > 50 && prob <= 75) {

		} else if (prob > 75) {
			tesoro();
		}

	}
	private static void combateMonstruo() {
		
	}
	private static void combateJefe() {
		
	}
	private static void tesoro() {
		Ciudad.generadorTesoro();
	}
}
