package fst.sir.gestionfiduciaire.ws.dto.demande;

public class EtatDemandeDto {
    private Long Id;
    private String libelle;
    private String code;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
}

