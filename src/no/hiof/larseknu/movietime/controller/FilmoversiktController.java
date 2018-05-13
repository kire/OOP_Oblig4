package no.hiof.larseknu.movietime.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import no.hiof.larseknu.movietime.MainJavaFX;
import no.hiof.larseknu.movietime.model.Film;



public class FilmoversiktController {

    @FXML
    private ListView Viewliste;
    @FXML
    private TextField Textdato;
    @FXML
    private TextArea Textbeskrivelse;
    @FXML
    private TextField Textspilletid;
    @FXML
    private Label LabelTittel;
    @FXML
    private Button Redigerbtn;

    private MainJavaFX mainJavaFX;

    private Object valgtFilm;

    private int valgtFilmIndex;

    public static FilmoversiktController mainJavaFXApplikasjon;

    @FXML
    public void initialize() {
        Viewliste.setItems(MainJavaFX.mainJavaFXApplikasjon.getfilmene());

        Viewliste.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Film>() {
            @Override
            public void changed(ObservableValue<? extends Film> observable, Film oldValue, Film newValue) {
                LabelTittel.setText(newValue.getTittel());

                Textbeskrivelse.setText(newValue.getBeskrivelse());
                Textdato.setText(String.valueOf(newValue.getUtgivelsesdato()));

                Textspilletid.setText(String.valueOf(newValue.getSpilletid()));
            }
        });

        Redigerbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                valgtFilm = Viewliste.getSelectionModel().getSelectedItem();
                // hvis inger film er valgt, så skal en melding vises
                if (valgtFilm != null) {
                    setValgtFilmIndex(Viewliste.getSelectionModel().getSelectedIndex());
                    mainJavaFX.mainJavaFXApplikasjon.visScene3();
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Feil, velg en film");
                    alert.show();
                }
            }
        });
    }

    public FilmoversiktController() {
        mainJavaFXApplikasjon = this;
    }
    // Viser scene 2 som er rediger scenen
    @FXML
    public void leggTilNyFilm() {
        MainJavaFX.mainJavaFXApplikasjon.visScene2();
    }

    @FXML
    public void Slettfilm() {

        int valgtFilm = Viewliste.getSelectionModel().getSelectedIndex();
        Viewliste.getItems().remove(valgtFilm);

    }
    public Object getValgtFilm() {
        return valgtFilm;
    }

    public ListView getViewliste() {
        return Viewliste;
    }

    public void setValgtFilmIndex(int valgtFilmIndex) {
        this.valgtFilmIndex = valgtFilmIndex;
    }

    public int getValgtFilmIndex() {
        return valgtFilmIndex;
    }
}
