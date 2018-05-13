package no.hiof.larseknu.movietime;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import no.hiof.larseknu.movietime.model.Film;


import java.io.IOException;
import java.time.LocalDate;

public class MainJavaFX extends Application {

    private ObservableList<Film> filmene = FXCollections.observableArrayList();

    public static MainJavaFX mainJavaFXApplikasjon;

    private Stage primaryStage;


    public MainJavaFX() {



        filmene.add(new Film("Lars emil the movie", "Java and cats", 175, LocalDate.of(2017,10,5)));

        filmene.add(new Film("Murder at Hiof", "Edgar is dead lol", 66, LocalDate.of(2054,1,13)));
        filmene.add(new Film("Emoji Movie", "Emoji's do stuff", 666, LocalDate.of(2017,10,10)));
        filmene.add(new Film("Drugs R Bad", "Dont do em, they R bad", 266, LocalDate.of(2014,10,10)));
        filmene.add(new Film("Howdy partner KKona", "*Spins revolver* hey cowboy", 166, LocalDate.of(2010,10,10)));

        mainJavaFXApplikasjon = this;

    }

    // Viser scene 1 ved start
    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        visScene1();
    }
        // Metoden for scene 1
    public void visScene1() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/Filmoversikt.fxml"));
            Parent hovedLayout = loader.load();
            Scene hovedScene = new Scene(hovedLayout);
            primaryStage.setScene(hovedScene);
            primaryStage.show();

        } catch (IOException ioe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setHeaderText("En feil");
            alert.setContentText(ioe.getMessage());
            alert.show();
        }
    }

    public void visScene2() {

        try {
            Stage redigerStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/NyFilm.fxml"));
            Parent hovedLayout = loader.load();
            Scene hovedScene = new Scene(hovedLayout);
            redigerStage.initOwner(primaryStage);
            redigerStage.setScene(hovedScene);
            redigerStage.showAndWait();


        }
        catch (IOException ioe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("En feil");
            alert.setContentText(ioe.getLocalizedMessage());
            alert.show();
        }
    }

    public void visScene3() {

        try {
            Stage editStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/RedigerFilm.fxml"));
            Parent hovedLayout = loader.load();
            Scene hovedScene = new Scene(hovedLayout);
            editStage.initOwner(primaryStage);
            editStage.setScene(hovedScene);
            editStage.showAndWait();


        }
        catch (IOException ioe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Feil");
            alert.setContentText(ioe.getLocalizedMessage());
            alert.show();
        }
    }
    public ObservableList<Film> getfilmene() {
        return filmene;
    }

    public static void main(String[] args) {
        launch(args);
    }

}

