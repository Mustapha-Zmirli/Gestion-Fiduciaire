package fst.sir.gestionfiduciaire.service.facade.paiement;


import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableTraitant;

public interface PaiementComptableTraitantService {

    PaiementComptableTraitant findByCode(String code);

    PaiementComptableTraitant findBySocieteCode(String code);

    PaiementComptableTraitant findByDemandeCode(String code);

    PaiementComptableTraitant findByComptableTraitantCin(String cin);

    PaiementComptableTraitant findByTypePaiementCode(String code);

    int deleteByCode(String code);

    PaiementComptableTraitant save(PaiementComptableTraitant paiementComptableTraitant);

    int deleteBySocieteCode(String code);

    int deleteByDemandeCode(String code);

    int deleteByComptableTraitantCin(String cin);

    int deleteByTypePaiementCode(String code);
}

