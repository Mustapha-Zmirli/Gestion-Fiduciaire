package fst.sir.gestionfiduciaire.service.facade.paiement;


import fst.sir.gestionfiduciaire.bean.commun.Comptable;
import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableTraitant;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PaiementComptableTraitantService {

    void affecterPaiementEnAttente(Comptable comptable, PaiementComptableTraitant paiement);

    PaiementComptableTraitant findByCode(String code);

    PaiementComptableTraitant findBySocieteCode(String code);

    PaiementComptableTraitant findByDemandeCode(String code);

    PaiementComptableTraitant findByComptableTraitantCin(String cin);

    PaiementComptableTraitant findByTypePaiementCode(String code);

    int deleteByCode(String code);

    int save(PaiementComptableTraitant paiementComptableTraitant);

    int deleteBySocieteCode(String code);

    int deleteByDemandeCode(String code);

    int deleteByComptableTraitantCin(String cin);

    int deleteByTypePaiementCode(String code);

    // Méthode pour récupérer le montant total des paiements traités
    double getMontantTotalPaiements();

    // Méthode pour récupérer le nombre de paiements traités par chaque comptable
    List<Comptable> getNombrePaiementsParComptable();

    // Méthode pour récupérer le montant moyen des paiements
    double getMontantMoyenPaiements();

    // Méthode pour générer un rapport sur les paiements effectués sur une période donnée
    List<Map<String, Object>> genererRapportPaiements(Date dateDebut, Date dateFin);

    // Méthode pour suivre l'état actuel d'un paiement spécifique
    String suivreEtatPaiement(Long idPaiement);

    int countPaiementsByComptable(Comptable comptable);
    List<PaiementComptableTraitant> findAll();


}

