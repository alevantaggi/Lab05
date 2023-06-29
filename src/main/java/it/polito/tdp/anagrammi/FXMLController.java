package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSearchAna;

    @FXML
    private TextArea correctAna;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea wrongAna;

    @FXML
    void doReset(ActionEvent event) {
    	txtParola.setText("");
    	wrongAna.setText("");
    	correctAna.setText("");
    }
    

    @FXML
    void doSearch(ActionEvent event) {
    	wrongAna.setText("");
    	correctAna.setText("");
    	
    	model.getRisultato(model.getAnagrammi(txtParola.getText().toLowerCase().replaceAll("[^a-zA-Z]", "")));
    	
    
        	
        for(String c: model.getListaCorretti())
        	correctAna.appendText(c+"\n");
        	
        for(String s: model.getListaScorretti())
        	wrongAna.appendText(s+"\n");
    	
    	
    }

    @FXML
    void initialize() {
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSearchAna != null : "fx:id=\"btnSearchAna\" was not injected: check your FXML file 'Scene.fxml'.";
        assert correctAna != null : "fx:id=\"correctAna\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert wrongAna != null : "fx:id=\"wrongAna\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model= model;
		
	}

}
