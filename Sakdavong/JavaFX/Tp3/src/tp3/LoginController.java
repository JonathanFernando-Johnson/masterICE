/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jonathan.FERNANDO-JO
 */
public class LoginController implements Initializable {

    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private ProgressBar progress_bar;
    @FXML
    private Label label_password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        login.requestFocus();

        //progress bar avec listener
        /* progress_bar.setProgress(password.getText().length()/8.0f);
        
        password.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                progress_bar.setProgress(newValue.length()/8.0f);   
            }
        });*/
        //progress bar avec bind
        progress_bar.progressProperty().bind(password.textProperty().length().divide(8.0f));

        //verif du pwd
        password.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                StringBuilder sb = new StringBuilder();
                if (!newValue.isEmpty()) {
                    if (!newValue.matches(".*\\d+.*")) {
                        sb.append("Chiffre manquant");
                    }
                    if (!newValue.matches("[a-zA-Z0-9]+")) {
                        sb.append("Caractère non alphanum manquant");
                    }
                }
                label_password.setText(sb.toString());
            }
        });
    }

    ContexteIdentification contexte;

    public void setContexte(ContexteIdentification contexte) {
        this.contexte = contexte;
        contexte.loginUtilisateurConnecteProperty().bind(login.textProperty());
        contexte.passwordUtilisateurConnecteProperty().bind(password.textProperty());
    }

    @FXML
    private void processCancel(ActionEvent event) {
        login.textProperty().set("");
        password.textProperty().set("");
    }

    @FXML
    private void processOk(ActionEvent event) {

        //System.out.println("Le login est " + contexte.loginUtilisateurConnecteProperty().getValue() + " et le password est " + contexte.passwordUtilisateurConnecteProperty().getValue());
        /* Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        //alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("Le login est " + contexte.loginUtilisateurConnecteProperty().getValue() + " et le password est " + contexte.passwordUtilisateurConnecteProperty().getValue());
        alert.showAndWait();*/
        Personne p = contexte.getPersonnes().identification(contexte.loginUtilisateurConnecteProperty().getValue(), contexte.passwordUtilisateurConnecteProperty().getValue());

        if (p != null) {
            System.out.println("Le login est " + contexte.loginUtilisateurConnecteProperty().getValue() + " et le password est " + contexte.passwordUtilisateurConnecteProperty().getValue());
            /*try {
                //Recupération du stage a partir de n'importe quel objet de JavaFX
                Stage stage = (Stage) this.login.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Tp3.class.getResource("MainWindow.fxml"));
                BorderPane rootLayout = (BorderPane) loader.load();

                //Chargement du second controleur
                MainWindowController controller = loader.getController();
                controller.setContexte(contexte);

                Scene scene = new Scene(rootLayout, 1000, 600);
                stage.setScene(scene);
                stage.centerOnScreen();
            } catch (IOException e) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
            }*/
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Identification Error");
            alert.setContentText("Mauvais login ou password. \nVeuillez essayer de nouveau. :)");
            alert.showAndWait();
        }
    }
}

/*    
    ECHEC DE VERIF PWD
    
    label_password.setText(verif(password.getText()));
    private String verif (String password){
        if(password.isEmpty()){
            return "";
        }
        else{
            if (!password.matches("(?=.*[0-9])")){
                return "Il faut au moins un chiffre";
            }
            
            if(!password.matches("(?=.*[@#$%^&+=])")){
                return "Il faut au moins un caractère spécial";
            }
            
            if(!password.matches("(?=.*[0-9])") && !password.matches("(?=.*[@#$%^&+=])")){
                return "Il faut au moins un chiffre et au moins un caractère spécial";             
            }            
        }
        return null;
    }*/
