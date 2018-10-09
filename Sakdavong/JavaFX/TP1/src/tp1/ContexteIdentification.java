/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Jonathan.FERNANDO-JO
 */
public class ContexteIdentification {

    private Personnes personnes;
    private StringProperty loginUtilisateurConnecte;
    private StringProperty passwordUtilisateurConnecte;

    public ContexteIdentification(Personnes personnes) {
        this.personnes = personnes;
        loginUtilisateurConnecte = new SimpleStringProperty();
        passwordUtilisateurConnecte = new SimpleStringProperty();
    }

    public Personnes getPersonnes() {
        return personnes;
    }

    public String getLoginUtilisateurConnecteProperty() {
        return loginUtilisateurConnecte.get();
    }

    public void setLoginUtilisateurConnecteProperty(String value) {
        loginUtilisateurConnecte.set(value);
    }

    public StringProperty loginUtilisateurConnecteProperty() {
        return loginUtilisateurConnecte;
    }

    public StringProperty getPasswordUtilisateurConnecte() {
        return passwordUtilisateurConnecte;
    }

    public void setPasswordUtilisateurConnecte(StringProperty passwordUtilisateurConnecte) {
        this.passwordUtilisateurConnecte = passwordUtilisateurConnecte;
    }
    
    public StringProperty passwordUtilisateurConnecteProperty() {
        return passwordUtilisateurConnecte;
    }
    
    
    //Retourne personne si le login et le password sont bons
    public Personne identification(){
        return personnes.identification(loginUtilisateurConnecte.getValue(), passwordUtilisateurConnecte.getValue());
    }

}
