
package fst.sir.gestionfiduciaire.bean.commun;
import jakarta.persistence.*;

@Entity
public class Comptable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cin;
    private String nom;
    private String prenom;
    private String email;
    private int nombrePaiementsTraites;
    private int nombrePaiementsValidees;

    public int getNombrePaiementsValidees() {
        return nombrePaiementsValidees;
    }

    public void setNombrePaiementsValidees(int nombrePaiementsValidees) {
        this.nombrePaiementsValidees = nombrePaiementsValidees;
    }

    @ManyToOne
    private CategorieComptable categorieComptable;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public CategorieComptable getCategorieComptable() {
        return categorieComptable;
    }

    public void setCategorieComptable(CategorieComptable categorieComptable) {
        this.categorieComptable = categorieComptable;
    }

    public int getNombrePaiementsTraites() {
        return nombrePaiementsTraites;
    }

    public void setNombrePaiementsTraites(int nombrePaiementsTraites) {
        this.nombrePaiementsTraites = nombrePaiementsTraites;
    }
}
