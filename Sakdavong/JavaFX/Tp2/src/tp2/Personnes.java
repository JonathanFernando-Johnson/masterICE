/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jonathan.FERNANDO-JO
 */
public class Personnes {

    private final ObservableList<Personne> liste;

    public Personnes() {
        this.liste = FXCollections.observableArrayList();
        this.liste.add(new Personne("naruto", "konoa", "Naruto UZUMAKI", "chez naruto", "", "123456789", "987654321"));
        this.liste.add(new Personne("luffy", "niku", "Monkey D. Luffy", "Sunny Go", "", "147258369", "963852741"));
        this.liste.add(new Personne("admin", "admin", "Jonathan FERNANDO-JOHNSON", "Chaz moi", "", "1593574862", "9517532684"));

    }
        

    public ObservableList<Personne> getListe() {
        return liste;
    }

    public Personne identification(String login, String password) {
        for (Personne p : liste) {
            if (p.checkPassword(login, password)) {
                return p;
            }
        }
        return null;
    }

}
