package metier;

public class Equipe {
	private int id_equipe;
	private String color;
	private String nomEquipe;
	private boolean isForfait;
	private int p1;
	private int p2;
	private int p3;
	private int p4;
	private int p5;
	private int p6;
	private int p7;
	private int prol1;
	private int prol2;
	private int prol3;
	private int prol4;
	private int prol5;
	private int prol6;
	private int prol7;
	private int prol_deuxieme;
	private int nb_periode;
	private int esprit_sportif;
	private int points;

	public Equipe(int id_equipe, String color, String nomEquipe, boolean isForfait, int p1, int p2, int p3, int p4, int p5, int p6, int p7,
			int prol1, int prol2, int prol3, int prol4, int prol5, int prol6, int prol7, int prol_deuxieme, int nb_periode, int esprit_sportif,
			int points) {
		super();
		this.id_equipe = id_equipe;
		this.color = color;
		this.nomEquipe = nomEquipe;
		this.isForfait = isForfait;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.p5 = p5;
		this.p6 = p6;
		this.p7 = p7;
		this.prol1 = prol1;
		this.prol2 = prol2;
		this.prol3 = prol3;
		this.prol4 = prol4;
		this.prol5 = prol5;
		this.prol6 = prol6;
		this.prol7 = prol7;
		this.prol_deuxieme = prol_deuxieme;
		this.nb_periode = nb_periode;
		this.esprit_sportif = esprit_sportif;
		this.points = points;
	}

	public Equipe(String color, String nomEquipe, boolean isForfait, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int prol1, int prol2,
			int prol3, int prol4, int prol5, int prol6, int prol7, int prol_deuxieme, int nb_periode, int esprit_sportif, int points) {
		super();
		this.color = color;
		this.nomEquipe = nomEquipe;
		this.isForfait = isForfait;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.p5 = p5;
		this.p6 = p6;
		this.p7 = p7;
		this.prol1 = prol1;
		this.prol2 = prol2;
		this.prol3 = prol3;
		this.prol4 = prol4;
		this.prol5 = prol5;
		this.prol6 = prol6;
		this.prol7 = prol7;
		this.prol_deuxieme = prol_deuxieme;
		this.nb_periode = nb_periode;
		this.esprit_sportif = esprit_sportif;
		this.points = points;
	}

	public int getId_equipe() {
		return id_equipe;
	}

	public void setId_equipe(int id_equipe) {
		this.id_equipe = id_equipe;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isForfait() {
		return isForfait;
	}

	public void setForfait(boolean isForfait) {
		this.isForfait = isForfait;
	}

	public int getP1() {
		return p1;
	}

	public void setP1(int p1) {
		this.p1 = p1;
	}

	public int getP2() {
		return p2;
	}

	public void setP2(int p2) {
		this.p2 = p2;
	}

	public int getP3() {
		return p3;
	}

	public void setP3(int p3) {
		this.p3 = p3;
	}

	public int getP4() {
		return p4;
	}

	public void setP4(int p4) {
		this.p4 = p4;
	}

	public int getP5() {
		return p5;
	}

	public void setP5(int p5) {
		this.p5 = p5;
	}

	public int getP6() {
		return p6;
	}

	public void setP6(int p6) {
		this.p6 = p6;
	}

	public int getP7() {
		return p7;
	}

	public void setP7(int p7) {
		this.p7 = p7;
	}

	public int getProl1() {
		return prol1;
	}

	public void setProl1(int prol1) {
		this.prol1 = prol1;
	}

	public int getProl2() {
		return prol2;
	}

	public void setProl2(int prol2) {
		this.prol2 = prol2;
	}

	public int getProl3() {
		return prol3;
	}

	public void setProl3(int prol3) {
		this.prol3 = prol3;
	}

	public int getProl4() {
		return prol4;
	}

	public void setProl4(int prol4) {
		this.prol4 = prol4;
	}

	public int getProl5() {
		return prol5;
	}

	public void setProl5(int prol5) {
		this.prol5 = prol5;
	}

	public int getProl6() {
		return prol6;
	}

	public void setProl6(int prol6) {
		this.prol6 = prol6;
	}

	public int getProl7() {
		return prol7;
	}

	public void setProl7(int prol7) {
		this.prol7 = prol7;
	}

	public int getProl_deuxieme() {
		return prol_deuxieme;
	}

	public void setProl_deuxieme(int prol_deuxieme) {
		this.prol_deuxieme = prol_deuxieme;
	}

	public int getNb_periode() {
		return nb_periode;
	}

	public void setNb_periode(int nb_periode) {
		this.nb_periode = nb_periode;
	}

	public int getEsprit_sportif() {
		return esprit_sportif;
	}

	public void setEsprit_sportif(int esprit_sportif) {
		this.esprit_sportif = esprit_sportif;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getNomEquipe() {
		return nomEquipe;
	}

	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}

}
