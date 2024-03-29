package fst.sir.gestionfiduciaire.ws.dto.paiement;


import fst.sir.gestionfiduciaire.bean.commun.Comptable;
import fst.sir.gestionfiduciaire.bean.demande.Demande;
import fst.sir.gestionfiduciaire.bean.commun.Societe;
import fst.sir.gestionfiduciaire.bean.paiement.TypePaiement;

import java.util.Date;

public class PaiementComptableValidateurDto {
    private Long id;
    private String code;
    private Societe societe;
    private Demande demande;
    private double montant;
    private TypePaiement typePaiement;
    private Comptable comptableValidateur;
    private boolean enAttenteValidation;
    private boolean valide;

    private String raisonRejet;
    private Date dateCreation;
    private Date dateLimite;

    public boolean isEnAttenteValidation() {
        return enAttenteValidation;
    }

    public void setEnAttenteValidation(boolean enAttenteValidation) {
        this.enAttenteValidation = enAttenteValidation;
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



