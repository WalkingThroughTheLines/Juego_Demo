package mainMenu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import modelo.*;

public class MainMenu {
	/**
	 * @author WTTL
	 * @version 1.0
	 */

	public static void mainMenu() {
		cargar();
		if (Ciudad.getCiudad1() == null) {
			String nombre;
			try {
				JOptionPane.showMessageDialog(null, "Creando una ciudad para que pueda jugar :>",
						"NO SE HA ENCONTRADO UNA CIUDAD", JOptionPane.INFORMATION_MESSAGE, null);
				nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre para su ciudad", "Nombre De La Ciudad",
						JOptionPane.INFORMATION_MESSAGE);
				Ciudad.getInstance(nombre);
				JOptionPane.showMessageDialog(null, "Ciudad creada", "CREANDO CIUDAD", JOptionPane.INFORMATION_MESSAGE,
						null);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR, valores introducidos incorrectos", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			}
		}
		Ciudad.iniciarThread();
		if (Heroe.getHeroe1() == null) {
			String nombre;
			try {
				JOptionPane.showMessageDialog(null, "Creando un heroe para que pueda jugar :>",
						"NO SE HA ENCONTRADO UN HEROE JUGABLE", JOptionPane.INFORMATION_MESSAGE, null);
				nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre para su heroe", "Nombre Del Heroe",
						JOptionPane.INFORMATION_MESSAGE);
				Heroe.getInstance(nombre);
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
		} while (resp != 3 && resp != -1);
		guardar();
	}

	private static int mostrarMenu(int resp) {
		String[] opc = { "Ciudad", "Combatir", "Heroe", "Salir" };
		try {
			resp = JOptionPane.showOptionDialog(null,
					"Bienvenido a Walking Through The Lines" + "\nElija aventurero lo que desea hacer", "Menu",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opc, null);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR, valores introducidos incorrectos", "ERROR",
					JOptionPane.ERROR_MESSAGE, null);
		}

		return resp;
	}

	private static void opcionesMenu(int resp) {
		switch (resp) {
		case 0:
			Ciudad.menuCiudad();
			break;
		case 1:
			Combate.iniciarCombate();
			break;
		case 2:
			Heroe.menuHeroe();
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "Hasta la proxima", "ADIOS", JOptionPane.INFORMATION_MESSAGE, null);
			break;
		case -1:
			JOptionPane.showMessageDialog(null, "Hasta la proxima", "ADIOS", JOptionPane.INFORMATION_MESSAGE, null);
			break;
		default:
			JOptionPane.showMessageDialog(null, "ERROR, PARAMETRO NO EVALUADO", "ERROR", JOptionPane.ERROR_MESSAGE,
					null);
			break;
		}
	}

	private static void guardar() {
		try {
			ObjectOutputStream guardado = new ObjectOutputStream(new FileOutputStream("datosCiudad.dat"));
			guardado.writeObject(Ciudad.getCiudad1());
			guardado.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "ERROR, NO SE ENCUENTRA EL ARCHIVO", "ERROR", JOptionPane.ERROR_MESSAGE,
					null);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE, null);
		}
		try {
			ObjectOutputStream guardado = new ObjectOutputStream(new FileOutputStream("datosHeroe.dat"));
			guardado.writeObject(Heroe.getHeroe1());
			guardado.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "ERROR, NO SE ENCUENTRA EL ARCHIVO", "ERROR", JOptionPane.ERROR_MESSAGE,
					null);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE, null);
		}
	}

	private static void cargar() {
		try {
			ObjectInputStream cargado = new ObjectInputStream(new FileInputStream("datosCiudad.dat"));
			try {
				Ciudad.setCiudad1((Ciudad) cargado.readObject());
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "ERROR, NO SE HA ENCOTRADO CIUDAD", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			}
			cargado.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "ERROR, NO SE ENCUENTRA EL ARCHIVO", "ERROR", JOptionPane.ERROR_MESSAGE,
					null);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE, null);
		}

		try {
			ObjectInputStream cargado = new ObjectInputStream(new FileInputStream("datosHeroe.dat"));
			try {
				Heroe.setHeroe1((Heroe) cargado.readObject());
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "ERROR, NO SE HA ENCOTRADO CIUDAD", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			}
			cargado.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "ERROR, NO SE ENCUENTRA EL ARCHIVO", "ERROR", JOptionPane.ERROR_MESSAGE,
					null);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE, null);
		}
	}
}
