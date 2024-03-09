package fst.sir.gestionfiduciaire.service.facade;

import fst.sir.gestionfiduciaire.bean.paiement.PaiementDemande;

import java.util.List;

public interface PaiementService {
    PaiementDemande findByCode(String code);

    int deleteByCode(String code);

    List<PaiementDemande> findByDemandeRef(String ref);

    int deleteByDemandeRef(String ref);
}
