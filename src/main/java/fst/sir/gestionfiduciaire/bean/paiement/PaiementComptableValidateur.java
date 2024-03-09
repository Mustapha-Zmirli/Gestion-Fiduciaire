package fst.sir.gestionfiduciaire.bean.paiement;

import fst.sir.gestionfiduciaire.bean.commun.Comptable;
import fst.sir.gestionfiduciaire.bean.commun.Societe;
import fst.sir.gestionfiduciaire.bean.paiement.TypePaiement;
import fst.sir.gestionfiduciaire.bean.demande.Demande;
import jakarta.persistence.*;

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

