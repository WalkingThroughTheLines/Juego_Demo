package modelo;

public abstract class Entidad {
	private int hp;
	private int def;
	private int lvl;
	private int ataque;
	private String efectoPasivo;

	public Entidad(int hp, int def, int lvl, int ataque, String efectoPasivo) {
		super();
		this.hp = hp;
		this.def = def;
		this.lvl = lvl;
		this.ataque = ataque;
		this.efectoPasivo = efectoPasivo;
	}

	public int getHp() {
		return hp;
	}

	public int getDef() {
		return def;
	}

	public int getLvl() {
		return lvl;
	}

	public int getAtaque() {
		return ataque;
	}

	public String getEfectoPasivo() {
		return efectoPasivo;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public void setEfectoPasivo(String efectoPasivo) {
		this.efectoPasivo = efectoPasivo;
	}

}
