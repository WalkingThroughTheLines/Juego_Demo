package modelo;

import java.io.Serializable;

public class Heroe extends Entidad implements Serializable {
	/**
	 * @author WTTL
	 * @version 1.0
	 */
	private static Heroe heroe1;
	private String nombre;

	public Heroe(int hp, int def, int lvl, int ataque, String efectoPasivo, String nombre) {
		super(hp, def, lvl, ataque, efectoPasivo);
		this.nombre = nombre;
	}

	public static Heroe getInstance(String nombre) {
		if (heroe1 == null) {
			heroe1 = new Heroe(15, 8, 1, 5, "none", nombre);
		}
		return heroe1;
	}

	public String getNombre() {
		return nombre;
	}

	public static Heroe getHeroe1() {
		return heroe1;
	}

	public static void setHeroe1(Heroe heroe1) {
		Heroe.heroe1 = heroe1;
	}

}
