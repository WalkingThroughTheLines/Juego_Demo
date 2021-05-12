package modelo;

import java.io.Serializable;
import javax.swing.JOptionPane;

public class Heroe extends Entidad implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6727091856783226175L;
	/**
	 * @author WTTL
	 * @version 1.0
	 */
	private static Heroe heroe1;
	private String nombre;

	public Heroe(int hp, int def, int lvl, int ataque, String efectoPasivo, String nombre, int exp) {
		super(hp, def, lvl, ataque, efectoPasivo, exp);
		this.nombre = nombre;
	}

	public static Heroe getInstance(String nombre) {
		if (heroe1 == null) {
			heroe1 = new Heroe(15, 8, 1, 5, "none", nombre, 0);
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

	public void subirLvl() {
		if (heroe1.getExp() >= 250 * (heroe1.getLvl() * 0.5)) {
			heroe1.setHp((int) Math.floor(heroe1.getHp() * 1.40));
			heroe1.setDef((int) Math.floor(heroe1.getDef() * 1.30));
			heroe1.setAtaque((int) Math.floor(heroe1.getAtaque() * 1.25));
			heroe1.setLvl(getLvl()+1);
			heroe1.setExp(0);
			JOptionPane.showMessageDialog(null, heroe1.nombre + " Ha subido de nivel", heroe1.nombre,
					JOptionPane.WARNING_MESSAGE, null);
		} else {
			JOptionPane.showMessageDialog(null,
					"Le faltan: " + (250 * (heroe1.getLvl() * 0.5) - heroe1.getExp()) + " Exp, para subir de nivel",
					heroe1.nombre, JOptionPane.INFORMATION_MESSAGE, null);
		}
	}

	public static void menuHeroe() {
		int resp = 0;
		String[] opc = { "Mostrar", "Ver nivel", "Volver" };
		resp = JOptionPane.showOptionDialog(null,
				"Bienvenido al gestor de: " + heroe1.nombre + "\n Seleccione su opcion", "Menu Heroe: " + heroe1.nombre,
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opc, null);
		opcionesHeroe(resp);
	}

	private static void opcionesHeroe(int resp) {
		switch (resp) {
		case 0:
			heroe1.mostrarHeroe();
			break;
		case 1:
			heroe1.verlvl();
			break;
		case 2:

			break;
		case -1:
			
			break;
		default:
			JOptionPane.showMessageDialog(null, "ERROR, PARAMETRO NO EVALUADO", "ERROR", JOptionPane.ERROR_MESSAGE,
					null);
			break;
		}
	}

	private void mostrarHeroe() {
		JOptionPane.showMessageDialog(null, "HP: "+heroe1.getHp()
		+"\nDefensa: "+heroe1.getDef()
		+"\nAtaque: "+heroe1.getAtaque()
		+"\nNivel: "+heroe1.getLvl()
		+"\nExperiencia: "+heroe1.getExp()
		, "Heroe: "+heroe1.nombre, JOptionPane.PLAIN_MESSAGE, null);
	}

	private void verlvl() {
		JOptionPane.showMessageDialog(null,
				heroe1.nombre + " es nivel: " + heroe1.getLvl() + "\nLe faltan: "
						+ (250 * (heroe1.getLvl() * 0.5) - heroe1.getExp()),
				heroe1.nombre, JOptionPane.PLAIN_MESSAGE, null);
	}

}
