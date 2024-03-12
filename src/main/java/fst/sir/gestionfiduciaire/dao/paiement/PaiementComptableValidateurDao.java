package fst.sir.gestionfiduciaire.dao.paiement;

import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableValidateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementComptableValidateurDao extends JpaRepository<PaiementComptableValidateur, Long> {
    PaiementComptableValidateur findByCode(String code);
    PaiementComptableValidateur findBySocieteCode(String code);
    PaiementComptableValidateur findByDemandeCode(String code);
    PaiementComptableValidateur findByComptableValidateurCin(String cin);
    PaiementComptableValidateur findByTypePaiementCode(String code);
    int deleteByCode(String code);
    int deleteBySocieteCode(String code);
    int deleteByDemandeCode(String code);
    int deleteByComptableValidateurCin(String cin);
    int deleteByTypePaiementCode(String code);
}

