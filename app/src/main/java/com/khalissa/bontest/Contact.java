package com.khalissa.bontest;

import java.io.Serializable;

public class Contact implements Serializable {
    private String nom;
    private String prenom;
    private String sexe;
    private String date_naissance;
    private String numeroTel;
    private String mail;

    public Contact() {
    }

    public Contact(String nom, String prenom, String sexe, String date_naissance, String numeroTel, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.date_naissance = date_naissance;
        this.numeroTel = numeroTel;
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public String getMail() {
        return mail;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Contact :" + '\n' +
                "nom : " + nom + '\n' +
                "prenom : " + prenom + '\n' +
                "sexe : " + sexe + '\n' +
                "date_naissance : " + date_naissance + '\n' +
                "numeroTel : " + numeroTel + '\n' +
                "mail : " + mail + '\n';
    }
}
