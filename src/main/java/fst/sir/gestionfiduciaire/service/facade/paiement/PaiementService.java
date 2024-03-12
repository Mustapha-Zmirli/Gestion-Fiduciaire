package fst.sir.gestionfiduciaire.service.facade.paiement;

import fst.sir.gestionfiduciaire.bean.paiement.PaiementDemande;
import java.util.List;

public interface PaiementService {
    int  save(PaiementDemande paiement);

    PaiementDemande findByCode(String code);

    int deleteByCode(String code);

    List<PaiementDemande> findByDemandeCode(String code);

    int deleteByDemandeCode(String code);


}
