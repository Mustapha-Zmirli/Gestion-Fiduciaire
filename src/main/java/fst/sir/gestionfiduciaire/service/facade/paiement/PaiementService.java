package fst.sir.gestionfiduciaire.service.facade.paiement;

import fst.sir.gestionfiduciaire.bean.paiement.PaiementDemande;
import fst.sir.gestionfiduciaire.ws.dto.paiement.PaiementDemandeDto;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface PaiementService {
    int  save(PaiementDemande paiement);

    PaiementDemande findByCode(String code);

    int deleteByCode(String code);

    List<PaiementDemande> findByDemandeCode(String code);

    int deleteByDemandeCode(String code);


    List<PaiementDemande> findBySocieteCode(String code);

    double getTotalPayeOfDemande(String code);


    @Transactional
    int update(String code, PaiementDemande paiement);

    List<PaiementDemande> getPaiementsBetweenDates(LocalDateTime dateDebut, LocalDateTime dateFin);
}
