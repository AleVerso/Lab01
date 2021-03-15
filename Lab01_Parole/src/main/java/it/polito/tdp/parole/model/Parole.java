package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.List;

public class Parole {

	private List<String> parole;

	public Parole() {
		this.parole = new ArrayList<>();
	}

	public void addParola(String p) {

		/*
		 * if (parole.isEmpty()) { parole.add(p); return; }
		 * 
		 * for (String s : this.parole) { if (p.equals(s)) { return; } }
		 */
		parole.add(p);

	}

	public List<String> getElenco() {

		List<String> elenco = new ArrayList<>();

		
		for (String p : this.parole) {
			elenco.add(p);
		}

		java.util.Collections.sort(elenco);

		return elenco;
	}

	public void reset() {
		this.parole.clear();
		
	}

	public void cancella(String p) {

		this.parole.remove(p);

	}

}
