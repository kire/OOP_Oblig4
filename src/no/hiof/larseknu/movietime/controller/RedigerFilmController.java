package no.hiof.larseknu.movietime.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import no.hiof.larseknu.movietime.MainJavaFX;
import no.hiof.larseknu.movietime.model.Film;



public class RedigerFilmController {


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

    private FilmoversiktController mainJavaFXApplikasjon;

    private ObservableList<Film> filmene = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        filmene.addAll(MainJavaFX.mainJavaFXApplikasjon.getfilmene());

        int in = FilmoversiktController.mainJavaFXApplikasjon.getValgtFilmIndex();
        Texttittel.setText(filmene.get(in).getTittel());
        Textbeskrivelse.setText(filmene.get(in).getBeskrivelse());
        Textspilletid.setText(String.valueOf(filmene.get(in).getSpilletid()));
        Textdato.setValue(filmene.get(in).getUtgivelsesdato());
    }
    @FXML
    public void redigerFilm() {

        int index = FilmoversiktController.mainJavaFXApplikasjon.getValgtFilmIndex();

        mainJavaFX.mainJavaFXApplikasjon.getfilmene().remove(index, index+1);
        Film test = new Film(Texttittel.getText(), Textbeskrivelse.getText(), Integer.valueOf(Textspilletid.getText()), Textdato.getValue());
        mainJavaFX.mainJavaFXApplikasjon.getfilmene().add(index,test);
        Stage stage = (Stage) addBtn.getScene().getWindow();
        stage.close();
    }

}
