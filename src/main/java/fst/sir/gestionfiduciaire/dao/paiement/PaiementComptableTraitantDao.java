package fst.sir.gestionfiduciaire.dao.paiement;



import fst.sir.gestionfiduciaire.bean.commun.Comptable;
import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableTraitant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementComptableTraitantDao extends JpaRepository<PaiementComptableTraitant, Long> {
    PaiementComptableTraitant findByCode(String code);
    PaiementComptableTraitant findBySocieteCode(String code);
    PaiementComptableTraitant findByDemandeCode(String code);
    PaiementComptableTraitant findByComptableTraitantCin(String cin);
    PaiementComptableTraitant findByTypePaiementCode(String code);
    int deleteBySocieteCode(String code);
    int deleteByDemandeCode(String code);
    int deleteByComptableTraitantCin(String cin);
    int deleteByTypePaiementCode(String code);
    int deleteByCode(String code);

    List<PaiementComptableTraitant> findByComptableTraitant(Comptable comptable);
}

