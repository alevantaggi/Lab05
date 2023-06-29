package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.dao.AnagrammaDAO;

public class Model {
	
	private AnagrammaDAO dao;
	private Anagramma anagrammi;
	private List<String> listaCorretti;
	private List<String> listaScorretti;
	
	public Model() {
		this.dao= new AnagrammaDAO();
		this.anagrammi= new Anagramma();
	}
	
	public Set<String> getAnagrammi(String parola){
		return anagrammi.getAnagrammi(parola);
	}
	
	public void getRisultato(Set<String> anagrammi) {
		listaCorretti= new ArrayList<>();
		listaScorretti= new ArrayList<>();
		dao.getRisultato(anagrammi, listaCorretti, listaScorretti);
		return;
	}

	public List<String> getListaCorretti() {
		return listaCorretti;
	}

	public List<String> getListaScorretti() {
		return listaScorretti;
	}
	
	
	
}
