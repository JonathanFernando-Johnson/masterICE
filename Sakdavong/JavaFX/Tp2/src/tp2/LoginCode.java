/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * Remplace le login.fxml du tp1
 *
 * @author Jonathan.FERNANDO-JO
 */
public class LoginCode extends BorderPane {

    Label titre;
    TextField login;
    PasswordField password;
    LoginControllerCode controleur; //le controleur

    public LoginCode() {
        titre = new Label("Identification");
        titre.setId("titre");
        this.setTop(titre);

        GridPane centerPane = new GridPane();

        Label label1 = new Label("Login :");
        label1.setPrefWidth(100);
        centerPane.add(label1, 0, 0);

        login = new TextField();
        login.requestFocus();
        centerPane.add(login, 1, 0);

        Label label2 = new Label("Password :");
        label2.setPrefWidth(100);
        centerPane.add(label2, 0, 1);

        password = new PasswordField();
        centerPane.add(password, 1, 1);

        this.setCenter(centerPane);

        FlowPane bottomPane = new FlowPane();
        bottomPane.setHgap(10);

        Button okButton = new Button("OK");
        okButton.setDefaultButton(true);
        okButton.setOnAction(e -> {
            controleur.processOk(e);
        });
        okButton.setOnMouseEntered(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                if(login.textProperty().getValue().equals("")){
                    okButton.setStyle("fx-background-color: red");
                }
            }
        });

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> {
            controleur.processCancel(e);
        });

        bottomPane.getChildren().addAll(okButton, cancelButton);
        this.setBottom(bottomPane);

        this.setPrefSize(437, 187);
        this.setPadding(new Insets(10, 10, 10, 10));  
        
        this.setAlignment(titre,Pos.CENTER);
        titre.setStyle("-fx-font-size: 30pt; -fx-font-weight: bold");
        
        centerPane.setAlignment(Pos.CENTER); 
        centerPane.setHgap(10);
        centerPane.setVgap(20);
        label1.setStyle("-fx-font-size: 10pt; -fx-font-weight: bold");
        label2.setStyle("-fx-font-size: 10pt; -fx-font-weight: bold");
        
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setHgap(30);
        bottomPane.setVgap(20);       
    }

    void setControleur(LoginControllerCode controller) {
        this.controleur = controller;
    }
}
