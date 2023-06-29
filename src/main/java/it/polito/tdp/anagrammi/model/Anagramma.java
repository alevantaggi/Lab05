package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;



public class Anagramma {

		
	
	public Set<String> getAnagrammi(String parola){
		Set<String> risultato= new HashSet<>();	
		
		if(parola.length()==1) {
			
			risultato.add(parola);
			return risultato;
		}
		
		else {
			for(int i=0; i<parola.length();i++){
				char iniziale= parola.charAt(i);
				String parziale= parola.substring(0,i)+parola.substring(i+1);
				
				Set<String> listaParziale= getAnagrammi(parziale);

				
				for(String s: listaParziale) {
					risultato.add(iniziale+s);
				}
			}
			return risultato;
		}
	}

}
