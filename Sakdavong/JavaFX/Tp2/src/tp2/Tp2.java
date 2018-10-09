/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Jonathan.FERNANDO-JO
 */
public class Tp2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane rootLayout = (BorderPane) new LoginCode();

        //Recuperation du controleur
        LoginControllerCode controller = new LoginControllerCode();
        ContexteIdentification contexte = new ContexteIdentification(new Personnes());
        controller.setUI((LoginCode) rootLayout);
        controller.setContexte(contexte);

        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);

        //scene.getStylesheets().add(LoginControllerCode.class.getResource("login.css").toExternalForm());

        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
