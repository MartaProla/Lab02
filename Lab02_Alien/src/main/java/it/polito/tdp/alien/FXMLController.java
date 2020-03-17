package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.alienModel.AlienDictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	AlienDictionary dizionario;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParolaInserita;

    @FXML
    private Button btnTraduzione;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnCancella;

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	txtParolaInserita.clear();

    }

    @FXML
    void doTraduzione(ActionEvent event) {
    	txtResult.clear();
    	String inserimento=txtParolaInserita.getText();
    	if(inserimento==null|| inserimento.length()==0) {
    		txtResult.appendText("Inserisci una o due parole per usare correttamente l'interfaccia");
    		return;
    	}
    	
    	String parts[]=inserimento.split(" ");
    	if(parts.length==2) {
    		//stai tentando di inserire una nuova combinazione
    		String parolaAliena=parts[0].trim();
    		String traduzione=parts[1].trim();
    		//controlli correttezza parola
    		if(parolaAliena.toLowerCase().matches("[a-zA-Z]*") && traduzione.toLowerCase().matches("[a-zA-Z]*")) {
	    		dizionario.addWord(parolaAliena, traduzione);
	    		txtResult.clear();
	    		txtResult.appendText("Inserita la corrispondenza in modo corretto\n");
	    		}else
	    			txtResult.appendText("Fai attenzione sono ammessi solo caratteri alfabetici \n");
    	}else {
    		if(parts.length==1) {
    			//vuoi la traduzione
    			String parolaAliena=parts[0].trim();
    			String trad="";
    			if(parolaAliena.toLowerCase().matches("[a-zA-Z]*")) {
    				trad=dizionario.translateWord(parolaAliena);
    			}else {
    				txtResult.appendText("Fai attenzione sono ammessi solo caratteri alfabetici \n");
    			}
    			txtResult.clear();
    			txtResult.appendText(trad);
    		
    		}else {
    			txtResult.appendText("E' consentito solo l'inserimento di una o due parole");
    		}
    	}
    	

    }

    @FXML
    void initialize() {
        assert txtParolaInserita != null : "fx:id=\"txtParolaInserita\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTraduzione != null : "fx:id=\"btnTraduzione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        
        dizionario=new AlienDictionary();
       

    }
}
