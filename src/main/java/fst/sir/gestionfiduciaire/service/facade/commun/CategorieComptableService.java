package fst.sir.gestionfiduciaire.service.facade.commun;

import fst.sir.gestionfiduciaire.bean.commun.CategorieComptable;

public interface CategorieComptableService {



    public CategorieComptable findByCode(String code);

    int deleteByCode(String code);

    CategorieComptable save(CategorieComptable categorieComptable);

    //List<CategorieComptable> findByLibelleLike(String libelle);
}
