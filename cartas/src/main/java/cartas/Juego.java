package cartas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Juego {

	public static void main(String[] args) throws IOException {
		
	
		Jugador jugador = new Jugador();
		Jugador cpu = new Jugador();
		System.out.println("Cargando Magic...");
		System.out.println("Bienvenido a Magic");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Quieres empezar una partida? si/no... ");
		String s = br.readLine();
		
		if (s.startsWith("no")) {
			System.out.println("Fin");
			return;
		}
		
		if (s.startsWith("si")) {
			System.out.println("Creando baraja...");
			System.out.println("Mezclando baraja...");
			Baraja baraja = new Baraja();
			Baraja original = new Baraja();
			baraja.barajar();
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Introduce nombre de jugador: ");
			String s1 = br1.readLine();
			jugador.nombre = s1;
			cpu.nombre = "CPU";
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Hola " + s1 + ", quieres volver a mezclar la baraja? si/no... ");
			String s2 = br2.readLine();
			if (s2.startsWith("si")) {
				System.out.println("De acuerdo mezclando la baraja...");
				baraja.barajar();
				System.out.println("La partida va a comenzar");
			} else {
				System.out.println("La partida va a comenzar");
			}
			System.out.println("Repartiendo cartas...");
			
			int i = 1;
			int total = 0;
			while (i <= 6) {
			int a = batalla(jugador, cpu, baraja);
			total = total + a;
			i = i + 1;
			}
			System.out.println();
			if (total < 0) {
				System.out.println("Has sido vencido, deberia darte vergüenza");
				System.out.println("Gracias por jugar a Magic");
			}
			if (total > 0) {
				System.out.println("Has ganado a la sucia CPU");
				System.out.println("Gracias por jugar a Magic");
			}
			if (total == 0) {
				System.out.println("Habeis empatado, vaya partida mas sosa");
				System.out.println("Gracias por jugar a Magic");
			}
		}
	}
	
	static int batalla (Jugador jugador, Jugador cpu, Baraja baraja) {
		
		int i = 0;
		int in = 0;
		int fue = 0;
		int des = 0;
		int intel = 0;
		int fue2 = 0;
		int des2 = 0;
		int intel2 = 0;
		int marcador = 0;
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Tus cartas:   ");
		while (in < 3) {
			jugador.mano.add(baraja.sacarCarta());
			System.out.print(jugador.mano.get(0) + "   ");
			Carta carta = jugador.mano.get(0);
			fue = fue + carta.fuerza;
			des = des + carta.destreza;
			intel = intel + carta.inteligencia;
			in = in + 1;
			jugador.mano.remove(0);
		}
			
		System.out.println();
		System.out.print("Cartas CPU:   ");
			
		while (i < 3) {
			cpu.mano.add(baraja.sacarCarta());
			System.out.print(cpu.mano.get(0) + "   ");
			Carta carta2 = cpu.mano.get(0);
			fue2 = fue2 + carta2.fuerza;
			des2 = des2+ carta2.destreza;
			intel2 = intel2 + carta2.inteligencia;
			i = i + 1;
			cpu.mano.remove(0);
		}	
		System.out.println();
			
		if (fue > fue2) {
			marcador = marcador + 1;
		}
		if (fue < fue2) {
			marcador = marcador - 1;
		}
		if (fue == fue2) {
			marcador = marcador + 0;
		}
		if (des > des2) {
			marcador = marcador + 1;
		}
		if (des < des2) {
			marcador = marcador - 1;
		}
		if (des == des2) {
			marcador = marcador + 0;
		}
		if (intel > intel2) {
			marcador = marcador + 1;
		}
		if (intel < intel2) {
			marcador = marcador + -1;
		}
		if (intel == intel2) {
			marcador = marcador + 0;
		}
		if (marcador > 0) {
			System.out.println("Tu ganas");
		} 
		if (marcador < 0) {
			System.out.println("La CPU gana");
		}
		if (marcador == 0) {
			System.out.println("Empate");
		}
		return marcador;
	}

}
