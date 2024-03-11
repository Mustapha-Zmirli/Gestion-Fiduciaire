package fst.sir.gestionfiduciaire.ws.dto.demande;

public class TypeDemandeDto {
    private Long Id;
    private String Libelle;
    private String Code;
    private double honnoraireComptableTraitant;
    private double honnoraireComptableValidateur;

    public double getHonnoraireComptableTraitant() {
        return honnoraireComptableTraitant;
    }

    public void setHonnoraireComptableTraitant(double honnoraireComptableTraitant) {
        this.honnoraireComptableTraitant = honnoraireComptableTraitant;
    }

    public double getHonnoraireComptableValidateur() {
        return honnoraireComptableValidateur;
    }

    public void setHonnoraireComptableValidateur(double honnoraireComptableValidateur) {
        this.honnoraireComptableValidateur = honnoraireComptableValidateur;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        Libelle = libelle;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
}

