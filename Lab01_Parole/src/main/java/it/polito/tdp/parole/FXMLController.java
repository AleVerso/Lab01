package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Parole elenco;

	@FXML
	private Button btnCancella;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtParola;

	@FXML
	private Button btnInserisci;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnReset;

	@FXML
	private TextArea txtTempoEsecuzione;

	@FXML
	void doCancella(ActionEvent event) {

		String daCancellare = txtResult.getSelectedText();
		double inizio = System.nanoTime();
		elenco.cancella(daCancellare);

		String stampa = "";

		for (String m : this.elenco.getElenco()) {

			stampa += m + "\n";
		}

		this.txtResult.setText(stampa);
		double fine = System.nanoTime();

		String tempo = String.valueOf(fine - inizio);

		this.txtTempoEsecuzione.setText(tempo);

	}

	@FXML
	void doInsert(ActionEvent event) {

		String string = "";
		String parola = this.txtParola.getText();
		double inizio = System.nanoTime();
		elenco.addParola(parola);

		for (String s : this.elenco.getElenco()) {

			string += s + "\n";
		}

		this.txtParola.clear();
		this.txtResult.setText(string);
		double fine = System.nanoTime();

		String tempo = String.valueOf(fine - inizio);

		this.txtTempoEsecuzione.setText(tempo);

	}

	@FXML
	void doReset(ActionEvent event) {
		txtResult.clear();
		elenco.reset();
	}

	@FXML
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtTempoEsecuzione != null
				: "fx:id=\"txtTempoEsecuzione\" was not injected: check your FXML file 'Scene.fxml'.";

		elenco = new Parole();
	}
}
