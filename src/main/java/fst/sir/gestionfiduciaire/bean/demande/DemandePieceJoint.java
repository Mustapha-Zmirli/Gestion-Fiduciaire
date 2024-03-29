package fst.sir.gestionfiduciaire.bean.demande;


import fst.sir.gestionfiduciaire.bean.commun.CategoriePieceJoint;
import jakarta.persistence.*;

@Entity
public class DemandePieceJoint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code ;
    @ManyToOne
    private Demande demande;

    private String path;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
