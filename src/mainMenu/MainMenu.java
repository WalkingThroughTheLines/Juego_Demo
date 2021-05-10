package mainMenu;

import javax.swing.JOptionPane;

public class MainMenu {

	public static void mainMenu() {
		int resp=0;
		do {
			resp=mostrarMenu(resp);
			opcionesMenu(resp);
		}while(resp!=0);
	}

	private static int mostrarMenu(int resp) {
		try {
			
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR, valores introducidos incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE, null);
		}
		
		return resp;
	}

	private static void opcionesMenu(int resp) {

	}
}
