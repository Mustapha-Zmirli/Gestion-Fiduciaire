package fst.sir.gestionfiduciaire.bean.paiement;

import fst.sir.gestionfiduciaire.bean.commun.Comptable;
import fst.sir.gestionfiduciaire.bean.commun.Societe;
import fst.sir.gestionfiduciaire.bean.paiement.TypePaiement;
import fst.sir.gestionfiduciaire.bean.demande.Demande;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PaiementComptableValidateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    @ManyToOne
    private Societe societe;
    @ManyToOne
    private Demande demande;
    private double montant;
    @ManyToOne
    private TypePaiement typePaiement;
    @ManyToOne
    private Comptable comptableValidateur;

    private boolean enAttenteValidation;
    private boolean valide;

    private String raisonRejet;
    private Date dateCreation;
    private Date dateLimite;

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateLimite() {
        return dateLimite;
    }

    public void setDateLimite(Date dateLimite) {
        this.dateLimite = dateLimite;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public String getRaisonRejet() {
        return raisonRejet;
    }

    public void setRaisonRejet(String raisonRejet) {
        this.raisonRejet = raisonRejet;
    }

    public boolean isEnAttenteValidation() {
        return enAttenteValidation;
    }

    public void setEnAttenteValidation(boolean enAttenteValidation) {
        this.enAttenteValidation = enAttenteValidation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }

    public Comptable getComptableValidateur() {
        return comptableValidateur;
    }

    public void setComptableValidateur(Comptable comptableValidateur) {
        this.comptableValidateur = comptableValidateur;
    }
}

