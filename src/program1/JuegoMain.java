package program1;

import javax.swing.JOptionPane;

public class JuegoMain {
	 /**
	  * @author Jesús, WTTL
	  * @version 1.0
	  */
	
	@SuppressWarnings("deprecation")
	public static void Juego() {
		String[] options = {"1.", "2.", "3.", "4."};
		int x=0;
		Ciudad c1 = new Ciudad(1, 40, 2, 0, 60.5f, "pepe");
		c1.start();
		do {
			try {
				x = JOptionPane.showOptionDialog(null, "Menu. \n1. Mostrar Ciudad. \n2. Buscar Pelea."
						+ " \n3. Contruir En La Ciudad. \n4. Salir Del Programa",
		                "WTTL",
		                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE
		                , null, options, null);
		        if(x == 0) {
		        	JOptionPane.showMessageDialog(null, c1, "Ciudad", JOptionPane.PLAIN_MESSAGE,null);
		        }else if (x==1) {
		        	
		        }else if (x==2) {
		        	c1.contruir();
		        }else if (x==3) {
		        	JOptionPane.showMessageDialog(null, "hasta la proxima", "Salida", JOptionPane.PLAIN_MESSAGE,null);
		        }else {
		        	
		        	System.out.println("ERROR");
		        }
			}catch(NumberFormatException e) {
				System.out.println("ERROR FORMATO.");
			}
		}while(x!=3);
		c1.stop();
	}

}
