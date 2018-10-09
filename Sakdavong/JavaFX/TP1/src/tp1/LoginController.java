/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

//import com.sun.istack.internal.logging.Logger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
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
//import sun.util.logging.PlatformLogger;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        System.out.println("Le login est " + contexte.loginUtilisateurConnecteProperty().getValue() + " et le password est " + contexte.passwordUtilisateurConnecteProperty().getValue());

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        //alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("Le login est " + contexte.loginUtilisateurConnecteProperty().getValue() + " et le password est " + contexte.passwordUtilisateurConnecteProperty().getValue());

        alert.showAndWait();
        /*Personne p = contexte.getPersonnes().identification(contexte.loginUtilisateurConnecteProperty().getValue(), contexte.passwordUtilisateurConnecteProperty().getValue());
        
        if (p != null){
            try{
                //Recupération du stage a partir de n'importe quel objet de JavaFX
                Stage stage = (Stage) this.login.getScene().getWindow();
                
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Tp1.class.getResource("MainWindow.fxml"));
                BorderPane rootLayout = (BorderPane) loader.load();
            
                //Chargement du second controleur
                MainWindowController controller = loader.getController();
                controller.setContexte(contexte);
            
                Scene scene = new Scene(rootLayout);
                stage.setScene(scene);
                stage.centerOnScreen();            
            }catch(IOException e){
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
            }
        }*/
    }
}
