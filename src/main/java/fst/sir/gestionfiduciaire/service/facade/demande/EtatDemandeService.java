package fst.sir.gestionfiduciaire.service.facade.demande;

import fst.sir.gestionfiduciaire.bean.demande.EtatDemande;
import fst.sir.gestionfiduciaire.dao.Demande.EtatDemandeDao;
import org.springframework.stereotype.Service;

@Service
public interface EtatDemandeService {

    int save(EtatDemande etatDemande);

    int deleteByCode(String code);

    EtatDemande findByCode(String code);
}
