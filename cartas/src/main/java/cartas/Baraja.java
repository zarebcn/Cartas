package cartas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Baraja {
	
	public List<Carta> cartas = new ArrayList<Carta>();

	public Baraja () {
	
		int fuerza = 1;
		int destreza = 1;
		int inteligencia = 10 - (fuerza + destreza);
		
		while ((fuerza < 9) && fuerza + destreza + inteligencia == 10) {
			
			Carta carta = new Carta (fuerza, destreza, inteligencia);
			cartas.add(carta);
			destreza = destreza + 1;
			inteligencia = inteligencia - 1;
			if (inteligencia == 0) {
				fuerza = fuerza + 1;
				destreza = 1;
				inteligencia = 10 - (fuerza + destreza);
			}
		}
		
	}
	
	public void barajar () {
		
		List<Carta> mezcla = new ArrayList<Carta>();
		int a = cartas.size();
		Random r = new Random();
		int i = 0;
		while (i < a) {
			int ran = r.nextInt(a-i);
			Carta carta = cartas.get(ran);
			mezcla.add(carta);
			cartas.remove(ran);
			i = i + 1;
		}
		cartas = mezcla;
	}
	
	public Carta sacarCarta () {
		
		List<Carta> mano = new ArrayList<Carta>();
		Carta carta = cartas.get(0);
		cartas.remove(0);
		mano.add(carta);
		Carta carta2 = mano.get(0);
		return carta2;
	}

}
