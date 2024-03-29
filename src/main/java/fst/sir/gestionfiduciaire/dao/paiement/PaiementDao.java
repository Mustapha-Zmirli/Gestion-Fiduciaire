package fst.sir.gestionfiduciaire.dao.paiement;


import fst.sir.gestionfiduciaire.bean.paiement.PaiementDemande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementDao extends JpaRepository<PaiementDemande,Long> {
    PaiementDemande findByCode(String code);
    int deleteByCode(String code);
    List<PaiementDemande> findByDemandeCode(String code);
    int deleteByDemandeCode(String code);

}