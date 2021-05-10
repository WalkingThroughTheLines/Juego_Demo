package modelo;

import javax.swing.JOptionPane;

public class Ciudad implements Runnable{
	 /**
	  * @author Jesús, WTTL
	  * @version 1.0
	  */
	private int gananciasHierro, gananciasOro, gananciasAluminio, gananciasSilicio
	, hierro, oro, aluminio, silicio;
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
	
	public static Ciudad getInstance(int gananciasHierro, int gananciasOro, int gananciasAluminio, int gananciasSilicio,
			float gananciasDinero, String nombreCiudad) {
		if(ciudad1==null){
			ciudad1= new Ciudad(gananciasHierro, gananciasOro, gananciasAluminio, gananciasSilicio, gananciasDinero, nombreCiudad);
		}
		return ciudad1;	
	}
	
	public void run() {
		while(true) {
			if(dinero<=99999 && hierro <=99999 && oro<=99999 && aluminio<=999999 && silicio<=99999) {
				dinero += gananciasDinero;
				hierro += gananciasHierro;
				oro += gananciasOro;
				aluminio += gananciasAluminio;
				silicio += gananciasSilicio;
				try {
					Thread.sleep(5000);
				}catch(InterruptedException e) {
					System.out.println("TONTO");
					e.getStackTrace();
				}
			}
		}
	}

	private void contruir() {
		String[] options = {"1.", "2.", "3.", "4.", "5."};
		int x=0;
		JOptionPane.showMessageDialog(null, "Bienvenido al gestor de edificios de tu ciudad", "Ciudad: " + nombreCiudad, JOptionPane.PLAIN_MESSAGE , null);
		try {
				x = JOptionPane.showOptionDialog(null, "Puede Construir: \n" + 
			"1.Fabrica de monedas  2.Minas \n3.proximamente 4.proximamente \n5.Volver",
		                "WTTL",
		                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE
		                , null, options, null);
		        if(x == 0) {
		        	fabrica();
		        } else if (x==1) {
		        	minas();
		        } else if (x==2) {
		        	
		        } else if (x==3) {
		        	
		        } else if (x==4) {
		        	
		        } else {
		        	
		        	System.out.println("ERROR, NO SE HA ENCONTRADO LA OPCION");
		        }
		}catch(NumberFormatException e) {
			System.out.println("ERROR FORMATO.");
		}
	}
	
	private void fabrica() {
		int resp=0;
		String[] opc= {"SI", "NO"};
		try {
			resp = JOptionPane.showInternalOptionDialog(null
		    		, "Ha elegido crear una fabrica de monedas." +
		    		"\nConstruirla cuesta: 1000 Monedas, 200 Hierro, 340 Aluminio." +
		    		"\n Consume y produce: +50 Monedas, -25 Oro, -10 Hierro." +
		    		"\n Seleccione si quiere construir la fabrica."
		    		, nombreCiudad, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opc, null);
		    	if (resp==0) {
		    		if(dinero>=1000 && hierro>=200 && aluminio >=340 && gananciasDinero>=26 && gananciasHierro>=11) {
		    			setDinero(getDinero()-1000);
		    			setHierro(getHierro()-200);
		    			setAluminio(getAluminio()-340);
		    			setGananciasOro(getGananciasOro()-25);
		    			setGananciasHierro(getGananciasHierro()-10);
		    			setGananciasOro(getGananciasOro()+50);
		    			JOptionPane.showMessageDialog(null, "Se ha creado con exito su Fabrica de monedas", nombreCiudad, JOptionPane.INFORMATION_MESSAGE);
		    		}else {
		    			JOptionPane.showMessageDialog(null, "No tienes los requesitos para construirlo", nombreCiudad, JOptionPane.ERROR_MESSAGE);
		    		}
		    	}else if(resp==1) {
		    		
		    	}else {
		    		System.out.println("ERROR, NO SE HA SELECCIONADO UNA RESPUESTA VALIDA");
		    	}
		}catch(NumberFormatException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
    	
	}
	private void minas(){
		String[] options = {"1.", "2.", "3.", "4.", "5."};
		String[] opc= {"SI", "NO"};
		int x=0, resp=0;
		try {
				x = JOptionPane.showOptionDialog(null, "Puede Construir: \n" + 
			"1.Mina de hierro  2.Mina de oro \n3.Mina de aluminio 4.Mina de silicio \n5.Volver",
		                "WTTL",
		                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE
		                , null, options, null);
		        if(x == 0) {
		        	resp = JOptionPane.showInternalOptionDialog(null, "Ha elegido crear una mina de hierro." +
				    		"\nConstruirla cuesta: 600 Monedas, 100 Hierro, 120 Aluminio." +
				    		"\n Consume y produce: -20 Monedas, -10 Aluminio, +30 Hierro." +
				    		"\n Seleccione si quiere construir la mina."
		        			, nombreCiudad, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opc, null);
			        	if (resp==0) {
				    		if(dinero>=600 && hierro>=100 && aluminio >=120 && gananciasDinero>=21 && gananciasAluminio>=11) {
				    			setDinero(getDinero()-600);
				    			setHierro(getHierro()-100);
				    			setAluminio(getAluminio()-120);
				    			setGananciasAluminio(getGananciasAluminio()-25);
				    			setGananciasHierro(getGananciasHierro()+30);
				    			setGananciasDinero(getGananciasDinero()-20);
				    			JOptionPane.showMessageDialog(null, "Se ha creado con exito su mina de hierro", nombreCiudad, JOptionPane.INFORMATION_MESSAGE);
				    		}else {
				    			JOptionPane.showMessageDialog(null, "No tienes los requesitos para construirlo", nombreCiudad, JOptionPane.ERROR_MESSAGE);
				    		}
				    	}else if(resp==1) {
				    		
				    	}else {
				    		System.out.println("ERROR, NO SE HA SELECCIONADO UNA RESPUESTA VALIDA");
				    	}
		        } else if (x==1) {
		        	resp = JOptionPane.showInternalOptionDialog(null, "Ha elegido crear una mina de oro." +
				    		"\nConstruirla cuesta: 1000 Monedas, 200 Hierro, 340 Aluminio." +
				    		"\n Consume y produce: +50 Monedas, -25 Oro, -10 Hierro." +
				    		"\n Seleccione si quiere construir la mina."
		        			, nombreCiudad, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opc, null);
		        	if (resp==0) {
			    		if(dinero>=1000 && hierro>=200 && aluminio >=340 && gananciasDinero>=26 && gananciasHierro>=11) {
			    			setDinero(getDinero()-1000);
			    			setHierro(getHierro()-200);
			    			setAluminio(getAluminio()-340);
			    			setGananciasOro(getGananciasOro()-25);
			    			setGananciasHierro(getGananciasHierro()-10);
			    			setGananciasOro(getGananciasOro()+50);
			    			JOptionPane.showMessageDialog(null, "Se ha creado con exito su mina de oro", nombreCiudad, JOptionPane.INFORMATION_MESSAGE);
			    		}else {
			    			JOptionPane.showMessageDialog(null, "No tienes los requesitos para construirlo", nombreCiudad, JOptionPane.ERROR_MESSAGE);
			    		}
			    	}else if(resp==1) {
			    		
			    	}else {
			    		System.out.println("ERROR, NO SE HA SELECCIONADO UNA RESPUESTA VALIDA");
			    	}
		        } else if (x==2) {
		        	resp = JOptionPane.showInternalOptionDialog(null, "Ha elegido crear una fabrica de monedas." +
				    		"\nConstruirla cuesta: 1000 Monedas, 200 Hierro, 340 Aluminio." +
				    		"\n Consume y produce: +50 Monedas, -25 Oro, -10 Hierro." +
				    		"\n Seleccione si quiere construir la fabrica."
		        			, nombreCiudad, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opc, null);
		        	if (resp==0) {
			    		if(dinero>=1000 && hierro>=200 && aluminio >=340 && gananciasDinero>=26 && gananciasHierro>=11) {
			    			setDinero(getDinero()-1000);
			    			setHierro(getHierro()-200);
			    			setAluminio(getAluminio()-340);
			    			setGananciasOro(getGananciasOro()-25);
			    			setGananciasHierro(getGananciasHierro()-10);
			    			setGananciasOro(getGananciasOro()+50);
			    			JOptionPane.showMessageDialog(null, "Se ha creado con exito su Fabrica de monedas", nombreCiudad, JOptionPane.INFORMATION_MESSAGE);
			    		}else {
			    			JOptionPane.showMessageDialog(null, "No tienes los requesitos para construirlo", nombreCiudad, JOptionPane.ERROR_MESSAGE);
			    		}
			    	}else if(resp==1) {
			    		
			    	}else {
			    		System.out.println("ERROR, NO SE HA SELECCIONADO UNA RESPUESTA VALIDA");
			    	}
		        } else if (x==3) {
		        	resp = JOptionPane.showInternalOptionDialog(null, "Ha elegido crear una fabrica de monedas." +
				    		"\nConstruirla cuesta: 1000 Monedas, 200 Hierro, 340 Aluminio." +
				    		"\n Consume y produce: +50 Monedas, -25 Oro, -10 Hierro." +
				    		"\n Seleccione si quiere construir la fabrica."
				    		, nombreCiudad, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opc, null);
		        	if (resp==0) {
			    		if(dinero>=1000 && hierro>=200 && aluminio >=340 && gananciasDinero>=26 && gananciasHierro>=11) {
			    			setDinero(getDinero()-1000);
			    			setHierro(getHierro()-200);
			    			setAluminio(getAluminio()-340);
			    			setGananciasOro(getGananciasOro()-25);
			    			setGananciasHierro(getGananciasHierro()-10);
			    			setGananciasOro(getGananciasOro()+50);
			    			JOptionPane.showMessageDialog(null, "Se ha creado con exito su Fabrica de monedas", nombreCiudad, JOptionPane.INFORMATION_MESSAGE);
			    		}else {
			    			JOptionPane.showMessageDialog(null, "No tienes los requesitos para construirlo", nombreCiudad, JOptionPane.ERROR_MESSAGE);
			    		}
			    	}else if(resp==1) {
			    		
			    	}else {
			    		System.out.println("ERROR, NO SE HA SELECCIONADO UNA RESPUESTA VALIDA");
			    	}
		        } else if (x==4) {
		        	
		        } else {
		        	
		        	System.out.println("ERROR, NO SE HA ENCONTRADO LA OPCION");
		        }
		}catch(NumberFormatException e) {
			System.out.println("ERROR FORMATO.");
		}
	}
	
	@Override
	public String toString() {
		return "ciudad: " + nombreCiudad 
		+ "\nDinero: " + dinero + "(" + gananciasDinero + ")"
		+ "      Hierro: " + hierro + "(" + gananciasHierro +")" 
		+ "\nOro: " + oro + "(" + gananciasOro + ")"
		+ "      Aluminio: " + aluminio +"(" + gananciasAluminio + ")" 
		+"\nSilicio: " + silicio + "(" + gananciasSilicio + ")" ;
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
	
	
}
