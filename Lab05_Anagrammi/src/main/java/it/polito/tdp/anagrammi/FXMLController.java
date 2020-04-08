package it.polito.tdp.anagrammi;

import model.Model;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;
	
    @FXML
    private TextField txtParola;
    @FXML
    private Label lblRight;

    @FXML
    private Label lblWrong;
    
    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtAreaR; // Right words

    @FXML
    private TextArea txtAreaW; // Wrong words

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	List<String> anagrammi = model.cercaAnagrammi(txtParola.getText());
    	
    	txtAreaR.clear();
    	txtAreaW.clear();
    	
    	int counterR = 0;
    	int counterW = 0;
    	
    	for (String parola : anagrammi) {
    		if (model.esiste(parola)) {
    			counterR++;
    			txtAreaR.appendText(parola + " ");
    		} else {
    			counterW++;
    			txtAreaW.appendText(parola + " ");
    		}
    	}
    	lblRight.setText("Anagrammi corretti: " + counterR);
    	lblWrong.setText("Anagrammi errati: " + counterW);
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	lblRight.setText("Anagrammi corretti:");
    	lblWrong.setText("Anagrammi errati:");
    	txtAreaR.clear();
    	txtAreaW.clear();
    }
    
	public void setModel(Model model) {
		this.model = model;
	}
}