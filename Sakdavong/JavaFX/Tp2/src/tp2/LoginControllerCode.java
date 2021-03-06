/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jonathan.FERNANDO-JO
 */
public class LoginControllerCode implements Initializable {

    private TextField login;
    private PasswordField password;
    LoginCode ui;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        login.requestFocus();
    }

    ContexteIdentification contexte;
    
    public void setUI(LoginCode ui){
        //Remplace l'injection
        login = ui.login;
        password = ui.password;
        
        //Memorisation de l'UI
        this.ui = ui;
        ui.setControleur(this);
    }

    public void setContexte(ContexteIdentification contexte) {
        this.contexte = contexte;
        contexte.loginUtilisateurConnecteProperty().bind(login.textProperty());
        contexte.passwordUtilisateurConnecteProperty().bind(password.textProperty());
    }


    public void processCancel(ActionEvent event) {
        login.textProperty().set("");
        password.textProperty().set("");
    }

    public void processOk(ActionEvent event) {
        
        System.out.println("Le login est " + contexte.loginUtilisateurConnecteProperty().getValue() + " et le password est " + contexte.passwordUtilisateurConnecteProperty().getValue());


        /* Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        //alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("Le login est " + contexte.loginUtilisateurConnecteProperty().getValue() + " et le password est " + contexte.passwordUtilisateurConnecteProperty().getValue());
        alert.showAndWait();*/
        
        /*Personne p = contexte.getPersonnes().identification(contexte.loginUtilisateurConnecteProperty().getValue(), contexte.passwordUtilisateurConnecteProperty().getValue());

        if (p != null) {
            System.out.println("Le login est " + contexte.loginUtilisateurConnecteProperty().getValue() + " et le password est " + contexte.passwordUtilisateurConnecteProperty().getValue());
            try {
                //Recupération du stage a partir de n'importe quel objet de JavaFX
                Stage stage = (Stage) this.login.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Tp1.class.getResource("MainWindow.fxml"));
                BorderPane rootLayout = (BorderPane) loader.load();

                //Chargement du second controleur
                MainWindowController controller = loader.getController();
                controller.setContexte(contexte);

                Scene scene = new Scene(rootLayout, 1000, 600);
                stage.setScene(scene);
                stage.centerOnScreen();
            } catch (IOException e) {
                Logger.getLogger(LoginControllerCode.class.getName()).log(Level.SEVERE, null, e);
            }
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Identification Error");
            alert.setContentText("Mauvais login ou password. \nVeuillez essayer de nouveau. :)");
            alert.showAndWait();
        }*/
    }
    
    public void hoverOk(MouseEvent event){
        
    }
}
