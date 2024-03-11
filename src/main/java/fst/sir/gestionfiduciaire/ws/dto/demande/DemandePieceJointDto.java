package fst.sir.gestionfiduciaire.ws.dto.demande;
import fst.sir.gestionfiduciaire.bean.demande.Demande;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class DemandePieceJointDto {
    private Long id;
    private String code ;
    private Demande demande;
    private String path;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}

