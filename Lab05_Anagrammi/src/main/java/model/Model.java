package model;

import java.util.ArrayList;
import java.util.List;

import DAO.MarkDAO;

/**
 * 
 * @author riccardo
 *	
 *	ESEMPIO SULLA RICORSIONE 
 *	1) Il livello, nell'algoritmo ricorsivo, rappresenta la % di completezza della soluzione che si sta lavorando.
 *	   Quando il livello coincide con l'ultimo livello possibile, si ha una soluzione completa del problema di partenza.
 *	2) Una soluzione parziale è un livello intermedio.
 *	3) Una soluzione parziale è anche completa quando rispetta certe condizioni (controllo if nell'algoritmo, prima di agire sulla soluzione, per vedere se è completa).
 *	4) ?
 *	5) ? 
 *	6) Per generare soluzioni del livello L+1, richiamo l'algoritmo ricorsivo passandogli come argomento la parziale a cui sono giunto al livello L
 *	7) La struttura per memorizzare la soluzione parziale dipende dalla tipologia di questa. Solitamente è una Stringa.
 *	8) La struttura per memorizzare lo stato della ricerca è un intero -il livello L-
 *	9)  
 */
public class Model {
	MarkDAO dao = new MarkDAO();
	private List<String> soluzione;
	
	public List<String> cercaAnagrammi(String parola) {
		parola = parola.toUpperCase();
		this.soluzione = new ArrayList<>();
		
		List<Character> disponibili = new ArrayList<>();
		for (int i = 0; i < parola.length(); i++) {
			disponibili.add(parola.charAt(i)); 	// creo lista dei caratteri
		}
		cerca("", 0, disponibili);
		return this.soluzione;
	}
	
	private void cerca(String parziale, int livello, List<Character> disponibili) {
		if (disponibili.size() == 0) {
			this.soluzione.add(parziale); 	// se non ho più disponibili è perchè ho un anagramma 
		}
		
		for (Character c : disponibili) {
			String tentativo = parziale + c;
			
			List<Character> rimanenti = new ArrayList<>(disponibili);	// rimuovo il carattere usato
			rimanenti.remove(c);
			
			cerca(tentativo, livello+1, rimanenti); // ricorsione
		}
	}
	
	public boolean esiste(String parola) {
		return dao.esiste(parola);
	}
}
