package it.polito.tdp.anagrammi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnagrammaDAO {
	
	private Set<String> dictionary;
	
	public AnagrammaDAO() {
		dictionary= new HashSet<>();
		String sql= "SELECT p.nome FROM parola p";
		
		try {
			Connection conn= DBConnect.getConnection();
			PreparedStatement st= conn.prepareStatement(sql);
			ResultSet rs= st.executeQuery();
			
			while(rs.next()) 
				dictionary.add(rs.getString("nome"));
		}
		
		catch (Exception e) {
			System.err.println("Errore di connessione al database");
			e.printStackTrace();
		}	
	}

	
	public void getRisultato(Set<String> anagrammi, List<String> corretti, List<String> scorretti) {
		
		for(String s: anagrammi) {
			
			if(this.dictionary.contains(s)) 
				corretti.add(s);
			
				
			else 
				scorretti.add(s);
				
		}
		return;
	}
	

}
