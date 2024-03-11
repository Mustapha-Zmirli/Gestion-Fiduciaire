package fst.sir.gestionfiduciaire.dao.Demande;

import fst.sir.gestionfiduciaire.bean.demande.EtatDemande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatDemandeDao extends JpaRepository<EtatDemande, Long> {
    int deleteByCode(String code);
    EtatDemande findByCode(String code);
}
