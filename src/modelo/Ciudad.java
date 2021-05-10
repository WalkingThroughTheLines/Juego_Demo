package modelo;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class Ciudad implements Runnable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2017587451663718165L;
	/**
	 * @author WTTL
	 * @version 1.0
	 */
	private int gananciasHierro, gananciasOro, gananciasAluminio, gananciasSilicio, hierro, oro, aluminio, silicio;
	private float gananciasDinero, dinero;
	private String nombreCiudad;
	private static Ciudad ciudad1;

	private Ciudad(int gananciasHierro, int gananciasOro, int gananciasAluminio, int gananciasSilicio,
			float gananciasDinero, String nombreCiudad) {
		super();
		this.gananciasHierro = gananciasHierro;
		this.gananciasOro = gananciasOro;
		this.gananciasAluminio = gananciasAluminio;
		this.gananciasSilicio = gananciasSilicio;
		this.gananciasDinero = gananciasDinero;
		this.nombreCiudad = nombreCiudad;
	}

	public static Ciudad getInstance(String nombreCiudad) {
		if (ciudad1 == null) {
			ciudad1 = new Ciudad(25, 50, 15, 0, 70, nombreCiudad);

		}
		return ciudad1;
	}

	public void run() {
		while (true) {
			if (dinero <= 99999 && hierro <= 99999 && oro <= 99999 && aluminio <= 999999 && silicio <= 99999) {
				dinero += gananciasDinero;
				hierro += gananciasHierro;
				oro += gananciasOro;
				aluminio += gananciasAluminio;
				silicio += gananciasSilicio;
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println("TONTO");
					e.getStackTrace();
				}
			}
		}
	}

	public static void menuCiudad() {
		int resp = 0;
		String[] opc = { "Construir", "Mostrar", "Salir" };
		resp = JOptionPane.showOptionDialog(null,
				"Bienvenido al gestor de tu ciudad: " + ciudad1.nombreCiudad + "\nSeleccione una opcion", "Menu Ciudad",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opc, null);
		opcionesCiudad(resp);
	}

	private static void opcionesCiudad(int resp) {
		switch (resp) {
		case 0:
			ciudad1.contruir();
			break;
		case 1:
			ciudad1.mostrarCiudad();
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

	private void contruir() {
		String[] options = { "1.", "2.", "3.", "4.", "5." };
		int x = 0;
		JOptionPane.showMessageDialog(null, "Bienvenido al gestor de edificios de tu ciudad", "Ciudad: " + nombreCiudad,
				JOptionPane.PLAIN_MESSAGE, null);
		try {
			x = JOptionPane.showOptionDialog(null,
					"Puede Construir: \n" + "1.Fabrica de monedas  2.Minas \n3.proximamente 4.proximamente \n5.Volver",
					"WTTL", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
			if (x == 0) {
				fabrica();
			} else if (x == 1) {
				minas();
			} else if (x == 2) {
				JOptionPane.showMessageDialog(null, "Opcion no disponible", "Ciudad: " + nombreCiudad,
						JOptionPane.PLAIN_MESSAGE, null);
			} else if (x == 3) {
				JOptionPane.showMessageDialog(null, "Opcion no disponible", "Ciudad: " + nombreCiudad,
						JOptionPane.PLAIN_MESSAGE, null);
			} else if (x == 4) {

			} else {

				System.out.println("ERROR, NO SE HA ENCONTRADO LA OPCION");
			}
		} catch (NumberFormatException e) {
			System.out.println("ERROR FORMATO.");
		}
	}

	private void fabrica() {
		int resp = 0;
		String[] opc = { "SI", "NO" };
		try {
			resp = JOptionPane.showInternalOptionDialog(null,
					"Ha elegido crear una fabrica de monedas."
							+ "\nConstruirla cuesta: 1000 Monedas, 200 Hierro, 340 Aluminio."
							+ "\n Consume y produce: +75 Monedas, -25 Oro, -10 Hierro."
							+ "\n Seleccione si quiere construir la fabrica.",
					nombreCiudad, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opc, null);
			if (resp == 0) {
				if (dinero >= 1000 && hierro >= 200 && aluminio >= 340 && gananciasDinero >= 26
						&& gananciasHierro >= 11) {
					setDinero(getDinero() - 1000);
					setHierro(getHierro() - 200);
					setAluminio(getAluminio() - 340);
					setGananciasOro(getGananciasOro() - 25);
					setGananciasHierro(getGananciasHierro() - 10);
					setGananciasDinero(getGananciasDinero()+75);
					JOptionPane.showMessageDialog(null, "Se ha creado con exito su Fabrica de monedas", nombreCiudad,
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "No tienes los requesitos para construirlo", nombreCiudad,
							JOptionPane.ERROR_MESSAGE);
				}
			} else if (resp == 1) {

			} else {
				System.out.println("ERROR, NO SE HA SELECCIONADO UNA RESPUESTA VALIDA");
			}
		} catch (NumberFormatException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}

	}

	private void minas() {
		String[] options = { "1.", "2.", "3.", "4.", "5." };
		String[] opc = { "SI", "NO" };
		int resp2 = 0, resp1 = 0;
		try {
			resp2 = JOptionPane.showOptionDialog(null,
					"Puede Construir: \n"
							+ "1.Mina de hierro  2.Mina de oro \n3.Mina de aluminio 4.Mina de silicio \n5.Volver",
					"WTTL", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
			if (resp2 == 0) {
				resp1 = JOptionPane.showInternalOptionDialog(null,
						"Ha elegido crear una mina de hierro."
								+ "\nConstruirla cuesta: 600 Monedas, 100 Hierro, 120 Aluminio."
								+ "\n Consume y produce: -20 Monedas, -10 Aluminio, +30 Hierro."
								+ "\n Seleccione si quiere construir la mina.",
						nombreCiudad, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opc, null);
				if (resp1 == 0) {
					if (dinero >= 600 && hierro >= 100 && aluminio >= 120 && gananciasDinero >= 21
							&& gananciasAluminio >= 11) {
						setDinero(getDinero() - 600);
						setHierro(getHierro() - 100);
						setAluminio(getAluminio() - 120);
						setGananciasAluminio(getGananciasAluminio() - 25);
						setGananciasHierro(getGananciasHierro() + 30);
						setGananciasDinero(getGananciasDinero() - 20);
						JOptionPane.showMessageDialog(null, "Se ha creado con exito su mina de hierro", nombreCiudad,
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "No tienes los requesitos para construirlo", nombreCiudad,
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (resp1 == 1) {

				} else {
					System.out.println("ERROR, NO SE HA SELECCIONADO UNA RESPUESTA VALIDA");
				}
			} else if (resp2 == 1) {
				resp1 = JOptionPane.showInternalOptionDialog(null,
						"Ha elegido crear una mina de oro."
								+ "\nConstruirla cuesta: 1000 Monedas, 200 Hierro, 260 Aluminio."
								+ "\n Consume y produce: -20 Monedas, +50 Oro, -10 Hierro, -15 Aluminio."
								+ "\n Seleccione si quiere construir la mina.",
						nombreCiudad, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opc, null);
				if (resp1 == 0) {
					if (dinero >= 1000 && hierro >= 200 && aluminio >= 260 && gananciasDinero >= 21
							&& gananciasHierro >= 11 && gananciasAluminio>=16) {
						setDinero(getDinero() - 1000);
						setHierro(getHierro() - 200);
						setAluminio(getAluminio() - 260);
						setGananciasHierro(getGananciasHierro() - 10);
						setGananciasOro(getGananciasOro() + 50);
						setGananciasAluminio(getGananciasAluminio() - 15);
						setGananciasDinero(getGananciasDinero() - 20);
						JOptionPane.showMessageDialog(null, "Se ha creado con exito su mina de oro", nombreCiudad,
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "No tienes los requesitos para construirlo", nombreCiudad,
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (resp1 == 1) {

				} else {
					System.out.println("ERROR, NO SE HA SELECCIONADO UNA RESPUESTA VALIDA");
				}
			} else if (resp2 == 2) {
				resp1 = JOptionPane.showInternalOptionDialog(null,
						"Ha elegido crear una mina de aluminio."
								+ "\nConstruirla cuesta: 1000 Monedas, 200 Hierro, 340 Aluminio."
								+ "\n Consume y produce: -20 Monedas, -10 Hierro, +50 Aluminio."
								+ "\n Seleccione si quiere construir la mina.",
						nombreCiudad, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opc, null);
				if (resp1 == 0) {
					if (dinero >= 1000 && hierro >= 200 && aluminio >= 340 && gananciasDinero >= 21
							&& gananciasHierro >= 11) {
						setDinero(getDinero() - 1000);
						setHierro(getHierro() - 200);
						setAluminio(getAluminio() - 340);
						setGananciasHierro(getGananciasHierro() - 10);
						setGananciasAluminio(getGananciasAluminio()+50);
						setGananciasDinero(getGananciasDinero() - 20);
						JOptionPane.showMessageDialog(null, "Se ha creado con exito su Fabrica de monedas",
								nombreCiudad, JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "No tienes los requesitos para construirlo", nombreCiudad,
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (resp1 == 1) {

				} else {
					System.out.println("ERROR, NO SE HA SELECCIONADO UNA RESPUESTA VALIDA");
				}
			} else if (resp2 == 3) {
				resp1 = JOptionPane.showInternalOptionDialog(null,
						"Ha elegido crear una mina de Silicio."
								+ "\nConstruirla cuesta: 1500 Monedas, 300 Hierro, 400 Aluminio."
								+ "\n Consume y produce: -30 Monedas, -15 Aluminio, -15 Hierro, +5 Silicio."
								+ "\n Seleccione si quiere construir la mina.",
						nombreCiudad, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opc, null);
				if (resp1 == 0) {
					if (dinero >= 1500 && hierro >= 300 && aluminio >= 400 && gananciasDinero >= 31
							&& gananciasHierro >= 16 && gananciasAluminio>= 16) {
						setDinero(getDinero() - 1000);
						setHierro(getHierro() - 200);
						setAluminio(getAluminio() - 340);
						setGananciasOro(getGananciasOro() - 25);
						setGananciasHierro(getGananciasHierro() - 10);
						setGananciasOro(getGananciasOro() + 50);
						setGananciasSilicio(getGananciasSilicio()+5);
						JOptionPane.showMessageDialog(null, "Se ha creado con exito su Fabrica de monedas",
								nombreCiudad, JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "No tienes los requesitos para construirlo", nombreCiudad,
								JOptionPane.ERROR_MESSAGE);
					}
				} else if (resp1 == 1) {

				} else {
					System.out.println("ERROR, NO SE HA SELECCIONADO UNA RESPUESTA VALIDA");
				}
			} else if (resp2 == 4) {

			} else {

				System.out.println("ERROR, NO SE HA ENCONTRADO LA OPCION");
			}
		} catch (NumberFormatException e) {
			System.out.println("ERROR FORMATO.");
		}
	}

	private void mostrarCiudad() {
		JOptionPane.showMessageDialog(null, ciudad1, "Ciudad: " + nombreCiudad, JOptionPane.PLAIN_MESSAGE, null);
	}

	@Override
	public String toString() {
		return "ciudad: " + nombreCiudad + "\nDinero: " + dinero + "(" + gananciasDinero + ")" + "      Hierro: "
				+ hierro + "(" + gananciasHierro + ")" + "\nOro: " + oro + "(" + gananciasOro + ")" + "      Aluminio: "
				+ aluminio + "(" + gananciasAluminio + ")" + "\nSilicio: " + silicio + "(" + gananciasSilicio + ")";
	}

	public int getGananciasHierro() {
		return gananciasHierro;
	}

	private void setGananciasHierro(int gananciasHierro) {
		this.gananciasHierro = gananciasHierro;
	}

	public int getGananciasOro() {
		return gananciasOro;
	}

	private void setGananciasOro(int gananciasOro) {
		this.gananciasOro = gananciasOro;
	}

	public int getGananciasAluminio() {
		return gananciasAluminio;
	}

	private void setGananciasAluminio(int gananciasAluminio) {
		this.gananciasAluminio = gananciasAluminio;
	}

	public int getGananciasSilicio() {
		return gananciasSilicio;
	}

	private void setGananciasSilicio(int gananciasSilicio) {
		this.gananciasSilicio = gananciasSilicio;
	}

	public int getHierro() {
		return hierro;
	}

	private void setHierro(int hierro) {
		this.hierro = hierro;
	}

	public int getOro() {
		return oro;
	}

	public int getAluminio() {
		return aluminio;
	}

	private void setAluminio(int aluminio) {
		this.aluminio = aluminio;
	}

	public int getSilicio() {
		return silicio;
	}

	public float getGananciasDinero() {
		return gananciasDinero;
	}

	private void setGananciasDinero(float gananciasDinero) {
		this.gananciasDinero = gananciasDinero;
	}

	public float getDinero() {
		return dinero;
	}

	private void setDinero(float dinero) {
		this.dinero = dinero;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public static Ciudad getCiudad1() {
		return ciudad1;
	}

	public static void setCiudad1(Ciudad ciudad1) {
		Ciudad.ciudad1 = ciudad1;
	}

	public static void iniciarThread() {
		new Thread(ciudad1).start();
	}

	public static void generadorTesoro() {
		int prob = (int) Math.floor(Math.random() * 101);
		int tsHierro=0, tsOro=0, tsDinero=0, tsAluminio=0, tsSilicio=0;
		if (prob <= 70) {
			tsHierro=(int) Math.ceil(Math.random() * 100);
			tsOro=(int) Math.ceil(Math.random() * 80);
			tsDinero=(int) Math.ceil(Math.random() * 200);
			ciudad1.hierro =+ tsHierro;
			ciudad1.oro =+tsOro;
			ciudad1.dinero =+tsDinero;
			JOptionPane.showMessageDialog(null, "Ha obtenido: \n"+tsHierro+" de Hierro."
					+"\n"+tsOro+" de Oro."
					+"\n"+tsDinero+" Monedas"
					, "TESORO COMUN", JOptionPane.INFORMATION_MESSAGE, null);
		} else if (prob > 70 && prob <= 90) {
			tsHierro=(int) Math.ceil(Math.random() * 150);
			tsOro=(int) Math.ceil(Math.random() * 110);
			tsDinero=(int) Math.ceil(Math.random() * 400);
			tsAluminio=(int) Math.ceil(Math.random() * 60);
			ciudad1.hierro =+ tsHierro;
			ciudad1.oro =+tsOro;
			ciudad1.dinero =+tsDinero;
			ciudad1.aluminio =+tsAluminio;
			JOptionPane.showMessageDialog(null, "Ha obtenido: \n"+tsHierro+" de Hierro."
					+"\n"+tsOro+" de Oro."
					+"\n"+tsDinero+" Monedas"
					+"\n"+tsAluminio+" de Aluminio"
					, "TESORO RARO", JOptionPane.INFORMATION_MESSAGE, null);
		} else if (prob > 90) {
			tsHierro=(int) Math.ceil(Math.random() * 200);
			tsOro=(int) Math.ceil(Math.random() * 140);
			tsDinero=(int) Math.ceil(Math.random() * 600);
			tsAluminio=(int) Math.ceil(Math.random() * 90);
			tsSilicio=(int) Math.ceil(Math.random() * 20);
			ciudad1.hierro =+ tsHierro;
			ciudad1.oro =+tsOro;
			ciudad1.dinero =+tsDinero;
			ciudad1.aluminio =+tsAluminio;
			ciudad1.silicio =+tsSilicio;
			JOptionPane.showMessageDialog(null, "Ha obtenido: \n"+tsHierro+" de Hierro."
					+"\n"+tsOro+" de Oro."
					+"\n"+tsDinero+" Monedas"
					+"\n"+tsAluminio+" de Aluminio"
					+"\n"+tsSilicio+" de Silicio"
					, "TESORO LEGENDARIO", JOptionPane.INFORMATION_MESSAGE, null);
		}
	}

}
