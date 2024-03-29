package fst.sir.gestionfiduciaire.service.facade.paiement;


import fst.sir.gestionfiduciaire.bean.commun.Comptable;
import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableTraitant;
import fst.sir.gestionfiduciaire.bean.paiement.PaiementComptableValidateur;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PaiementComptableValidateurService {

    PaiementComptableValidateur findBySocieteCode(String code);

    PaiementComptableValidateur findByDemandeCode(String code);

    PaiementComptableValidateur findByComptableValidateurCin(String cin);

    void affecterPaiementEnValidation(Comptable comptable, PaiementComptableValidateur paiement);

    void validerPaiement(Comptable comptable, PaiementComptableValidateur paiement);

    void rejeterPaiement(Comptable comptable, PaiementComptableValidateur paiement, String raison);

    void reaffecterPaiement(Comptable nouveauComptable, PaiementComptableValidateur paiement);

    void genererRapportDelaisValidation(Date dateDebut, Date dateFin);

    List<PaiementComptableValidateur> getPaiementsRejetes();

    PaiementComptableValidateur findByCode(String code);

    PaiementComptableValidateur findByTypePaiementCode(String code);
    int save(PaiementComptableValidateur paiementComptableValidateur);


    int deleteByCode(String code);

    int deleteBySocieteCode(String code);

    int deleteByDemandeCode(String code);

    int deleteByComptableValidateurCin(String cin);

    int deleteByTypePaiementCode(String code);

    // Méthode pour récupérer le montant total des paiements validees
    double getMontantTotalPaiements();

    // Méthode pour récupérer le nombre de paiements validees par chaque comptable
    List<Comptable> getNombrePaiementsParComptable();

    // Méthode pour récupérer le montant moyen des paiements
    double getMontantMoyenPaiements();

    // Méthode pour générer un rapport sur les paiements effectués sur une période donnée
    List<Map<String, Object>> genererRapportPaiements(Date dateDebut, Date dateFin);

    // Méthode pour suivre l'état actuel d'un paiement spécifique
    String suivreEtatPaiement(Long idPaiement);

    int countPaiementsByComptable(Comptable comptable);
    List<PaiementComptableValidateur> findAll();
}


