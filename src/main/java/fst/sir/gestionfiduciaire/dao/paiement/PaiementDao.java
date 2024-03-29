package fst.sir.gestionfiduciaire.dao.paiement;


import fst.sir.gestionfiduciaire.bean.paiement.PaiementDemande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface PaiementDao extends JpaRepository<PaiementDemande,Long> {
    PaiementDemande findByCode(String code);
    int deleteByCode(String code);
    List<PaiementDemande> findByDemandeCode(String code);
    int deleteByDemandeCode(String code);

    List<PaiementDemande> findBySocieteCode(String code);
    @Query("SELECT p FROM PaiementDemande p WHERE p.datePaiement BETWEEN ?1 AND ?2")
    List<PaiementDemande> getPaiementsBetweenDates(Date dateDebut, Date dateFin);
}