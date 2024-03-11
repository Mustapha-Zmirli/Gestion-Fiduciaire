package fst.sir.gestionfiduciaire.service.facade.commun;

import fst.sir.gestionfiduciaire.bean.commun.Comptable;

public interface ComptableService {

    Comptable findByCin(String cin);

    int deleteByCin(String cin);
    // List<Comptable> findByNomLike(String nom);

    // List<Comptable> findByPrenomLike(String prenom);
    Comptable save(Comptable comptable);
}
