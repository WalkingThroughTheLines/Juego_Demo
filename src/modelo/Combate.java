package modelo;

import javax.swing.JOptionPane;

public class Combate {
	/**
	 * @author WTTL
	 * @version 1.0
	 */
	public static void iniciarCombate() {
		int prob = (int) Math.floor(Math.random() * 101);
		if (prob <= 65) {
			Monstruo.setMonstruo1(null);
			Monstruo.getInstanceMonstruo();
			combateMonstruo();
		} else if (prob > 65 && prob <= 75) {
			Monstruo.setMonstruo1(null);
			Monstruo.getInstanceJefe();
			combateJefe();
		} else if (prob > 75) {
			Ciudad.generadorTesoro();
		}

	}

	private static void combateMonstruo() {
		String[] acciones = { "Atacar", "Defenderse", "Huir" };
		int resp = 0;
		int vidaM=0, vidaH=0;
		boolean defM=false, defH=false, huir=false;
		do {
			int prob = (int) Math.ceil(Math.random() * 100);
			defH=false; 
			huir=false;
			resp = JOptionPane.showOptionDialog(null, "La vida del heroe "+Heroe.getHeroe1().getNombre()
					+": "+(Heroe.getHeroe1().getHp()-vidaH)
					+"\n Vida del monstruo comun: "+(Monstruo.getMonstruo1().getHp()-vidaM)
					, "Monstruo", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, acciones, null);
			switch (resp) {
				case 0:
					vidaM=ataque(vidaM, defM);
					defM=false;
					if(Monstruo.getMonstruo1().getHp()-vidaM >0) {
						if(prob<=50) {
							vidaH=ataqueMonstruo(vidaH,defH);
							JOptionPane.showMessageDialog(null, "El enemigo te ataca !!!", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
						}else {
							defM=defensaMonstruo();
							JOptionPane.showMessageDialog(null, "El enemigo se defiende ?!?", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
						}
					}else {
						
					}
					break;
				case 1:
					defH=defensa();
					defM=false;
					if(prob<=50) {
						vidaH=ataqueMonstruo(vidaH,defH);
						JOptionPane.showMessageDialog(null, "El enemigo te ataca !!!", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
					}else {
						defM=defensaMonstruo();
						JOptionPane.showMessageDialog(null, "El enemigo se defiende ?!?", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
					}
					break;
				case 2:
					huir=huir();
					defM=false;
					if(huir==false) {
						JOptionPane.showMessageDialog(null, "Has fallado al huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
						if(prob<=50) {
							vidaH=ataqueMonstruo(vidaH,defH);
							JOptionPane.showMessageDialog(null, "El enemigo te ataca !!!", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
						}else {
							defM=defensaMonstruo();
							JOptionPane.showMessageDialog(null, "El enemigo se defiende ?!?", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Has conseguido huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
					}
					break;
				case -1:
					huir=huir();
					defM=false;
					if(huir==false) {
						JOptionPane.showMessageDialog(null, "Has fallado al huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
						if(prob<=50) {
							vidaH=ataqueMonstruo(vidaH,defH);
							JOptionPane.showMessageDialog(null, "El enemigo te ataca !!!", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
						}else {
							defM=defensaMonstruo();
							JOptionPane.showMessageDialog(null, "El enemigo se defiende ?!?", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Has conseguido huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
					}
					break;
				default:
					huir=huir();
					defM=false;
					if(huir==false) {
						JOptionPane.showMessageDialog(null, "Has fallado al huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
						if(prob<=50) {
							vidaH=ataqueMonstruo(vidaH,defH);
							JOptionPane.showMessageDialog(null, "El enemigo te ataca !!!", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
						}else {
							defM=defensaMonstruo();
							JOptionPane.showMessageDialog(null, "El enemigo se defiende ?!?", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Has conseguido huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
					}
					break;
			}
		} while (Monstruo.getMonstruo1().getHp()-vidaM >0 && Heroe.getHeroe1().getHp()-vidaH > 0 && huir==false);
		if (Heroe.getHeroe1().getHp()-vidaH <=0) {
			JOptionPane.showMessageDialog(null, "Has muerto, das pena", "DERROTA", JOptionPane.WARNING_MESSAGE, null);
		}else {
			if(Monstruo.getMonstruo1().getHp()-vidaM <=0){
				JOptionPane.showMessageDialog(null, "Has salido victorioso, has ganado: "+Monstruo.getMonstruo1().getExp()+" exp", "VICTORIA", JOptionPane.INFORMATION_MESSAGE, null);
				Heroe.getHeroe1().setExp(Heroe.getHeroe1().getExp()+Monstruo.getMonstruo1().getExp());
				Heroe.getHeroe1().subirLvl();
			}
		}
	}

	private static void combateJefe() {
		String[] acciones = { "Atacar", "Defenderse", "Huir" };
		int resp = 0;
		int vidaM=0, vidaH=0;
		boolean huir=false;
		boolean defM=false, defH=false;
		do {
			int prob = (int) Math.ceil(Math.random() * 100);
			defH=false;
			huir=false;
			resp = JOptionPane.showOptionDialog(null, "La vida del heroe "+Heroe.getHeroe1().getNombre()
					+": "+(Heroe.getHeroe1().getHp()-vidaH)
					+"\n Vida del Jefe: "+(Monstruo.getMonstruo1().getHp()-vidaM)
					, "Monstruo", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, acciones, null);
				switch (resp) {
				case 0:
					vidaM=ataque(vidaM, defM);
					defM=false;
					if(Monstruo.getMonstruo1().getHp()-vidaM >0) {
						if(prob<=50) {
							vidaH=ataqueMonstruo(vidaH,defH);
							JOptionPane.showMessageDialog(null, "El enemigo te ataca !!!", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
						}else {
							defM=defensaMonstruo();
							JOptionPane.showMessageDialog(null, "El enemigo se defiende ?!?", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
						}
					}else {
						
					}
					break;
				case 1:
					defH=defensa();
					defM=false;
					if(prob<=50) {
						vidaH=ataqueMonstruo(vidaH,defH);
						JOptionPane.showMessageDialog(null, "El enemigo te ataca !!!", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
					}else {
						defM=defensaMonstruo();
						JOptionPane.showMessageDialog(null, "El enemigo se defiende ?!?", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
					}
					break;
				case 2:
					huir=huir();
					defM=false;
					if(huir==false) {
						JOptionPane.showMessageDialog(null, "Has fallado al huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
						if(prob<=50) {
							vidaH=ataqueMonstruo(vidaH,defH);
							JOptionPane.showMessageDialog(null, "El enemigo te ataca !!!", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
						}else {
							defM=defensaMonstruo();
							JOptionPane.showMessageDialog(null, "El enemigo se defiende ?!?", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Has conseguido huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
					}
					break;
				case -1:
					huir=huir();
					defM=false;
					if(huir==false) {
						JOptionPane.showMessageDialog(null, "Has fallado al huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
						if(prob<=50) {
							vidaH=ataqueMonstruo(vidaH,defH);
							JOptionPane.showMessageDialog(null, "El enemigo te ataca !!!", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
						}else {
							defM=defensaMonstruo();
							JOptionPane.showMessageDialog(null, "El enemigo se defiende ?!?", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Has conseguido huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
					}
					break;
				default:
					huir=huir();
					defM=false;
					if(huir==false) {
						JOptionPane.showMessageDialog(null, "Has fallado al huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
						if(prob<=50) {
							vidaH=ataqueMonstruo(vidaH,defH);
							JOptionPane.showMessageDialog(null, "El enemigo te ataca !!!", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
						}else {
							defM=defensaMonstruo();
							JOptionPane.showMessageDialog(null, "El enemigo se defiende ?!?", "TURNO MONSTRUO", JOptionPane.WARNING_MESSAGE, null);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Has conseguido huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
					}
					break;
			}
				
		} while (Monstruo.getMonstruo1().getHp()-vidaM > 0 && Heroe.getHeroe1().getHp()-vidaH > 0 && huir==false);
		if (Heroe.getHeroe1().getHp()-vidaH <=0) {
			JOptionPane.showMessageDialog(null, "Has muerto, das pena", "DERROTA", JOptionPane.WARNING_MESSAGE, null);
		}else {
			if(Monstruo.getMonstruo1().getHp()-vidaM <=0){
				JOptionPane.showMessageDialog(null, "Has salido victorioso, has ganado: "+Monstruo.getMonstruo1().getExp()+" exp", "VICTORIA", JOptionPane.INFORMATION_MESSAGE, null);
				Heroe.getHeroe1().setExp(Heroe.getHeroe1().getExp()+Monstruo.getMonstruo1().getExp());
				Heroe.getHeroe1().subirLvl();
			}
		}
	}

	private static int ataque(int vidaM, boolean defM) {
		if(defM==true) {
			vidaM+=(Heroe.getHeroe1().getAtaque()-(Monstruo.getMonstruo1().getDef()*0.04));
		}else {
			vidaM+=(Heroe.getHeroe1().getAtaque()-(Monstruo.getMonstruo1().getDef()*0.02));
		}
		
		return vidaM;
	}

	private static boolean defensa() {
		return true;
	}

	private static int ataqueMonstruo(int vidaH, boolean defH) {
		if(defH==true) {
			vidaH+=(Monstruo.getMonstruo1().getAtaque()-(Heroe.getHeroe1().getDef()*0.04));
		}else {
			vidaH+=(Monstruo.getMonstruo1().getAtaque()-(Heroe.getHeroe1().getDef()*0.02));
		}
		
		return vidaH;
	}
	
	private static boolean defensaMonstruo() {
		return true;
	}
	
	private static boolean huir() {
		int prob = (int) Math.floor(1+Math.random() * 2);
		if(prob==1) {
			return true;
		}
		return false;
	}
}
