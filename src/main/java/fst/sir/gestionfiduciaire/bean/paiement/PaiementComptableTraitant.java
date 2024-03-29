package fst.sir.gestionfiduciaire.bean.paiement;


import fst.sir.gestionfiduciaire.bean.commun.Comptable;
import fst.sir.gestionfiduciaire.bean.commun.Societe;
import fst.sir.gestionfiduciaire.bean.paiement.TypePaiement;
import fst.sir.gestionfiduciaire.bean.demande.Demande;
import jakarta.persistence.*;

@Entity
public class PaiementComptableTraitant {
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
    private Comptable comptableTraitant;
    @ManyToOne
    private TypePaiement typePaiement;

    private boolean enAttente;

    // Getters et setters pour l'attribut "enAttente"

    public boolean isEnAttente() {
        return enAttente;
    }

    public void setEnAttente(boolean enAttente) {
        this.enAttente = enAttente;
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

    public Comptable getComptableTraitant() {
        return comptableTraitant;
    }

    public void setComptableTraitant(Comptable comptableTraitant) {
        this.comptableTraitant = comptableTraitant;
    }

    public TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }
}


