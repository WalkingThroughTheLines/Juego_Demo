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
		do {
			int prob = (int) Math.floor(1+Math.random() * 2);
			boolean defM=false, defH=false;
			resp = JOptionPane.showOptionDialog(null, "La vida del heroe "+Heroe.getHeroe1().getNombre()
					+": "+(Heroe.getHeroe1().getHp()-vidaH)
					+"\n Vida del monstruo comun: "+(Monstruo.getMonstruo1().getHp()-vidaM)
					, "Monstruo", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, acciones, null);
			switch (resp) {
				case 0:
					vidaM=ataque(vidaM, defM);
					if(Monstruo.getMonstruo1().getHp()-vidaM >=0) {
				
					}else {
						if(prob==1) {
							vidaH=ataqueMonstruo(vidaH,defH);
						}else {
							defM=defensaMonstruo();
						}
					}
					break;
				case 1:
					defH=defensa();
					if(prob==1) {
						vidaH=ataqueMonstruo(vidaH,defH);
					}else {
						defM=defensaMonstruo();
					}
					break;
				case 2:
					huir();
					if(huir()==false) {
						JOptionPane.showMessageDialog(null, "Has fallado al huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
						if(prob==1) {
							vidaH=ataqueMonstruo(vidaH,defH);
						}else {
							defM=defensaMonstruo();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Has conseguido huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
					}
					break;
				case -1:
					huir();
					if(huir()==false) {
						JOptionPane.showMessageDialog(null, "Has fallado al huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
						if(prob==1) {
							vidaH=ataqueMonstruo(vidaH,defH);
						}else {
							defM=defensaMonstruo();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Has conseguido huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
					}
					break;
				default:
					huir();
					if(huir()==false) {
						JOptionPane.showMessageDialog(null, "Has fallado al huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
						if(prob==1) {
							vidaH=ataqueMonstruo(vidaH,defH);
						}else {
							defM=defensaMonstruo();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Has conseguido huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
					}
					break;
			}
		} while ((Monstruo.getMonstruo1().getHp()-vidaM >0 || Heroe.getHeroe1().getHp()-vidaH > 0) || huir()!=false);
	}

	private static void combateJefe() {
		String[] acciones = { "Atacar", "Defenderse", "Huir" };
		int resp = 0;
		int vidaM=0, vidaH=0;
		do {
			int prob = (int) Math.floor(1+Math.random() * 2);
			boolean defM=false, defH=false;
			resp = JOptionPane.showOptionDialog(null, "La vida del heroe "+Heroe.getHeroe1().getNombre()
					+": "+(Heroe.getHeroe1().getHp()-vidaH)
					+"\n Vida del Jefe: "+(Monstruo.getMonstruo1().getHp()-vidaM)
					, "Monstruo", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, acciones, null);
				switch (resp) {
				case 0:
					vidaM=ataque(vidaM, defM);
					if(Monstruo.getMonstruo1().getHp()-vidaM >=0) {
				
					}else {
						if(prob==1) {
							vidaH=ataqueMonstruo(vidaH,defH);
						}else {
							defM=defensaMonstruo();
						}
					}
					break;
				case 1:
					defH=defensa();
					if(prob==1) {
						vidaH=ataqueMonstruo(vidaH,defH);
					}else {
						defM=defensaMonstruo();
					}
					break;
				case 2:
					huir();
					if(huir()==false) {
						JOptionPane.showMessageDialog(null, "Has fallado al huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
						if(prob==1) {
							vidaH=ataqueMonstruo(vidaH,defH);
						}else {
							defM=defensaMonstruo();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Has conseguido huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
					}
					break;
				case -1:
					huir();
					if(huir()==false) {
						JOptionPane.showMessageDialog(null, "Has fallado al huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
					}else {
						JOptionPane.showMessageDialog(null, "Has conseguido huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
					}
					break;
				default:
					huir();
					if(huir()==false) {
						JOptionPane.showMessageDialog(null, "Has fallado al huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
						if(prob==1) {
							vidaH=ataqueMonstruo(vidaH,defH);
						}else {
							defM=defensaMonstruo();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Has conseguido huir", "HUIR", JOptionPane.WARNING_MESSAGE, null);
					}
					break;
			}
		} while ((Monstruo.getMonstruo1().getHp()-vidaM > 0 || Heroe.getHeroe1().getHp()-vidaH > 0) || huir()!=false);
	}

	private static int ataque(int vidaM, boolean defM) {
		if(defM==true) {
			vidaM+=(Heroe.getHeroe1().getAtaque()-(Monstruo.getMonstruo1().getDef()*0.4));
		}else {
			vidaM+=(Heroe.getHeroe1().getAtaque()-(Monstruo.getMonstruo1().getDef()*0.2));
		}
		
		return vidaM;
	}

	private static boolean defensa() {
		return true;
	}

	private static int ataqueMonstruo(int vidaH, boolean defH) {
		if(defH==true) {
			vidaH+=(Monstruo.getMonstruo1().getAtaque()-(Heroe.getHeroe1().getDef()*0.4));
		}else {
			vidaH+=(Heroe.getHeroe1().getAtaque()-(Monstruo.getMonstruo1().getDef()*0.2));
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
