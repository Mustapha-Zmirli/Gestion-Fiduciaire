package fst.sir.gestionfiduciaire.service.facade.demande;


import fst.sir.gestionfiduciaire.bean.demande.Demande;
import fst.sir.gestionfiduciaire.bean.demande.EtatDemande;

import java.util.List;

public interface DemandeService {
    int changerEtatDemande(String code, EtatDemande nvEatat);

    Demande findByCode(String code);

    int deleteByCode(String code);

    int save(Demande demande);

    List<Demande> findAll();
}
