package fst.sir.gestionfiduciaire.service.facade.demande;


import fst.sir.gestionfiduciaire.bean.demande.Demande;

public interface DemandeService {
    Demande findByCode(String code);

    int deleteByCode(String code);
}
