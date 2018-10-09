/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author Jonathan.FERNANDO-JO
 */
public class MainWindowController implements Initializable {

    @FXML
    private TextFlow text_flow;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Text t = new Text();
        t.setText("Le login est " + contexte.loginUtilisateurConnecteProperty().getValue() + " et le password est " + contexte.passwordUtilisateurConnecteProperty().getValue());
        /*this.text_flow.setText(); 
        contexte.loginUtilisateurConnecteProperty().bind(login.textProperty());*/
    }    

    ContexteIdentification contexte;
    
    void setContexte(ContexteIdentification contexte) {
        this.contexte = contexte;
    }
    
}
