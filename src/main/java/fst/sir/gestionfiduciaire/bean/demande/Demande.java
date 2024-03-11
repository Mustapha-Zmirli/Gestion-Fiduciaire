package fst.sir.gestionfiduciaire.bean.demande;

import fst.sir.gestionfiduciaire.bean.commun.Comptable;
import fst.sir.gestionfiduciaire.bean.commun.Societe;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String libelle;
    private String code;
    private LocalDateTime dateDemande;
    private LocalDateTime dateExigibilite;
    @ManyToOne
    private Societe societe;
    @ManyToOne
    private TypeDemande typeDemande;
    @ManyToOne
    private EtatDemande etatDemande;
    @ManyToOne
    private Comptable comptableValidateur;
    @ManyToOne
    private Comptable comptableTraitant;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(LocalDateTime dateDemande) {
        this.dateDemande = dateDemande;
    }

    public LocalDateTime getDateExigibilite() {
        return dateExigibilite;
    }

    public void setDateExigibilite(LocalDateTime dateExigibilite) {
        this.dateExigibilite = dateExigibilite;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public TypeDemande getTypeDemande() {
        return typeDemande;
    }

    public void setTypeDemande(TypeDemande typeDemande) {
        this.typeDemande = typeDemande;
    }

    public EtatDemande getEtatDemande() {
        return etatDemande;
    }

    public void setEtatDemande(EtatDemande etatDemande) {
        this.etatDemande = etatDemande;
    }

    public Comptable getComptableValidateur() {
        return comptableValidateur;
    }

    public void setComptableValidateur(Comptable comptableValidateur) {
        this.comptableValidateur = comptableValidateur;
    }

    public Comptable getComptableTraitant() {
        return comptableTraitant;
    }

    public void setComptableTraitant(Comptable comptableTraitant) {
        this.comptableTraitant = comptableTraitant;
    }
}
