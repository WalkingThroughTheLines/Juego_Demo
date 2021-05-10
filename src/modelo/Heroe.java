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

	public static Heroe existe() {
		return heroe1;
	}

	public static Heroe getInstance(int hp, int def, int lvl, int ataque, String efectoPasivo, String nombre) {
		if (heroe1 == null) {
			heroe1 = new Heroe(15, 8, 1, 5, "none", nombre);
		}
		return heroe1;
	}

	public String getNombre() {
		return nombre;
	}

}
