/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

import java.time.LocalDateTime;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Jonathan.FERNANDO-JO
 */
public class Personne {

    private final StringProperty login = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final StringProperty nom = new SimpleStringProperty();
    private final StringProperty adresse1 = new SimpleStringProperty();
    private final StringProperty adresse2 = new SimpleStringProperty();
    private final StringProperty villeCP = new SimpleStringProperty();
    private final StringProperty tel1 = new SimpleStringProperty();
    private final StringProperty tel2 = new SimpleStringProperty();

    public String getLogin() {
        return login.get();
    }

    public void setLogin(String value) {
        login.set(value);
    }

    public StringProperty loginProperty() {
        return login;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String value) {
        password.set(value);
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String value) {
        nom.set(value);
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public String getAdresse1() {
        return adresse1.get();
    }

    public void setAdresse1(String value) {
        adresse1.set(value);
    }

    public StringProperty adresse1Property() {
        return adresse1;
    }

    public String getAdresse2() {
        return adresse2.get();
    }

    public void setAdresse2(String value) {
        adresse2.set(value);
    }

    public StringProperty adresse2Property() {
        return adresse2;
    }

    public String getVilleCP() {
        return villeCP.get();
    }

    public void setVilleCP(String value) {
        villeCP.set(value);
    }

    public StringProperty villeCPProperty() {
        return villeCP;
    }

    public String getTel1() {
        return tel1.get();
    }

    public void setTel1(String value) {
        tel1.set(value);
    }

    public StringProperty tel1Property() {
        return tel1;
    }

    public String getTel2() {
        return tel2.get();
    }

    public void setTel2(String value) {
        tel2.set(value);
    }

    public StringProperty tel2Property() {
        return tel2;
    }

    public Personne(String login, String password, String nom, String adresse1, String adresse2, String tel1, String tel2) {
        this.login.set(login);
        this.password.set(password);
        this.nom.set(nom);
        this.adresse1.set(adresse1);
        this.adresse2.set(adresse2);
        this.tel1.set(tel1);
        this.tel1.set(tel2);
    }
    
    public boolean checkPassword(String login, String password){
        return login.equals(this.login.getValue()) && password.equals(this.password.getValue());
    }
    
    private final ObjectProperty<LocalDateTime> derniereConnexion = new SimpleObjectProperty<>();

    public LocalDateTime getDerniereConnexion() {
        return derniereConnexion.get();
    }

    public void setDerniereConnexion(LocalDateTime value) {
        derniereConnexion.set(value);
    }

    public ObjectProperty derniereConnexionProperty() {
        return derniereConnexion;
    }
    
}
