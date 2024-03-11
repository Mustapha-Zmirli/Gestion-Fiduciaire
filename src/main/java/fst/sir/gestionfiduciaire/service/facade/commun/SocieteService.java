package fst.sir.gestionfiduciaire.service.facade.commun;


import fst.sir.gestionfiduciaire.bean.commun.Societe;

public interface SocieteService {
    Societe findByCode(String code);

    int deleteByCode(String code);



    int save (Societe s);

}
