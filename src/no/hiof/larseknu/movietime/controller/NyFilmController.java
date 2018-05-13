package no.hiof.larseknu.movietime.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import no.hiof.larseknu.movietime.MainJavaFX;
import no.hiof.larseknu.movietime.model.Film;

public class NyFilmController {

    @FXML
    private Button addBtn;
    @FXML
    private TextField Texttittel;
    @FXML
    private TextArea Textbeskrivelse;
    @FXML
    private DatePicker Textdato;
    @FXML
    private TextField Textspilletid;

    private MainJavaFX mainJavaFX;


    @FXML
    public void leggTiltest() {

        int index = FilmoversiktController.mainJavaFXApplikasjon.getValgtFilmIndex();

        Film test = new Film(Texttittel.getText(), Textbeskrivelse.getText(), Integer.valueOf(Textspilletid.getText()), Textdato.getValue());
        mainJavaFX.mainJavaFXApplikasjon.getfilmene().add(index,test);
        Stage stage = (Stage) addBtn.getScene().getWindow();
        stage.close();
    }
}