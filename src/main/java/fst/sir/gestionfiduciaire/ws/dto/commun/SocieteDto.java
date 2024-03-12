package fst.sir.gestionfiduciaire.ws.dto.commun;

public class SocieteDto {
    private Long id;
    private String code;
    private String ice;
    private String rc;

    public String getCode() {
        return code;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
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




