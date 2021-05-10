package modelo;

public class Monstruo extends Entidad {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4544976300348370368L;
	private static Monstruo monstruo1;

	/**
	 * @author WTTL
	 * @version 1.0
	 */

	private Monstruo() {
		super(0, 0, 0, 0, null, 0);
	}

	public static Monstruo getInstanceMonstruo() {
		if (monstruo1 == null) {
			monstruo1= new Monstruo();
			monstruo1.generarMonstruo();
		}
		return monstruo1;
	}

	public static Monstruo getInstanceJefe() {
		if (monstruo1 == null) {
			monstruo1=new Monstruo();
			monstruo1.generarJefe();
		}
		return monstruo1;
	}

	public void generarMonstruo() {
		setLvl(Heroe.getHeroe1().getLvl()); 
		setHp((int) Math.floor(Math.random() * (Heroe.getHeroe1().getHp() - (Heroe.getHeroe1().getHp() * 0.20))));
		setDef((int) Math.floor(Math.random() * (Heroe.getHeroe1().getDef() - (Heroe.getHeroe1().getDef() * 0.20))));
		setAtaque((int) Math
				.floor(Math.random() * (Heroe.getHeroe1().getAtaque() - (Heroe.getHeroe1().getAtaque() * 0.20))));
		setEfectoPasivo("none");
		setExp((int) Math.floor(Math.random() * (60 * (getExp() * 0.5))));
	}
	public void generarJefe() {
		setLvl(Heroe.getHeroe1().getLvl()); 
		setHp((int) Math.floor(Math.random() * (Heroe.getHeroe1().getHp() - (Heroe.getHeroe1().getHp() * 0.40))));
		setDef((int) Math.floor(Math.random() * (Heroe.getHeroe1().getDef() - (Heroe.getHeroe1().getDef() * 0.40))));
		setAtaque((int) Math
				.floor(Math.random() * (Heroe.getHeroe1().getAtaque() - (Heroe.getHeroe1().getAtaque() * 0.40))));
		setEfectoPasivo("none");
		setExp((int) Math.floor(Math.random() * (60 * (getExp() * 0.7))));

	}

	public static Monstruo getMonstruo1() {
		return monstruo1;
	}

	public static void setMonstruo1(Monstruo monstruo1) {
		Monstruo.monstruo1 = monstruo1;
	}

}
