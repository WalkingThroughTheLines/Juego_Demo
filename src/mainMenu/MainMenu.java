package mainMenu;

import javax.swing.JOptionPane;

import modelo.Ciudad;
import modelo.Heroe;

public class MainMenu {
	/**
	 * @author WTTL
	 * @version 1.0
	 */
	public static void mainMenu() {
		if (Ciudad.existe() == null) {
			String nombre;
			try {
				JOptionPane.showMessageDialog(null, "Creando una ciudad para que pueda jugar :>",
						"NO SE HA ENCONTRADO UNA CIUDAD", JOptionPane.INFORMATION_MESSAGE, null);
				nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre para su ciudad", "Nombre De La Ciudad",
						JOptionPane.INFORMATION_MESSAGE);
				Ciudad.getInstance(25, 50, 15, 0, 70, nombre);
				JOptionPane.showMessageDialog(null, "Ciudad creada", "CREANDO CIUDAD", JOptionPane.INFORMATION_MESSAGE,
						null);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR, valores introducidos incorrectos", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			}
		}
		if (Heroe.existe() == null) {
			String nombre;
			try {
				JOptionPane.showMessageDialog(null, "Creando un heroe para que pueda jugar :>",
						"NO SE HA ENCONTRADO UN HEROE JUGABLE", JOptionPane.INFORMATION_MESSAGE, null);
				nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre para su heroe", "Nombre Del Heroe",
						JOptionPane.INFORMATION_MESSAGE);
				Ciudad.getInstance(25, 50, 15, 0, 70, nombre);
				JOptionPane.showMessageDialog(null, "Heroe creado", "CREANDO HEROE", JOptionPane.INFORMATION_MESSAGE,
						null);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR, valores introducidos incorrectos", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			}

		}
		int resp = 0;
		do {
			resp = mostrarMenu(resp);
			opcionesMenu(resp);
		} while (resp != 0);
	}

	private static int mostrarMenu(int resp) {
		String[] opc = { "Ciudad", "Combatir", "Heroe", "Salir" };
		try {
			resp = JOptionPane.showOptionDialog(null,
					"Bienvenido a Walking Through The Lines" + "Elija aventurero lo que desea hacer", "Menu",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opc, null);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR, valores introducidos incorrectos", "ERROR",
					JOptionPane.ERROR_MESSAGE, null);
		}

		return resp;
	}

	private static void opcionesMenu(int resp) {

	}
}
