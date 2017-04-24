package cartas;

public class Carta {
	
	public int fuerza;
	public int destreza;
	public int inteligencia;
	
	public Carta(int fuerza, int destreza, int inteligencia) {
		 this.fuerza = fuerza;
		 this.destreza = destreza;
		 this.inteligencia = inteligencia;
	}
	

	public String toString() {
		String texto = fuerza + " " + destreza + " " + inteligencia;
		return texto;
	}

}
