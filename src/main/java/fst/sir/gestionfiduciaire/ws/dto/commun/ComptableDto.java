package fst.sir.gestionfiduciaire.ws.dto.commun;


import fst.sir.gestionfiduciaire.bean.commun.CategorieComptable;

public class ComptableDto {
    private Long id;
    private String cin;
    private String nom;
    private String prenom;
    private String email;
    private CategorieComptable categorieComptableId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CategorieComptable getCategorieComptableId() {
        return categorieComptableId;
    }

    public void setCategorieComptableId(CategorieComptable categorieComptableId) {
        this.categorieComptableId = categorieComptableId;
    }
}

