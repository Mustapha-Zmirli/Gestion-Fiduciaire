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
    private static Societe societe;
    @ManyToOne
    private static Demande demande;
    private double montant;
    @ManyToOne
    private static Comptable comptableTraitant;
    @ManyToOne
    private static TypePaiement typePaiement;

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

    public static Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public static Demande getDemande() {
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

    public static Comptable getComptableTraitant() {
        return comptableTraitant;
    }

    public void setComptableTraitant(Comptable comptableTraitant) {
        this.comptableTraitant = comptableTraitant;
    }

    public static TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }
}


