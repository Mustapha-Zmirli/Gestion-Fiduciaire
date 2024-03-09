package fst.sir.gestionfiduciaire.service.facade;


import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableValidateur;

public interface PaiementComptableValidateurService {

    PaiementComptableValidateur findBySocieteCode(String code);

    PaiementComptableValidateur findByDemandeCode(String code);

    PaiementComptableValidateur findByComptableValidateurCin(String cin);

    PaiementComptableValidateur findByCode(String code);

    PaiementComptableValidateur findByTypePaiementCode(String code);
    PaiementComptableValidateur save(PaiementComptableValidateur paiementComptableValidateur);


    int deleteByCode(String code);

    int deleteBySocieteCode(String code);

    int deleteByDemandeCode(String code);

    int deleteByComptableValidateurCin(String cin);

    int deleteByTypePaiementCode(String code);
}


