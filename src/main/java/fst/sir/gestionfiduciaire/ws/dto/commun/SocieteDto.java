package fst.sir.gestionfiduciaire.ws.dto.commun;

public class SocieteDto {
    private Long id;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

